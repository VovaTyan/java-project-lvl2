package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String formatter(Map<String, Map<String, Object>> construchionDiff, String format) {
        switch (format) {
            case "stylish":
                return Stylish.format(construchionDiff);
            case "plain":
                return Plain.format(construchionDiff);
            case "json":
                return Json.format(construchionDiff);
            default:
                throw new RuntimeException();
        }
    }
}
