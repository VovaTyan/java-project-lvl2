package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    @Test
    public void testGenerateJson() throws IOException {
        Path path1 = Path.of("file1.json");
        Path path2 = Path.of("file2.json");
        var actual1 = Differ.generate(path1, path2, "stylish");
        var expected1 = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n  + timeout: 20\n  + verbose: true\n}";
        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    public void testGenerateYaml() throws IOException {
        Path path1 = Path.of("file1.yml");
        Path path2 = Path.of("file2.yml");
        var actual1 = Differ.generate(path1, path2, "stylish");
        var expected1 = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n  + timeout: 20\n  + verbose: true\n}";
        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    public void testGeneratePlain() throws IOException {
        Path path1 = Path.of("file1.json");
        Path path2 = Path.of("file2.json");
        var actual1 = Differ.generate(path1, path2, "plain");
        var expected1 = "Property 'follow' was removed\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From 50 to 20\n"
                + "Property 'verbose' was added with value: true\n";
        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    public void testGenerateStructureStylish() throws IOException {
        Path path1 = Path.of("file3.json");
        Path path2 = Path.of("file4.json");
        var actual1 = Differ.generate(path1, path2, "stylish");
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
        Path path1 = Path.of("file3.json");
        Path path2 = Path.of("file4.json");
        var actual1 = Differ.generate(path1, path2, "plain");
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
            + "Property 'setting3' was updated. From true to 'none'\n";
        assertThat(actual1).isEqualTo(expected1);
    }
    @Test
    public void testGenerateOutJson() throws IOException {
        Path path1 = Path.of("file1.json");
        Path path2 = Path.of("file2.json");
        var actual1 = Differ.generate(path1, path2, "json");
        var expected1 = "[\n"
                + "  {\"name\": \"follow\", \"valuesPair\": [false, null]},\n"
                + "  {\"name\": \"host\", \"valuesPair\": [\"hexlet.io\", \"hexlet.io\"]},\n"
                + "  {\"name\": \"proxy\", \"valuesPair\": [\"123.234.53.22\", null]},\n"
                + "  {\"name\": \"timeout\", \"valuesPair\": [50, 20]},\n"
                + "  {\"name\": \"verbose\", \"valuesPair\": [null, true]}\n"
                + "]";
        assertThat(actual1).isEqualTo(expected1);
    }
}
