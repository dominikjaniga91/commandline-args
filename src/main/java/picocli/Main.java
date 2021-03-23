package picocli;

import java.util.ArrayList;
import java.util.List;

import static picocli.CommandLine.*;

@Command
class Main implements Runnable {

    @Option(names = { "--notation" }, description = "Output file (default: print to console)")
    static String option;

    @Parameters( description = "Any number of input numbers")
    static List<String> files = new ArrayList<>();

    @Override
    public void run() {

    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        CommandLine commandLine = new CommandLine(new Main());
        commandLine.setParameterExceptionHandler(new ArgumentExceptionHandler());
        commandLine.execute(args);
        System.out.println(files);
        System.out.println(option);
    }
}