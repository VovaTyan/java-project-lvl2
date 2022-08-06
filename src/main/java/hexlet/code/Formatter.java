package hexlet.code;

import static formatters.Json.json;
import static formatters.Plain.plain;
import static formatters.Stylish.stylish;

public class Formatter {
    public static String[] formatter(String format, String diff) {
        return switch (format) {
            case "plain" -> plain(diff);
            case "json" -> json(diff);
            default -> stylish(diff);
        };
    }
}
