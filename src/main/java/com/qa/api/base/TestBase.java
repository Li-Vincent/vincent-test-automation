package com.qa.api.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public Properties prop;
    public int RES_STATUS_CODE_200 = 200;
    public int RES_STATUS_CODE_201 = 201;
    public int RES_STATUS_CODE_400 = 400;
    public int RES_STATUS_CODE_404 = 404;
    public int RES_STATUS_CODE_500 = 500;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/com/qa/api/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
