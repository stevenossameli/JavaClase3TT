package paquete.util;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public class ReadProperties {
    public static String leer(String key){

        Properties props = new Properties();

        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String propertiesPath = rootPath+"MiFactory.properties";


        try {
            FileInputStream fi = new FileInputStream(propertiesPath);
            props.load(fi);
            return props.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return "Not Found";
        }

    }
}
