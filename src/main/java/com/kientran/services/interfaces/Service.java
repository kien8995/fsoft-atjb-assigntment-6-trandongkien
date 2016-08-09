package com.kientran.services.interfaces;

import java.util.List;

public interface Service<T, ID> {
	public abstract List<T> getAll();

	public abstract T save(T t);

	public abstract T update(T t);
}
