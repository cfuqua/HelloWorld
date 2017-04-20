/**
 * 
 */
package mil.dtic.common.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import mil.dtic.common.utility.AppVersionInfo;

/**
 * @author 1511690796@mil
 *
 */
public class AppVersionInfoTest {

    private final AppVersionInfo tester = new AppVersionInfo();

    /**
     * Test method for {@link main.java.mil.dtic.common.utility.AppVersionInfo#getVersionInfo()}.
     */
    @Test
    public final void testGetVersionInfo() {

        // assert statements
        assertNotNull("all version info", tester.getVersionInfo());
    }

    /**
     * Test method for {@link main.java.mil.dtic.common.utility.AppVersionInfo#getVersionInfoVersion()}.
     */
    @Test
    public final void testGetVersionInfoVersion() {
        assertNotNull("version", tester.getVersionInfoVersion());
    }

    /**
     * Test method for {@link main.java.mil.dtic.common.utility.AppVersionInfo#getVersionInfoVersion(boolean)}.
     */
    @Test
    public final void testGetVersionInfoVersionBoolean() {
        assertNotNull("authorized to see version", tester.getVersionInfoVersion(true));
        assertNotNull("not authorized to see version", tester.getVersionInfoVersion(false));
    }
    /**
     * Test method for {@link main.java.mil.dtic.common.utility.AppVersionInfo#getVersionInfoBuildNumber()}.
     */
    @Test
    public final void testGetVersionInfoBuildNumber() {
        assertNotNull("Build Number", tester.getVersionInfoBuildNumber());
    }


    /**
     * Test method for {@link main.java.mil.dtic.common.utility.AppVersionInfo#getVersionInfoBuildTimestamp()}.
     */
    @Test
    public final void testGetVersionInfoBuildTimestamp() {
        assertNotNull("Build Timestamp", tester.getVersionInfoBuildTimestamp());
    }

    /**
     * Test method for {@link main.java.mil.dtic.common.utility.AppVersionInfo#getVersionInfoBuildTimestamp(boolean)}.
     */
    @Test
    public final void testGetVersionInfoBuildTimestampBoolean() {
        assertNotNull("authorized to see Build Timestamp", tester.getVersionInfoBuildTimestamp(true));
        assertNotNull("not authorized to see Build Timestamp", tester.getVersionInfoBuildTimestamp(false));
    }

    /**
     * Test method for {@link main.java.mil.dtic.common.utility.AppVersionInfo#getVersionInfoProp(java.lang.String)}.
     */
    @Test
    public final void testGetVersionInfoProp() {
        assertNotNull("version property value", tester.getVersionInfoProp("version"));
    }

}
