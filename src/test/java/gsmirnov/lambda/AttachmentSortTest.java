package gsmirnov.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Attachment's list sorting test.
 */
public class AttachmentSortTest {
    private List<Attachment> attachments;

    @Before
    public void init() {
         this.attachments = Arrays.asList(
                new Attachment("image 3", 100),
                new Attachment("Image 2", 34),
                new Attachment("image 1", 13)
         );
    }

    @Test
    public void whenUseSizeSort() {
        assertThat(AttachmentSort.sortBySize(this.attachments), is(Arrays.asList(
                new Attachment("image 1", 13),
                new Attachment("Image 2", 34),
                new Attachment("image 3", 100)
        )));
    }

    @Test
    public void whenUseNameSort() {
        assertThat(AttachmentSort.sortByName(this.attachments), is(Arrays.asList(
                new Attachment("Image 2", 34),
                new Attachment("image 1", 13),
                new Attachment("image 3", 100)
        )));
    }
}