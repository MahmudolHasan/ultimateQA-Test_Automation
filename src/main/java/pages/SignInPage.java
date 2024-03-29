package pages;

import org.openqa.selenium.By;
import utils.webUtils;

public class SignInPage extends webUtils {

	By loc_email = By.id("user[email]");
	By loc_password = By.id("user[password]");
	By loc_btnLogin = By.xpath("//button[@type='submit']");

	By loc_FailedSignInErrorMessage = By.xpath("//li[@class='form-error__list-item']");

	By captcha = By.xpath("//*[@src='about:blank']");

	public String doLogin(String email, String password) throws InterruptedException {

		typeEle(loc_email, email);

		typeEle(loc_password, password);

		clickOn(loc_btnLogin);
		threadSleep(1);
		return getPageTitle();
	}

	public String failedSignInMessageVisibility() {

		return getEleText(loc_FailedSignInErrorMessage);
	}

	public String getPageTitle() {
		return getTitle();
	}

	public boolean captchaVisibility() {
		return doesElementExist(captcha);
	}
}
