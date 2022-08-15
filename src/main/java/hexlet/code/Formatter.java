package hexlet.code;

import java.util.Map;

import static hexlet.code.formatters.Json.json;
import static hexlet.code.formatters.Plain.plain;
import static hexlet.code.formatters.Stylish.stylish;

public class Formatter {
    public static String formatter(Map<String, Map<String, Object>> construchionDiff, String format) {
        switch (format) {
            case "stylish":
                return stylish(construchionDiff);
            case "plain":
                return plain(construchionDiff);
            case "json":
                return json(construchionDiff);
            default:
                throw new RuntimeException();
        }
    }
}
