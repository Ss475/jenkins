package info.prime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceDemo {
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> getResponse(Exception exp){
		ExceptionResponse response = new ExceptionResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(exp.getMessage());
		response.setTime(System.currentTimeMillis());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

}
