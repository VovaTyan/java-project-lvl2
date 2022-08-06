package hexlet.code;

import static formatters.Json.json;
import static formatters.Plain.plain;
import static formatters.Stylish.stylish;

public class Formatter {
    public static String[] formatter(String format, String diff) {
        if (format.equals("plain")) {
            return plain(diff);
        } else if (format.equals("json")) {
            return json(diff);
        } else {
            return stylish(diff);
        }

    }
}
