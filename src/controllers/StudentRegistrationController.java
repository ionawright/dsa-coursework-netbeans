package controllers;

import model.Student;
import model.StudentList;
import repositories.Repository;
import helpers.InputHelper;

public class StudentRegistrationController {
    
    private final Repository repository;
    StudentList students;

    private Student student;

    public StudentRegistrationController() {
        students = new StudentList();
        InputHelper input = new InputHelper();
        char c = input.readCharacter("\nLoad an existing file?");
        if ( c == 'Y' || c == 'y') {
            String filename = input.readString("Enter file name:");
            this.repository = new Repository(filename);
        } else {
            this.repository = new Repository();
        }
    }

    public void run() {
        boolean finished = false;

        do {
            char choice = displayMenu();
            switch (choice) {
                case 'A': addStudent();
                    break;
                case 'B': removeStudent();
                    break;
                case 'C': findStudentByRegNum();
                    break;
                case 'D': findStudentByLastName();
                    break;
                case 'E': storeFile();
                    break;
                case 'Q': finished = true;
            }
        } while (!finished);
    }

    private char displayMenu() {
        InputHelper input = new InputHelper();
        System.out.println("A. Add student ");
//        System.out.println("B. Remove student ");
        System.out.println("C. Find student by registration number");
        System.out.println("D. Find student by last name");
        System.out.println("E. Store file");
        System.out.println("Q. Quit");
        return input.readCharacter("\nEnter choice", "ABCDEQ");
    }

    private void addStudent() {
        InputHelper input = new InputHelper();
        String firstName = input.readString("Enter student first name");
        String lastName = input.readString("Enter student last name");
        Integer regNumber = input.readInt("Enter student registration number");
        String regDate = input.readString("Enter student registration day");
        String studentType = input.readString("Select student type");
        Student newStudent = new Student(firstName, lastName);
        repository.add(newStudent);
    }

    private void removeStudent() {
        InputHelper inputHelper = new InputHelper();
        boolean validStudentId = false;
        Student requiredStudent = null;
        do {
            int id = inputHelper.readInt("Enter student Id");
//            requiredStudent = repository.getItem(id);
            if (requiredStudent != null) {
                validStudentId = true;
            }
        } while (!validStudentId);
        System.out.println("Student\n========\n" + requiredStudent);
    }

    private void findStudentByRegNum() {
        InputHelper inputHelper = new InputHelper();
        String regNum = inputHelper.readString("Enter student registration number");

    }

    private void findStudentByLastName() {
        InputHelper inputHelper = new InputHelper();
        String lastName = inputHelper.readString("Enter student last name");

    }
    
    private void storeFile() {
        InputHelper inputHelper = new InputHelper();
        String fileName = inputHelper.readString("Enter name for your file");
        repository.store(fileName);
    }

}