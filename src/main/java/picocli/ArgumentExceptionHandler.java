package picocli;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static picocli.CommandLine.*;

class ArgumentExceptionHandler implements IParameterExceptionHandler {


    @Override
    public int handleParseException(ParameterException ex, String[] strings) {

        CommandLine cmd = ex.getCommandLine();
        PrintWriter writer = cmd.getOut();

        Model.CommandSpec spec = cmd.getCommandSpec();
        String usage = "";
        try {
            usage = Files.readAllLines(Path.of("0_usage.screen")).stream().collect(Collectors.joining("\n"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        writer.printf(usage);

        return cmd.getExitCodeExceptionMapper() != null
                ? cmd.getExitCodeExceptionMapper().getExitCode(ex)
                : spec.exitCodeOnInvalidInput();
    }
}
