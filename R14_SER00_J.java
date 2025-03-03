import java.io.*;

public class R14_SER00_J {
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        // Apply a security filter to prevent deserializing malicious classes
        ois.setObjectInputFilter(info -> 
            info.serialClass() != null && info.serialClass().getName().startsWith("java.")
                ? ObjectInputFilter.Status.ALLOWED
                : ObjectInputFilter.Status.REJECTED
        );

        return ois.readObject();
    }
}
