package hexlet.code.formatters;

import hexlet.code.Utils;

import java.util.Map;

public class Json {
    public static String format(Map<String, Map<String, Object>> construchionDiff) {
        StringBuilder result = new StringBuilder();
        result.append("[\n");
        for (Map.Entry<String, Map<String, Object>> map: construchionDiff.entrySet()) {
            String oneString = construchionDiff.get(map.getKey()).get("value1") == null ? "null"
                    : construchionDiff.get(map.getKey()).get("value1").toString();
            String twoString = construchionDiff.get(map.getKey()).get("value2") == null ? "null"
                    : construchionDiff.get(map.getKey()).get("value2").toString();

            if (construchionDiff.get(map.getKey()).get("value1") instanceof String) {
                oneString = Utils.frame(oneString, "\"");
            }
            if (construchionDiff.get(map.getKey()).get("value2") instanceof String) {
                twoString = Utils.frame(twoString, "\"");
            }

            if ("added".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("  {\"name\": \"").append(map.getKey()).append("\", \"valuesPair\": [null, ")
                        .append(twoString).append("]},\n");
            }
            if ("deleted".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("  {\"name\": \"").append(map.getKey()).append("\", \"valuesPair\": [")
                        .append(oneString).append(", null]},\n");
            }
            if ("changed".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("  {\"name\": \"").append(map.getKey()).append("\", \"valuesPair\": [")
                        .append(oneString)
                        .append(", ").append(twoString).append("]},\n");
            }
            if ("unchanged".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("  {\"name\": \"").append(map.getKey()).append("\", \"valuesPair\": [")
                        .append(oneString).append(", ").append(twoString).append("]},\n");
            }
        }
        result.deleteCharAt(result.lastIndexOf(","));
        result.append("]");
        return result.toString();
    }
}
