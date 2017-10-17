package com.jokerdemo.crm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jokerdemo.crm.action.SalesManagementAction;
import com.jokerdemo.crm.dao.ChanceDao;
import com.jokerdemo.crm.dao.UserDao;
import com.jokerdemo.crm.dao.impl.ChanceDaoImpl;
import com.jokerdemo.crm.domain.Chance;
import com.jokerdemo.crm.domain.User;
import com.jokerdemo.service.SaleManagementService;
import com.jokerdemo.service.impl.SaleManagementServiceImpl;

public class SmileTest {
//	@Test
//	public void findAllChance() {
//		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");	
//		ChanceDao chanceDao=(ChanceDao)application.getBean("chanceDao");
//		List<Chance> chances=chanceDao.findAll();
//		System.out.println(chances);
//		Chance chance=chances.get(0);
//		System.out.println(chance.getFrom());
//	}
	@Test
	public void findchanceById() {
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");	
		SaleManagementService ss=(SaleManagementService)application.getBean("saleManagementService");
	//	UserDao userDao=(UserDao)application.getBean("userDao");
		//User user=userDao.get(8);
		ss.delete(22);
//		chance.setUserByAssignuserid(user);
//		System.out.println(chance.getContactsname());
//		chance.setSource("asdfasdf");
		
	//	chanceDao.update(chance);
	
	}
@Test
	public void deletechance() {
		ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		SalesManagementAction action=(SalesManagementAction)application.getBean("salesManagementAction");
		SaleManagementService saleManagementService=(SaleManagementService)application.getBean("saleManagementService");
		System.out.println(saleManagementService.delete(10));

	}
}
