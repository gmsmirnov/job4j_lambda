package gsmirnov.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Filter utilities for Attachments.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-03-30
 */
public class AttachmentSearch {
    /**
     * Filters list of attachments by the specified size condition.
     *
     * @param attachments list of attachments.
     * @param sizeFilter the size condition.
     * @return filtered list of attachments.
     */
    public static List<Attachment> filterSize(List<Attachment> attachments, final int sizeFilter) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > sizeFilter;
            }
        };
        return filter(attachments, predicate);
    }

    /**
     * Filers list of attachments by the specified name condition.
     *
     * @param attachments list of attachments.
     * @param nameFilter the name filter.
     * @return filtered list of attachments.
     */
    public static List<Attachment> filterName(List<Attachment> attachments, final String nameFilter) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains(nameFilter);
            }
        };
        return filter(attachments, predicate);
    }

    /**
     * Filters list of attachments by the specified condition.
     *
     * @param attachments list of attachments.
     * @param predicate the specified condition.
     * @return filtered list of attachments.
     */
    private static List<Attachment> filter(List<Attachment> attachments, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<Attachment>();
        for (Attachment attachment : attachments) {
            if (predicate.test(attachment)) {
                rsl.add(attachment);
            }
        }
        return rsl;
    }
}