package gsmirnov.lambda;

import java.util.Comparator;
import java.util.List;

/**
 * Sorting utils for attachment collections.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-03-30
 */
public class AttachmentSort {
    /**
     * Sorts attachment's list by attachment's size.
     *
     * @param attachments attachment's list.
     * @return sorted by size attachment's list.
     */
    public static List<Attachment> sortBySize(List<Attachment> attachments) {
        attachments.sort(new Comparator<Attachment>() {
            @Override
            public int compare(Attachment attLeft, Attachment attRight) {
                return attLeft.getSize() - attRight.getSize();
            }
        });
        return attachments;
    }

    /**
     * Sorts attachment's list by attachment's name.
     *
     * @param attachments attachment's list.
     * @return sorted by name attachment's list.
     */
    public static List<Attachment> sortByName(List<Attachment> attachments) {
        attachments.sort(new Comparator<Attachment>() {
            @Override
            public int compare(Attachment attLeft, Attachment attRight) {
                return attLeft.getName().compareTo(attRight.getName());
            }
        });
        return attachments;
    }
}