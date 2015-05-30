package com.anybox.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.anybox.Exception.NotEnoughProductException;
import com.anybox.model.NotEnoughExceptionModel;

@ControllerAdvice
public class GlobalExceptionHandler extends ExceptionHandlerExceptionResolver {

	
	private static final Logger logger = LoggerFactory
			.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleException(Exception ex, HttpServletRequest request) {
		logger.info("Internal server error Occured:: " + ex.toString());
		ex.printStackTrace();
		return new ModelAndView().addObject("error", "err msg");
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NotEnoughProductException.class)
	public @ResponseBody NotEnoughExceptionModel handleNotEnoughProductException(
			NotEnoughProductException ex) {
		logger.info("NotEnoughProductException Occured:: "
				+ ex.getModel().toString());
		return ex.getModel();
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SQLException.class)
	public void handleSQLException(Exception ex) {
		logger.info("SQLException Occured:: " + ex.toString());
		ex.printStackTrace();
	}

}
