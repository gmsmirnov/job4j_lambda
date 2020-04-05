package gsmirnov.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * School model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.3
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
                .flatMap(Stream::ofNullable)
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
        return students.stream()
                .flatMap(Stream::ofNullable)
                .collect(Collectors.toMap(Student::getSurname, student -> student, (student, student2) -> student));
    }

    /**
     * Gets all the students whose score level is grater than the specified bound. The list is ordered by
     * descending score level.
     *
     * @param students the list of students.
     * @param bound the specified bound.
     * @return the list of students whose score level is grater than the specified bound.
     */
    public static List<Student> levelOf(List<Student> students, final int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(student -> student.getScore() >= bound)
                .collect(Collectors.toList());
    }
}