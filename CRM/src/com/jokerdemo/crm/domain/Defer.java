package com.jokerdemo.crm.domain;
// Generated 2017-10-12 17:23:36 by Hibernate Tools 3.5.0.Final

/**
 * Defer generated by hbm2java
 */
public class Defer implements java.io.Serializable {

	private int deferid;
	private Churns churns;
	private String deferstep;
	private String defercontent;

	public Defer() {
	}

	public Defer(int deferid) {
		this.deferid = deferid;
	}

	public Defer(int deferid, Churns churns, String deferstep, String defercontent) {
		this.deferid = deferid;
		this.churns = churns;
		this.deferstep = deferstep;
		this.defercontent = defercontent;
	}

	public int getDeferid() {
		return this.deferid;
	}

	public void setDeferid(int deferid) {
		this.deferid = deferid;
	}

	public Churns getChurns() {
		return this.churns;
	}

	public void setChurns(Churns churns) {
		this.churns = churns;
	}

	public String getDeferstep() {
		return this.deferstep;
	}

	public void setDeferstep(String deferstep) {
		this.deferstep = deferstep;
	}

	public String getDefercontent() {
		return this.defercontent;
	}

	public void setDefercontent(String defercontent) {
		this.defercontent = defercontent;
	}

}
