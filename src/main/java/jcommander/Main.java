package jcommander;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Main {

    @Parameter(names = "params", description = "Information about what to draw")
    private List<String> params = new ArrayList<>();

    @Parameter(order = 1)
    private String test;

    public List<String> getParams() {
        return params;
    }

    public String getTest() {
        return test;
    }

    public static void main(String[] args) {
        Main jArgs = new Main();
        JCommander helloCmd = JCommander.newBuilder()
                .addObject(jArgs)
                .build();
        helloCmd.parse(args);
        System.out.println("Hello " + jArgs.getParams());
    }
}
