/**
 * 
 */
package mil.dtic.common.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import mil.dtic.common.utility.PropertiesFile;

/**
 * @author 1511690796@mil
 *
 */
public class PropertiesFileTest {

    private final PropertiesFile tester = new PropertiesFile("file");
    private final PropertiesFile testerPath = new PropertiesFile("path", "file");

    @Test
    public final void testGetProperties() {
        assertNotNull("return properties", tester.getProperties());
        assertNotNull("return properties", testerPath.getProperties());
    }

}
