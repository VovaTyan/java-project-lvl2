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
                + "Property 'host' was unchanged with value: hexlet.io\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From 50 to 20\n"
                + "Property 'verbose' was added with value: true\n";
        assertThat(actual1).isEqualTo(expected1);
    }
}
