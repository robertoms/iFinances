package es.udc.fic.iFinances.dao.employee;

import java.util.List;

import es.udc.fic.iFinances.modelutil.dao.GenericDao;

public interface EmployeeDao extends GenericDao<Employee, Long> {

    public List<Employee> findByDepartmentId(Long departmentId);

}
