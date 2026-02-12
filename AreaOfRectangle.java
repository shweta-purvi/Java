import java.util.Scanner;

public class AreaOfRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Length: ");
        double length = scanner.nextDouble();

        System.out.print("Enter Width: ");
        double width = scanner.nextDouble();

        double area = length * width;

        System.out.println("Area of Rectangle: " + area);
        
        scanner.close();
    }
}
