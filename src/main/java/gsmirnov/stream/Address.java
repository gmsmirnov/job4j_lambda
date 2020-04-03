package gsmirnov.stream;

import java.util.Objects;

/**
 * Address model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-01
 */
public class Address {
    /**
     * City name.
     */
    private String city;

    /**
     * Street name;
     */
    private String street;

    /**
     * Home number.
     */
    private int home;

    /**
     * Apartment number.
     */
    private int apartment;

    /**
     * Creates an address with the specified params.
     *
     * @param city the specified city name.
     * @param street the specified street name.
     * @param home the specified home number.
     * @param apartment the specified apartment number.
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    /**
     * Creates an address with params of another address.
     *
     * @param address another address.
     */
    public Address(Address address) {
        this.city = address.getCity();
        this.street = address.getStreet();
        this.home = address.getHome();
        this.apartment = address.getApartment();
    }

    /**
     * Gets the city of this address.
     *
     * @return the city of this address.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the specified city into this address.
     *
     * @param city the specified city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the street of this address.
     *
     * @return the street of this address.
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * Sets the specified street into this address.
     *
     * @param street the specified street.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the home number of this address.
     *
     * @return the home number of this address.
     */
    public int getHome() {
        return this.home;
    }

    /**
     * Sets the specified home number into this address.
     *
     * @param home the specified home number
     */
    public void setHome(int home) {
        this.home = home;
    }

    /**
     * Gets the apartment number from this address.
     *
     * @return the apartment number from this address.
     */
    public int getApartment() {
        return this.apartment;
    }

    /**
     * Sets the specified apartment number into this address.
     *
     * @param apartment the specified apartment number
     */
    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    /**
     * Checks this address for equivalence with another address.
     *
     * @param o another address.
     * @return true if both addresses are equal, false either.
     */
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Address address = (Address) o;
            result = this.home == address.home
                    && this.apartment == address.apartment
                    && Objects.equals(this.city, address.city)
                    && Objects.equals(this.street, address.street);
        }
        return result;
    }

    /**
     * Calculates hash-code for this address.
     *
     * @return calculated hash-code for this address.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.city, this.street, this.home, this.apartment);
    }

    /**
     * A string presentation of this address.
     *
     * @return a string presentation of this address.
     */
    @Override
    public String toString() {
        return String.format("Address{city='%s', street='%s', home=%d, apartment=%d}", this.city, this.street, this.home, this.apartment);
    }
}