package com.jokerdemo.crm.domain;
// Generated 2017-10-12 17:23:36 by Hibernate Tools 3.5.0.Final

/**
 * Jobprivalege generated by hbm2java
 */
public class Jobprivalege implements java.io.Serializable {

	private Integer jpid;
	private Privilege privilege;
	private Job job;
	private String privilegename;
	
	public Jobprivalege() {
	}
	
	public Jobprivalege(String privilegename) {
		this.privilegename = privilegename;
	}

	public Jobprivalege(Privilege privilege, Job job) {
		this.privilege = privilege;
		this.job = job;
	}

	public String getPrivilegename() {
		return privilegename;
	}

	public void setPrivilegename(String privilegename) {
		this.privilegename = privilegename;
	}

	public Integer getJpid() {
		return this.jpid;
	}

	public void setJpid(Integer jpid) {
		this.jpid = jpid;
	}

	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
