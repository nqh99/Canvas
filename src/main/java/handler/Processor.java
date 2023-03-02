package handler;

import exception.InvalidCommandException;
import inputreader.InputReader;
import util.Utils;

public class Processor {
    private static final String CMD_QUIT = "Q";
    private static final String CMD_ENTER = "enter command: ";
    private Handler handler;
    private Mapper mapper;
    private InputReader inputReader;

    public Processor(Handler handler, Mapper mapper, InputReader inputReader) {
        this.handler = handler;
        this.mapper = mapper;
        this.inputReader = inputReader;
    }

    public void process() {
        boolean exitLoop = false;
        while (!exitLoop) {
            System.out.print(CMD_ENTER);
            String input = inputReader.read();
            if (Utils.isNotBlank(input)) {
                if (isQuitCommand(input)) {
                    exitLoop = true;
                } else {
                    try {
                        handler.handle(mapper.map(input));
                    } catch (InvalidCommandException e) {
                        if (Utils.isNotEmpty(e.getErrorMessages())) {
                            e.getErrorMessages().forEach(System.out::println);
                        } else {
                            System.out.println("'" + input + "' is not a recognized command.");
                        }
                    }
                }
            }
        }
    }

    private boolean isQuitCommand(String command) {
        return CMD_QUIT.equals(command.trim());
    }
}
