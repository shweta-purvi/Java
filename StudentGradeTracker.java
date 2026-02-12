import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Student Grade Tracker");
        System.out.println("Enter student details. Type 'done' as name to finish.");

        while (true) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter grade for " + name + ": ");
            try {
                double grade = Double.parseDouble(scanner.nextLine());
                if (grade < 0 || grade > 100) {
                     System.out.println("Grade must be between 0 and 100. Student not added.");
                } else {
                    students.add(new Student(name, grade));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade. Please enter a number.");
            }
        }

        if (students.isEmpty()) {
            System.out.println("No students added.");
        } else {
            double sum = 0;
            double highest = students.get(0).grade;
            double lowest = students.get(0).grade;
            String highestName = students.get(0).name;
            String lowestName = students.get(0).name;

            System.out.println("\n--- Grade Report ---");
            for (Student s : students) {
                System.out.println(s.name + ": " + s.grade);
                sum += s.grade;
                if (s.grade > highest) {
                    highest = s.grade;
                    highestName = s.name;
                }
                if (s.grade < lowest) {
                    lowest = s.grade;
                    lowestName = s.name;
                }
            }

            double average = sum / students.size();
            System.out.printf("\nAverage Grade: %.2f%n", average);
            System.out.println("Highest Grade: " + highest + " (" + highestName + ")");
            System.out.println("Lowest Grade: " + lowest + " (" + lowestName + ")");
        }

        scanner.close();
    }
}
