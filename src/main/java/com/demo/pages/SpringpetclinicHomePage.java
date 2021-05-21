package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SpringpetclinicHomePage extends BasePage {
    //Launch Home page Welcome header
    @FindBy(xpath="//h2")
    private WebElement txthdrWelcome;

    //constructor
    public SpringpetclinicHomePage(WebDriver driver){
        super.driver=driver;
        super.wait=new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    //Launch spring-petclinic site from Openshift Sandbox cloud envt
    public void launchApp( String url) {
        try {
            this.driver.get(url);
            //this.driver.manage().window().maximize();
            this.wait.until(ExpectedConditions.visibilityOf(this.txthdrWelcome));
            Assert.assertEquals(this.txthdrWelcome.getText(), "Welcome");
            System.out.println("springpet-clinic web App site is launched! Home page is displayed.");
            Thread.sleep(3000);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("IDP portal was not launched. Please check if Firm was created and try again!...");
            throw new AssertionError("spring-petclinic site was not launched. Please check if App is up and running and try again!... "+ e.getMessage());
            //System.exit(1);
        }
    }

}
