package handler;

import data.CanvasData;
import data.CommandLine;
import exception.InvalidCommandException;
import shape.Shape;
import shape.ShapeType;
import util.Utils;
import validation.ValidationError;
import validation.Validator;

import java.util.List;
import java.util.Map;

public class Handler {
    private static final String CANVAS_YET_CREATED = "Canvas has not been created yet, please create canvas first.";
    private static final String CMD_CREATE = "C";
    private CanvasData canvasData;
    private final Map<ShapeType, Shape> shapeMap;
    private final Map<ShapeType, Validator> validatorMap;

    public Handler(Map<ShapeType, Shape> shapeMap,
                   Map<ShapeType, Validator> validatorMap) {
        this.shapeMap = shapeMap;
        this.validatorMap = validatorMap;
    }

    public void handle(CommandLine commandLine) {
        validate(commandLine);
        if (CMD_CREATE.equals(commandLine.getCmd())) {
            canvasData = new CanvasData(commandLine.getParameters());
        }
        executeCmd(commandLine, canvasData);
    }

    public void validate(CommandLine commandLine) {
        Validator validator = validatorMap.get(ShapeType.fromValue(commandLine.getCmd()));
        if (validator != null) {
            validator.setParameters(commandLine.getParameters());
            if (canvasData != null) {
                validator.setCanvasSize(canvasData.getWidth(), canvasData.getHeight());
            }
            ValidationError result = validator.validate();
            if (Utils.isNotEmpty(result.getErrorMessages())) {
                throw new InvalidCommandException(result.getErrorMessages());
            }
        }
        else {
            throw new InvalidCommandException();
        }
    }

    public void executeCmd(CommandLine commandLine, CanvasData canvasData) {
        if (canvasData == null) {
            throw new InvalidCommandException(CANVAS_YET_CREATED);
        }
        Shape shape = shapeMap.get(ShapeType.fromValue(commandLine.getCmd()));
        if (shape != null) {
            // draw and display
            drawAndDisplay(shape, canvasData, commandLine.getParameters());
        } else {
            throw new InvalidCommandException();
        }
    }

    public void drawAndDisplay(Shape shape, CanvasData canvasData, List<String> parameters) {
        shape.setParameters(parameters);
        shape.draw(canvasData);
        System.out.println(canvasData.toDisplayString());
    }

}
