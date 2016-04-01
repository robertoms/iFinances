package es.udc.fic.iFinances.modelutil.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.udc.fic.iFinances.modelutil.exceptions.InstanceNotFoundException;

public class GenericDaoHibernate<E, PK extends Serializable> implements
GenericDao<E, PK> {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public GenericDaoHibernate() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	

	public void save(E entity) {
		entityManager.merge(entity);
	}

	@SuppressWarnings("unchecked")
	public E find(PK id) throws InstanceNotFoundException {
		E entity = (E) entityManager.find(entityClass, id);
		if (entity == null) {
			throw new InstanceNotFoundException(id, entityClass.getName());
		}
		return entity;
	}

	public void remove(PK id) throws InstanceNotFoundException {
		entityManager.remove(find(id));
	}

}