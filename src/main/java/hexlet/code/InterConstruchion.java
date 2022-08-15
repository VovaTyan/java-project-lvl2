package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class InterConstruchion {
    public static Map<String, Map<String, Object>>
        getInterConstruchion(Map<String, Object> oneMap, Map<String, Object> twoMap) {
        Map<String, Map<String, Object>> result = new TreeMap<>();

        TreeSet<String> keys;
        keys = new TreeSet<>();
        keys.addAll(oneMap.keySet());
        keys.addAll(twoMap.keySet());
        for (String key: keys) {
            Map<String, Object> infoChangeMap = new TreeMap<>();
            String oneString = oneMap.get(key) == null ? "null" : oneMap.get(key).toString();
            String twoString = twoMap.get(key) == null ? "null" : twoMap.get(key).toString();
            if (!oneMap.containsKey(key)) {
                infoChangeMap.put("changeType", "added");
                infoChangeMap.put("value1", "null");
                infoChangeMap.put("value2", twoMap.get(key));
            } else if (!twoMap.containsKey(key)) {
                infoChangeMap.put("changeType", "deleted");
                infoChangeMap.put("value1", oneMap.get(key));
                infoChangeMap.put("value2", "null");
            } else {
                if (!oneString.equals(twoString)) {
                    infoChangeMap.put("changeType", "changed");
                    infoChangeMap.put("value1", oneMap.get(key));
                    infoChangeMap.put("value2", twoMap.get(key));
                } else {
                    infoChangeMap.put("changeType", "unchanged");
                    infoChangeMap.put("value1", oneMap.get(key));
                    infoChangeMap.put("value2", twoMap.get(key));
                }
            }
            result.put(key, infoChangeMap);
        }
        return result;
    }
}
