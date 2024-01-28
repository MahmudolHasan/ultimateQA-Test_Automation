package pages;

import org.openqa.selenium.By;
import utils.webUtils;


public class HomePage extends webUtils {

    /*
                                     ======Locators======
     */
    By loc_javaSDETAcademy = By.xpath ("//ul[@id='menu-main-menu']//a[normalize-space()='Java SDET Academy']");
    By loc_learningDropDown = By.xpath ("//ul[@id='menu-main-menu']//li[@id='menu-item-218225']//a[@href='#'][normalize-space()='Learning']");
    By loc_successStories = By.xpath ("//ul[@id='menu-main-menu']//a[normalize-space()='Success Stories']");
    By loc_blog = By.xpath ("//ul[@id='menu-main-menu']//a[normalize-space()='Blog']");
    By loc_about = By.xpath ("//ul[@id='menu-main-menu']//a[normalize-space()='About']");
    By loc_contactUS = By.xpath ("//ul[@id='menu-footer-main-menu']//a[normalize-space()='Contact Us']");
    By loc_automationPractise = By.xpath ("//ul[@id='menu-footer-secondary-menu']//a[normalize-space()='Automation Exercises']");
    By loc_freeCourses = By.xpath ("//ul[@id='menu-footer-secondary-menu']//a[normalize-space()='Free Courses']");

    public CoursesPage navigateToCourses(){
        clickOn (loc_freeCourses);
        return new CoursesPage ();
    }

    public BlogsPage navigateToBlogs(){
        clickOn (loc_blog);
        return new BlogsPage ();
    }

    public ContactUsPage navigateToContactUs(){
        clickOn (loc_contactUS);
        return new ContactUsPage ();
    }










}
