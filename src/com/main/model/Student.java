package com.main.model;

public class Student {
	private int id;
	private String name;
	private double perc;
	
	
	public Student() {
		super();
	}


	public Student(int id, double perc) {
		super();
		this.id = id;
		this.perc = perc;
	}


	public Student(int id, String name, double perc) {
		super();
		this.id = id;
		this.name = name;
		this.perc = perc;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", perc=" + perc + "]";
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


	public double getPerc() {
		return perc;
	}


	public void setPerc(double perc) {
		this.perc = perc;
	}
	

}
