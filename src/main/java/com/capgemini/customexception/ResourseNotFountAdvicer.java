package com.capgemini.customexception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.payloads.ApiResponse;

@RestControllerAdvice
public class ResourseNotFountAdvicer {
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourseNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> resp = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((errors)->{
			String fieldName = ((FieldError)errors).getField();
			String defaultMessage = errors.getDefaultMessage();
			resp.put(fieldName, defaultMessage);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}	

}
