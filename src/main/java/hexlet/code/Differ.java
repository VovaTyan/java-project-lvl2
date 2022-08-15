package hexlet.code;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import static hexlet.code.Formatter.formatter;
import static hexlet.code.InterConstruchion.getInterConstruchion;
import static hexlet.code.Parser.parser;


public class Differ {
    private static final byte INDEX_0 = 0;
    private static final byte INDEX_1 = 1;
    private static final byte INDEX_2 = 2;
    private static final byte INDEX_3 = 3;
    private static final byte INDEX_4 = 4;
    private static final byte INDEX_5 = 5;

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        Map<String, Object> oneMap = parser(Paths.get(filepath1));
        Map<String, Object> twoMap = parser(Paths.get(filepath2));
        Map<String, Map<String, Object>> construchionDiff = getInterConstruchion(oneMap, twoMap);
        return formatter(construchionDiff, format);
    }
}
