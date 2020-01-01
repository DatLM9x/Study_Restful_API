package gateway.wrb.util;

import java.math.BigDecimal;

public class NumberUtils {
    public static BigDecimal parseToDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Integer parseToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception ex) {
            return null;
        }
    }
}
