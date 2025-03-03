public class R09_OBJ05_J {
    private int[] values = {1, 2, 3};

    // Non-Compliant Version
    public int[] nonCompliant() {
        return values; // Exposes internal representation
    }

    // Compliant Version
    public int[] compliant() {
        return values.clone(); // Returns a copy instead of the actual array
    }

    public static void main(String[] args) {
        R09_OBJ05_J obj = new R09_OBJ05_J();

        System.out.println("Running Non-Compliant Code:");
        int[] nonCompliantArray = obj.nonCompliant();
        nonCompliantArray[0] = 100; // This modifies the internal array
        System.out.println("Modified value: " + obj.values[0]);

        System.out.println("\nRunning Fixed Code:");
        int[] compliantArray = obj.compliant();
        compliantArray[0] = 200; // This does not affect the internal array
        System.out.println("Internal value remains unchanged: " + obj.values[0]);
    }
}
