package com.domain;

import java.util.Date;

/**
 * @Title: 学生类
 * @Package com.domain
 * @Description: 学生类封装(用一句话描述该文件做什么)
 * @author xu_yuxin
 * @date 2019年9月26日
 * @version V1.0
 */
public class Student {
	private int sid;
	private String name;
	private String gender;
	private String phone;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	private Date birthday;
	private String hobby;
	private String info;

}
