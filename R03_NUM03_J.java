import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class R03_NUM03_J {

    // Non-Compliant Version
    public static int nonCompliant(DataInputStream is) throws IOException {
        return is.readInt();
    }

    // Compliant Version
    public static long compliant(DataInputStream is) throws IOException {
        return is.readInt() & 0xFFFFFFFFL;
    }

    public static void main(String[] args) throws IOException {
        byte[] inputData = { 0, 0, 0, 127 };
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(inputData));

        System.out.println("Running Non-Compliant Code:");
        System.out.println(nonCompliant(dis));

        dis = new DataInputStream(new ByteArrayInputStream(inputData));

        System.out.println("\nRunning Fixed Code:");
        System.out.println(compliant(dis));
    }
}
