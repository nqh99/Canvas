package validation;

import message.Messages;
import util.Utils;

public class CanvasValidator extends BaseValidator {

    @Override
    public ValidationError validate() {
        ValidationError result = new ValidationError();
        if (Utils.isEmpty(parameters)) {
            result.add(Messages.PARAMETERS_EXPECTED);
        }
        else if (parameters.size() > 2) {
            result.add(Messages.TOO_MANY_PARAMETERS);
        }
        else if (parameters.size() < 2) {
            result.add(Messages.HAS_MISSING_PARAMETERS);
        }
        else {
            if (!Utils.isPositiveNumberList(parameters.get(0), parameters.get(1))) {
                result.add(Messages.CANVAS_SIZE_POSITIVE);
            }
        }
        return result;
    }

}
