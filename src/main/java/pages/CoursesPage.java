package pages;

import org.openqa.selenium.By;
import utils.webUtils;

public class CoursesPage extends webUtils {
	/*
	 * ======Locators======
	 */
	By loc_signIn = By.xpath("//a[normalize-space()='Sign In']");
	By loc_search = By.xpath("//input[@placeholder='Search']");
	By loc_searchResult = By.xpath("//h3[@class = 'products__title']/strong");
	By loc_noSearchResult = By.xpath("//p[@class='products__list-no-results']");
	By loc_secondPage = By
			.xpath("//ul[@class=\"pagination__pages\"]/li/a[@class=\"pagination__page-number\" and text()='2']");
	By loc_seleniumCourse = By
			.xpath("//h3[contains(@class, 'card__name') and contains(text(), 'Selenium WebDriver Basics for Java')]");

	public SignInPage navigateToSignInPage() {
		clickOn(loc_signIn);
		return new SignInPage();
	}

	public String searchWith(String keyWord) throws InterruptedException {
		try {
			typeEle(loc_search, keyWord);
			threadSleep(3);
			findEle(loc_search).submit();
			threadSleep(1);
			return getEleText(loc_searchResult);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isKeyWordShown() {
		return doesElementExist(loc_searchResult);
	}

	public boolean invalidKeywordSearchErrorMsg() {
		return doesElementExist(loc_noSearchResult);
	}

	public Course_Sele_WebDriver navigateToSeleniumWebDriverCoursePage() throws InterruptedException {
		try {
			scrollToBottom();
			threadSleep(1);
			clickOn(loc_secondPage);
		} catch (Exception e) {
			searchWith("Selenium WebDriver");
		}
		clickOn(loc_seleniumCourse);
		return new Course_Sele_WebDriver();

	}

}
