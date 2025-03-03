import java.util.logging.Logger;
import java.util.regex.Pattern;

public class R00_IDS03_J {
    private static final Logger logger = Logger.getLogger(R00_IDS03_J.class.getName());

    // Non-Compliant Version
    public static void nonCompliant(String username, boolean loginSuccessful) {
        if (loginSuccessful) {
            logger.severe("User login succeeded for: " + username);
        } else {
            logger.severe("User login failed for: " + username);
        }
    }

    // Compliant Version
    public static void compliant(String username, boolean loginSuccessful) {
        if (loginSuccessful) {
            logger.severe("User login succeeded for: " + sanitizeUser(username));
        } else {
            logger.severe("User login failed for: " + sanitizeUser(username));
        }
    }

    public static String sanitizeUser(String username) {
        return Pattern.matches("[A-Za-z0-9]+", username) ? username : "unauthorized user";
    }

    public static void main(String[] args) {
        String username = "admin123!@#";
        System.out.println("Running Non-Compliant Code:");
        nonCompliant(username, false);

        System.out.println("\nRunning Fixed Code:");
        compliant(username, false);
    }
}
