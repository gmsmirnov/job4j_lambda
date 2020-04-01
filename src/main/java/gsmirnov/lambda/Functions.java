package gsmirnov.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Some functions (linear, quadratic and exponential), which calculate values in the specified range.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-01
 */
public class Functions {
    /**
     * General calculating part, which is the same for all functions.
     *
     * @param start left border of the range.
     * @param end right border of the range.
     * @param func the math function.
     * @return a list of values, calculated by the specified function in the specified range.
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<Double>();
        for (int index = start; index <= end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
