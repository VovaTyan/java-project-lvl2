package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static hexlet.code.InnerConstruchion.getInnerConstruchion;
import static hexlet.code.Parser.parser;
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

    private String expectedStylish = "./src/test/resources/expectedStylish.txt";
    private String expectedPlain = "./src/test/resources/expectedPlain.txt";
    private String expectedComplexValue = "./src/test/resources/expectedComplexValue.txt";
    private String expectedComplexValuePlain = "./src/test/resources/expectedComplexValuePlain.txt";
    private String expectedOutJson = "./src/test/resources/expectedOutJson.txt";
    private String expectedInnerConstruchion = "./src/test/resources/expectedInnerConstruchion.txt";

    @Test
    public void testGetInnerConstruchionJson() throws IOException {
        Map<String, Object> oneMap = parser(Paths.get(pathFileJson1));
        Map<String, Object> twoMap = parser(Paths.get(pathFileJson2));
        String construchionDiff = getInnerConstruchion(oneMap, twoMap).toString();
        var actual = construchionDiff;
        String fileExpected = Files.readString(Path.of(expectedInnerConstruchion));
        var expected = fileExpected;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testGetInnerConstruchionYaml() throws IOException {
        Map<String, Object> oneMap = parser(Paths.get(pathFileYaml1));
        Map<String, Object> twoMap = parser(Paths.get(pathFileYaml2));
        String construchionDiff = getInnerConstruchion(oneMap, twoMap).toString();
        var actual = construchionDiff;
        String fileExpected = Files.readString(Path.of(expectedInnerConstruchion));
        var expected = fileExpected;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testGenerateJson() throws IOException {
        var actual = Differ.generate(pathFileJson1, pathFileJson2, "stylish");
        String fileExpected = Files.readString(Path.of(expectedStylish));
        var expected = fileExpected;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testGenerateYaml() throws IOException {
        var actual = Differ.generate(pathFileYaml1, pathFileYaml2, "stylish");
        String fileExpected = Files.readString(Path.of(expectedStylish));
        var expected = fileExpected;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testGeneratePlain() throws IOException {
        var actual = Differ.generate(pathFileJson1, pathFileJson2, "plain");
        String fileExpected = Files.readString(Path.of(expectedPlain));
        var expected = fileExpected;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testGenerateStructureStylish() throws IOException {
        var actual = Differ.generate(pathFileJson3, pathFileJson4, "stylish");
        String fileExpected = Files.readString(Path.of(expectedComplexValue));
        var expected = fileExpected;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testGenerateStructurePlain() throws IOException {
        var actual = Differ.generate(pathFileJson3, pathFileJson4, "plain");
        String fileExpected = Files.readString(Path.of(expectedComplexValuePlain));
        var expected = fileExpected;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testGenerateOutJson() throws IOException {
        var actual = Differ.generate(pathFileJson1, pathFileJson2, "json");
        String fileExpected = Files.readString(Path.of(expectedOutJson));
        var expected = fileExpected;
        assertThat(actual).isEqualTo(expected);
    }
}
