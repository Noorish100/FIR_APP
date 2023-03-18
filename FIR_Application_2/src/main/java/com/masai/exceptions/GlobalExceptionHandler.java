package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<MyErrorDetail> userNotFoundExceptionHandler(UserNotFound cf, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());

		err.setMessage(cf.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(FirException.class)
	public ResponseEntity<MyErrorDetail> firExceptionHandler(FirException cf, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());

		err.setMessage(cf.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(PoliceException.class)
	public ResponseEntity<MyErrorDetail> policeExceptionHandler(PoliceException cf, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());

		err.setMessage(cf.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(PoliceStationException.class)
	public ResponseEntity<MyErrorDetail> policeStationExceptionHandler(PoliceStationException cf, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());

		err.setMessage(cf.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> exceptionHandler(Exception cf, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());

		err.setMessage(cf.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
}
