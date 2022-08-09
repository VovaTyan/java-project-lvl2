package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.nio.file.Path;
import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class Gendiff implements Callable<Integer> {

    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
        private String format = "stylish";
    @CommandLine.Parameters(index = "0", description = "path to first file")
        private Path filepath1 = Path.of("/home/vova/java-project-lvl2/filepath1");
    @CommandLine.Parameters(index = "1", description = "path to second file")
        private Path filepath2 = Path.of("/home/vova/java-project-lvl2/filepath2");

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
