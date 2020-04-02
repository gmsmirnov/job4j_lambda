package gsmirnov.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static gsmirnov.stream.Profiles.collect;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

/**
 * Test profiles to addresses transform.
 */
public class ProfilesTest {
    private final List<Profile> profiles = new ArrayList<Profile>();

    @Before
    public void init() {
        this.profiles.add(new Profile(new Address("Moscow", "Lenina", 10, 5)));
        this.profiles.add(new Profile(new Address("Novosibirsk", "Sovetskaya", 27, 19)));
        this.profiles.add(new Profile(new Address("Moscow", "Arbat", 19, 1)));
        this.profiles.add(new Profile(new Address("Novosibirsk", "Lenina", 25, 7)));
    }

    @Test
    public void test() {
        List<Address> result = collect(this.profiles);
        assertThat(result, containsInAnyOrder(
                new Address("Moscow", "Lenina", 10, 5),
                new Address("Novosibirsk", "Sovetskaya", 27, 19),
                new Address("Moscow", "Arbat", 19, 1),
                new Address("Novosibirsk", "Lenina", 25, 7)
        ));
    }
}