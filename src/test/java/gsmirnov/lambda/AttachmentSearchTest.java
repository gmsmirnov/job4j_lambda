package gsmirnov.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Attachment's list filter test.
 */
public class AttachmentSearchTest {
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
        assertThat(AttachmentSearch.filterSize(this.attachments, 50), is(Arrays.asList(
                new Attachment("image 3", 100)
        )));
    }

    @Test
    public void whenUseNameSort() {
        assertThat(AttachmentSearch.filterName(this.attachments, "image"), is(Arrays.asList(
                new Attachment("image 3", 100),
                new Attachment("image 1", 13)
        )));
    }
}