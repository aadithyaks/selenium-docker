package com.tests;

//import com.idp.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    public void setupDriverRemote() throws MalformedURLException {
        //Selenium Grid config code
        //BROWSER=chrome/firefox
        //HUB_HOST=localhost/ec2-3-138-244-105.us-east-2.compute.amazonaws.com

        //String host="localhost";
        String host="ec2-3-138-244-105.us-east-2.compute.amazonaws.com";
        //DesiredCapabilities dc = DesiredCapabilities.chrome();
        DesiredCapabilities dc;

        //By default chrome
        if (System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc=DesiredCapabilities.firefox();
        }else{
            dc=DesiredCapabilities.chrome();
        }
        //By default localhost
        if(System.getProperty("HUB_HOST")!=null){
            host=System.getProperty("HUB_HOST");
        }
        //Selenium Grid Remote setup
        String completeURL= "http://"+ host +":4444/wd/hub";
        this.driver=new RemoteWebDriver(new URL(completeURL), dc);

        //***********************************************************
        //Comment this code...used setupDriverLocal() function below
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\683132\\OneDrive - Cognizant\\chromedriver89\\chromedriver_win32\\chromedriver.exe");
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--start-maximized");
//        //DesiredCapabilities dc = DesiredCapabilities.chrome();
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        dc.setCapability(ChromeOptions.CAPABILITY, options);
//        options.merge(dc);
//        this.driver = new ChromeDriver(options);
    }

    //Regular code to execute tests locally
    //UNCOMMENT and use this...
    //@BeforeTest
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\683132\\OneDrive - Cognizant\\chromedriver89\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        //DesiredCapabilities dc = DesiredCapabilities.chrome();
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(dc);
        this.driver = new ChromeDriver(options);
        //this.driver = new ChromeDriver();
    }

    //write tests here

    @AfterTest
    public void quitDriver() throws InterruptedException {
        this.driver.quit();
    }
}
