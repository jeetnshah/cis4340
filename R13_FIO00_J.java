public class R13_FIO00_J {

    // Non-Compliant Version
    public static void nonCompliant() {
        String password = "SuperSecret123"; // Hardcoded password
        System.out.println("Using password: " + password);
    }

    // Compliant Version
    public static void compliant() {
        String password = System.getenv("APP_PASSWORD");
        if (password == null) {
            System.err.println("Error: No password set in environment variables.");
        } else {
            System.out.println("Password retrieved securely.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Running Non-Compliant Code:");
        nonCompliant();

        System.out.println("\nRunning Fixed Code:");
        compliant();
    }
}
