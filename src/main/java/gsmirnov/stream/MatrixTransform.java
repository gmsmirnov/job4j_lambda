package gsmirnov.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Matrix transform utilities.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-03
 */
public class MatrixTransform {
    /**
     * Transforms integer matrix into list of integers.
     *
     * @param matrix the specified 2d-matrix.
     * @return the list of integers.
     */
    public static List<Integer> matrixToList(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }
}