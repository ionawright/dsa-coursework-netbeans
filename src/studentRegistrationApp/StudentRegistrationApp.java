package studentRegistrationApp;

import controllers.StudentRegistrationController;
import model.Student;
import model.StudentType;
import model.StudentList;

import java.util.Calendar;

public class StudentRegistrationApp {

    public static void run() {
        System.out.println("Hello, welcome to the student registration application");

        StudentRegistrationController studentController = new StudentRegistrationController();
        studentController.run();
        System.out.println("Goodbye");
    }

    public static void main(String[] args) {
        StudentRegistrationApp studentReg = new StudentRegistrationApp();

        Calendar regDate = Calendar.getInstance();
        regDate.set(2019, 7, 8);
        Student student1 = new Student("Joe", "Blogs", 534543, regDate, StudentType.GRADUATE);
        Student student2 = new Student("Jane", "Blogs", 134345, regDate, StudentType.UNDERGRADUATE);
        Student student3 = new Student("Jack", "Blogs", 135635, regDate, StudentType.UNDERGRADUATE);
        Student student4 = new Student("Jack", "Blogs", 135635, regDate, StudentType.UNDERGRADUATE);


        StudentList studentList = new StudentList();
        studentList.addStudent(student1);
//        studentList.addStudent(student2);
//        studentList.addStudent(student3);
//        studentList.addStudent(student4);
        
//        System.out.println(studentList.displayStudentList());
        
//        studentList.removeStudent(student4);
//        System.out.println(studentList.displayStudentList());
        studentReg.run();

    }
}
