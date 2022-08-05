package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;


class DifferTest {
    @Test
    public void testGenerate() throws IOException {
        Path path1 = Path.of("/home/vova/java-project-lvl2/file1.json");
        Path path2 = Path.of("/home/vova/java-project-lvl2/file2.json");
        var actual1 = Differ.generate(path1, path2);
        var expected1 = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n  + timeout: 20\n  + verbose: true\n}";
        assertThat(actual1).isEqualTo(expected1);
    }
}
