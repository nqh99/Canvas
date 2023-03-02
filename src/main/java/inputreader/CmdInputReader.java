package inputreader;

import java.util.Scanner;

public class CmdInputReader implements InputReader {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String read() {
        return scanner.nextLine();
    }
}
