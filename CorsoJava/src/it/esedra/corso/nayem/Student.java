package it.esedra.corso.nayem;

public class Student {
	private String Name;
	private String Surename;
	private int age;
	private University university;

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public void display() {

	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurename() {
		return Surename;
	}

	public void setSurename(String surename) {
		Surename = surename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
