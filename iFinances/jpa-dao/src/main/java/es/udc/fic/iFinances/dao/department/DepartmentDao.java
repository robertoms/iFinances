package es.udc.fic.iFinances.dao.department;

import java.util.List;

import es.udc.fic.iFinances.modelutil.dao.GenericDao;

public interface DepartmentDao extends GenericDao<Department, Long> {

    public List<Department> findAll();

}
