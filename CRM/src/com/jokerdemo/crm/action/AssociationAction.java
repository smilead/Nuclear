package com.jokerdemo.crm.action;

import org.apache.struts2.ServletActionContext;

import com.jokerdemo.crm.domain.Association;
import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.service.AssociationService;
import com.opensymphony.xwork2.ModelDriven;

public class AssociationAction extends BaseAction implements ModelDriven<Association> {
		private Association association=new Association();
		private AssociationService associationService;
		private String cuostomerid;
	public void setCuostomerid(String cuostomerid) {
			this.cuostomerid = cuostomerid;
		}
	public void setAssociationService(AssociationService associationService) {
			this.associationService = associationService;
		}
	@Override
	public Association getModel() {
		// TODO Auto-generated method stub
		return association;
	}
	public String tian(){
		System.out.println(cuostomerid);
		ServletActionContext.getRequest().setAttribute("assoction",associationService.findByNameQuery("tiange11", cuostomerid) );
		return "tian1111";
	}
	public String xxxx(){
		return "tttt";
	}
	public String add(){
		association.setCustomer((Customer)ServletActionContext.getRequest().getSession().getAttribute("customer"));
		associationService.save(association);
		return "mmm";
	}

}
