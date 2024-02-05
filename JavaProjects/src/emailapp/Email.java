package emailapp;

import java.util.Scanner;
/**
 * Design a New Hire Email Creating Application
 * Application functions:
 *  Generate an email with the following syntax: firstname.lastname@department.company.com
 *  Determine the department (sales, development, accounting), if none leave blank
 *  Generate a random String for a password
 *  Have set methods to change the password, set the mailbox capacity
 *  Define an alternate email address
 *  Have get methods to display the name, email, and mailbox capacity
 *
 * @author Zichen Men <zichen.men@bellevuecollege.edu>
 * @version ____1.0______
 */
public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String passWord;
    private String email;
    private int mailboxCapacity = 100;
    private String alternateEmail;
    private final int DefaultPwLength = 10;
    private final String CompanyPrefix = "BC.com";

    // constructor to receive the first and last name
    public Email(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);

        // call the method asking for the department - return the department
        department = this.askForDepartment();
        System.out.println("Department: " + department);

        // call the method to generate a random password
        this.passWord = this.randomPassword(DefaultPwLength);
        System.out.println("random password: " + passWord);

        // generate email by combining elements
        this.email = firstName + "." + lastName + "@" + department + "." + CompanyPrefix;
        System.out.println("Your email is: " + email);

    }

    // ask for department
    public String askForDepartment() {
        System.out.print("New worker " + firstName + ", Please enter the Department Code: " +
                "\n1 for Sales\n2 for Development\n3 for Accounting" +
                "\n0 for none\nEnter the code: ");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        if (depChoice == 1) return "Sales";
        else if (depChoice == 2) return "Development";
        else if (depChoice == 3) return "Accounting";
        else return "";
    }

    // method to generate a random password
    public String randomPassword(int length) {
        String passwordSet = "0123456789!@#$%^&abcdefghi";
        char[] randPass = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            randPass[i] = passwordSet.charAt(rand);
        }

        return new String(randPass);
    }

    // change password
    public void setPassWord(String newPassword) {
        this.passWord = newPassword;
    }

    // set mail capacity
    public void setCapacity(int newCapacity) {
        this.mailboxCapacity = newCapacity;
    }

    // set an alternate email address
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // get mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // get get alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // get info
    public String getInfo() {
        return  "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
