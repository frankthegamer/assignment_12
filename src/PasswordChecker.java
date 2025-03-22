import java.util.Scanner;

public class PasswordChecker {

    public static void passwordCheck(String password) {

        if (password.length() < 8) {                          // length check
            System.out.println("Password is too short!");
            return; // Exit if length is invalid
        } else if (password.length() > 16) {
            System.out.println("Password is too long!");
            return; // Exit if length is invalid
        }

        boolean hasLower = false;                             
        boolean hasUpper = false;
        boolean hasNum = false;
        boolean hasSpecial = false;

        String specialSymbols = "~!@#$%^&*()-=+";

        for (char ch : password.toCharArray()) {             // char check
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasNum = true;
            } else if (specialSymbols.indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

        int categoriesMet = 0;    // increments if category is satisfied

        if (hasLower) {
            categoriesMet++;
        }
        if (hasUpper) {
            categoriesMet++;
        }
        if (hasNum) {
            categoriesMet++;
        }
        if (hasSpecial) {
            categoriesMet++;
        }

        if (categoriesMet < 3) {       // if < 3 categories, specify missing
            System.out.println("Password must meet at least 3 of the 4 categories:");

            if (!hasLower) {
                System.out.println(" - Lowercase letter");
            }
            if (!hasUpper) {
                System.out.println(" - Uppercase letter");
            } 
            if (!hasNum) {
                System.out.println(" - Number");
            }
            if (!hasSpecial) {
                System.out.println(" - Special character");
            }
        } else {
            System.out.println("Password is valid!");
        }
    }

    public static void main(String[] args) throws Exception {     // main method
    
        System.out.print("Enter a password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        scanner.close();

        passwordCheck(password);

    }
}
