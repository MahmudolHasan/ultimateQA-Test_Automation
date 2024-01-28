package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SignInPage;
import utils.AllureListener;
import utils.RetryAnalyzer;

@Listeners(AllureListener.class)
public class Test_SignIn extends BaseTest {    //// 4

    SignInPage signInPage;
    SoftAssert softAssert;
    String expectedErrorMessage = "         Invalid email or password.       ";

    @BeforeMethod
    public void navigateToSignInPage () {
        signInPage = new HomePage ().navigateToCourses ().navigateToSignInPage ();
    }

    //Paased
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 0,retryAnalyzer = RetryAnalyzer.class,alwaysRun = true)
    public void validateCaptchAvilability () throws InterruptedException {
        signInPage.doLogin ("benexe3701@konican.com", "Test0135");
        Assert.assertTrue (signInPage.captchaVisibility (), "Captcha is not visible!");
    }
    //Skipped
    @Severity(SeverityLevel.BLOCKER)
    //@Test (priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void ValidateSignInWithValidCredentials () throws InterruptedException {
        String actualPageTitle = signInPage.doLogin ("benexe3701@konican.com", "Test0135");
        String expectedPageTitle = "All Products - Ultimate QA";
        if (!signInPage.captchaVisibility ()) {
            Assert.assertEquals (actualPageTitle, expectedPageTitle, "SignIn page title didn't match!");
        } else {
            throw new SkipException ("Couldn't execute login function because of captcha!");
        }
    }
    //Skipped
    //@Test(priority = 2 ,retryAnalyzer = RetryAnalyzer.class)
    public void ValidateSignInWithWrongCredentials () throws InterruptedException {
        signInPage.doLogin ("benexe3701@konican.com", "Test013585");
        if (!(signInPage.captchaVisibility ())) {
            Assert.assertEquals (signInPage.failedSignInMessageVisibility (),expectedErrorMessage);
        } else {
            throw new SkipException ("Couldn't execute login function because of captcha!");
        }
    }
    //Skipped
    //@Test(priority = 3 ,retryAnalyzer = RetryAnalyzer.class)
    public void validateLoginFunctionalityWithoutAnyInput() throws InterruptedException {
        String actualErrorMessage = signInPage.doLogin ("", "");
        if (!(signInPage.captchaVisibility ())) {
            Assert.assertEquals (actualErrorMessage, expectedErrorMessage, "SignIn Error Message didn't match!");
        }else {
            throw new SkipException ("Couldn't execute login function because of captcha!");
        }
    }
    
}
