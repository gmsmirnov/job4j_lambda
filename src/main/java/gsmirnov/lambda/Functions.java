package gsmirnov.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.lang.Math.pow;

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

    /**
     * Linear function.
     *
     * @param start left border of the range.
     * @param end right border of the range.
     * @return a list of values, calculated by this linear function in the specified range.
     */
    public static List<Double> linearFunc(int start, int end) {
        Function<Double, Double> func = x -> x * 10 - 3;
        return diapason(start, end, func);
    }

    /**
     * Quadratic function.
     *
     * @param start left border of the range.
     * @param end right border of the range.
     * @return a list of values, calculated by this quadratic function in the specified range.
     */
    public static List<Double> quadFunc(int start, int end) {
        Function<Double, Double> func = x -> 5 * x * x;
        return diapason(start, end, func);
    }

    /**
     * Exponential function.
     *
     * @param start left border of the range.
     * @param end right border of the range.
     * @return a list of values, calculated by this exponential function in the specified range.
     */
    public static List<Double> expFunc(int start, int end) {
        Function<Double, Double> func = x -> pow(5, x);
        return diapason(start, end, func);
    }
}
