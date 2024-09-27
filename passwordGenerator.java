import java.security.SecureRandom;
import java.util.Scanner;

public class passwordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the required length of password");
        int length = sc.nextInt();
        System.out.println("Want to include uppercase letter ? (yes or no)");
        boolean uCase = sc.next().equalsIgnoreCase("yes");
        System.out.println("Want to include lowercase letter ? (yes or no)");
        boolean loCase = sc.next().equalsIgnoreCase("yes");
        System.out.println("Want to include numbers ? (yes or no)");
        boolean num = sc.next().equalsIgnoreCase("yes");
        System.out.println("Want to include special character ? (yes or no)");
        boolean speChar = sc.next().equalsIgnoreCase("yes");

        String password = passwordMaker(length, uCase, loCase, num, speChar);
        System.out.println();
        System.out.println("Password is " + password);
        System.out.println();
        sc.close();
    }

    public static String passwordMaker(int length, boolean uCase, boolean loCase, boolean num, boolean speChar) {
        String upperCaseString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseString = "abcdefghijklmnopqrstuvwxyz";
        String numString = "0123456789";
        String speCharString = "!@#$%^&*()_-=+<>";
        StringBuilder pool = new StringBuilder();
        int count = 0;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        if (uCase) {
            pool.append(upperCaseString);
            int idx = random.nextInt(upperCaseString.length());
            password.append(upperCaseString.charAt(idx));
            count++;
        }
        if (loCase) {
            pool.append(lowerCaseString);
            int idx = random.nextInt(lowerCaseString.length());
            password.append(lowerCaseString.charAt(idx));
            count++;
        }
        if (num) {
            pool.append(numString);
            int idx = random.nextInt(numString.length());
            password.append(numString.charAt(idx));
            count++;
        }
        if (speChar) {
            pool.append(speCharString);
            int idx = random.nextInt(speCharString.length());
            password.append(speCharString.charAt(idx));
            count++;
        }

        if (pool.length() == 0) {
            return "Atleast one type is required to generate paasword";
        }

        for (int i = count; i < length; i++) {
            int idx = random.nextInt(pool.length());
            password.append(pool.charAt(idx));
        }
        return password.toString();
    }
}
