package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String fileString) throws IOException {
        return new ObjectMapper(new YAMLFactory()).readValue(fileString, new TypeReference<>() { });
    }
}
