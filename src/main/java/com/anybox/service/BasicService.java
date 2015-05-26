package com.anybox.service;

import java.util.List;

public interface BasicService<T> {
	
	public T add(T t);
	
	public T update(T t);
	
	public List<T> list();
	
	public T getById(int id);
	
	public void delete(int id);

}
