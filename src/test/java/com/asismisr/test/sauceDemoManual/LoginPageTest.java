package com.asismisr.test.sauceDemoManual;

import com.asismisr.annotations.TestCategoryAnnotation;
import com.asismisr.configs.Config;
import com.asismisr.constants.Constants;
import com.asismisr.enums.TestGroupEnum;
import com.asismisr.pages.sauceDemoManual.LoginPage;
import com.asismisr.pojo.sauceDemo.SauceDemoLoginCredantials;
import com.asismisr.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest {

    private LoginPageTest()
    {
        // No need to create object for this page.
    }

    @TestCategoryAnnotation(testAuthors = "Ashish", testGroups = {TestGroupEnum.REGRESSION})
    @Test(priority = 0, dataProvider = "LoginData",dataProviderClass = com.asismisr.utils.dataProvide.DataSender.class)
    public void loginWithValidCredantials(SauceDemoLoginCredantials sauceDemoLoginCredantials)
    {
        LoginPage loginPage=new LoginPage();
        loginPage.goToSauceDemourl(Config.getTestProperty(Constants.SAUCEDEMO_URL));
        loginPage.enterLoginUsername(sauceDemoLoginCredantials.getUsername());
        loginPage.enterLoginPassword(sauceDemoLoginCredantials.getPassword());
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getUrlAfterLogin(),Config.getTestProperty(Constants.SAUCEDEMO_HOME));
    }

    @TestCategoryAnnotation(testAuthors = "Ashish", testGroups = {TestGroupEnum.REGRESSION})
    @Test(priority = 1)
    public void loginWithEmptyCredantials()
    {
        LoginPage loginPage=new LoginPage();
        loginPage.goToSauceDemourl(Config.getTestProperty(Constants.SAUCEDEMO_URL));
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(),Config.getTestProperty(Constants.SAUCEDEMO_EMPTYCREDANTIALS_ERROR));
        System.out.println(loginPage.getLoginErrorMessage());
    }


}
