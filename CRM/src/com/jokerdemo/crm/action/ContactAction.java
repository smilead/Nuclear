package com.jokerdemo.crm.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.context.ApplicationContext;

import com.jokerdemo.crm.domain.Contacts;
import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.service.ContactsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ContactAction extends ActionSupport implements ModelDriven<Contacts> {
	private Contacts contacts=new Contacts();
	private ContactsService contactsService;
	private String  cuostomerid;

	public void setCuostomerid(String cuostomerid) {
		this.cuostomerid = cuostomerid;
	}

	public void setContactsService(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

	@Override
	public Contacts getModel() {
		// TODO Auto-generated method stub
		return contacts;
	}
	
	public String contact(){
		System.out.println("6666666666666");
		System.out.println(cuostomerid+1);
		ServletActionContext.getRequest().setAttribute("contacts",contactsService.findByNameQuery("tiange", cuostomerid) );
		System.out.println(contactsService.findByNameQuery("tiange", cuostomerid).get(0).getContactsbirthday());
		return "tiange11";
	}
	public String con(){
		return "tian";
	}
	public String add(){
		
		contacts.setCustomer((Customer)ServletActionContext.getRequest().getSession().getAttribute("customer"));
		contactsService.add(contacts);
		return "add";
	}
	public String com(){
		ServletActionContext.getRequest().setAttribute("contact", contactsService.get(contacts.getContactsid()));
		return "xiaotian";
	}
	public String updata(){
		contacts.setCustomer((Customer)ServletActionContext.getRequest().getSession().getAttribute("customer"));
		contactsService.updata(contacts);
		return "xxtian";
	}
	

}
