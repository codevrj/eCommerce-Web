package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    public ReadConfig(){

        File src = new File("./configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);

        }catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
    //Get User configure data
    public String getUserAppUrl(){
        return properties.getProperty("baseUrlUser");
    }
    public String getUserExcelPath(){
        return properties.getProperty("excelPathUser");
    }

    //Get Admin configure data
    public String getAdminAppUrl(){
        return properties.getProperty("baseUrlAdmin");
    }
    public String getAdminExcelPath(){
        return properties.getProperty("excelPathAdmin");
    }
}

