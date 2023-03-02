package validation;

import java.util.List;

public abstract class BaseValidator implements Validator {
    protected List<String> parameters;
    protected Integer canvasWidth;
    protected Integer canvasHeight;

    @Override
    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void setCanvasSize(int width, int height) {
        this.canvasWidth = width;
        this.canvasHeight = height;
    }

    protected boolean isInvalidPosition(int x, int y) {
        if (canvasWidth != null) {
            return x < 1 || y < 1 || x > canvasWidth - 2 || y > canvasHeight - 2;
        }
        return false;// if canvas has not been created, suppose that any other position is valid.
    }

}
