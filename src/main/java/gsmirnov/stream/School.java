package gsmirnov.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * School model.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@vocalize.ru>)
 * @version 0.1
 * @since 2020-04-01
 */
public class School {
    /**
     * Filters students by the specified predicate.
     *
     * @param students input list of all available students.
     * @param predict the specified filter.
     * @return filtered list of students.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}