package validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
    private List<String> errorMessages;

    public List<String> getErrorMessages() {
        if (errorMessages == null) {
            errorMessages = new ArrayList<>();
        }
        return errorMessages;
    }

    public void add(String errorMessage) {
        getErrorMessages().add(errorMessage);
    }
}
