package es.udc.fic.iFinances.dao.employee;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.udc.fic.iFinances.modelutil.dao.GenericDaoHibernate;

@Repository("employeeDao")
public class EmployeeDaoHibernate extends GenericDaoHibernate<Employee, Long>
    implements EmployeeDao {

    @SuppressWarnings("unchecked")
    public List<Employee> findByDepartmentId(Long departmentId) {
        return null;
    }

}
