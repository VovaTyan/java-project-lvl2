package hexlet.code.formatters;

import java.util.Map;

public class Stylish {
    public static String format(Map<String, Map<String, Object>> construchionDiff) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Map.Entry<String, Map<String, Object>> map: construchionDiff.entrySet()) {
            if ("added".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("  + ").append(map.getKey()).append(": ")
                        .append(construchionDiff.get(map.getKey()).get("value2")).append("\n");
            }
            if ("deleted".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("  - ").append(map.getKey()).append(": ")
                        .append(construchionDiff.get(map.getKey()).get("value1")).append("\n");
            }
            if ("changed".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("  - ").append(map.getKey()).append(": ")
                        .append(construchionDiff.get(map.getKey()).get("value1")).append("\n");
                result.append("  + ").append(map.getKey()).append(": ");
                result.append(construchionDiff.get(map.getKey()).get("value2")).append("\n");
            }
            if ("unchanged".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("    ").append(map.getKey()).append(": ")
                        .append(construchionDiff.get(map.getKey()).get("value1")).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
