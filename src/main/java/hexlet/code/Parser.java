package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(Path filepath) throws IOException {
        String fileString = Files.readString(filepath);
        return new ObjectMapper(new YAMLFactory()).readValue(fileString, new TypeReference<>() { });
    }
}
