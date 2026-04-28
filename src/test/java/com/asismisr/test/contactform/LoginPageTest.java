package com.asismisr.test.contactform;

import com.asismisr.annotations.TestCategoryAnnotation;
import com.asismisr.configs.Config;
import com.asismisr.constants.Constants;
import com.asismisr.enums.TestGroupEnum;
import com.asismisr.pages.contactform.LoginPage;
import com.asismisr.pojo.ContactForm;
import com.asismisr.test.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public final class LoginPageTest extends BaseTest {
    private LoginPageTest()
    {
        // no need of object
    }




    @TestCategoryAnnotation(testAuthors = "Aditya", testGroups = {TestGroupEnum.SMOKE})
    @Test(dataProviderClass = com.asismisr.utils.dataProvide.DataProviding.class, dataProvider = "ContactformInput")
    public void loginTest(ContactForm contactForm) throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.navigateToUrl(Config.getTestProperty(Constants.CONTACTFORM_URL));
        loginPage.enterUsername(contactForm.getUsername());
        loginPage.enterPassword(contactForm.getPassword());
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        int numberOfLogoutButton=loginPage.findLogoutButton();
        if (numberOfLogoutButton==1)
        {
            Assert.assertTrue(loginPage.isContactformTitleVisible());
        }
        else {
            Assert.assertTrue(loginPage.isLoginErrorShown());
        }
    }
}
