import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Demonstrates the lazy evaluation lambda in Java.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-03-31
 */
public class LazyEvaluationTest {
    /**
     * Two items. Lambda executes in sorting process.
     */
    @Test
    public void whenLambdaExecutesThenShowMessage() {
        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }

    /**
     * Only one item. Nothing to sort. Lambda do not executes.
     */
    @Test
    public void whenLambdaNoExecutesThenNoMessage() {
        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }
}