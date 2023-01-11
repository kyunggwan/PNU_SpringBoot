package edu.pnu.domain;

import java.util.Date;

public class MemberVO {

	private int id;
	private String name;
	private String pass;
	private Date regidate;

	public MemberVO() {
		super();
	}

	public MemberVO(int id, String name, String pass, Date regidate) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.regidate = regidate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	public String getPass() {
		return pass;
	}

	public Date getRegidate() {
		return regidate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", pass=" + pass + ", regidate=" + regidate + "]";
	}

}
