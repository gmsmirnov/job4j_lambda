package gsmirnov.stream;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Tests users comparision.
 */
public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<User>(
                Set.of(
                        new User("Max", 29),
                        new User("Ivan", 15),
                        new User("Hans", 18),
                        new User("Petr", 32),
                        new User("Ivan", 31),
                        new User("Fritz", 17)
                )
        );
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Fritz", 17)));
        assertThat(it.next(), is(new User("Hans", 18)));
        assertThat(it.next(), is(new User("Ivan", 15)));
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Max", 29)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePetrVSIvan() {
        int result = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(result, greaterThan(0));
    }
}