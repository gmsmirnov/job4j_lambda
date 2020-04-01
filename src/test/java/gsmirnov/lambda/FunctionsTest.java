package gsmirnov.lambda;

import org.junit.Test;

import java.util.List;

import static gsmirnov.lambda.Functions.*;
import static java.lang.Math.pow;
import static org.junit.Assert.assertArrayEquals;

/**
 * Testing linear, quadratic and exponential functions.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-01
 */
public class FunctionsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = diapason(5, 8, x -> x * 10 - 3);
        Double[] expected = new Double[] {47D, 57D, 67D, 77D};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void whenQuadFunctionThenQuadResults() {
        List<Double> result = diapason(5, 8, x -> 5 * x * x);
        Double[] expected = new Double[] {125D, 180D, 245D, 320D};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void whenExpFunctionThenExpResults() {
        List<Double> result = diapason(5, 8, x -> pow(5, x));
        Double[] expected = new Double[] {3125D, 15625D, 78125D, 390625D};
        assertArrayEquals(expected, result.toArray());
    }
}