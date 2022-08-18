package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    private String pathFileJson1 = "./src/test/resources/file1.json";
    private String pathFileJson2 = "./src/test/resources/file2.json";
    private String pathFileJson3 = "./src/test/resources/file3.json";
    private String pathFileJson4 = "./src/test/resources/file4.json";

    private String pathFileYaml1 = "./src/test/resources/file1.yml";
    private String pathFileYaml2 = "./src/test/resources/file2.yml";
    private String pathFileYaml3 = "./src/test/resources/file3.yml";
    private String pathFileYaml4 = "./src/test/resources/file4.yml";
    @Test
    public void testFileJson() throws IOException {
        String fileJson1 = Files.readString(Path.of(pathFileJson1));
        var actual1 = fileJson1;
        var expected1 = "{\n"
                + "  \"host\": \"hexlet.io\",\n"
                + "  \"timeout\": 50,\n"
                + "  \"proxy\": \"123.234.53.22\",\n"
                + "  \"follow\": false\n"
                + "}";
        assertThat(actual1).isEqualTo(expected1);

        String fileJson2 = Files.readString(Path.of(pathFileJson2));
        var actual2 = fileJson2;
        var expected2 = "{\n"
                + "  \"timeout\": 20,\n"
                + "  \"verbose\": true,\n"
                + "  \"host\": \"hexlet.io\"\n"
                + "}";
        assertThat(actual2).isEqualTo(expected2);

        String fileJson3 = Files.readString(Path.of(pathFileJson3));
        var actual3 = fileJson3;
        var expected3 = "{\n"
                + "  \"setting1\": \"Some value\",\n"
                + "  \"setting2\": 200,\n"
                + "  \"setting3\": true,\n"
                + "  \"key1\": \"value1\",\n"
                + "  \"numbers1\": [1, 2, 3, 4],\n"
                + "  \"numbers2\": [2, 3, 4, 5],\n"
                + "  \"id\": 45,\n"
                + "  \"default\": null,\n"
                + "  \"checked\": false,\n"
                + "  \"numbers3\": [3, 4, 5],\n"
                + "  \"chars1\": [\"a\", \"b\", \"c\"],\n"
                + "  \"chars2\": [\"d\", \"e\", \"f\"]\n"
                + "}";
        assertThat(actual3).isEqualTo(expected3);

        String fileJson4 = Files.readString(Path.of(pathFileJson4));
        var actual4 = fileJson4;
        var expected4 = "{\n"
                + "  \"setting1\": \"Another value\",\n"
                + "  \"setting2\": 300,\n"
                + "  \"setting3\": \"none\",\n"
                + "  \"key2\": \"value2\",\n"
                + "  \"numbers1\": [1, 2, 3, 4],\n"
                + "  \"numbers2\": [22, 33, 44, 55],\n"
                + "  \"id\": null,\n"
                + "  \"default\": [\"value1\", \"value2\"],\n"
                + "  \"checked\": true,\n"
                + "  \"numbers4\": [4, 5, 6],\n"
                + "  \"chars1\": [\"a\", \"b\", \"c\"],\n"
                + "  \"chars2\": false,\n"
                + "  \"obj1\": {\n"
                + "    \"nestedKey\": \"value\",\n"
                + "    \"isNested\": true\n"
                + "  }\n"
                + "}";
        assertThat(actual4).isEqualTo(expected4);
    }
    @Test
    public void testFileYaml() throws IOException {
        String fileYaml1 = Files.readString(Path.of(pathFileYaml1));
        var actual1 = fileYaml1;
        var expected1 = "---\n"
                + "host: hexlet.io\n"
                + "timeout: 50\n"
                + "proxy: 123.234.53.22\n"
                + "follow: false";
        assertThat(actual1).isEqualTo(expected1);

        String fileYaml2 = Files.readString(Path.of(pathFileYaml2));
        var actual2 = fileYaml2;
        var expected2 = "---\n"
                + "timeout: 20\n"
                + "verbose: true\n"
                + "host: hexlet.io";
        assertThat(actual2).isEqualTo(expected2);

        String fileYaml3 = Files.readString(Path.of(pathFileYaml3));
        var actual3 = fileYaml3;
        var expected3 = "---\n"
                + "setting1: Some value\n"
                + "setting2: 200\n"
                + "setting3: true\n"
                + "key1: value1\n"
                + "numbers1:\n  - 1\n  - 2\n  - 3\n  - 4\n"
                + "numbers2:\n  - 2\n  - 3\n  - 4\n  - 5\n"
                + "id: 45\n"
                + "default:\n"
                + "checked: false\n"
                + "numbers3:\n  - 3\n  - 4\n  - 5\n"
                + "chars1:\n  - a\n  - b\n  - c\n"
                + "chars2:\n  - d\n  - e\n  - f";
        assertThat(actual3).isEqualTo(expected3);

        String fileYaml4 = Files.readString(Path.of(pathFileYaml4));
        var actual4 = fileYaml4;
        var expected4 = "---\n"
                + "setting1: Another value\n"
                + "setting2: 300\n"
                + "setting3: none\n"
                + "key2: value2\n"
                + "numbers1:\n  - 1\n  - 2\n  - 3\n  - 4\n"
                + "numbers2:\n  - 22\n  - 33\n  - 44\n  - 55\n"
                + "id:\n"
                + "default:\n  - value1\n  - value2\n"
                + "checked: true\n"
                + "numbers4:\n  - 4\n  - 5\n  - 6\n"
                + "chars1:\n  - a\n  - b\n  - c\n"
                + "chars2: false\n"
                + "obj1:\n"
                + "  nestedKey: value\n"
                + "  isNested: true";
        assertThat(actual4).isEqualTo(expected4);
    }
    @Test
    public void testGenerateJson() throws IOException {
        var actual3 = Differ.generate(pathFileJson1, pathFileJson2, "stylish");
        var expected3 = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n  + timeout: 20\n  + verbose: true\n}";
        assertThat(actual3).isEqualTo(expected3);
    }

    @Test
    public void testGenerateYaml() throws IOException {
        var actual3 = Differ.generate(pathFileYaml1, pathFileYaml2, "stylish");
        var expected3 = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n  + timeout: 20\n  + verbose: true\n}";
        assertThat(actual3).isEqualTo(expected3);
    }

    @Test
    public void testGeneratePlain() throws IOException {
        var actual1 = Differ.generate(pathFileJson1, pathFileJson2, "plain");
        var expected1 = "Property 'follow' was removed\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From 50 to 20\n"
                + "Property 'verbose' was added with value: true";
        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    public void testGenerateStructureStylish() throws IOException {
        var actual1 = Differ.generate(pathFileJson3, pathFileJson4, "stylish");
        var expected1 = "{\n    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n}";
        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    public void testGenerateStructurePlain() throws IOException {
        var actual1 = Differ.generate(pathFileJson3, pathFileJson4, "plain");
        var expected1 = "Property 'chars2' was updated. From [complex value] to false\n"
            + "Property 'checked' was updated. From false to true\n"
            + "Property 'default' was updated. From null to [complex value]\n"
            + "Property 'id' was updated. From 45 to null\n"
            + "Property 'key1' was removed\n"
            + "Property 'key2' was added with value: 'value2'\n"
            + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
            + "Property 'numbers3' was removed\n"
            + "Property 'numbers4' was added with value: [complex value]\n"
            + "Property 'obj1' was added with value: [complex value]\n"
            + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
            + "Property 'setting2' was updated. From 200 to 300\n"
            + "Property 'setting3' was updated. From true to 'none'";
        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    public void testGenerateOutJson() throws IOException {
        var actual1 = Differ.generate(pathFileJson1, pathFileJson2, "json");
        var expected1 = "{\"follow\":{\"changeType\":\"deleted\",\"value1\":false,\"value2\":\"null\"},"
                + "\"host\":{\"changeType\":\"unchanged\",\"value1\":\"hexlet.io\",\"value2\":\"hexlet.io\"},"
                + "\"proxy\":{\"changeType\":\"deleted\",\"value1\":\"123.234.53.22\",\"value2\":\"null\"},"
                + "\"timeout\":{\"changeType\":\"changed\",\"value1\":50,\"value2\":20},"
                + "\"verbose\":{\"changeType\":\"added\",\"value1\":\"null\",\"value2\":true}}";
        assertThat(actual1).isEqualTo(expected1);
    }
}
