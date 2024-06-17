package singleton;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private static Configuration instance;
    private Map<String, String> settings;

    private Configuration() {
        settings = new HashMap<>();
        settings.put("dbUrl", "jdbc:mysql://localhost:3306/mydatabase");
        settings.put("dbUser", "root");
        settings.put("dbPassword", "password");
        settings.put("currency", "RS");
    }

    public static synchronized Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String getSetting(String key) {
        return settings.get(key);
    }

    public void setSetting(String key, String value) {
        settings.put(key, value);
    }
}
