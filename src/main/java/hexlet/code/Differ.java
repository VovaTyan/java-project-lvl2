package hexlet.code;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeSet;

import static hexlet.code.Formatter.formatter;
import static hexlet.code.Parser.parser;


public class Differ {
    private static final byte INDEX_0 = 0;
    private static final byte INDEX_1 = 1;
    private static final byte INDEX_2 = 2;
    private static final byte INDEX_3 = 3;
    private static final byte INDEX_4 = 4;
    private static final byte INDEX_5 = 5;

    public static String generate(Path filepath1, Path filepath2, String format) throws IOException {
        Map<String, Object> oneMap = parser(filepath1);
        Map<String, Object> twoMap = parser(filepath2);

        StringBuilder result = new StringBuilder();
        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(oneMap.keySet());
        keys.addAll(twoMap.keySet());

        String[] forms;
        String state;
        if (format.equals("stylish")) {
            result.append("{\n");
        }
        if (format.equals("json")) {
            result.append("[\n");
        }
        for (String key: keys) {
            String oneString = oneMap.get(key) == null ? "null" : oneMap.get(key).toString();
            String twoString = twoMap.get(key) == null ? "null" : twoMap.get(key).toString();

            if (!oneMap.containsKey(key)) {
                state = "added";
            } else if (!twoMap.containsKey(key)) {
                state = "deleted";
            } else {
                if (!oneString.equals(twoString)) {
                    state = "changed";
                } else {
                    state = "unchanged";
                }
            }
            if (format.equals("plain")) {
                oneString = ((oneMap.get(key) instanceof String)
                        || (oneMap.get(key) instanceof Integer)
                        || (oneMap.get(key) instanceof Boolean)) ? oneMap.get(key).toString() : "[complex value]";
                twoString = ((twoMap.get(key) instanceof String)
                        || (twoMap.get(key) instanceof Integer)
                        || (twoMap.get(key) instanceof Boolean)) ? twoMap.get(key).toString() : "[complex value]";
            }
            forms = formatter(format, state);
            if (state.equals("added")) {
                result.append(forms[INDEX_0]).append(key).append(forms[INDEX_1])
                        .append(twoString).append(forms[INDEX_2]);
            }
            if (state.equals("deleted")) {
                result.append(forms[INDEX_0]).append(key).append(forms[INDEX_1]);
                if (format.equals("stylish") || format.equals("json")) {
                    result.append(oneString).append(forms[INDEX_2]);
                }
            }
            if (state.equals("changed")) {
                result.append(forms[INDEX_0]).append(key).append(forms[INDEX_1])
                        .append(oneString).append(forms[INDEX_2]);
                result.append(forms[INDEX_3]);
                if (format.equals("stylish")) {
                    result.append(key).append(forms[INDEX_4]);
                }
                result.append(twoString).append(forms[INDEX_5]);
            }
            if (state.equals("unchanged")) {
                result.append(forms[INDEX_0]).append(key).append(forms[INDEX_1]).append(oneString);
                if (format.equals("json")) {
                    result.append(",").append(oneString);
                }
                result.append(forms[INDEX_2]);
            }
        }
        if (format.equals("stylish")) {
            result.append("}");
        }
        if (format.equals("json")) {
            result.append("]");
        }
        return result.toString();
    }
}
