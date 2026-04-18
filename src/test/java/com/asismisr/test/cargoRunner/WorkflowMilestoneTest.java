package com.asismisr.test.cargoRunner;

import com.asismisr.annotations.TestCategoryAnnotation;
import com.asismisr.codeUtils.CommonUtilis;
import com.asismisr.configs.Config;
import com.asismisr.constants.Constants;
import com.asismisr.enums.TestGroupEnum;
import com.asismisr.listeners.ListenersClass;
import com.asismisr.pages.cargoRunner.LoginPage;
import com.asismisr.pages.cargoRunner.WfmMilestonePage;
import com.asismisr.pages.cargoRunner.WorkflowManagementPage;
import com.asismisr.pojo.wfm.MilestoneCreationPojo;
import com.asismisr.pojo.wfm.MilestoneUpdationPojo;
import com.asismisr.serviceLayer.wfm.WfmService;
import com.asismisr.test.BaseTest;
import com.asismisr.utils.dataProvide.DataSender;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkflowMilestoneTest extends BaseTest {

    private WfmService wfmService = new WfmService();

    @TestCategoryAnnotation(testAuthors = "Aditya", testGroups = {TestGroupEnum.REGRESSION, TestGroupEnum.SMOKE})
    @Test(enabled = false, priority = 0, dataProviderClass = com.asismisr.utils.dataProvide.DataSender.class, dataProvider = "dataproviding")
    public void createMiletoneTest(MilestoneCreationPojo milestoneCreationPojo) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.goToUrl(Config.getTestProperty(Constants.CARGORUNNER_URL));
        Assert.assertFalse(loginPage.isSigninButtonEnable());
        loginPage.enteringLoginDetails(Config.getTestProperty(Constants.CARGORUNNER_USERNAME), Config.getTestProperty(Constants.CARGORUNNER_PASSWORD));
        Assert.assertTrue(loginPage.isSigninButtonEnable());
        loginPage.clickOnSigninButton();
        ListenersClass.attachScreenshotWithMessage("Login done");
        WorkflowManagementPage workflowManagementPage = new WorkflowManagementPage();
        workflowManagementPage.navigateToURL(Config.getTestProperty(Constants.CARGORUNNER_NAVIGATING_URL));
        WfmMilestonePage wfmMilestonePage = new WfmMilestonePage();
        Assert.assertEquals(wfmMilestonePage.returnsTitleText(), Config.getTestProperty(Constants.CARGORUNNER_TITLE_WF));
        wfmMilestonePage.clickOnMilestoneTab();
        Assert.assertTrue(wfmMilestonePage.isCreatenewmilestoneVisible());
        wfmMilestonePage.clickonMilestoneButton();
        Assert.assertTrue(wfmMilestonePage.isCreatemilestoneTitleVisible());
        Assert.assertFalse(wfmMilestonePage.isCreateButtonEnabled());
        wfmMilestonePage.fillingMilestoneName(milestoneCreationPojo.getMileStoneName());
        wfmMilestonePage.fillingMilestoneCode(milestoneCreationPojo.getMileStoneCode());
        wfmMilestonePage.fillingMilestoneType(milestoneCreationPojo.getMileStoneWorkflowType());
        ListenersClass.attachScreenshotWithMessage("Milestone datas filled");
        Assert.assertTrue(wfmMilestonePage.isCreateButtonEnabled());
        wfmMilestonePage.clickOnCreateButton();
        Assert.assertTrue(wfmMilestonePage.isMilestoneNameListed(milestoneCreationPojo.getMileStoneName()));
        Assert.assertTrue(wfmMilestonePage.isMilestoneCodeListed(milestoneCreationPojo.getMileStoneCode()));
        Assert.assertTrue(wfmMilestonePage.isMilestoneTypeListed(milestoneCreationPojo.getMileStoneWorkflowType()));
        ListenersClass.attachScreenshotWithMessage("Present in milestone listing");
    }

    @TestCategoryAnnotation(testAuthors = "Aditya", testGroups = {TestGroupEnum.REGRESSION, TestGroupEnum.SMOKE})
    @Test(enabled = false, dataProviderClass = DataSender.class, dataProvider = "dataproviding")
    public void createMilestoneWithallFieldsTest(MilestoneCreationPojo milestoneCreationPojo) {
        LoginPage loginPage = new LoginPage();
        milestoneCreationPojo.setMileStoneName(CommonUtilis.randomString(6) + "_MilestoneName");
        milestoneCreationPojo.setMileStoneCode(CommonUtilis.randomString(4) + "cde");
        loginPage.goToUrl(Config.getTestProperty(Constants.CARGORUNNER_URL));
        Assert.assertFalse(loginPage.isSigninButtonEnable());
        loginPage.enteringLoginDetails(Config.getTestProperty(Constants.CARGORUNNER_USERNAME), Config.getTestProperty(Constants.CARGORUNNER_PASSWORD));
        Assert.assertTrue(loginPage.isSigninButtonEnable());
        loginPage.clickOnSigninButton();
        ListenersClass.attachScreenshotWithMessage("Login done");
        WorkflowManagementPage workflowManagementPage = new WorkflowManagementPage();
        workflowManagementPage.navigateToURL(Config.getTestProperty(Constants.CARGORUNNER_NAVIGATING_URL));
        WfmMilestonePage wfmMilestonePage = new WfmMilestonePage();
        Assert.assertEquals(wfmMilestonePage.returnsTitleText(), Config.getTestProperty(Constants.CARGORUNNER_TITLE_WF));
        wfmMilestonePage.clickOnMilestoneTab();
        Assert.assertTrue(wfmMilestonePage.isCreatenewmilestoneVisible());
        wfmMilestonePage.clickonMilestoneButton();
        Assert.assertTrue(wfmMilestonePage.isCreatemilestoneTitleVisible());
        Assert.assertFalse(wfmMilestonePage.isCreateButtonEnabled());
        wfmService.createMilStoneService(milestoneCreationPojo);
        Assert.assertTrue(wfmMilestonePage.isCreateButtonEnabled());
        ListenersClass.attachScreenshotWithMessage("Milestone datas filled: customerPortalFlag:"
                + milestoneCreationPojo.getMileStoneCustomerPortalFlag() + "; dynamicFlag:" + milestoneCreationPojo.getMileStoneDynamicFlag());
        wfmMilestonePage.clickOnCreateButton();
        Assert.assertTrue(wfmMilestonePage.isMilestoneNameListed(milestoneCreationPojo.getMileStoneName()));
        Assert.assertTrue(wfmMilestonePage.isMilestoneCodeListed(milestoneCreationPojo.getMileStoneCode()));
        Assert.assertTrue(wfmMilestonePage.isMilestoneDiscriptionListed(milestoneCreationPojo.getMileStoneDescription()));
        Assert.assertTrue(wfmMilestonePage.isMilestoneTypeListed(milestoneCreationPojo.getMileStoneWorkflowType()));
        ListenersClass.attachScreenshotWithMessage("Present in milestone listing");
    }

    @TestCategoryAnnotation(testAuthors = "Aditya", testGroups = {TestGroupEnum.REGRESSION, TestGroupEnum.SMOKE})
    @Test(enabled = true, priority = 1, dataProviderClass = DataSender.class, dataProvider = "updatingMilestoneDatasInListing")
    public void updatingMilestoneData(MilestoneUpdationPojo milestoneUpdationPojo) {
        LoginPage loginPage = new LoginPage();
        loginPage.goToUrl(Config.getTestProperty(Constants.CARGORUNNER_URL));
        Assert.assertFalse(loginPage.isSigninButtonEnable());
        loginPage.enteringLoginDetails(Config.getTestProperty(Constants.CARGORUNNER_USERNAME), Config.getTestProperty(Constants.CARGORUNNER_PASSWORD));
        Assert.assertTrue(loginPage.isSigninButtonEnable());
        ListenersClass.attachScreenshotWithMessage("Login done");
        loginPage.clickOnSigninButton();
        WorkflowManagementPage workflowManagementPage = new WorkflowManagementPage();
        workflowManagementPage.navigateToURL(Config.getTestProperty(Constants.CARGORUNNER_NAVIGATING_URL));
        WfmMilestonePage wfmMilestonePage = new WfmMilestonePage();
        Assert.assertEquals(wfmMilestonePage.returnsTitleText(), Config.getTestProperty(Constants.CARGORUNNER_TITLE_WF));
        wfmMilestonePage.clickOnMilestoneTab();
        ListenersClass.attachScreenshotWithMessage("In milestone Tab");
        Assert.assertTrue(wfmMilestonePage.isCreatenewmilestoneVisible());
        wfmMilestonePage.clickonMilestoneButton();
        Assert.assertTrue(wfmMilestonePage.isCreatemilestoneTitleVisible());
        Assert.assertFalse(wfmMilestonePage.isCreateButtonEnabled());
        MilestoneCreationPojo milestoneCreationPojo = new MilestoneCreationPojo(
                milestoneUpdationPojo.getMileStoneName(),
                milestoneUpdationPojo.getMileStoneCode(),
                milestoneUpdationPojo.getEditWorkflowType(),
                milestoneUpdationPojo.getMileStoneDescription(),
                milestoneUpdationPojo.getEditShowCustomerPortalFlag(),
                milestoneUpdationPojo.getMileStoneDynamicFlag()
        );
        wfmService.createMilStoneService(milestoneCreationPojo);
        ListenersClass.attachScreenshotWithMessage("Milestone datas filled");
        Assert.assertTrue(wfmMilestonePage.isCreateButtonEnabled());
        wfmMilestonePage.clickOnCreateButton();
        wfmMilestonePage.clickOnActionsEditButton(milestoneCreationPojo.getMileStoneName());
        Assert.assertTrue(wfmMilestonePage.isEditMilestoneTitleVisible());
        ListenersClass.attachScreenshotWithMessage("In edit milestone");
        Assert.assertTrue(wfmMilestonePage.isUpdateButtonVisible());
        wfmService.updateMilStoneService(milestoneUpdationPojo);
        ListenersClass.attachScreenshotWithMessage("Filled the details");
        wfmMilestonePage.clickOnUpdateButton();
        Assert.assertTrue(wfmMilestonePage.isPopupMilestoneSuccessfullMessageVisible());
        wfmMilestonePage.clickOnDismissPopup();
        //Assert.assertFalse(wfmMilestonePage.isPopupMilestoneSuccessfullMessageVisible());
        Assert.assertTrue(wfmMilestonePage.isMilestoneNameListed(milestoneUpdationPojo.getMileStoneName()));
        Assert.assertTrue(wfmMilestonePage.isMilestoneDiscriptionListed(milestoneUpdationPojo.getMileStoneName()));
        Assert.assertTrue(wfmMilestonePage.isMilestoneCodeListed(milestoneUpdationPojo.getMileStoneName()));
        Assert.assertTrue(wfmMilestonePage.isMilestoneTypeListed(milestoneUpdationPojo.getMileStoneName()));

    }
}
