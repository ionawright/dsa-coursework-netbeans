///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Test;
//
//import model.Student;
//import model.StudentType;
//import org.junit.Test;
//import org.junit.Before;
//
//import java.util.Calendar;
//
//import static org.junit.Assert.assertEquals;
//
//
//
///**
// *
// * @author ionawright
// */
//public class StudentTest {
//       
//    Student studentName;
//    Student studentType;
//    Student studentReg;
//
//    @Before
//    public void before() {
//
//        Calendar regDate = Calendar.getInstance();
//        regDate.set(2019, 7, 8);
//
//        studentName = new Student("Blair", "Dickson");
//        studentType = new Student("Jasmine", "Wright", StudentType.UNDERGRADUATE);
//        studentReg = new Student("Jordan", "Pollock", 1234, regDate, StudentType.GRADUATE);
//    }
//
//    @Test
//    public void canGetStudentFirstName() {
//        System.out.println("Student First Name - unit test passed!");
//        assertEquals("Blair", studentName.getFirstName());
//    }
//
//    @Test
//    public void canGetStudentLastName() {
//        System.out.println("Student Last Name - unit test passed!");
//        assertEquals("Dickson", studentName.getLastName());
//    }
//
//    @Test
//    public void getRegNumber() {
//        System.out.println("Student Reg Num - unit test passed!");
//        assertEquals(1234, studentReg.getRegNumber());
//    }
//
//    @Test
//    public void getRegDate() {
//        Calendar regDate = Calendar.getInstance();
//        regDate.set(2019, 7, 8);
//
//        System.out.println("Student Reg Date - unit test passed!");
//        assertEquals(regDate, studentReg.getRegDate());
//    }
//
//    @Test
//    public void canGetStudentType() {
//        System.out.println("Student Type - unit test passed!");
//        assertEquals(StudentType.UNDERGRADUATE, studentType.isStudentType());
//    }
//}
