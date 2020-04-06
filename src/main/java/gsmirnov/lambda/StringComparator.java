package gsmirnov.lambda;

import java.util.Comparator;

/**
 * Utilities for comparing strings.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.2
 * @since 2020-03-31
 */
public class StringComparator {
    /**
     * Compare two strings by size.
     */
    public static final Comparator<String> CMP_SIZE = (left, right) -> left.length() - right.length();

    /**
     * Compare two strings lexicographically.
     */
    public static final Comparator<String> CMP_TEXT = (left, right) -> left.compareTo(right);

    /**
     * Compare two strings by size in revers order.
     */
    public static final Comparator<String> CMP_DESC_SIZE = (left, right) -> {
        int result = right.length() - left.length();
        System.out.println(String.format("Compare - %s : %s", left, right));
        System.out.println(String.format("Result is: %d", result));
        return result;
    };
}