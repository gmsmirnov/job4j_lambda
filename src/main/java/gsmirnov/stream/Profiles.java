package gsmirnov.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Profiles ti addresses converter.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-01
 */
public class Profiles {
    /**
     * Converts the list of given profiles into the list of addresses.
     *
     * @param profiles given profiles list.
     * @return converted into addresses list.
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> new Address(
                                profile.getAddress().getCity(),
                                profile.getAddress().getStreet(),
                                profile.getAddress().getHome(),
                                profile.getAddress().getApartment()))
                .collect(Collectors.toList());
    }
}