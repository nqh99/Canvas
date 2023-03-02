package validation;

import java.util.List;

public interface Validator {
    void setParameters(List<String> parameters);
    void setCanvasSize(int width, int height);
    ValidationError validate();
}
