package View;


import Model.Student;
import java.util.List;
import java.util.Scanner;


public class StudentView {
    public void displayMenu() {
        System.out.println("=========Collection sort program=========");
        System.out.println("||1. Input student information         ||");
        System.out.println("||2. Display and Sort Students         ||");
        System.out.println("||3. Exit                              ||");
        System.out.println("=========================================");
    }

    public int getChoice(Scanner scanner) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    scanner.nextLine(); 
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } else {
                scanner.nextLine(); 
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public void displayStudents(List<Student> students) {
        int studentNumber = 1;
        for (Student student : students) {
            System.out.println("-------------Student " + studentNumber + "-------------");
            System.out.println("Name: " + student.getName());
            System.out.println("Classes: " + student.getClassName());
            System.out.println("Mark: " + student.getMark());
            System.out.println("-----------------------------------");
            studentNumber++;
        }
    }
}

