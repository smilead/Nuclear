package com.jokerdemo.service.impl;


import org.springframework.transaction.annotation.Transactional;

import com.jokerdemo.crm.dao.OfferDao;
import com.jokerdemo.crm.domain.Offer;
import com.jokerdemo.service.OfferService;




@Transactional
public class OfferServiceImpl implements OfferService{

	private OfferDao offerDao;
	
	
	public void setOfferDao(OfferDao offerDao) {
		this.offerDao = offerDao;
	}


	@Override
	public Offer get(Integer offerid) {
		// TODO Auto-generated method stub
		return offerDao.get(offerid);
	}


	@Override
	public boolean addbaodan(Offer offer) {
		// TODO Auto-generated method stub
		return offerDao.addbaodan(offer);
	}




}
