package com.studentmvc.model;

public class Student {

	private int id;
	private String name;
	private String phone;
	private float marks;
	private String city;
	private String gender;
	
	public Student() {
		
	}
	
	
	public Student(int id, String name, String phone, float marks, String city, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.marks = marks;
		this.city = city;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
