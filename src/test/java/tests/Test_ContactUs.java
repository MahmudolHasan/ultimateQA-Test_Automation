package tests;

import dataGenerator.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.AllureListener;
import utils.RetryAnalyzer;

@Listeners(AllureListener.class)
public class Test_ContactUs extends BaseTest{
    DataGenerator data = new DataGenerator ();
    ContactUsPage contact;
    @BeforeMethod
    public void navigateToContactUsPage(){
        contact = new HomePage ().navigateToContactUs();
    }
    //1 //Passed
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void ValidatingSubmitMessage(){
        String fname = data.firstNameGenerate ();
        String lname = data.lastNameGenerate ();
        String email = data.emailGenerate ();
        String message ="thanks for such a informative website about QA!";
        contact.submitMessage (fname,lname,email,message);
        Assert.assertEquals (contact.getSubmitMessage (),"Thanks for contacting us","message is not submitted!");
    }
    //2 //Passed
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void CheckingMessageSubmissionWithoutFullInput(){
        String fname = data.firstNameGenerate ();
        String lname = "";
        String email = data.emailGenerate ();
        String message ="thanks for such a informative website!";
        contact.submitMessage (fname,lname,email,message);
        Assert.assertEquals (contact.getSubmitMessage (),"Please, fill in the following fields:","message is not submitted!");

    }
    //3 //Passed
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validatingTheNumberOfInputRequiredShowedInErrorMessage(){
        String fname = data.firstNameGenerate ();
        String lname = "";
        String email = data.emailGenerate ();
        String message ="";
        contact.submitMessage (fname,lname,email,message);
        int number = contact.getRequiredFieldNumberInCaseOfIncompleteSubmission ().size ();
        Assert.assertEquals (number,2,"Required field number doesn't match!");
    }
}
