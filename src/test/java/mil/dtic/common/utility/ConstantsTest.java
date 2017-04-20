/**
 * 
 */
package mil.dtic.common.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import mil.dtic.common.utility.Constants;

/**
 * @author 1511690796@mil
 *
 */
public class ConstantsTest {

    private final Constants tester = new Constants();

    @Test
    public final void testQuoteIt() {
        assertEquals("wrap text in ''", "'NULL'", tester.quoteIt("NULL"));
    }

}
