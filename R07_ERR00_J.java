import java.io.*;

public class R07_ERR00_J {

    // Non-Compliant Version
    public static void nonCompliant() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        System.out.println(reader.readLine());
        // No call to reader.close(), leading to a resource leak
    }

    // Compliant Version
    public static void compliant() {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Running Non-Compliant Code:");
        try {
            nonCompliant();
        } catch (IOException e) {
