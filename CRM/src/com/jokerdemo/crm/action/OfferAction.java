package com.jokerdemo.crm.action;


import com.jokerdemo.crm.domain.Offer;
import com.jokerdemo.service.OfferService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OfferAction extends ActionSupport implements ModelDriven<Offer>{

	private Offer offer=new Offer();
	private OfferService offerService;
	
	
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}


	@Override
	public Offer getModel() {
		// TODO Auto-generated method stub
		return offer;
	}

	public String chadingdan(){
		
		System.out.println(offer.getOfferid());
		Offer offer1=this.offerService.get(offer.getOfferid());
		if(offer1==null){
			return SUCCESS;
		}else{
			return "fail";
			
		}
	}
	
	public String addbaojia(){
		System.out.println(offer);
		boolean res=offerService.addbaodan(offer);
		if(res){
			return SUCCESS;
		}else{
			return "fail";
		}

	}
	
	
}
