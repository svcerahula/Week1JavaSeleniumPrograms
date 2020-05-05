package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    // chrome driver path
    // chrome driver attribute name
    // fb email id
    // fb password

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "\\src\\test\\resources\\configurations.properties";
    private static String chromeDriverAttrName;
    private static String chromeDriverPath;
    private static String fbUrl;
    private static String fbEmailId;
    private static String fbPassword;
    private static String browserNotificationFlag;
    private static String amazonINUrl;

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();

        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        //Get properties from configuration.properties
        chromeDriverAttrName = prop.getProperty("chromeDriverAttrName");
        chromeDriverPath = prop.getProperty("chromeDriverPath");
        fbUrl = prop.getProperty("fbUrl");
        fbEmailId =prop.getProperty("fbEmailId");
        fbPassword=prop.getProperty("fbPassword");
        browserNotificationFlag=prop.getProperty("browserNotificationFlag");
        amazonINUrl=prop.getProperty("amazonINUrl");
    }

    public String getChromeDriverAttrName() {
        return chromeDriverAttrName;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public String getFbUrl() {
        return fbUrl;
    }

    public String getFbEmailId() {
        return fbEmailId;
    }

    public String getFbPassword() {
        return fbPassword;
    }

    public String getBrowserNotificationFlag() {
        return browserNotificationFlag;
    }

    public String getAmazonINUrl() {
        return amazonINUrl;
    }
}
