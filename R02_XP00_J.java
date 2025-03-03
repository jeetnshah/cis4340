import java.io.File;

public class R02_XP00_J {
    public static void main(String[] args) {
        deleteFile();
    }

    public static void deleteFile() {
        File someFile = new File("someFileName.txt");

        if (!someFile.delete()) {
            System.err.println("Error: Failed to delete the file.");
        } else {
            System.out.println("File deleted successfully.");
        }
    }
}
