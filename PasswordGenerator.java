import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    // Define character sets for the password
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "~!#$%^&*()_+/*|}{][<>?:',.`";

    // SecureRandom is more secure than Random
    private static final SecureRandom random = new SecureRandom();

    // Method to generate password
    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useNumbers, boolean useSpecial) {

        StringBuilder password = new StringBuilder(length);
        String characterPool = "";

        // Add character sets to pool
        if (useUpper) {
            characterPool += UPPERCASE_LETTERS;
        }

        if (useLower) {
            characterPool += LOWERCASE_LETTERS;
        }

        if (useNumbers) {
            characterPool += NUMBERS;
        }

        if (useSpecial) {
            characterPool += SPECIAL_CHARACTERS;
        }

        // Validate at least one option selected
        if (characterPool.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one character type must be selected.");
        }

        // Generate password
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get password length
        System.out.println("Enter the desired length of password:");
        int length = sc.nextInt();

        // Ask user for character options
        System.out.println("Include uppercase letters? (true/false)");
        boolean useUpper = sc.nextBoolean();

        System.out.println("Include lowercase letters? (true/false)");
        boolean useLower = sc.nextBoolean();

        System.out.println("Include numbers? (true/false)");
        boolean useNumbers = sc.nextBoolean();

        System.out.println("Include special characters? (true/false)");
        boolean useSpecial = sc.nextBoolean();

        // Generate and display password
        try {
            String password = generatePassword(length, useUpper, useLower, useNumbers, useSpecial);

            System.out.println("Generated password is: " + password);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}