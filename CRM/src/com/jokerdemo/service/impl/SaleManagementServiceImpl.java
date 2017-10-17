package com.jokerdemo.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.jokerdemo.crm.dao.ChanceDao;
import com.jokerdemo.crm.dao.UserDao;
import com.jokerdemo.crm.dao.impl.UserDaoImpl;
import com.jokerdemo.crm.domain.Chance;
import com.jokerdemo.crm.domain.User;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.SaleManagementService;
import com.jokerdemo.service.UserService;
import com.sun.net.httpserver.Authenticator.Success;
@Transactional
public class SaleManagementServiceImpl implements SaleManagementService{
	private ChanceDao chanceDao=null;
	private PageModel<Chance> page=null;
	private HibernateTransactionManager tx;
	public void setPage(PageModel<Chance> page) {
		this.page = page;
	}

	
	public void setChanceDao(ChanceDao chanceDao) {
		this.chanceDao = chanceDao;
	}

	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}

	

	@Override
	public PageModel<Chance> searchChance(String searchCustomername, String searchContactsname, String searchOutline,int currentPage, int pageSize) {
		// TODO Auto-generated method stub
	
		String hql=" where ";
		if(!"".equals(searchContactsname)) {
			hql=hql+"contactsname like '%"+searchContactsname+"%'";
			if(!"".equals(searchOutline))
				hql=hql+" and outline like '%"+searchOutline+"%'";
			if(!"".equals(searchCustomername))
				hql=hql+" and customername like '%"+searchCustomername+"%'";
		}else if(!"".equals(searchCustomername)) {
				hql=hql+"customername like '%"+searchCustomername+"%'";
				if(!"".equals(searchOutline))
					hql=hql+" and outline like '%"+searchOutline+"%'";				
		}else if(!"".equals(searchOutline)){
			hql=hql+"outline like '%"+searchOutline+"%'";
		}else {
			hql="";
		}
		hql="select new Chance(c.chanceid,c.customername,c.outline,c.contactsname,c.contactsphone,c.createtime) from Chance as c "+hql;
		PageModel<Chance> page=(PageModel<Chance>)chanceDao.listPage(hql, currentPage, pageSize);
		return page;
	}

	@Override
	public Chance getChance(int id) {
		// TODO Auto-generated method stub
		return (Chance)chanceDao.get(id);
	}

	@Override
	public String addChance(Chance chance) {
		chanceDao.add(chance);
		return "success";
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return chanceDao.delete(id);
	}
	
	
	
	@Override
	public boolean assignChanceService(Integer chanceId,Integer userid) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao= (UserDaoImpl)applicationContext.getBean("userDao");
		User user=userDao.get(userid);
		Chance chance=chanceDao.get(chanceId);
		chance.setUserByAssignuserid(user);
		if(chanceDao.update(chance)) {
			return true;	
		}
		return false;
		
	}

	@Override
	public boolean updateChanceService(Chance chance) {
		// TODO Auto-generated method stub
		System.out.println(chance.getChanceid());
		Chance ch=chanceDao.get(chance.getChanceid());
		ch.setContactsname(chance.getContactsname());
//		ch.setAssigntime(chance.getAssigntime());
//		ch.setContactsname(chance.getContactsname());
//		ch.setCreatetime(chance.getCreatetime());
//		ch.setOutline(chance.getOutline());
//		ch.setCustomername(chance.getCustomername());
//		ch.setSource(chance.getSource());
//		ch.setStatus(chance.getStatus());
		return chanceDao.update(ch);
		
	}
	
	


}
