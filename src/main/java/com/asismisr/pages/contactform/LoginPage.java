package com.asismisr.pages.contactform;

import com.asismisr.enums.WaitStrategyEnums;
import com.asismisr.pages.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class LoginPage extends BasePage {
    private final String USERNAME_INPUT="//input[@id='username']";
    private final String PASSWORD_INPUT="//input[@id='password']";
    private final String LOGIN_BUTTON="//button[text()='Login']";
    private final String LOGIN_ERROR="//div[text()='Invalid username or password']";
    private final String CONTACTFORM_TITLE="//span[text()='Contact Form']";
    private final String LOGOUT_BUTTON="//button[text()='Logout']";

    public void navigateToUrl(String url)
    {
        goToUrl(url);
    }

    public void enterUsername(String username)
    {
        sendElement(USERNAME_INPUT,username);
    }

    public void enterPassword(String password)
    {
        sendElement(PASSWORD_INPUT,password);
    }

    public boolean isLoginErrorShown()
    {
        return findElementWithWait(LOGIN_ERROR,WaitStrategyEnums.VISIBLE,10).isDisplayed();
    }

    public void clickOnLoginButton()
    {
        clickOnElement(LOGIN_BUTTON);
    }

    public boolean isContactformTitleVisible()
    {
        return findElementWithWait(CONTACTFORM_TITLE, WaitStrategyEnums.VISIBLE,5).isDisplayed();
    }

    public int findLogoutButton()
    {
        return returnWebElementsFromBy(LOGOUT_BUTTON).size();
    }









}
