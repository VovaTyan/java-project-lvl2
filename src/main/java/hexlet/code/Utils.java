package hexlet.code;

import java.util.Map;

public class Utils {
    public static String frame(String str, String type) {
        return type + str + type;
    }

    public static boolean isComplexValue(Object value) {
        return (value instanceof String) || (value instanceof Integer)
                || (value instanceof Boolean) || (value == null);
    }

    public static String toString(Map<String, Object> map, String value) {
        return map.get(value) == null ? "null" : map.get(value).toString();
    }
}
