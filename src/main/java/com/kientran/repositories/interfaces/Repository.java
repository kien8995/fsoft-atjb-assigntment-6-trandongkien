package com.kientran.repositories.interfaces;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface Repository<T, ID> {
	public abstract T findById(ID id);

	public abstract List<T> findAll();

	public abstract List<T> findByCriteria(Criterion... criterion);

	public abstract T persist(T entity);

	public abstract T merge(T entity);

	public abstract void flush();

	public abstract void clear();
}
