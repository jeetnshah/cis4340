import java.io.File;

public class R02_XP00_J {

    // Non-Compliant Version
    public static void nonCompliant() {
        File someFile = new File("someFileName.txt");
        someFile.delete();
    }

    // Compliant Version
    public static void compliant() {
        File someFile = new File("someFileName.txt");
        if (!someFile.delete()) {
            System.err.println("Error: Failed to delete the file.");
        } else {
            System.out.println("File deleted successfully.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Running Non-Compliant Code:");
        nonCompliant();

        System.out.println("\nRunning Fixed Code:");
        compliant();
    }
}
