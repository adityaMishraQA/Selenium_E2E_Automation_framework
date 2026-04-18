package com.asismisr.pages.sauceDemoManual;

import com.asismisr.enums.WaitStrategyEnums;
import com.asismisr.pages.BasePage;

public final class LoginPage extends BasePage {
    private final String LOGIN_USERNAME="//input[@id='user-name']";
    private final String LOGIN_PASSWORD="//input[@id='password']";
    private final String LOGIN_BUTTON="//input[@id='login-button']";
    private final String LOGIN_ERROR_MESSAGE="//h3[@data-test='error']";

    public void goToSauceDemourl(String url)
    {
        goToUrl(url);
    }

    public void enterLoginUsername(String username)
    {
        clickOnElementToSendText(LOGIN_USERNAME).sendKeys(username);
    }

    public void enterLoginPassword(String password)
    {
        clickOnElementToSendText(LOGIN_PASSWORD).sendKeys(password);
    }

    public void clickOnLoginButton()
    {
        clickOnElement(LOGIN_BUTTON);
    }

    public String getLoginErrorMessage()
    {
        return findElementWithWait(LOGIN_ERROR_MESSAGE, WaitStrategyEnums.VISIBLE,10).getText();
    }

    public String getUrlAfterLogin()
    {
        return getCurrentPageUrl();
    }




}
