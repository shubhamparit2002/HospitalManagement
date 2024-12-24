package com.controller;

import java.util.ArrayList;
import java.util.Scanner;
import com.pojo.Patient;
import com.service.PatientServiceImp;

public class PatientController {

    static Scanner sc = new Scanner(System.in);
    static PatientServiceImp pp = new PatientServiceImp();
    static ArrayList<Patient> patientList = new ArrayList<>(); // Added patientList

    public static void main(String[] args) {
        int choice;

        do {
            // Display the menu
            System.out.println();
            System.out.println("Enter your choice:");
            System.out.println("1. Register Patient");
            System.out.println("2. Get Patient Info by ID");
            System.out.println("3. Get All Patient Data");
            System.out.println("4. Insert Data into ArrayList");
            System.out.println("5. DELETE Data By Id");
            System.out.println("6. Update Data By Id");


            System.out.println("0. Exit");
            System.out.println();

            // Read user choice
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertData(); // Register a patient
                    break;
                case 2:
                    getById();
                    break;
                case 3:
                    fetchData();
                    break;
                case 4:
                    insertDataToArrayList();
                    break;
                case 5:
                	deleteEntry();
                	break;
                case 6:
                	updateDetails();
                	break;
                
                case 0:
                    System.out.println("Exit... Happy Coding!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
    
    public static void updateDetails() {
        System.out.println("Update Patient Name and Age using ID");

        System.out.println("Enter Patient ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        System.out.println("Enter Name:");
        String newName = sc.nextLine();

        System.out.println("Enter Age:");
        int newAge = sc.nextInt();
        System.out.println("Enter gender:");
        String gender = sc.next();


        try {
        	Patient p=new Patient(id, newName, newAge, gender);
            pp.updateDetails(p);
            System.out.println("Patient details updated successfully!");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    

    private static void deleteEntry() {
        // Prompt user to enter ID to delete
        System.out.println("Enter Patient ID to delete:");
        int id = sc.nextInt();
        try {
            pp.deleteEntry(id); // Pass the ID to the deleteEntry method
            System.out.println("Patient data deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error occurred while deleting data: " + e.getMessage());
        }
    }


	private static void insertDataToArrayList() {
        // Add patients to the list
        patientList = pp.insertDataToArrayList();
        System.out.println("Patients added to ArrayList successfully:");
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }

    private static void fetchData() {
        // Fetch all patient data
        pp.fetchData();
    }

    private static void getById() {
        // Get patient by ID
    	
        System.out.println("Enter Patient ID:");
        int id = sc.nextInt();
        pp.getById(id);
    }

    public static void insertData() {
        // Register a new patient
        System.out.println("Enter Patient ID, Name, Age, Gender:");

        System.out.println("Enter Patient ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume leftover newline
        System.out.println("Enter Patient Name:");
        String name = sc.nextLine();
        System.out.println("Enter Patient AGE:");
        int age = sc.nextInt();
        sc.nextLine(); // Consume leftover newline
        System.out.println("Enter Patient Gender:");
        String gender = sc.nextLine();

        Patient p = new Patient(id, name, age, gender);

        try {
            pp.regiter(p);
            System.out.println("Patient registered successfully!");
        } catch (Exception e) {
            System.out.println("Error occurred during registration: " + e.getMessage());
        }
    }
}
