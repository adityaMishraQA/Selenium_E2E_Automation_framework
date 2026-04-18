package com.asismisr.pages.cargoRunner;

import com.asismisr.enums.WaitStrategyEnums;
import com.asismisr.pages.BasePage;
import org.openqa.selenium.Keys;

public class WfmMilestonePage extends BasePage {
    private final String WFM_TILE="//div[text()='WORKFLOW MANAGEMENT']";
    private final String MILESTONE_TAB="//div[text()='Milestone']";
    private final String CREATE_NEW_MILESTONE_BUTTON="//button[text()='Create New Milestone']";
    private final String CREATE_MILESTONE_TITLE="//div[text()='Create New Milestone']";
    private final String CREATE_BUTTON="//button[text()='Create']";
    private final String FIELD_MILESTONE_NAME="//label[text()='Milestone Name']/../div/input";
    private final String FIELD_MILESTONE_CODE="//label[text()='Milestone Code']/../div/input";
    private final String FIELD_WORKFLOWTYPE_CODE="//label[text()='Workflow Type*']/../div/input";
    private final String FIELD_MILESTONE_DESCRIPTION="//label[text()='Milestone Description']/../div/textarea[@aria-invalid='false']";
    private final String FIELD_CHECKBOX_TICK="//div[text()='%s']/../../div/span/input";
    private final String CUSTOMER_FIELD_CHECKBOX="//div[text()='Show on Customer Portal']/../../div/span/input";
    private final String CUSTOMER_FIELD_CHECKBOX_SPAN="//div[text()='Show on Customer Portal']/../../div/span";
    private final String DYNAMIC_FIELD_CHECKBOX="//div[text()='Dynamic']/../../div/span/input";
    private final String DYNAMIC_FIELD_CHECKBOX_SPAN="//div[text()='Dynamic']/../../div/span";
    private final String ACTIONS_EDIT_BUTTON="//span[text()='%s']/../../../../td[6]/div/div/div/span";
    private final String TITLE_EDIT_MILESTONE="//div[text()='Edit Milestone']";
    private final String UPDATE_BUTTON="//button[text()='Update']";
    private final String POPUP_MILESTONE_UPDATE="//div[text()='Milestone updated successfully']";
    private final String POPUP_BUTTON_DISMISS="//div[text()='Milestone updated successfully']/../../div[2]/button";
    private final String CHECKBOX_CHEKCED_CUSTOMER_PORTAL="//div[text()='Show on Customer Portal']/../../div/span/input[@checked]";
    private final String CHECKBOX_CHEKCED_DYNAMIC="//div[text()='Dynamic']/../../div/span/input[@checked]";


    private final String LIST_NAME="//span[text()='%s']";
    private final String LIST_CODE="//span[text()='%s']/../../../../td[3]/div/div/span";
    private final String LIST_WORKTYPE="//span[text()='%s']/../../../../td[4]/div/div/span";
    private final String LIST_DISCRIPTION="//span[text()='%s']/../../../../td[2]/div/div/span";
    

    public String returnsTitleText()
    {
        return findElementWithWait(WFM_TILE, WaitStrategyEnums.VISIBLE, 10).getText();
    }

    public void clickOnMilestoneTab()
    {
        clickOnElement(MILESTONE_TAB);
    }

    public boolean isCreatenewmilestoneVisible()
    {
        return findElementWithWait(CREATE_NEW_MILESTONE_BUTTON, WaitStrategyEnums.VISIBLE,10).isDisplayed();
    }

    public void clickonMilestoneButton()
    {
        clickOnElement(CREATE_NEW_MILESTONE_BUTTON);
    }

    public boolean isCreatemilestoneTitleVisible()
    {
        return findElementWithWait(CREATE_MILESTONE_TITLE,WaitStrategyEnums.VISIBLE,10).isDisplayed();
    }

    public boolean isCreateButtonEnabled()
    {
        return findElementWithWait(CREATE_BUTTON,WaitStrategyEnums.VISIBLE,10).isEnabled();
    }

    public void fillingMilestoneName(String milestoneName)
    {
        findElementsXpath(FIELD_MILESTONE_NAME).sendKeys(milestoneName);
    }

    public void fillingMilestoneCode(String milestoneCode)
    {
        findElementsXpath(FIELD_MILESTONE_CODE).sendKeys(milestoneCode);
    }

    public void fillingMilestoneType(String workflowType)
    {
        findElementsXpath(FIELD_WORKFLOWTYPE_CODE).sendKeys(workflowType,Keys.ARROW_DOWN,Keys.ENTER);
    }

    public void fillingMilestoneDiscription(String discriptionText)
    {
        findElementsXpath(FIELD_MILESTONE_DESCRIPTION).sendKeys(discriptionText);
    }

    public void tickOnShowonCustomerCheckbox()
    {
        clickOnElement(CUSTOMER_FIELD_CHECKBOX);
    }

    public void tickOnDynamicCheckbox()
    {
        clickOnElement(DYNAMIC_FIELD_CHECKBOX);
    }
    

    public void clickOnCreateButton()
    {
        clickOnElement(CREATE_BUTTON);
    }

