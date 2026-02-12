import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String symbols = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        
        String allChars = upper + lower + nums + symbols;

        System.out.println("Password Generator");
        System.out.print("Enter desired password length: ");
        int length = 0;
        if(scanner.hasNextInt()) {
            length = scanner.nextInt();
        }

        if (length < 4) {
             System.out.println("Password length should be at least 4 for better security.");
             length = 8; // Default to 8
        }

        char[] password = new char[length];
        
        // Ensure at least one of each type
        password[0] = upper.charAt(random.nextInt(upper.length()));
        password[1] = lower.charAt(random.nextInt(lower.length()));
        password[2] = nums.charAt(random.nextInt(nums.length()));
        password[3] = symbols.charAt(random.nextInt(symbols.length()));

        // Fill the rest
        for (int i = 4; i < length; i++) {
            password[i] = allChars.charAt(random.nextInt(allChars.length()));
        }

        // Shuffle
        for (int i = 0; i < length; i++) {
            int r = random.nextInt(length);
            char temp = password[i];
            password[i] = password[r];
            password[r] = temp;
        }

        System.out.println("Generated Password: " + new String(password));
        
        scanner.close();
    }
}
