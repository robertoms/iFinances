package es.udc.fic.iFinances.dao.test;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fic.iFinances.dao.department.Department;
import es.udc.fic.iFinances.dao.department.DepartmentDao;
import es.udc.fic.iFinances.modelutil.exceptions.InstanceNotFoundException;
import static es.udc.fic.iFinances.dao.util.GlobalNames.SPRING_CONFIG_FILE;
import static org.junit.Assert.assertTrue;

/**
 * It only includes two test cases for demonstration purposes.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {SPRING_CONFIG_FILE})
@Transactional
public class AppTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void test() throws InstanceNotFoundException {
    	
    Department dept= new Department("Dep1", Calendar.getInstance());
    departmentDao.save(dept);
    
    Long id= dept.getDepartmentId();
    		
        assertTrue(true);
    }



}
