package com.softech.ls360.grid_hub;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;


/**
 * Created by syed.musab on 11/25/2016.
 */
public class GridHub {


    public static void main (String [] args) throws MalformedURLException {

            WebDriver driver;
            String nodeURl;
            String baseUrl;


        baseUrl = "qa-udp-1.360training.com:8080/LS360Dashboard/login";
        nodeURl = "http://10.0.101.15:5555/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeURl), capability);

        driver.get(baseUrl);
        assertEquals("UDP Dashboard", driver.getTitle());
        driver.quit();
    }


    public void simpleTest() {


    }


    public void afterTest() {

       // driver.quit();

    }
}
