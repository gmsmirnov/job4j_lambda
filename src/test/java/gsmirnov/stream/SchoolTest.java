package gsmirnov.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test students filter.
 */
public class SchoolTest {
    private final List<Student> students = new ArrayList<Student>();
    private final School school = new School();

    @Before
    public void init() {
        students.add(new Student(77));
        students.add(new Student(55));
        students.add(new Student(14));
        students.add(new Student(91));
        students.add(new Student(87));
        students.add(new Student(98));
        students.add(new Student(68));
        students.add(new Student(16));
        students.add(new Student(49));
        students.add(new Student(31));
    }

    @Test
    public void whenOnlyASudentsNeeded() {
        List<Student> studentsA = this.school.collect(this.students, student -> student.getScore() >= 70 && student.getScore() < 100);
        assertThat(studentsA.containsAll(Arrays.asList(
                new Student(77),
                new Student(91),
                new Student(87),
                new Student(98)
        )), is(true));
    }

    @Test
    public void whenOnlyBSudentsNeeded() {
        List<Student> studentsA = this.school.collect(this.students, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(studentsA.containsAll(Arrays.asList(
                new Student(55),
                new Student(68)
        )), is(true));
    }

    @Test
    public void whenOnlyCSudentsNeeded() {
        List<Student> studentsA = this.school.collect(this.students, student -> student.getScore() > 0 && student.getScore() < 50);
        assertThat(studentsA.containsAll(Arrays.asList(
                new Student(14),
                new Student(16),
                new Student(49),
                new Student(31)
        )), is(true));
    }
}