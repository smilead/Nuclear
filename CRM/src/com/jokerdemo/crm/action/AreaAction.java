package com.jokerdemo.crm.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jokerdemo.crm.domain.Area;
import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.service.AreaService;
import com.opensymphony.xwork2.ActionSupport;

public class AreaAction extends ActionSupport{
	private AreaService as;
	private Integer pid;
	private List<Area> ars;


	public List<Area> getArs() {
		return ars;
	}

	public void setArea(List<Area> ars) {
		this.ars = ars;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public void setAs(AreaService as) {
		this.as = as;
	}
	
	public String getAreas() {
		ars=this.as.find(pid);
		return SUCCESS;
		
	}

}
