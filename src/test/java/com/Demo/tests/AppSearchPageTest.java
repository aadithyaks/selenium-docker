package com.Demo.tests;

import com.demo.pages.SpringpetclinicHomePage;
import com.demo.pages.SpringpetclinicSearchPage;
import com.tests.BaseTest;
import org.testng.annotations.Test;

public class AppSearchPageTest extends BaseTest {
    @Test
    public void LaunchSpringpetclinicTest(){
        SpringpetclinicHomePage springpetclinicHomePage = new SpringpetclinicHomePage(driver);
        springpetclinicHomePage.launchApp("http://spring-petclinic-aadithyaks-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/");
    }
    //Find Owner Search page test
    @Test(dependsOnMethods = "LaunchSpringpetclinicTest")
    public void FindOwnerTest() {
        SpringpetclinicSearchPage springpetclinicSearchPage = new SpringpetclinicSearchPage(driver);
        springpetclinicSearchPage.FindOwnerListAll();
    }
}
