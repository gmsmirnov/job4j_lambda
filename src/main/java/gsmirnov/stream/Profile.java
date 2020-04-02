package gsmirnov.stream;

/**
 * Profile model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-01
 */
public class Profile {
    /**
     * Profile's address.
     */
    private Address address;

    /**
     * Constructor. Creates a profile with the specified params.
     *
     * @param address the specified address.
     */
    public Profile(Address address) {
        this.address = address;
    }

    /**
     * Gets this profile's address.
     *
     * @return this profile's address.
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Sets the specified address to this profile.
     *
     * @param address the specified address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}