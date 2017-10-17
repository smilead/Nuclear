package com.jokerdemo.service;

import com.jokerdemo.crm.domain.Offer;



public interface OfferService {

	public Offer get(Integer  offerid);
	public boolean addbaodan(Offer offer);
	
}
