package core.properties;

/**
 * @author aolkuski
 * 13:34 26.06.14
 * <p/>
 * Class dedicated for handling properties files.
 */
public class PropertyHandlerFactory {

    private static PropertyHandler defaultHandler;

    /**
     * Method which allows to get a PropertyHandler. Singleton.
     *
     * @return PropertyHandler instance enabling to get property from default properties file
     */
    public static PropertyHandler get() {
        if (defaultHandler == null) {
            synchronized (PropertyHandlerFactory.class) {
                if (defaultHandler == null) {
                    defaultHandler = new PropertyHandler();
                }
            }
        }
        return defaultHandler;
    }

    /**
     * Method which allows to get a PropertyHandler.
     *
     * @param pathToFile path to file containing properties.
     * @return PropertyHandler instance enabling to get property from file specified by argument
     */
    public static PropertyHandler get(String pathToFile) {
        return new PropertyHandler(pathToFile);
    }
}
