package com.anybox.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class AnyboxFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//if (request.getHeader("Access-Control-Request-Method") != null
		//		&& "OPTIONS".equals(request.getMethod())) {
			// CORS "pre-flight" request
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
			//Access-Control-Allow-Headers "Origin, X-Requested-With, Content-Type, Accept"
//			response.addHeader("Access-Control-Allow-Methods",
//					"GET, POST, PUT, DELETE, OPTIONS");
//			response.addHeader("Access-Control-Allow-Headers",
//					"origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
//			response.addHeader("Access-Control-Max-Age", "1800");// 30 min
		//}
		filterChain.doFilter(request, response);
	}

}