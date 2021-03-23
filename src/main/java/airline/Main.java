package airline;

import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Arguments;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import java.util.List;

@Command(name = "arguments")
public class Main {

    @Option(name = { "--notation" },  description = "An option that requires no values")
    private String option;

    @Arguments(description = "Additional arguments")
    private List<String> args;

    public static void main(String[] args) {
        var parser = SingleCommand.singleCommand(Main.class);
        Main cmd = parser.parse(args);
        cmd.run();
    }

    private void run() {
        System.out.println(option);
        System.out.println(args);
    }
}