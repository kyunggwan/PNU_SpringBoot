package edu.pnu.domain;

import java.util.Date;

public class MemberVO {

	private String id;
	private String name;
	private String pass;
	private Date regidate;

	public MemberVO(String id, String name, String pass, Date regidate) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.regidate = regidate;
	}

	public MemberVO() {

	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", pass=" + pass + ", regidate=" + regidate + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

}
