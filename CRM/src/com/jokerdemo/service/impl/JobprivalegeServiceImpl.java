package com.jokerdemo.service.impl;


import java.util.List;

import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.JobprivalegeDao;
import com.jokerdemo.crm.domain.Jobprivalege;
import com.jokerdemo.service.JobprivalegeService;


public class JobprivalegeServiceImpl implements JobprivalegeService{
	private JobprivalegeDao jpd;
	private HibernateTransactionManager tx;

	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	public void setJpd(JobprivalegeDao jpd) {
		this.jpd = jpd;
	}
	@Override
	public String findPrivs(Integer jobno) {
		if(jobno==null) return null;
		String hql = "select new Jobprivalege(p.privilegename) from Jobprivalege as jp left join jp.job as j left join jp.privilege as p where j.jobno = "+jobno;
		List<Jobprivalege> jobprivaleges = this.jpd.find(hql);
		String privs = "";
		for(Jobprivalege jobprivalege:jobprivaleges) {
			privs += " "+jobprivalege.getPrivilegename();
		}
		return privs;
	}
}
