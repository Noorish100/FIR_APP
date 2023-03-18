package com.masai.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.FirException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.PoliceException;
import com.masai.exceptions.PoliceStationException;
import com.masai.exceptions.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Fir;
import com.masai.model.LoginDto;
import com.masai.model.Police;
import com.masai.model.PoliceStation;
import com.masai.model.User;
import com.masai.repository.FirRepository;
import com.masai.repository.PoliceRepository;
import com.masai.repository.PoliceStationRepository;
import com.masai.repository.UserRepository;
import com.masai.repository.UserSessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PoliceRepository policeRepository;

	@Autowired
	private PoliceStationRepository policeStationRepository;

	@Autowired
	private FirRepository firRepository;

	@Autowired
	private UserSessionRepository userSessionRepository;

	@Override
	public User createUser(User user) throws UserException {

		Optional<User> existedUser = userRepository.findById(user.getUserId());
		if (existedUser.isPresent())
			throw new UserException("user already exist");

		return userRepository.save(user);
	}

	@Override
	public Police createPolice(Police police) throws PoliceException {
		Optional<Police> existedPolice = policeRepository.findById(police.getPoliceId());

		if (existedPolice.isPresent()) {
			throw new PoliceException("police already exist");
		}
		return policeRepository.save(police);
	}

	@Override
	public PoliceStation createPoliceStation(PoliceStation policeStation) throws PoliceStationException {

		Optional<PoliceStation> existedStation = policeStationRepository.findById(policeStation.getStationId());

		if (existedStation.isPresent()) {
			throw new PoliceStationException("policeStation already exist");
		}

		return policeStationRepository.save(policeStation);
	}

	@Override
	public String logInUsers(LoginDto loginDto) throws LoginException {

		User user = userRepository.findByMobileNumber(loginDto.getMobile());

		if (user == null) {
			throw new LoginException("Please enter valid number");
		}

		Optional<CurrentUserSession> currentUserSession = userSessionRepository.findById(user.getUserId());

		if (currentUserSession.isPresent()) {
			throw new LoginException("User already Logged In this number");
		}

		if (!user.getPassword().equals(loginDto.getPassword())) {
			throw new LoginException("Please Enter valid password");
		}

		String str = RandomString.make(6);

		CurrentUserSession currentSeession = new CurrentUserSession(user.getUserId(), str, LocalDateTime.now());

		userSessionRepository.save(currentSeession);

		return currentSeession.toString();
	}

	@Override
	public String logOutUsers(String str) throws LoginException {
		CurrentUserSession currentSeession = userSessionRepository.findByUuid(str);

		if (currentSeession == null) {
			throw new LoginException("User Not Logged In this mobile number");
		}

		userSessionRepository.delete(currentSeession);
		return "Logged Out successful";
	}

	@Override
	public List<Fir> getOldFir(Integer stationId) {

		Optional<PoliceStation> policeStation = policeStationRepository.findById(stationId);

		List<Fir> firs = policeStation.get().getFirList();

		ArrayList<Fir> openFIR = new ArrayList<>();

		for (Fir element : firs) {
			if (element.getIsOpen())
				openFIR.add(element);
		}
		return openFIR;
	}

	@Override
	public Police getPolice(Integer pStationId) throws PoliceStationException {

		PoliceStation policeStation = policeStationRepository.findById(pStationId).get();

		if (policeStation == null)
			throw new PoliceStationException("Invalid Police Station Code");

		List<Police> list = policeStation.getConstables();

		Police resultCase = null;

		int result = 0;

		for (Police p : list) {

			if (p.getCasesClosed().size() > result) {

				result = p.getCasesClosed().size();

				resultCase = p;
			}
		}
		Police police = policeStation.getOfficerInCharge();

		if (police.getCasesClosed().size() > result)

			return police;

		else
			return resultCase;
	}

	@Override
	public Fir deletedFir(Integer fId) {
		Fir fir = null;

		try {
			fir = firRepository.findById(fId).orElseThrow(() -> new FirException("No fir Found"));
			firRepository.deleteById(fId);
		} catch (FirException e) {
			e.printStackTrace();
		}

		return fir;
	}

	@Override
	public Fir updatedFir(Integer pStationId, Integer fId) {
		return null;
	}

	@Override
	public String deletedPolice(Integer police1, Integer police2) {

		Optional<Police> Police1 = policeRepository.findById(police1);

		List<Fir> firsFiled = Police1.get().getFirsFiled();

		Police1.get().setFirsFiled(new ArrayList<>());

		Optional<Police> Police2 = policeRepository.findById(police2);

		Police2.get().getFirsFiled().addAll(firsFiled);

		policeRepository.save(Police1.get());
		policeRepository.save(Police2.get());

		return "Deleted and assigned Succsessfully";
	}

}
