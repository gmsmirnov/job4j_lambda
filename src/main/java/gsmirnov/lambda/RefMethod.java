package gsmirnov.lambda;

/**
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-03-31
 */
public class RefMethod {
    /**
     * Checks the specified string value length. If it is greater than 10, then cut the string.
     *
     * @param value the specified string value.
     */
    public static void cutOf(String value) {
        if (value.length() > 10) {
            System.out.println(String.format("%s..", value.substring(0, 10)));
        } else {
            System.out.println(value);
        }
    }
}