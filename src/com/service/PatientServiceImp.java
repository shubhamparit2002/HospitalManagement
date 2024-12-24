package com.service;

import java.util.ArrayList;

import com.dao.DAO;
import com.pojo.Patient;

public class PatientServiceImp  implements PatientInterface{

	public void regiter(Patient p) {
		DAO.insertPatientD(p);
	}

	@Override
	public boolean IsRegisted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateDetails(Patient p) {
		DAO.updateDetails(p);
		
	}

	@Override
	public void deleteEntry(int id) {
		DAO.deleteEntry(id);
	}

	@Override
	public void viewData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getById(int id) {
		System.out.println("dd");
		DAO.patientById(id);
		
		
	}

	@Override
	public void fetchData() {
		DAO.fetchData();
		
	}

	@Override
	public ArrayList<Patient> insertDataToArrayList() {
		return DAO.insertDataToArrayList();
		
	}

	

}
