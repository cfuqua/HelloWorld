package mil.dtic.common.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * The AgencyDAO class is the Agency data access object for the reference data
 * in the AGENCY table.
 */
public class PropertiesFile {

    private final Class CLASS = PropertiesFile.class;
    // private Log logger = LogFactory.getLog(CLASS);

    private String p_propertiesFilePath = "";
    private String propertiesFilename = "";

    public PropertiesFile(final String p_propertiesFilename) {
        this.propertiesFilename = p_propertiesFilename;
        setPropertiesFileLoaded(false);
    };

    public PropertiesFile(final String p_propertiesFilePath, final String p_propertiesFilename) {
        this.p_propertiesFilePath = p_propertiesFilePath;
        this.propertiesFilename = p_propertiesFilename;
        setPropertiesFileLoaded(false);
    };

    public Properties getProperties()
    {
        final String method = "getProperties";
        // logger.debug(Constants.quoteIt("enter", method));

        Properties props = new Properties();
        BufferedReader reader = null;
        final String propertiesFile = p_propertiesFilePath + this.propertiesFilename;
        try {
            reader = new BufferedReader(new FileReader(propertiesFile));
            props.load(reader);
            // if (logger.isDebugEnabled()) {
            // show(props);
            // }
            setPropertiesFileLoaded(true);
        }
        catch (FileNotFoundException e) {
            // logger.error(Constants.quoteIt("FileNotFoundException occurred
            // while loading property file" + propertiesFile), e);
            setPropertiesFileLoaded(false);
        }
        catch (IOException e) {
            // logger.error(Constants.quoteIt("IOException occurred while
            // loading property file", propertiesFile), e);
            setPropertiesFileLoaded(false);
        }
        finally {
            if (reader != null)
                try {
                    reader.close();
                }
                catch (IOException e) {
                    // logger.error(Constants.quoteIt("IOException occurred
                    // while closing reader for", this.propertiesFilename), e);
                }
        }

        // logger.debug(Constants.quoteIt("exit", method));
        return props;
    }

    public Properties getPropertiesFromClasspath()
    {
        final String method = "getPropertiesFromClasspath";
        // logger.debug(Constants.quoteIt("enter", method));

        Properties propsSorted = new Properties();
        // logger.debug(Constants.quoteIt("propertiesFilename",this.propertiesFilename));
        InputStream inputStream = CLASS.getClassLoader().getResourceAsStream(this.propertiesFilename);
        try {
            Properties props = new Properties();
            props.load(inputStream);
            final SortedMap<String,String> sortedProperties = new TreeMap(props);
            final Set<String> keySet = sortedProperties.keySet();
            final Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                final String propertyName = (String) iterator.next();
                final String propertyValue = props.getProperty(propertyName);
                propsSorted.put(propertyName, propertyValue);
            }
            show(propsSorted);
            setPropertiesFileLoaded(true);
        }
        catch (IOException e) {
            // logger.error(Constants.quoteIt("property file",
            // this.propertiesFilename)
            // + " not found in the classpath", e);
            // logger.error(Constants.quoteIt("IOException occurred while
            // loading property file",this.propertiesFilename) + " from
            // InputStream", e);
            setPropertiesFileLoaded(false);
        }
        finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    // logger.error(Constants.quoteIt("IOException occurred
                    // while closing InputStream for", this.propertiesFilename),
                    // e);
                }
        }

        // logger.debug(Constants.quoteIt("exit", method));
        return propsSorted;
    }

    private boolean propertiesFileLoaded = false;

    public boolean isPropertiesFileLoaded()
    {
        return this.propertiesFileLoaded;
    };

    public void setPropertiesFileLoaded(final boolean p_boolean)
    {
        this.propertiesFileLoaded = p_boolean;
    };

    private void show(final Properties p_props)
    {
        final String method = "show";
        // logger.debug(Constants.quoteIt("enter", method));

        // if (logger.isDebugEnabled()) {
        // StringBuffer sb = new
        // StringBuffer(Constants.quoteIt("propertiesFilename",this.propertiesFilename));
        // Set<Object> keys = p_props.keySet();
        // for (Object key : keys) {
        // sb.append(Constants.NEW_LINE);
        // sb.append(Constants.quoteIt(key.toString(),
        // p_props.getProperty(key.toString())));
        // }
        // logger.debug(sb);
        // }
        //
        // logger.debug(Constants.quoteIt("exit", method));
    }
}
