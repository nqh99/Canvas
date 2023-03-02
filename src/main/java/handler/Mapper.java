package handler;

import data.CommandLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mapper {

    private static final String REGEX = "\\s+";

    public CommandLine map(String input) {
        String[] array = input.trim().split(REGEX);
        CommandLine commandLine = new CommandLine();
        List<String> parameters = new ArrayList<>(Arrays.asList(array));
        if (!parameters.isEmpty()) {
            String cmd = parameters.get(0);
            commandLine.setCmd(cmd);
            parameters.remove(cmd);
        }
        commandLine.setParameters(parameters);
        return commandLine;
    }
}
