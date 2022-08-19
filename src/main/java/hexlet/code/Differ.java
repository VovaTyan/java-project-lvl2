package hexlet.code;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import static hexlet.code.Formatter.formatter;
import static hexlet.code.InnerConstruchion.getInnerConstruchion;
import static hexlet.code.Parser.parser;


public class Differ {

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        Map<String, Object> oneMap = parser(Paths.get(filepath1));
        Map<String, Object> twoMap = parser(Paths.get(filepath2));
        Map<String, Map<String, Object>> construchionDiff = getInnerConstruchion(oneMap, twoMap);
        return formatter(construchionDiff, format);
    }
}
