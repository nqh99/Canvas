package message;

public interface Messages {
    String PARAMETERS_EXPECTED = "Parameters are expected.";
    String TOO_MANY_PARAMETERS = "Command has too many parameters.";
    String HAS_MISSING_PARAMETERS = "Command has missing parameters.";
    String CANVAS_SIZE_POSITIVE = "Parameters for canvas size should be positive numbers.";
    String PARAMETERS_POSITIVE = "Parameters for position should be positive numbers.";
    String POSITION_OUTSIDE_CANVAS = "Position is outside of canvas.";
    String COLOR_ONE_CHARACTER = "Parameter stands for color should be 1 character.";
    String HORIZONTAL_VERTICAL_SUPPORT = "Currently only horizontal and vertical lines are supported.";
}
