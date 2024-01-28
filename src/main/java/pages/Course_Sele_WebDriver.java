package pages;

import org.openqa.selenium.By;
import utils.webUtils;

import java.util.HashMap;

public class Course_Sele_WebDriver extends webUtils {

    By loc_buyNow = By.xpath ("//a[@class='button button-primary button-purchase']");
    By loc_coursePrice = By.xpath ("//span[normalize-space()='$9.99']");
    By loc_courseLessons = By.xpath ("//span[normalize-space()='22 lessons']");
    By loc_courseDuration =By.xpath ("//span[normalize-space()='1 hour of video content']");
    By loc_syllabus = By.xpath ("//ol[@class='course-curriculum__chapter-list section__body']/li");

    public CheckOut clickOnBuyNow(){
        clickOn (loc_buyNow);
        return new CheckOut();
    }
    public HashMap<String,String> getTotalCourseInfo(){
        HashMap<String, String> about = new HashMap<String, String>();
        about.put ("price",getEleText (loc_coursePrice));
        about.put ("lessons",getEleText (loc_courseLessons));
        about.put ("duration",getEleText (loc_courseDuration));
        return about;
    }
     public int  getCurriculumChapterNumber(){
        return findAllElements (loc_syllabus).size ();
     }
}
