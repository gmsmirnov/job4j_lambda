package gsmirnov.lambda.phonebook;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test for PhoneBook filter.
 */
public class PhoneBookTest {
    private final PhoneBook phoneBook = new PhoneBook();

    @Before
    public void init() {
        this.phoneBook.add(new Person("Ivan", "Ivanov", "999534872", "Bryansk"));
        this.phoneBook.add(new Person("Petr", "Petrov", "996534872", "Bryansk"));
        this.phoneBook.add(new Person("Pavel", "Pavlov", "992511872", "Moscow"));
        this.phoneBook.add(new Person("Ivan", "Petrov", "995511872", "Moscow"));
    }

    @Test
    public void whenFindByName() {
        List<Person> persons = this.phoneBook.find("Petr");
        assertThat(persons.size(), is(2));
        assertThat(persons.get(0).getName(), is("Petr"));
        assertThat(persons.get(0).getSurname(), is("Petrov"));
        assertThat(persons.get(0).getPhone(), is("996534872"));
        assertThat(persons.get(0).getAddress(), is("Bryansk"));
        assertThat(persons.get(1).getName(), is("Ivan"));
        assertThat(persons.get(1).getSurname(), is("Petrov"));
        assertThat(persons.get(1).getPhone(), is("995511872"));
        assertThat(persons.get(1).getAddress(), is("Moscow"));
    }

    @Test
    public void whenFindBySurname() {
        List<Person> persons = this.phoneBook.find("petr");
        assertThat(persons.size(), is(2));
        assertThat(persons.get(0).getName(), is("Petr"));
        assertThat(persons.get(0).getSurname(), is("Petrov"));
        assertThat(persons.get(0).getPhone(), is("996534872"));
        assertThat(persons.get(0).getAddress(), is("Bryansk"));
        assertThat(persons.get(1).getName(), is("Ivan"));
        assertThat(persons.get(1).getSurname(), is("Petrov"));
        assertThat(persons.get(1).getPhone(), is("995511872"));
        assertThat(persons.get(1).getAddress(), is("Moscow"));
    }

    @Test
    public void whenFindByPhone() {
        List<Person> persons = this.phoneBook.find("992511872");
        assertThat(persons.size(), is(1));
        assertThat(persons.get(0).getName(), is("Pavel"));
        assertThat(persons.get(0).getSurname(), is("Pavlov"));
        assertThat(persons.get(0).getPhone(), is("992511872"));
        assertThat(persons.get(0).getAddress(), is("Moscow"));
    }

    @Test
    public void whenFindByAddress() {
        List<Person> persons = this.phoneBook.find("MOSCOW");
        assertThat(persons.size(), is(2));
        assertThat(persons.get(0).getName(), is("Pavel"));
        assertThat(persons.get(0).getSurname(), is("Pavlov"));
        assertThat(persons.get(0).getPhone(), is("992511872"));
        assertThat(persons.get(0).getAddress(), is("Moscow"));
        assertThat(persons.get(1).getName(), is("Ivan"));
        assertThat(persons.get(1).getSurname(), is("Petrov"));
        assertThat(persons.get(1).getPhone(), is("995511872"));
        assertThat(persons.get(1).getAddress(), is("Moscow"));
    }
}