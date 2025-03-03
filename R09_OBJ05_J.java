public class R09_OBJ05_J {
    private int[] values = {1, 2, 3};

    public int[] getValues() {
        return values.clone(); // Returns a copy instead of the actual array
    }
}
