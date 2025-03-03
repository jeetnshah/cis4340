import java.math.BigInteger;
import java.util.Arrays;

public class R04_STR03_J {
    public static void main(String[] args) {
        BigInteger x = new BigInteger("530500452766");
        
        // Secure method: Keep bytes as raw data
        byte[] byteArray = x.toByteArray();
        
        // If needed, encode as Base64 or Hex instead of String conversion
        byte[] copiedArray = Arrays.copyOf(byteArray, byteArray.length);
        
        BigInteger newX = new BigInteger(copiedArray);
        System.out.println("Reconstructed value: " + newX);
    }
}
