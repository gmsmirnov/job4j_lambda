package gsmirnov.stream;


import java.util.Objects;

/**
 * Student model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-01
 */
public class Student {
    /**
     * This student's rating.
     */
    private int score;

    /**
     * Constructor. Creates a student with the specified params.
     *
     * @param score the specified score.
     */
    public Student(int score) {
        this.score = score;
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
            result = this.score == student.score;
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
        return Objects.hash(this.score);
    }

    /**
     * String presentation of this student.
     *
     * @return the string presentation of this student.
     */
    @Override
    public String toString() {
        return String.format("Student{score=%d}", this.score);
    }
}