public class R12_THI00_J {
    private static int counter = 0;

    // Non-Compliant Version
    public static void nonCompliant() {
        counter++; // No synchronization, unsafe in multithreaded environments
    }

    // Compliant Version
    public synchronized static void compliant() {
        counter++; // Now thread-safe
    }

    public static void main(String[] args) {
        System.out.println("Running Non-Compliant Code:");
        nonCompliant();
        System.out.println("Counter: " + counter);

        System.out.println("\nRunning Fixed Code:");
        compliant();
        System.out.println("Counter: " + counter);
    }
}
