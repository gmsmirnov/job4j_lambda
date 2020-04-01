package gsmirnov.lambda;

import org.junit.Test;

import java.util.List;

import static gsmirnov.lambda.Functions.expFunc;
import static gsmirnov.lambda.Functions.linearFunc;
import static gsmirnov.lambda.Functions.quadFunc;
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
        List<Double> result = linearFunc(5, 8);
        Double[] expected = new Double[] {47D, 57D, 67D, 77D};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void whenQuadFunctionThenQuadResults() {
        List<Double> result = quadFunc(5, 8);
        Double[] expected = new Double[] {125D, 180D, 245D, 320D};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void whenExpFunctionThenExpResults() {
        List<Double> result = expFunc(5, 8);
        Double[] expected = new Double[] {3125D, 15625D, 78125D, 390625D};
        assertArrayEquals(expected, result.toArray());
    }
}