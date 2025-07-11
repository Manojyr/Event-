package event_Management;
import java.util.Random;

public class random_string {
    // Define the characters you want to include in the random string
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 5;

    public static String generateRandomString() {
        StringBuilder randomString = new StringBuilder(LENGTH);
        Random random = new Random();

        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(index));
        }

        return randomString.toString();
    }

    public static void main(String[] args) {
        String randomString = generateRandomString();
        System.out.println("Random Alphanumeric String: " + randomString);
    }
}


