package in.tp.lms.controller;

import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.tp.lms.exception.LoanException;

@RestControllerAdvice
public class GlobalExceptionAdvise {
	
	private Logger logger;
	
	public GlobalExceptionAdvise() {
		logger = Logger.getLogger(GlobalExceptionAdvise.class.getName());
	}

	@ExceptionHandler(LoanException.class)
	public ResponseEntity<String> handleLoanTypeException(LoanException excep){
		logger.severe(excep.getMessage());
		return new ResponseEntity<String>(excep.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleOtherExceptions(Exception excep){
		logger.severe(excep.getMessage());
		return new ResponseEntity<String>(excep.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
