public class R13_FIO00_J {
    public static void main(String[] args) {
        String password = System.getenv("APP_PASSWORD");
        if (password == null) {
            System.err.println("Error: No password set in environment variables.");
        } else {
            System.out.println("Password retrieved securely.");
        }
    }
}
