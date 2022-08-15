package hexlet.code.formatters;

import hexlet.code.Utils;

import java.util.Map;

public class Plain {
    public static String plain(Map<String, Map<String, Object>> construchionDiff) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Map<String, Object>> map: construchionDiff.entrySet()) {
            String oneString = construchionDiff.get(map.getKey()).get("value1") == null ? "null"
                    : construchionDiff.get(map.getKey()).get("value1").toString();
            String twoString = construchionDiff.get(map.getKey()).get("value2") == null ? "null"
                    : construchionDiff.get(map.getKey()).get("value2").toString();
            if (!Utils.isComplexValue(construchionDiff.get(map.getKey()).get("value1"))) {
                oneString = "[complex value]";
            }
            if (!Utils.isComplexValue(construchionDiff.get(map.getKey()).get("value2"))) {
                twoString = "[complex value]";
            }


            if (construchionDiff.get(map.getKey()).get("value1") instanceof String) {
                oneString = Utils.frame(oneString, "'");
            }
            if (construchionDiff.get(map.getKey()).get("value2") instanceof String) {
                twoString = Utils.frame(twoString, "'");
            }
            if ("added".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("Property '").append(map.getKey()).append("' was added with value: ")
                        .append(twoString).append("\n");
            }
            if ("deleted".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("Property '").append(map.getKey()).append("' was removed\n");
            }
            if ("changed".equals(construchionDiff.get(map.getKey()).get("changeType"))) {
                result.append("Property '").append(map.getKey()).append("' was updated. From ")
                        .append(oneString).append(" to ").append(twoString).append("\n");
            }
        }
        result.deleteCharAt(result.lastIndexOf("\n"));
        return result.toString();
    }
}
