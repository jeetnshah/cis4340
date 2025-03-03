public class R12_THI00_J {
    private static int counter = 0;

    public synchronized static void increment() {
        counter++; // Now thread-safe
    }
}
