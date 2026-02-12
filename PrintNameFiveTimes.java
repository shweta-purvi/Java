import java.util.Scanner;

public class PrintNameFiveTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Printing name 5 times:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ". " + name);
        }
        
        scanner.close();
    }
}
