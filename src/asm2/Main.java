package asm2;

import Helper.readCSV;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        // Load students from CSV
        String filePath = "students.csv";
        readCSV.loadStudentsFromCSV(filePath, bst);
        

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new student");
            System.out.println("2. Search student by ID");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Print student list");
            System.out.println("5. Evaluate students by rank");
            System.out.println("6. Sort students by marks");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter marks: ");
                    double mark = Double.parseDouble(scanner.nextLine());
                    if (mark != -1) {
                        bst.insert(new Student(id, name, mark));
                        System.out.println("Student added!");
                    } else if (mark < 0 || mark > 10) {
                        System.out.println("Invalid mark. Must be between 0 and 10.");
                        return;                    
                    }             
                    break;    
                }
                case 2 -> {
                    System.out.print("Enter ID to search: ");
                    String id = scanner.nextLine();
                    Student student = bst.search(id);
                    if (student == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.println("Student details: " + student);
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Enter ID to delete: ");
                    String idToDelete = scanner.nextLine().trim();
                    Student studentToDelete = bst.search(idToDelete);
                    if (studentToDelete == null) {
                        System.out.println("Student not found. Cannot delete.");
                    } else {
                        bst.delete(idToDelete);
                        System.out.println("Student deleted successfully!");
                    }
                    break;
                }
                case 4 -> {
                    System.out.println("Student list:");
                    if (bst.isEmpty()) {
                        System.out.println("No students available to display!");
                        return;
                    }
                    bst.inOrderTraversal();
                    break;
                }
                case 5 -> {
                    System.out.println("Evaluate students by rank:");
                    bst.evaluateByRank();
                    break;
                }
                case 6 -> {
                    // for (Student student : students) {
                    //     System.out.println(student);
                    // }
                    // int targetMark = scanner.nextInt();
                    // List<Student> filteredStudents = filterStudentsByMark(students, targetMark);
                    // if (filteredStudents.isEmpty()) {
                    //     System.out.println("No students found with the given mark.");
                    // } else {
                    //     System.out.println("Students with mark " + targetMark + ":");
                    //     for (Student student : filteredStudents) {
                    //         System.out.println(student);
                    //     }
                    // }
                    // -----------------------------------------------------------
                    // System.out.println("Students sorted by marks:");
                    // double targetMark = Double.parseDouble(scanner.nextLine());                    
                    // if (targetMark != -1){
                    //     System.out.println("Students with mark " + targetMark + ":");
                    //     List<Student> sortedStudents = bst.getStudentsSortedByMarks(students, targetMark);
                    //     if (sortedStudents.isEmpty()){
                    //         System.out.println("No students found with the given mark.");
                    //     } else {
                    //         for (Student student : sortedStudents) {
                    //             System.out.println(student);
                    //         }
                    //     }
                    // }
                    System.out.println("Students sorted by marks:");
                    List<Student> sortedStudents = bst.getStudentsSortedByMarks();
                    for (Student student : sortedStudents) {
                        System.out.println(student);
                    }
                    
                }
                case 7 -> {
                    System.out.println("Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
