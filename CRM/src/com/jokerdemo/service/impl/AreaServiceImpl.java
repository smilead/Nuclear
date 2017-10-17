package com.jokerdemo.service.impl;


import java.util.List;

import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.AreaDao;
import com.jokerdemo.crm.domain.Area;
import com.jokerdemo.service.AreaService;

public class AreaServiceImpl implements AreaService{
	private AreaDao ad;
	private HibernateTransactionManager tx;

	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	public void setAd(AreaDao ad) {
		this.ad = ad;
	}
	@Override
	public List<Area> find(int pid) {
		List<Area> ars = this.ad.find("select new Area(areaid,aname) from Area where pid = "+pid);
		
		return ars;
	}
	@Override
	public Area findById(int areaid) {

		return this.ad.get(areaid);
	}


}
