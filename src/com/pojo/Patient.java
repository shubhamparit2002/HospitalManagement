package com.pojo;

public class Patient {

	private int Pid;
	private String pName;
	private int age;
	private String gender;
	@Override
	public String toString() {
		return "Patient [Pid=" + Pid + ", pName=" + pName + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	public Patient(int pid, String pName, int age, String gender) {
		super();
		Pid = pid;
		this.pName = pName;
		this.age = age;
		this.gender = gender;
	}


	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
