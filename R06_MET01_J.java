public class R06_MET01_J {
    public static int getAbsAdd(int x, int y) {
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
        try {
            System.out.println(getAbsAdd(Integer.MIN_VALUE, 1));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
