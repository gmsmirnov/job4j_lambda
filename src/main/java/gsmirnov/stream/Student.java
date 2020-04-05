package gsmirnov.stream;


import java.util.Objects;

/**
 * Student model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.3
 * @since 2020-04-01
 */
public class Student implements Comparable<Student> {
    /**
     * This student's surname.
     */
    private String surname;

    /**
     * This student's first name.
     */
    private String name;

    /**
     * This student's rating.
     */
    private int score;

    /**
     * Constructor. Creates a student with the specified params.
     *
     * @param surname the specified surname.
     * @param name the specified first name.
     * @param score the specified score.
     */
    public Student(String surname, String name, int score) {
        this.surname = surname;
        this.name = name;
        this.score = score;
    }

    /**
     * Constructor. Creates a student with the specified params and default zero score.
     *
     * @param surname the specified surname.
     * @param name the specified first name.
     */
    public Student(String surname, String name) {
        this.surname = surname;
        this.name = name;
        this.score = 0;
    }

    /**
     * Gets this student's surname.
     *
     * @return this student's surname.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Sets the specified surname to this student.
     *
     * @param surname the specified surname.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets this students name.
     *
     * @return this students name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the specified name to this student.
     *
     * @param name the specified name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets this student's rating.
     *
     * @return this student's rating.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets the specified rating to this student.
     *
     * @param score the specified rating.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Checks this student for equivalence with another student.
     *
     * @param o another student.
     * @return true if both students are equals, false either.
     */
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Student student = (Student) o;
            result = Objects.equals(this.surname, student.surname) && Objects.equals(this.name, student.name);
        }
        return result;
    }

    /**
     * Calculates hash-code for this student.
     *
     * @return calculated hash-code for this student.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.surname, this.name);
    }

    /**
     * String presentation of this student.
     *
     * @return the string presentation of this student.
     */
    @Override
    public String toString() {
        return String.format("Student{surname='%s', name='%s', score=%d}", this.surname, this.name, this.score);
    }

    /**
     * Compares this student with another by the score level.
     *
     * @param o another student.
     * @return 1 if another student's score level is greater, -1 if another student's score level is lower, 0 if the levels are equals.
     */
    @Override
    public int compareTo(Student o) {
        int result = 0;
        if (this.getScore() > o.getScore()) {
            result = -1;
        } else if (this.getScore() < o.getScore()) {
            result = 1;
        }
        return result;
    }
}