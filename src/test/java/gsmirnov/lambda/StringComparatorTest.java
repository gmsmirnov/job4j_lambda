package gsmirnov.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static gsmirnov.lambda.StringComparator.CMP_DESC_SIZE;
import static gsmirnov.lambda.StringComparator.CMP_SIZE;
import static gsmirnov.lambda.StringComparator.CMP_TEXT;
import static org.junit.Assert.*;

public class StringComparatorTest {
    private String first = "First test string";
    private String second = "Second test string";
    private String third = "Third test string";
    private String[] strings = new String[3];

    @Before
    public void init() {
        this.strings[0] = this.first;
        this.strings[1] = this.second;
        this.strings[2] = this.third;
    }

    @Test
    public void testCmpLength() {
        String[] expected = {this.first, this.third, this.second};
        Arrays.sort(this.strings, CMP_SIZE);
        assertArrayEquals(this.strings, expected);
    }

    @Test
    public void testCmpDescLength() {
        String[] expected = {this.second, this.first, this.third};
        Arrays.sort(this.strings, CMP_DESC_SIZE);
        assertArrayEquals(this.strings, expected);
    }

    @Test
    public void testCmpText() {
        String[] expected = {this.first, this.second, this.third};
        Arrays.sort(this.strings, CMP_TEXT);
        assertArrayEquals(this.strings, expected);
    }
}