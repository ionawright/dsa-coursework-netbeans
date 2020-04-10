package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Student implements Serializable {
    private final int id;
    private static int idIterator = 0;

    private String firstName;
    private String lastName;
    private int regNumber;
    private Calendar regDate;
    private StudentType studentType;

    public Student() {
        this.id = ++idIterator;
        this.firstName = "";
        this.lastName = "";
    }

    public Student(String firstName, String lastName) {
        this.id = ++idIterator;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, StudentType studentType) {
        this.id = ++idIterator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentType = studentType;
    }

    public Student(String firstName, String lastName, int regNumber, StudentType studentType) {
        this.id = ++idIterator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.regNumber = regNumber;
        this.studentType = studentType;
    }

    public Student(String firstName, String lastName, int regNumber, Calendar regDate, StudentType studentType) {
        this.id = ++idIterator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.regNumber = regNumber;
        this.regDate = regDate;
        this.studentType = studentType;
    }

    public Student(int id, String firstName, String lastName, int regNumber, Calendar regDate, StudentType studentType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.regNumber = regNumber;
        this.regDate = regDate;
        this.studentType = studentType;

        if(id > Student.idIterator) {
            Student.idIterator = id;
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public Calendar getRegDate() {
        return regDate;
    }

    public StudentType isStudentType() {
        return studentType;
    }

    public static int getLastId() {
        return idIterator;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public void setRegDate(Calendar regDate) {
        this.regDate = regDate;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    public static void setIdIterator(int idIterator) {
        Student.idIterator = idIterator;
    }

    private String getFormattedRegDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(this.regDate.getTime());
        return dateString;
    }

    @Override
    public String toString() {
        return "\nStudent Id: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nReg Number: " + regNumber +
                "\nReg Date: " + getFormattedRegDate() +
                "\nStudent Type: " + studentType +
                "\n";
    }

    public String toString(char delimiter) {
        final String QUOTE = "\"";
        String output = Integer.toString(this.id) + delimiter +
                QUOTE + this.firstName + QUOTE + delimiter +
                QUOTE + this.lastName + QUOTE + delimiter +
                QUOTE + this.regNumber + QUOTE + delimiter +
                QUOTE + getFormattedRegDate() + QUOTE + delimiter +
                QUOTE + this.studentType + QUOTE + delimiter;
        return output;
    }
}