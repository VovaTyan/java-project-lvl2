package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class Gendiff implements Callable<Integer> {

    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
        private String format = "stylish";
    @CommandLine.Parameters(index = "0", description = "path to first file",
            defaultValue = "./src/test/resources/file1.json")
        private String filepath1;
    @CommandLine.Parameters(index = "1", description = "path to second file",
            defaultValue = "./src/test/resources/file2.json")
        private String filepath2;

    @Override
    public Integer call() throws Exception {
        String diff = Differ.generate(filepath1, filepath2, format);
        System.out.println(diff);
        return 0;
    }
}
public class App {
    public static void main(String... args) {
        int exitCode = new CommandLine(new Gendiff()).execute(args);
        System.exit(exitCode);
    }
}
