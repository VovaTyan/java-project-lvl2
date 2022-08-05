package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeSet;

public class Differ {
    public static String generate(Path filepath1, Path filepath2) throws IOException {
        String fileString1 = Files.readString(filepath1);
        Map<String, Object> oneMap = new ObjectMapper().readValue(fileString1, new TypeReference<>() { });
        String fileString2 = Files.readString(filepath2);
        Map<String, Object> twoMap = new ObjectMapper().readValue(fileString2, new TypeReference<>() { });

        StringBuilder result = new StringBuilder();

        TreeSet<String> keys = new TreeSet<>();

        keys.addAll(oneMap.keySet());
        keys.addAll(twoMap.keySet());

        result.append("{\n");
        for (String key: keys) {
            if (!oneMap.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(twoMap.get(key)).append("\n");
            } else if (!twoMap.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(oneMap.get(key)).append("\n");
            } else {
                if (!twoMap.get(key).equals(oneMap.get(key))) {
                    result.append("  - ").append(key).append(": ").append(oneMap.get(key)).append("\n");
                    result.append("  + ").append(key).append(": ").append(twoMap.get(key)).append("\n");
                } else {
                    result.append("    ").append(key).append(": ").append(oneMap.get(key)).append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
