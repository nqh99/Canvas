package validation;

import message.Messages;
import util.Utils;

public class RectangleValidator extends BaseValidator {

    @Override
    public ValidationError validate() {
        ValidationError result = new ValidationError();
        if (Utils.isEmpty(parameters)) {
            result.add(Messages.PARAMETERS_EXPECTED);
        }
        else if (parameters.size() > 4) {
            result.add(Messages.TOO_MANY_PARAMETERS);
        }
        else if (parameters.size() < 4) {
            result.add(Messages.HAS_MISSING_PARAMETERS);
        }
        else {
            if (!Utils.isPositiveNumberList(
                    parameters.get(0),
                    parameters.get(1),
                    parameters.get(2),
                    parameters.get(3))) {
                result.add(Messages.PARAMETERS_POSITIVE);
            } else {
                if (isInvalidPosition(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1))) ||
                        isInvalidPosition(Integer.parseInt(parameters.get(2)), Integer.parseInt(parameters.get(3)))) {
                    result.add(Messages.POSITION_OUTSIDE_CANVAS);
                }
            }
        }
        return result;
    }

}
