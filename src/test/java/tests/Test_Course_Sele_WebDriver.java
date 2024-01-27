package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Course_Sele_WebDriver;
import pages.HomePage;
import org.testng.asserts.SoftAssert;
import utils.AllureListener;
import utils.RetryAnalyzer;

import java.util.HashMap;

@Listeners(AllureListener.class)
public class Test_Course_Sele_WebDriver extends BaseTest {
    SoftAssert softAssert;
    Course_Sele_WebDriver sele;
    @BeforeMethod
    public void navigateToCoursePage() throws InterruptedException {
        sele =  new HomePage().navigateToCourses().navigateToSeleniumWebDriverCoursePage();
    }
    
    //1 //Passed 
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validateCourseInfo(){
        softAssert = new SoftAssert ();
        HashMap<String,String> details = sele.getTotalCourseInfo ();
        softAssert.assertEquals (details.get ("price"),"$9.99","Price is not same!");
        softAssert.assertEquals  (details.get ("duration"),"1 hour of video content","Course duration didn't match");
        softAssert.assertEquals  (details.get ("lessons"),"22 lessons");
        softAssert.assertAll ();

    }
    //2 //Passed
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validationOfCourseSyllabus(){
        int actualChapter = sele.getCurriculumChapterNumber ();
        Assert.assertEquals(actualChapter,4);
    }
}
