package gsmirnov.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * School model.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@vocalize.ru>)
 * @version 0.2
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
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    /**
     * Transforms the given list of students into the map of students, where key is student's surname and value is
     * the student itself.
     *
     * @param students the specified list of students.
     * @return the map of students, where key is student's surname and value is the student itself.
     */
    public static Map<String, Student> collectMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getSurname, student -> student));
    }
}