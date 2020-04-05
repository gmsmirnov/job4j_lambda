package gsmirnov.lambda.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Phone book model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-01
 */
public class PhoneBook {
    /**
     * Phone book. Contains persons contacts.
     */
    private final List<Person> phoneBook = new ArrayList<Person>();

    /**
     * Puts the specified person into phone book.
     *
     * @param person the specified person.
     */
    public void add(Person person) {
        this.phoneBook.add(person);
    }

    /**
     * Finds the list of all persons in phone book who matches the specified key-word.
     *
     * @param key the specified key-word.
     * @return the list of all matched persons from this phone book.
     */
    public List<Person> find(String key) {
        var result = new ArrayList<Person>();
        for (var person : this.phoneBook) {
            if (this.createFilter(key.toLowerCase()).test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    /**
     * Creates combo filters over all person-class fields.
     *
     * @param key the specified filtered key-word.
     * @return predicate which can check all the person-class fields.
     */
    private Predicate<Person> createFilter(final String key) {
        Predicate<Person> predName = person -> person.getName().toLowerCase().contains(key);
        Predicate<Person> predSurname = person -> person.getSurname().toLowerCase().contains(key);
        Predicate<Person> predPhone = person -> person.getPhone().toLowerCase().contains(key);
        Predicate<Person> predAddress = person -> person.getAddress().toLowerCase().contains(key);
        return predName.or(predSurname).or(predPhone).or(predAddress);
    }
}