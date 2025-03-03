import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class R03_NUM03_J {
    public static void main(String[] args) throws IOException {
        byte[] inputData = { 0, 0, 0, 127 }; // Example data
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(inputData));

        long result = getUnsignedInteger(dis);
        System.out.println("Result: " + result);
    }

    public static long getUnsignedInteger(DataInputStream is) throws IOException {
        return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits to ensure unsigned interpretation
    }
}
