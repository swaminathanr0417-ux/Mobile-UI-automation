package utils;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final Properties PROPS = new Properties();

    static {
        String platform = System.getProperty("platform", "android").toLowerCase();
        String file = platform.equals("ios") ? "config/ios.properties" : "config/android.properties";
        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream(file)) {
            if (in != null) PROPS.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load configuration: " + file, e);
        }
    }

    public static String get(String key) {
        return System.getProperty(key, PROPS.getProperty(key));
    }
}
