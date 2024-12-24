package com.service;

import java.util.ArrayList;

import com.pojo.Patient;

public interface PatientInterface {
	public void regiter(Patient p);
	public boolean IsRegisted();
	public void updateDetails(Patient p);
	public void deleteEntry(int id);
	public void viewData();
	void getById(int id);
	void fetchData();
	ArrayList<Patient> insertDataToArrayList();

}
