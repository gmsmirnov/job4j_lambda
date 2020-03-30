package gsmirnov.lambda;

import java.util.Objects;

/**
 * Describes an attachment model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-03-30
 */
public class Attachment {
    /**
     * Attachment's name.
     */
    private String name;

    /**
     * Attachment's size.
     */
    private int size;

    /**
     * Attachment's constructor. Creates an attachment with the specified parameters.
     *
     * @param name the specified name.
     * @param size the specified size.
     */
    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Gets the attachment's name.
     *
     * @return the attachment's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the attachment's size.
     *
     * @return the attachment's size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Compares this attachment with another.
     *
     * @param o another attachment.
     * @return true if these attachments are equal, false either.
     */
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Attachment that = (Attachment) o;
            result = this.size == that.size && Objects.equals(this.name, that.name);
        }
        return result;
    }

    /**
     * Produces this attachment's hash-code.
     *
     * @return this attachment's hash-code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.size);
    }

    /**
     * String - presentation of this attachment.
     *
     * @return a string-presentation.
     */
    @Override
    public String toString() {
        return String.format("Attachment{name='%s', size=%d}", this.name, this.size);
    }
}