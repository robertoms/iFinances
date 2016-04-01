package es.udc.fic.iFinances.dao.main;


import static es.udc.fic.iFinances.dao.util.GlobalNames.SPRING_CONFIG_FILE;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import es.udc.fic.iFinances.dao.department.Department;
import es.udc.fic.iFinances.dao.department.DepartmentDao;
import es.udc.fic.iFinances.dao.employee.Employee;
import es.udc.fic.iFinances.modelutil.exceptions.InstanceNotFoundException;
public class Main {

	public static void main(String[] args) throws Throwable {
		
		PlatformTransactionManager transactionManager;
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILE);
		
		transactionManager = ctx.getBean(PlatformTransactionManager.class);
		
		TransactionStatus transactionStatus =
	            transactionManager.getTransaction(null);
		
		DepartmentDao departmentDao= DepartmentDao.class.cast(ctx.getBean("departmentDao"));
		try {
			
		
		Department ict = new Department(
                "Department of Information and Communications Technologies",
                Calendar.getInstance());
            /*Employee fbellas = new Employee("Fernando", "Bellas Permuy", "tu",
                200);
            Employee jrs = new Employee("Juan", "Raposo Santiago", "cd", 200);
            Employee mad = new Employee("Manuel", "Alvarez Diaz", "cd", 200);
            Employee jss = new Employee("Jose", "Soto Soto", "tu", 300);
            */
         
         departmentDao.save(ict);
         Department d= departmentDao.find(ict.getDepartmentId());
         
         System.out.println("aaaa");
         transactionManager.commit(transactionStatus);

        } catch (Throwable e) {
            transactionManager.rollback(transactionStatus);
            throw e;
        }
		
		
		
	
	}

}
