package gsmirnov.stream;

import java.util.Objects;

/**
 * User model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-05
 */
public class User implements Comparable<User> {
    /**
     * This user's name.
     */
    private String name;

    /**
     * This user's age.
     */
    private int age;

    /**
     * Creates a new user with the specified parameters.
     *
     * @param name the specified name.
     * @param age the specified age.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Gets this user's name.
     *
     * @return this user's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the specified name to this user.
     *
     * @param name the specified name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets this user's age.
     *
     * @return this user's age.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Sets the specified age to this user.
     *
     * @param age the specified age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Checks this user for equivalence with another user. Both users are equals if theirs names and ages are equal.
     *
     * @param o another user.
     * @return true if both users are equals.
     */
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            User user = (User) o;
            result = this.age == user.age && Objects.equals(this.name, user.name);
        }
        return result;
    }

    /**
     * Calculates hash code to this user.
     *
     * @return calculate to this user hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }

    /**
     * A string-presentation of this user.
     *
     * @return a string-presentation of this user.
     */
    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d}", this.name, this.age);
    }

    /**
     * Compares this user with another user. First in lexicographical order by name; second by age in ascending order.
     *
     * @param o another user.
     * @return >0 if another user "is greater", <0 if this user "is greater". 0 if both users are equals.
     */
    @Override
    public int compareTo(User o) {
        int result;
        int nameCmp = this.name.compareToIgnoreCase(o.name);
        if (nameCmp != 0) {
            result = nameCmp;
        } else {
            result = this.age - o.age;
        }
        return result;
    }
}