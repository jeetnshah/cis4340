public class R06_MET01_J {

    // Non-Compliant Version
    public static int nonCompliant(int x, int y) {
        assert x != Integer.MIN_VALUE;
        assert y != Integer.MIN_VALUE;
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        assert (absX <= Integer.MAX_VALUE - absY);
        return absX + absY;
    }

    // Compliant Version
    public static int compliant(int x, int y) {
        if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Invalid input: Integer.MIN_VALUE is not allowed.");
        }
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        if (absX > Integer.MAX_VALUE - absY) {
            throw new IllegalArgumentException("Integer overflow detected.");
        }
        return absX + absY;
    }

    public static void main(String[] args) {
        System.out.println("Running Non-Compliant Code:");
        try {
            System.out.println(nonCompliant(Integer.MIN_VALUE, 1));
        } catch (AssertionError e) {
            System.err.println("AssertionError: " + e.getMessage());
        }

        System.out.println("\nRunning Fixed Code:");
        try {
            System.out.println(compliant(Integer.MIN_VALUE, 1));
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        }
    }
}
