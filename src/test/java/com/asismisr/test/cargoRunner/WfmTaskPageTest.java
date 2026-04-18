package com.asismisr.test.cargoRunner;

import com.asismisr.configs.Config;
import com.asismisr.constants.Constants;
import com.asismisr.listeners.ListenersClass;
import com.asismisr.pages.cargoRunner.LoginPage;
import com.asismisr.pages.cargoRunner.WfmMilestonePage;
import com.asismisr.pages.cargoRunner.WorkflowManagementPage;
import com.asismisr.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WfmTaskPageTest extends BaseTest {

    @Test
    public void wfmTaskPageTest()
    {
        LoginPage loginPage=new LoginPage();
        loginPage.goToUrl(Config.getTestProperty(Constants.CARGORUNNER_URL));
        Assert.assertFalse(loginPage.isSigninButtonEnable());
        loginPage.enteringLoginDetails(Config.getTestProperty(Constants.CARGORUNNER_USERNAME),Config.getTestProperty(Constants.CARGORUNNER_PASSWORD));
        Assert.assertTrue(loginPage.isSigninButtonEnable());
        ListenersClass.attachScreenshotWithMessage("Login done");
        loginPage.clickOnSigninButton();
        WorkflowManagementPage workflowManagementPage=new WorkflowManagementPage();
        workflowManagementPage.navigateToURL(Config.getTestProperty(Constants.CARGORUNNER_NAVIGATING_URL));
        WfmMilestonePage wfmMilestonePage=new WfmMilestonePage();
        Assert.assertEquals(wfmMilestonePage.returnsTitleText(),Config.getTestProperty(Constants.CARGORUNNER_TITLE_WF));


    }
}
