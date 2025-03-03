import java.io.*;

public class R14_SER00_J {

    // Non-Compliant Version
    public static Object nonCompliant(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject(); // Unsafe deserialization
    }

    // Compliant Version
    public static Object compliant(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bis);

        // Security filter to prevent deserializing malicious classes
        ois.setObjectInputFilter(info -> 
            info.serialClass() != null && info.serialClass().getName().startsWith("java.")
                ? ObjectInputFilter.Status.ALLOWED
                : ObjectInputFilter.Status.REJECTED
        );

        return ois.readObject();
    }

    public static void main(String[] args) {
        byte[] serializedData = {}; // Example serialized data

        System.out.println("Running Non-Compliant Code:");
        try {
            System.out.println(nonCompliant(serializedData));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\nRunning Fixed Code:");
        try {
            System.out.println(compliant(serializedData));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
