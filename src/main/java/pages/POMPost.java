package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import utils.webUtils;

import java.util.Locale;

public class POMPost extends webUtils {

    static Faker faker = new Faker(new Locale ("en-US"));

    By loc_commentBox = By.xpath ("//textarea[@id='comment']");
    By loc_commentName = By.xpath ("//input[@id='author']");
    By loc_commentEmail = By.xpath ("//input[@id='email']");
    By loc_btnSubmitComment = By.xpath ("//input[@id='submit']");

    public void submitComment (String comment, String name, String email) throws InterruptedException {
        typeEle (loc_commentBox, comment);
        typeEle (loc_commentName, name);
        typeEle (loc_commentEmail, email);
        threadSleep (3);
        clickOn (loc_btnSubmitComment);
        threadSleep (3);
    }
    public boolean IsCommentSubmitted(String name){
        String xpath = "//span[@class='fn' and text()='"+name+"']";
        return findEle (By.xpath (xpath)).isDisplayed ();
    }

    public String getModeratorMessage(String name){
        String ModeratorXpath = "//span[@class='fn' and text()='"+name+"']/../following-sibling::div[@class='comment_area']//em[@class='moderation']";
        return getEleText (By.xpath (ModeratorXpath));
    }

}
