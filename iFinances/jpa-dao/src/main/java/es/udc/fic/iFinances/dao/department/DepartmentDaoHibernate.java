package es.udc.fic.iFinances.dao.department;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fic.iFinances.modelutil.dao.GenericDaoHibernate;;
@Transactional
@Repository("departmentDao")
public class DepartmentDaoHibernate extends
        GenericDaoHibernate<Department, Long> implements DepartmentDao {

    @SuppressWarnings("unchecked")
    public List<Department> findAll() {
        return findAll();
    }

}
