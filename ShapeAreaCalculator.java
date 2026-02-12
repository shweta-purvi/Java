import java.util.Scanner;

interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Shape Area Calculator");

        while (running) {
             System.out.println("\n1. Circle");
             System.out.println("2. Rectangle");
             System.out.println("3. Triangle");
             System.out.println("4. Exit");
             System.out.print("Choose a shape: ");

             int choice = -1;
             if (scanner.hasNextInt()) {
                 choice = scanner.nextInt();
             } else {
                 scanner.next();
             }

             Shape shape = null;

             switch (choice) {
                 case 1:
                     System.out.print("Enter radius: ");
                     double r = scanner.nextDouble();
                     shape = new Circle(r);
                     break;
                 case 2:
                     System.out.print("Enter length: ");
                     double l = scanner.nextDouble();
                     System.out.print("Enter width: ");
                     double w = scanner.nextDouble();
                     shape = new Rectangle(l, w);
                     break;
                 case 3:
                     System.out.print("Enter base: ");
                     double b = scanner.nextDouble();
                     System.out.print("Enter height: ");
                     double h = scanner.nextDouble();
                     shape = new Triangle(b, h);
                     break;
                 case 4:
                     running = false;
                     break;
                 default:
                     System.out.println("Invalid choice.");
             }

             if (shape != null) {
                 System.out.printf("Area: %.2f%n", shape.calculateArea());
             }
        }
        System.out.println("Exiting...");
        scanner.close();
    }
}
