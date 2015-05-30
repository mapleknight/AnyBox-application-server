package com.anybox.utils;

import com.anybox.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AnyboxUtils {
	
	public static <T> String toString(T t) {
		ObjectMapper objectMapper = new ObjectMapper();
		String result = "";
		try {
			result = objectMapper.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
		return result;
	}
	
	public static void main(String args[]) {
		User user = new User();
		user.setEmail("wangke@gmail.com");
		user.setPassword("123456");
		
		System.out.println(AnyboxUtils.toString(user));
	}

}
