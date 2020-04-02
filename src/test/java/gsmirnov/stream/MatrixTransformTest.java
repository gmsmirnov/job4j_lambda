package gsmirnov.stream;

import org.junit.Test;

import java.util.List;

import static gsmirnov.stream.MatrixTransform.matrixToList;
import static org.junit.Assert.*;

/**
 * Tests matrix to list transform.
 */
public class MatrixTransformTest {

    @Test
    public void matrixToListTransformTest() {
        Integer[][] matrix = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };
        List<Integer> result = matrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        assertEquals(expected, result);
    }
}