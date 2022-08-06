package formatters;

public class Stylish {
    private static final byte INDEX_0 = 0;
    private static final byte INDEX_1 = 1;
    private static final byte INDEX_2 = 2;
    private static final byte INDEX_3 = 3;
    private static final byte INDEX_4 = 4;
    private static final byte INDEX_5 = 5;
    private static final byte INDEX_6 = 6;
    public static String[] stylish(String dif) {
        String[] result = new String[INDEX_6];
        switch (dif) {
            case "added":
                result[INDEX_0] = "  + ";
                result[INDEX_1] = ": ";
                result[INDEX_2] = "\n";
                break;
            case "deleted":
                result[INDEX_0] = "  - ";
                result[INDEX_1] = ": ";
                result[INDEX_2] = "\n";
                break;
            case "changed":
                result[INDEX_0] = "  - ";
                result[INDEX_1] = ": ";
                result[INDEX_2] = "\n";
                result[INDEX_3] = "  + ";
                result[INDEX_4] = ": ";
                result[INDEX_5] = "\n";
                break;
            case "unchanged":
                result[INDEX_0] = "    ";
                result[INDEX_1] = ": ";
                result[INDEX_2] = "\n";
                break;
            default:
                throw new RuntimeException();
        }
        return result;
    }
}
