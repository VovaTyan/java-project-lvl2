package formatters;

public class Plain {
    private static final byte INDEX_0 = 0;
    private static final byte INDEX_1 = 1;
    private static final byte INDEX_2 = 2;
    private static final byte INDEX_3 = 3;
    private static final byte INDEX_4 = 4;
    private static final byte INDEX_5 = 5;
    private static final byte INDEX_6 = 6;
    public static String[] plain(String dif) {
        String[] result = new String[INDEX_6];
        switch (dif) {
            case "added" -> {
                result[INDEX_0] = "Property '";
                result[INDEX_1] = "' was added with value: ";
                result[INDEX_2] = "\n";
            }
            case "deleted" -> {
                result[INDEX_0] = "Property '";
                result[INDEX_1] = "' was removed\n";
            }
            case "changed" -> {
                result[INDEX_0] = "Property '";
                result[INDEX_1] = "' was updated. From ";
                result[INDEX_2] = "";
                result[INDEX_3] = " to ";
                result[INDEX_4] = "";
                result[INDEX_5] = "\n";
            }
            case "unchanged" -> {
                result[INDEX_0] = "Property '";
                result[INDEX_1] = "' was unchanged with value: ";
                result[INDEX_2] = "\n";
            }
            default -> throw new RuntimeException();
        }
        return result;
    }
}
