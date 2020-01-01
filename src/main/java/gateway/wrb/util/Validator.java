package gateway.wrb.util;

import java.util.Collection;

public class Validator {

    public static boolean validateString(String value) {
        return null != value && !value.isEmpty();
    }

    public static boolean validateStrings(String... args) {
        for (int i = 0; i < args.length; i++) {
            if (!validateString(args[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateCollection(Collection<?> collection) {
        return null != collection && !collection.isEmpty();
    }

    public static boolean validateObject(Object object) {
        return object != null;
    }

    public static boolean validateObjects(Object... args) {
        for (int i = 0; i < args.length; i++) {
            if (!validateObject(args[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean validate(Object param) {
        if (param == null) {
            return false;
        }

        boolean isInvalid = param instanceof String && ((String) param).isEmpty();
        return !isInvalid;
    }
}
