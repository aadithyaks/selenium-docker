package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SpringpetclinicSearchPage extends BasePage {
    //Find Owner menu link
    @FindBy(xpath = "//span[contains(text(), 'Find owners')]")
    private WebElement mnulinkFindOwner;
    //Find Owner button
    @FindBy(xpath = "//button[contains(text(), 'Find')]")
    private WebElement btnFindOwner;

    //constructor
    public SpringpetclinicSearchPage(WebDriver driver){
        super.driver=driver;
        super.wait=new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    //Keep LastName Blank and click Find Owner button. All 11 records from DB returned
    public void FindOwnerListAll() {
        try {
            Thread.sleep(2000);
            this.wait.until(ExpectedConditions.elementToBeClickable(this.mnulinkFindOwner)).click();
            Thread.sleep(2000);
            this.wait.until(ExpectedConditions.elementToBeClickable(this.btnFindOwner)).click();
            Thread.sleep(2000);
            Assert.assertEquals(this.driver.getCurrentUrl(), "http://spring-petclinic-aadithyaks-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/owners?lastName=");
            System.out.println("Expected Find Owner Search page and table of records is displayed. Test passed");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("IDP portal was not launched. Please check if Firm was created and try again!...");
            throw new AssertionError("spring-petclinic Find Owner Search page not working... Please check if App and DB is up and running and try again!... "+ e.getMessage());
            //System.exit(1);
        }
    }
}
