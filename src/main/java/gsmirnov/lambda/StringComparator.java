package gsmirnov.lambda;

import java.util.Comparator;

/**
 * Utilities for comparing strings.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@vocalize.ru>)
 * @version 0.1
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
    public static final Comparator<String> CMP_DESC_SIZE = (left, right) -> (-1) * (left.length() - right.length());
}