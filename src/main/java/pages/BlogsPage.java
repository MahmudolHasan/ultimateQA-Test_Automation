package pages;

import org.openqa.selenium.By;

import utils.webUtils;

public class BlogsPage extends webUtils {

    By loc_postOnBestPractise  = By.xpath ("//a[contains(text(),'Top 17 Automated Testing Best Practices (Supported')]");
    By loc_postOnPOMPageFactory = By.xpath ("//img[@alt='Understanding PageFactory vs. Page Object Model in Selenium']");

    public PractisePost navigateToPractisePost(){
        clickOn (loc_postOnBestPractise);
        return new PractisePost ();
    }

    public POMPost navigateToPOMPost(){
        clickOn (loc_postOnPOMPageFactory);
        POMPost pom = new POMPost ();
        return pom;
    }
}
