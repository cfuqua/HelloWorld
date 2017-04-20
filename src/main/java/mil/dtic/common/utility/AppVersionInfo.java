package mil.dtic.common.utility;

import java.util.Properties;
//import org.apache.commons.mail.EmailException;

//import mil.dtic.cbes.submissions.service.annotated.ConfigService;

/**
 * Hook into the servlet lifecycle.
 */
public class AppVersionInfo {

    // TODO: make the following a constant or configurable from web.xml
    private static final String VERSION_PROPERTIES_FILE = "version.properties";
    private static final String VERSION = "version";
    private static final String BUILD_TIMESTAMP = "buildtimestamp";
    private static final String BUILD_NUMBER = "buildnumber";
    private static final String VERSION_PAGE = "version.jsp";
    private static final PropertiesFile propertiesFile = new PropertiesFile(VERSION_PROPERTIES_FILE);

    public static String getVersionInfo()
    {
        return getProperties().toString();
    }

    public static String getVersionInfoVersion()
    {
        return getVersionInfoProp(VERSION);
    }

    public static String getVersionInfoVersion(final boolean p_isUserAuthorized)
    {
        final String version = getVersionInfoVersion();
        final String result = (p_isUserAuthorized ? formatLink(VERSION_PAGE, version) : version);

        return result;
    }
    public static String getVersionInfoBuildNumber()
    {
        return getVersionInfoProp(BUILD_NUMBER);
    }


    public static String getVersionInfoBuildTimestamp()
    {
        return getVersionInfoProp(BUILD_TIMESTAMP).toString();
    }

    public static String getVersionInfoBuildTimestamp(final boolean p_isUserAuthorized)
    {
        final String timestamp = getVersionInfoBuildTimestamp();
        final String result = (p_isUserAuthorized ? formatLink(VERSION_PAGE, timestamp) : timestamp);

        return result;
    }

    public static String getVersionInfoProp(final String p_propertyName)
    {
        String result = Constants.EMPTY_STRING;
        try {
            result = getProperties().getProperty(p_propertyName).toString();
        }
        catch (NullPointerException e) {}
        return result;
    }

    private static String formatLink(final String p_link, final String p_text)
    {
        StringBuffer sb = new StringBuffer("<a href='");
        sb.append(p_link);
        sb.append("'>");
        sb.append(p_text);
        sb.append("</a>");

        return sb.toString();
    }

    private static Properties getProperties()
    {
        return propertiesFile.getPropertiesFromClasspath();
    }

}
