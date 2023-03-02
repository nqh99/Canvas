package exception;

import java.util.ArrayList;
import java.util.List;

public class InvalidCommandException extends IllegalArgumentException {
	
	private static final long serialVersionUID = 1L;
	
	private List<String> errorMessages;

    public InvalidCommandException(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public InvalidCommandException(String errorMessage) {
        getErrorMessages().add(errorMessage);
    }

    public InvalidCommandException() {
    }

    public List<String> getErrorMessages() {
        if (errorMessages == null) {
            errorMessages = new ArrayList<>();
        }
        return errorMessages;
    }
}
