package com.masai.services;

import java.util.List;

import com.masai.exceptions.LoginException;
import com.masai.exceptions.PoliceException;
import com.masai.exceptions.PoliceStationException;
import com.masai.exceptions.UserException;
import com.masai.model.Fir;
import com.masai.model.LoginDto;
import com.masai.model.Police;
import com.masai.model.PoliceStation;
import com.masai.model.User;

public interface UserService {

	public User createUser(User user) throws UserException;

	public Police createPolice(Police police) throws PoliceException;

	public PoliceStation createPoliceStation(PoliceStation policeStation) throws PoliceStationException;

	public String logInUsers(LoginDto loginDto) throws LoginException;

	public String logOutUsers(String str) throws LoginException;

	public List<Fir> getOldFir(Integer stationId);

	public Police getPolice(Integer pStationId) throws PoliceStationException;

	public Fir deletedFir(Integer fId);

	public Fir updatedFir(Integer pStationId, Integer fId);

	public String deletedPolice(Integer police1,Integer police2);

}