    public boolean isMilestoneNameListed(String milestoneName)
    {
        String newXpath=xPathEditor(LIST_NAME,milestoneName);
        return clickElementWithWait(newXpath,WaitStrategyEnums.VISIBLE,20).isDisplayed();
    }

    public void clickOnActionsEditButton(String listingPageName)
    {
        String newXpath=xPathEditor(ACTIONS_EDIT_BUTTON,listingPageName);
        findElementWithWait(newXpath,WaitStrategyEnums.VISIBLE,10).click();
    }

    public boolean isEditMilestoneTitleVisible()
    {
        return clickElementWithWait(TITLE_EDIT_MILESTONE,WaitStrategyEnums.VISIBLE,10).isDisplayed();
    }

    public void updatingMilestoneName(String newMilestoneName)
    {
        findElementsXpath(FIELD_MILESTONE_NAME).sendKeys(Keys.CONTROL,"a");
        findElementsXpath(FIELD_MILESTONE_NAME).sendKeys(Keys.DELETE);
        findElementsXpath(FIELD_MILESTONE_NAME).sendKeys(newMilestoneName);
    }

    public void updatingMilestoneCode(String newMilestoneCode)
    {
        findElementsXpath(FIELD_MILESTONE_CODE).sendKeys(Keys.CONTROL,"a");
        findElementsXpath(FIELD_MILESTONE_CODE).sendKeys(Keys.DELETE);
        findElementsXpath(FIELD_MILESTONE_CODE).sendKeys(newMilestoneCode);
    }

    public void updatingMilestoneDescription(String newMilestoneDescription)
    {
        findElementsXpath(FIELD_MILESTONE_DESCRIPTION).sendKeys(Keys.CONTROL,"a");
        findElementsXpath(FIELD_MILESTONE_DESCRIPTION).sendKeys(Keys.DELETE);
        findElementsXpath(FIELD_MILESTONE_DESCRIPTION).sendKeys(newMilestoneDescription);
    }

    public void updatingMilestoneWorkflowType(String newMilestoneWorkflowType)
    {
        findElementsXpath(FIELD_WORKFLOWTYPE_CODE).sendKeys(Keys.CONTROL,"a"); 
        findElementsXpath(FIELD_WORKFLOWTYPE_CODE).sendKeys(Keys.DELETE);      
        findElementsXpath(FIELD_WORKFLOWTYPE_CODE).sendKeys(newMilestoneWorkflowType,Keys.ARROW_DOWN,Keys.ENTER);
    }

    public boolean isShowonCustomerPortalTicked()
    {
        return findElementWithWait(CUSTOMER_FIELD_CHECKBOX_SPAN,WaitStrategyEnums.CLICKABLE,15).isSelected();
    }

    public boolean isShowonDynamicTicked()
    {
        return findElementWithWait(DYNAMIC_FIELD_CHECKBOX_SPAN,WaitStrategyEnums.CLICKABLE,15).isSelected();
    }

    public boolean isUpdateButtonVisible()
    {
        return findElementWithWait(UPDATE_BUTTON,WaitStrategyEnums.VISIBLE,10).isDisplayed();
    }

    public void clickOnUpdateButton()
    {
        findElementWithWait(UPDATE_BUTTON,WaitStrategyEnums.VISIBLE,15).click();
    }

    public boolean isPopupMilestoneSuccessfullMessageVisible()
    {
        return findElementWithWait(POPUP_MILESTONE_UPDATE,WaitStrategyEnums.VISIBLE,25).isDisplayed();
    }

    public void clickOnDismissPopup()
    {
        findElementWithWait(POPUP_BUTTON_DISMISS,WaitStrategyEnums.VISIBLE,10).click();
    }


    public boolean isMilestoneCodeListed(String milestoneCode)
    {
        String newXpath=xPathEditor(LIST_CODE,milestoneCode);
        return clickElementWithWait(newXpath,WaitStrategyEnums.VISIBLE,20).isDisplayed();
    }

    public boolean isMilestoneTypeListed(String milestoneType)
    {
        String newXpath=xPathEditor(LIST_WORKTYPE,milestoneType);
        return clickElementWithWait(newXpath,WaitStrategyEnums.VISIBLE,20).isDisplayed();
    }

    public boolean isMilestoneDiscriptionListed(String discription)
    {
        String newXpath=xPathEditor(LIST_DISCRIPTION,discription);
        return clickElementWithWait(newXpath,WaitStrategyEnums.VISIBLE,20).isDisplayed();
    }


    public boolean isCheckedAttributePresentinShowonCustomerCheckbox()
    {
        boolean result=false;
        if (findElementWithWait(CUSTOMER_FIELD_CHECKBOX,WaitStrategyEnums.VISIBLE,10).getDomAttribute("checked").equals("true"))
        {
            findElementsXpath(CUSTOMER_FIELD_CHECKBOX).click();
            result=true;
            return result;
        }
        return result;
    }

    public boolean isCheckedAttributePresentinDynamicCheckbox()
    {
        boolean result=false;
        if (findElementWithWait(DYNAMIC_FIELD_CHECKBOX,WaitStrategyEnums.VISIBLE,10).getDomAttribute("checked").equals("true"))
        {
            findElementsXpath(DYNAMIC_FIELD_CHECKBOX).click();
            return result=true;
        }
        return result;
    }








}
