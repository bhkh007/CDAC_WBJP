package com.studentcrud.models;

public class Student {

	private int id;
	private String name;
	private float marks;
	private String gender;
	private String city;
	private String phone;
	
	
	public Student() {
		
	}
	
	public Student(int id, String name, float marks, String gender, String city, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.gender = gender;
		this.city = city;
		this.phone = phone;
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
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
