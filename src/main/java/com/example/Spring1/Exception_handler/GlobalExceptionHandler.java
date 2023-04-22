package com.example.Spring1.Exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Spring1.dto.ResponseDTO;
import com.example.Spring1.exception.UserAlreadyExistException;
import com.example.Spring1.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<?>HandleUserAlreadyExistException(UserAlreadyExistException e){
		return new ResponseEntity<>(new ResponseDTO<>("error",e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?>UserNotFoundException(UserNotFoundException e){
		return new ResponseEntity<>(new ResponseDTO<>("error",e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
}