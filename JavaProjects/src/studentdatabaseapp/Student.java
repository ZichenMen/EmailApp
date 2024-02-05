package studentdatabaseapp;

import java.util.Arrays;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // constructor: prompt user to enter student's name and year
    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's first name: ");
        this.firstName = scanner.nextLine();
        System.out.print("Enter student's last name: ");
        this.lastName = scanner.nextLine();
        System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior" +
                "\nEnter student's grade year: ");
        this.gradeYear = scanner.nextInt();
        setStudentID();
    }
    // Generate an ID
    public void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Course enrolled1: " + courses);
        do {
            System.out.println("Enter course to enroll (Q to quit): ");
            String course = scanner.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                System.out.println("Course enrolled1: " + courses);
                tuitionBalance += costOfCourse;
            } else break;
        } while (1 != 2);

        System.out.println("Course enrolled3: " + courses);

    }

    // View balance
    public void viewBalance() {
        System.out.println("Your balance is : $" + tuitionBalance);
    }

    // pay tuition
    public void payTuition() {
        viewBalance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your payment: ");
        int payment = scanner.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thanks for your payment of $" + payment);
        viewBalance();
    }
    // show info
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }

}
