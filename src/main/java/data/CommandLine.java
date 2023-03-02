package data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CommandLine {
    private String cmd;
    private List<String> parameters;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public void setParameters(String... parameters) {
        this.parameters = Arrays.asList(parameters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandLine that = (CommandLine) o;
        return Objects.equals(cmd, that.cmd) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cmd, parameters);
    }
}
