package es.udc.fic.iFinances.modelutil.dao;


import java.io.Serializable;
import es.udc.fic.iFinances.modelutil.exceptions.*;


public interface GenericDao <E, PK extends Serializable>{

	void save(E entity);

	E find(PK id) throws InstanceNotFoundException;

	void remove(PK id) throws InstanceNotFoundException;

}