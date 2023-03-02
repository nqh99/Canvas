package util;

import java.util.List;

public class Utils {

    public static boolean isPositiveNumber(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isPositiveNumberList(String... input) {
        if (input != null && input.length != 0) {
            for (String n : input) {
                if (!isPositiveNumber(n)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNotBlank(String input) {
        return input != null && input.trim().length() != 0;
    }

    public static boolean isNotEmpty(List<?> result) {
        return !isEmpty(result);
    }

    public static boolean isEmpty(List<?> result) {
        return result == null || result.isEmpty();
    }
}
