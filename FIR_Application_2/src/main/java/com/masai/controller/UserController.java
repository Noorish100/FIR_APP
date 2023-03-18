package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.FirException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.PoliceException;
import com.masai.exceptions.PoliceStationException;
import com.masai.exceptions.UserException;
import com.masai.model.Fir;
import com.masai.model.LoginDto;
import com.masai.model.Police;
import com.masai.model.PoliceStation;
import com.masai.model.User;
import com.masai.services.UserService;

@RestController
@RequestMapping("/masaifir")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/login")
	public ResponseEntity<String> logInUsers(@RequestBody LoginDto loginDto) throws LoginException {

		String result = userService.logInUsers(loginDto);

		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	@PostMapping("/user/logout")
	public String logOutUsers(@RequestParam(required = false) String str) throws LoginException {

		return userService.logOutUsers(str);

	}

	@PostMapping("/user/register")
	public ResponseEntity<User> createUser(@RequestBody User user) throws UserException {

		return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);

	}

	@PostMapping("/user/registerPolice")
	public ResponseEntity<Police> createPolice(@RequestBody Police police) throws PoliceException {

		return new ResponseEntity<>(userService.createPolice(police), HttpStatus.OK);

	}

	@PostMapping("/user/registerPoliceStation")
	public ResponseEntity<PoliceStation> createPoliceStation(@RequestBody PoliceStation policeStation)
			throws PoliceStationException {

		return new ResponseEntity<>(userService.createPoliceStation(policeStation), HttpStatus.OK);

	}

	@DeleteMapping("/user/fir/{firId}")
	public ResponseEntity<Fir> deletedFir(@PathVariable Integer firId) throws FirException {

		return new ResponseEntity<Fir>(userService.deletedFir(firId), HttpStatus.OK);

	}

	@DeleteMapping("/user/officer/{police1}/{police2}")
	public ResponseEntity<String> deletedPolice(@PathVariable("police1") Integer police1,
			@PathVariable("police2") Integer police2) throws PoliceException {

		String deletedPolice = userService.deletedPolice(police1, police2);
		return new ResponseEntity<>(deletedPolice, HttpStatus.OK);
	}

}
