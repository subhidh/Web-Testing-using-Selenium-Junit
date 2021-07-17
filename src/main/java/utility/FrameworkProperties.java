package utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String result = "";
    private InputStream inputStream;

    public String getProperty(String key) throws IOException {
        try {
            Properties properties = new Properties();
            String propFile = "Framework.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFile);

            if (inputStream != null)
                properties.load(inputStream);
            else
                throw new FileNotFoundException("File Not Found");

            String propertyValue = properties.getProperty(key);
            this.result = propertyValue;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
