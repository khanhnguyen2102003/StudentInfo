package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Student;
import Model.StudentModel;
import View.StudentView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Manager {
    private StudentModel model;
    private StudentView view;

    public Manager(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        boolean continueProgram = true;

        while (continueProgram) {
            view.displayMenu();
            int choice = view.getChoice(scanner);

            switch (choice) {
                case 1:
                    inputStudentData(scanner);
                    break;
                case 2:
                    performFunction();
                    break;
                case 3:
                    continueProgram = false;
                    break;
            }
        }
    }

    public void inputStudentData(Scanner scanner) {
        while (true) {
            System.out.println("Please input student information:");
            String name = "";
            while (name.isEmpty() || !Pattern.matches("^[a-zA-Z]+$", name)) {
                System.out.print("Name: ");
                name = scanner.nextLine().trim();
                if (name.isEmpty() || !Pattern.matches("^[a-zA-Z]+$", name)) {
                    System.out.println("Invalid name.");
                }
            }

            String className = "";
            while (className.isEmpty() || !Pattern.matches("^[a-zA-Z0-9]+$", className)) {
                System.out.print("Classes: ");
                className = scanner.nextLine().trim();
                if (className.isEmpty() || !Pattern.matches("^[a-zA-Z0-9]+$", className)) {
                    System.out.println("Invalid class name.");
                }
            }

            float mark = 0.0f;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Mark: ");
                try {
                    mark = Float.parseFloat(scanner.nextLine().trim());
                    if (mark >= 0.0f && mark <= 100.0f) {
                        validInput = true;
                    } else {
                        System.out.println("Please enter a valid number [0.0-100.0].");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            Student student = new Student(name, className, mark);
            model.addStudent(student);
            System.out.println("Student information added.");

            System.out.print("Do you want to enter more students information (Y/N)? ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y")) {
                break;
            }
        }
    }

    public void performFunction() {
        List<Student> students = model.getStudents();
        if (students.isEmpty()) {
            System.out.println("No student data to display.");
            return;
        }

        Collections.sort(students, Comparator.comparing(Student::getName));
        view.displayStudents(students);
    }
}

