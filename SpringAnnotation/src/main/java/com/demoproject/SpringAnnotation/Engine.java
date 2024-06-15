package com.demoproject.SpringAnnotation;

import org.springframework.stereotype.Component;


@Component
public class Engine {

	
	private int capacity;
	private int pistons;
	private int torque;
	
	public Engine() {
		capacity =1200;
		pistons = 6;
		torque = 200;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPistons() {
		return pistons;
	}
	public void setPistons(int pistons) {
		this.pistons = pistons;
	}
	public int getTorque() {
		return torque;
	}
	public void setTorque(int torque) {
		this.torque = torque;
	}
	@Override
	public String toString() {
		return "Engine [capacity=" + capacity + " CC, pistons=" + pistons + " pistons, torque=" + torque + " Nm]";
	}
	
	
}
