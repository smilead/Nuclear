package com.jokerdemo.crm.dao;

import com.jokerdemo.crm.domain.Offer;



public interface OfferDao {

	public Offer get(Integer offerid);
	public boolean addbaodan(Offer offer);
}
