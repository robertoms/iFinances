package es.udc.fic.iFinances.dao.main;


import static es.udc.fic.iFinances.dao.util.GlobalNames.SPRING_CONFIG_FILE;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import es.udc.fic.iFinances.dao.department.Department;
import es.udc.fic.iFinances.dao.department.DepartmentDao;
public class Main {

	public static void main(String[] args) throws Throwable {
		
		//PlatformTransactionManager transactionManager;
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILE);
		
		PlatformTransactionManager transactionManager = context.getBean(PlatformTransactionManager.class);
        
        DepartmentDao departmentDao = context.getBean(DepartmentDao.class);
        TransactionStatus transactionStatus =
                transactionManager.getTransaction(null);
		try {
			
		
		Department ict = new Department(
                "Department of Information and Communications Technologies",
                Calendar.getInstance());
         
         departmentDao.save(ict);
         transactionManager.commit(transactionStatus);
    
        System.out.println("aaaa");

        } catch (Throwable e) {
           // transactionManager.rollback(transactionStatus);
            throw e;
        }
		
		
		
	
	}

}
