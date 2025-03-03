import java.math.BigInteger;
import java.util.Arrays;

public class R04_STR03_J {

    // Non-Compliant Version
    public static BigInteger nonCompliant(BigInteger x) {
        byte[] byteArray = x.toByteArray();
        String s = new String(byteArray);
        byteArray = s.getBytes();
        return new BigInteger(byteArray);
    }

    // Compliant Version
    public static BigInteger compliant(BigInteger x) {
        byte[] byteArray = x.toByteArray();
        byte[] copiedArray = Arrays.copyOf(byteArray, byteArray.length);
        return new BigInteger(copiedArray);
    }

    public static void main(String[] args) {
        BigInteger x = new BigInteger("530500452766");

        System.out.println("Running Non-Compliant Code:");
        System.out.println(nonCompliant(x));

        System.out.println("\nRunning Fixed Code:");
        System.out.println(compliant(x));
    }
}
