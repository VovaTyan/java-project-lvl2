package hexlet.code;

public class Utils {
    public static String frame(String str, String type) {
        return type + str + type;
    }

    public static boolean isComplexValue(Object value) {
        return (value instanceof String) || (value instanceof Integer)
                || (value instanceof Boolean) || (value == null);
    }
}
