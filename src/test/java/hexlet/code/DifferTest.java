package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    @Test
    public void testGenerateDefault() throws IOException {
        String pathFileYaml1 = "./src/test/resources/file1.yml";
        String pathFileYaml2 = "./src/test/resources/file2.yml";
        var actual = Differ.generate(pathFileYaml1, pathFileYaml2);
        String expectedStylish = "./src/test/resources/expectedStylish.txt";
        var expected = Files.readString(Path.of(expectedStylish));
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testGenerateStructureStylish() throws IOException {
        String pathFileJson3 = "./src/test/resources/file3.json";
        String pathFileJson4 = "./src/test/resources/file4.json";
        var actual = Differ.generate(pathFileJson3, pathFileJson4, "stylish");
        String expectedComplexValue = "./src/test/resources/expectedComplexValue.txt";
        var expected = Files.readString(Path.of(expectedComplexValue));
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testGenerateStructurePlain() throws IOException {
        String pathFileYaml3 = "./src/test/resources/file3.yml";
        String pathFileYaml4 = "./src/test/resources/file4.yml";
        var actual = Differ.generate(pathFileYaml3, pathFileYaml4, "plain");
        String expectedComplexValuePlain = "./src/test/resources/expectedComplexValuePlain.txt";
        var expected = Files.readString(Path.of(expectedComplexValuePlain));
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testGenerateOutJson() throws IOException {
        String pathFileJson3 = "./src/test/resources/file3.json";
        String pathFileJson4 = "./src/test/resources/file4.json";
        var actual = Differ.generate(pathFileJson3, pathFileJson4, "json");
        String expectedOutJson = "./src/test/resources/expectedOutJson.txt";
        var expected = Files.readString(Path.of(expectedOutJson));
        assertThat(actual).isEqualTo(expected);
    }
}
