package com.jokerdemo.crm.dao.impl;



import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jokerdemo.crm.dao.OfferDao;
import com.jokerdemo.crm.domain.Offer;






public class OfferDaoImpl extends HibernateDaoSupport implements OfferDao{

	@Override
	public Offer get(Integer offerid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Offer.class, offerid);
	}

	@Override
	public boolean addbaodan(Offer offer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(offer);
		return true;
	}





}
