package gsmirnov.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static gsmirnov.stream.School.collect;
import static gsmirnov.stream.School.collectMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test students filter.
 */
public class SchoolTest {
    private final List<Student> students = new ArrayList<Student>();

    @Before
    public void init() {
        students.add(new Student("Ivanov", "Ivan", 77));
        students.add(new Student("Petrov", "Petr", 55));
        students.add(new Student("Pupkin", "Vasya", 14));
        students.add(new Student("Semenov", "Semen", 91));
        students.add(new Student("Vasiliev", "Vasilii", 87));
        students.add(new Student("Andreev", "Andrey", 98));
        students.add(new Student("Pavlov", "Pavel", 68));
        students.add(new Student("Sidorov", "Sidr", 16));
        students.add(new Student("Borisov", "Boris", 49));
        students.add(new Student("Marinina", "Marina", 31));
    }

    @Test
    public void whenOnlyASudentsNeeded() {
        List<Student> studentsA = collect(this.students, student -> student.getScore() >= 70 && student.getScore() < 100);
        assertThat(studentsA.containsAll(Arrays.asList(
                new Student("Ivanov", "Ivan", 77),
                new Student("Semenov", "Semen", 91),
                new Student("Vasiliev", "Vasilii", 87),
                new Student("Andreev", "Andrey", 98)
        )), is(true));
    }

    @Test
    public void whenOnlyBSudentsNeeded() {
        List<Student> studentsA = collect(this.students, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(studentsA.containsAll(Arrays.asList(
                new Student("Petrov", "Petr", 55),
                new Student("Pavlov", "Pavel", 68)
        )), is(true));
    }

    @Test
    public void whenOnlyCSudentsNeeded() {
        List<Student> studentsA = collect(this.students, student -> student.getScore() > 0 && student.getScore() < 50);
        assertThat(studentsA.containsAll(Arrays.asList(
                new Student("Pupkin", "Vasya", 14),
                new Student("Sidorov", "Sidr", 16),
                new Student("Borisov", "Boris", 49),
                new Student("Marinina", "Marina", 31)
        )), is(true));
    }

    @Test
    public void listToMapTransformTest() {
        Map<String, Student> studentsMap = collectMap(this.students);
        assertThat(studentsMap.get("Borisov"), is(new Student("Borisov", "Boris")));
        assertThat(studentsMap.get("Petrov"), is(new Student("Petrov", "Petr")));
        assertThat(studentsMap.get("Ivanov"), is(new Student("Ivanov", "Ivan")));
        assertThat(studentsMap.get("Marinina"), is(new Student("Marinina", "Marina")));
        assertThat(studentsMap.get("Sidorov"), is(new Student("Sidorov", "Sidr")));
        assertThat(studentsMap.get("Pupkin"), is(new Student("Pupkin", "Vasya")));
    }
}