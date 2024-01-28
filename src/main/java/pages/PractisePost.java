package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import utils.webUtils;

import java.util.Locale;

public class PractisePost extends webUtils {

	By loc_postTitle = By.xpath("//h1[@class = 'entry-title']");
	By loc_authorName = By.xpath("//span[@class='author vcard']//a");
	By loc_date = By.xpath("//span[@class='published']");
	By loc_commentNumber = By.xpath("//span[@class='comments-number']/a");
	By loc_commentBox = By.xpath("//textarea[@id='comment']");
	By loc_commentName = By.xpath("//input[@id='author' and @type='text']");
	By loc_commentEmail = By.xpath("//input[@id='email']");
	By loc_btnSubmitComment = By.xpath("//input[@id='submit']");

	By loc_submitEmptyCommentPage = By.xpath("//div[@class='wp-die-message']");
	static Faker faker = new Faker(new Locale("en-US"));

	public String getPostTitle() throws InterruptedException {
		threadSleep(1);
		return getEleText(loc_postTitle);
	}

	public String getPostAuthor() {
		return getEleText(loc_authorName);
	}

	public String getPostDate() {
		return getEleText(loc_date);
	}

	public String getTotalCommentNumber() {
		return getEleText(loc_commentNumber);
	}

	public void submitComment(String comment, String name, String email) throws InterruptedException {
		typeEle(loc_commentEmail, email);
		Thread.sleep(1300);
		typeEle(loc_commentEmail, email);
		Thread.sleep(500);
		typeEle(loc_commentName, name);
		threadSleep(1);
		typeEle(loc_commentBox, comment);
		threadSleep(2);
		clickOn(loc_btnSubmitComment);
		threadSleep(2);

	}

	public boolean IsCommentSubmitted(String name) {
		String xpath = "//span[@class='fn' and text()='" + name + "']";
		return findEle(By.xpath(xpath)).isDisplayed();
	}

	public boolean isDriverMovedToCommentErrorPage() {
		return isElementVisible(loc_submitEmptyCommentPage);
	}

}
