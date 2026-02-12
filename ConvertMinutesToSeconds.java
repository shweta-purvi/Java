import java.util.Scanner;

public class ConvertMinutesToSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();

        int seconds = minutes * 60;

        System.out.println(minutes + " minutes is equal to " + seconds + " seconds.");
        
        scanner.close();
    }
}
