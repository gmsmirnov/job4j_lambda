package gsmirnov.lambda.phonebook;

import java.util.Objects;

/**
 * Person model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-01
 */
public class Person {
    /**
     * Person's name.
     */
    private String name;

    /**
     * Person's surname.
     */
    private String surname;

    /**
     * Person's phone.
     */
    private String phone;

    /**
     * Person's address.
     */
    private String address;

    /**
     * Constructor. Creates a person with the specified parameters.
     *
     * @param name the specified name.
     * @param surname the specified surname.
     * @param phone the specified phone.
     * @param address the specified address.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Gets this person's name.
     *
     * @return this person's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the specified name to this person.
     *
     * @param name the specified name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets this person's surname.
     *
     * @return this person's surname.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Sets the specified surname to this person.
     *
     * @param surname the specified surname.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets this person's phone.
     *
     * @return this person's phone.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Sets the specified phone to this person.
     *
     * @param phone the specified phone.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets this person's address.
     *
     * @return this person's address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets the specified address ti this person.
     *
     * @param address the specified address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Checks this person for equivalence with another person.
     *
     * @param o another person.
     * @return true if both persons are equals, false either.
     */
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Person person = (Person) o;
            result = Objects.equals(this.name, person.name) && Objects.equals(this.surname, person.surname);
        }
        return result;
    }

    /**
     * Calculates hash-code for this person.
     *
     * @return calculates hash-code for this person.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname);
    }

    /**
     * A string-presentation of this person.
     *
     * @return a string-presentation of this person.
     */
    @Override
    public String toString() {
        return String.format("Person{name='%s', surname='%s', phone='%s', address='%s'}", this.name, this.surname, this.phone, this.address);
    }
}