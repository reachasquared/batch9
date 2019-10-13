package core.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * Class for handling properties.
 *
 * @author aolkuski
 */
public class PropertyHandler {
    private static Logger LOGGER = LogManager.getLogger("Helper");
    private String propertiesPath;
    private Properties propertyCache;

    public PropertyHandler() {
        propertiesPath = "config/default.properties";
        init();
    }

    /**
     * Constructor of properties object.
     *
     * @param pathToProperties path to properties file
     */
    public PropertyHandler(String pathToProperties) {
        propertiesPath = pathToProperties.replaceAll("\\\\", "/");
        init();
    }

    /**
     * Method gets property value from default file (location: /testdata/dynamic.properties).
     *
     * @param propertyKey Name of property to be read
     * @return property value
     * @author aolkuski
     */
    public static String getDynamicPropertyFromDefaultFile(String propertyKey) {
        return getDynamicProperty(propertyKey, "/testdata/dynamic.properties");
    }

    /**
     * Method stores property in a default file (location: /testdata/dynamic.properties).
     *
     * @param propertyKey   Name of property to be read
     * @param propertyValue Value of a property to be stored
     * @author aolkuski
     */
    public static void setDynamicPropertyToDefaultFile(String propertyKey, String propertyValue) {
        setDynamicProperty(propertyKey, propertyValue, "/testdata/dynamic.properties");
    }

    /**
     * Reads value from dynamic prooperties file.
     *
     * @param propertyKey    Name of property to be read
     * @param propertiesPath Path to properties file, convertable to URL e.g. '/testdata/dynamic.properties'
     * @return Value of specified property
     * @author jsowicki
     */
    public static String getDynamicProperty(String propertyKey, String propertiesPath) {
        String val = "Nothing was read";

        FileInputStream fis = null;
        Properties prop = new Properties();
        String name = propertiesPath;
        File file = null;

        try {
            URL resourceUrl = PropertyHandler.class.getResource(name);
            if (resourceUrl.toURI().getScheme().equals("jar")) {
                String uriStr = resourceUrl.toURI().toString();
                uriStr = uriStr.substring(uriStr.lastIndexOf('/') + 1);
                file = new File(uriStr);
            } else file = new File(resourceUrl.toURI());
            if (!file.exists()) file.createNewFile();
            fis = new FileInputStream(file);
            prop.load(fis);
            val = prop.getProperty(propertyKey);
            System.out.println("***** Data from dynamic properties (GET) *****");
            System.out.println("**** propertyKey(GET): " + propertyKey + " ****");
            System.out.println("**** propertyValue(GET): " + val + " ****");
        } catch (URISyntaxException e) {
            LOGGER.warn("String could not be parsed as URI", e);
        } catch (FileNotFoundException e) {
            LOGGER.warn("File not found!", e);
        } catch (IOException e) {
            LOGGER.warn(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    LOGGER.warn(e);
                }
            }
        }
        return val;
    }

    /**
     * Reads value from dynamic prooperties file - in case of null, third argument is returned.
     *
     * @param propertyKey    Name of property to be read
     * @param propertiesPath Path to properties file, convertable to URL e.g. '/testdata/dynamic.properties'
     * @param defaultValue   Value to return, if specified is not present in dynamic properties
     * @return Value of specified property
     * @author jsowicki
     */
    public static String getDynamicProperty(String propertyKey, String propertiesPath, String defaultValue) {
        return (getDynamicProperty(propertyKey, propertiesPath) == null || getDynamicProperty(propertyKey, propertiesPath).equals("null")) ? defaultValue : getDynamicProperty(propertyKey, propertiesPath);
    }

    /**
     * Deletes value from dynamic properties file
     *
     * @param propertyKey    Name of property to be deleted
     * @param propertiesPath
     * @author jsowicki
     */
    public static void removeDynamicProperty(String propertyKey, String propertiesPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        Properties prop = new Properties();
        String name = propertiesPath;
        File file = null;

        try {
            URL resourceUrl = PropertyHandler.class.getResource(name);
            if (resourceUrl.toURI().getScheme().equals("jar")) {
                String uriStr = resourceUrl.toURI().toString();
                uriStr = uriStr.substring(uriStr.lastIndexOf('/') + 1);
                file = new File(uriStr);
            } else file = new File(resourceUrl.toURI());
            if (!file.exists()) file.createNewFile();
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file);
            prop.load(fis);
            prop.remove(propertyKey);
            prop.store(fos, null);
        } catch (URISyntaxException | IOException e) {
            LOGGER.warn(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    LOGGER.warn(e);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    LOGGER.warn(e);
                }
            }
        }
    }

    /**
     * Sets pair property key/property value in properties file specified in constructor.
     *
     * @param propertyKey    name of a property to be set
     * @param propertyValue  value of a property to be set
     * @param propertiesPath to properties file, convertable to URL e.g. '/testdata/dynamic.properties'
     * @author jsowicki
     */
    public static void setDynamicProperty(String propertyKey, String propertyValue, String propertiesPath) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        Properties prop = new Properties();
        String name = propertiesPath;
        File file = null;
        File fileo = null;

        try {
            URL resourceUrl = PropertyHandler.class.getResource(name);
            if (resourceUrl.toURI().getScheme().equals("jar")) {
                String uriStr = resourceUrl.toURI().toString();
                uriStr = uriStr.substring(uriStr.lastIndexOf('/') + 1);
                file = new File(uriStr);
                fileo = new File(uriStr);
            } else {
                file = new File(resourceUrl.toURI());
                fileo = new File(resourceUrl.toURI());
            }
            if (!file.exists()) file.createNewFile();
            fis = new FileInputStream(file);
            prop.load(fis);
            fos = new FileOutputStream(fileo);
            prop.setProperty(propertyKey, propertyValue);
            prop.store(fos, null);
            System.out.println("***** Data from dynamic properties (SET) *****");
            System.out.println("**** propertyKey(SET): " + propertyKey + " ****");
            System.out.println("**** propertyValue(SET): " + propertyValue + " ****");
        } catch (URISyntaxException | IOException e) {
            LOGGER.warn(e);
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException ignore) {
                }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ignore) {
                }
            }
        }
    }

    /**
     * Gets property value from file specified in constructor.
     *
     * @param propertyKey name of a property to be found
     * @return value of a found property
     */
    public String getPropertyValue(String propertyKey) {
        String val = System.getProperty(propertyKey);
        if ((val == null) || (val.equals(""))) {
            val = (String) propertyCache.get(propertyKey);
        }
        return val;
    }

    private void init() {
        FileInputStream inputStream = null;
        propertyCache = new Properties();
        try {
            inputStream = new FileInputStream(new File(propertiesPath));
            propertyCache.load(inputStream);
        } catch (IOException e) {
            LOGGER.warn(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ignore) {
                }
            }
        }
    }

    /**
     * Sets pair propertyKey, propertyValue in file specified in constructor.
     *
     * @param propertyKey
     * @param propertyValue
     */
    public void setPropertyValue(String propertyKey, String propertyValue) {
        FileInputStream inputStream = null;
        FileOutputStream fos = null;
        Properties props = new Properties();

        try {
            inputStream = new FileInputStream(new File(propertiesPath));
            props.load(inputStream);
            fos = new FileOutputStream(new File(propertiesPath));
            props.setProperty(propertyKey, propertyValue);
            props.store(fos, null);
        } catch (IOException e) {
            LOGGER.warn(e);
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException ignore) {
                }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ignore) {
                }
            }
        }
    }

}
