package com.anybox.model;

import java.io.Serializable;

import javax.persistence.Entity;

import com.anybox.utils.AnyboxUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ResponseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7199622097452457096L;
	
	private int code;
	
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return AnyboxUtils.toString(this);
	}

}
