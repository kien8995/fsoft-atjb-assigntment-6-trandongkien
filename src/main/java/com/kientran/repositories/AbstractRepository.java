package com.kientran.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import com.kientran.repositories.interfaces.Repository;
import com.kientran.utils.HibernateUtil;

public class AbstractRepository<T, ID extends Serializable> implements Repository<T, ID> {

	private Class<T> persistentClass;
	private Transaction transaction;
	private Session session;

	public AbstractRepository() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected Session getSession() {
		if (this.session == null) {
			this.session = HibernateUtil.getSessionFactory().openSession();
		}
		return this.session;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public T findById(ID id) {
		return getSession().get(this.getPersistentClass(), id);
	}

	@Override
	public List<T> findAll() {
		return this.findByCriteria();
	}

	@Override
	public List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = this.getSession().createCriteria(this.getPersistentClass());

		for (Criterion c : criterion) {
			crit.add(c);
		}

		return crit.list();
	}

	@Override
	public T persist(T entity) {
		this.transaction = this.getSession().beginTransaction();
		try {
			this.getSession().save(entity);
			this.transaction.commit();
		} catch (Exception e) {
			this.transaction.rollback();
			return null;
		} finally {
			clear();
		}
		return entity;
	}

	@Override
	public T merge(T entity) {
		this.transaction = this.getSession().beginTransaction();
		try {
			this.getSession().merge(entity);
			this.transaction.commit();
		} catch (Exception e) {
			this.transaction.rollback();
			return null;
		} finally {
			clear();
		}
		return entity;
	}

	@Override
	public void flush() {
		this.getSession().flush();
	}

	@Override
	public void clear() {
		this.getSession().clear();
	}

}
