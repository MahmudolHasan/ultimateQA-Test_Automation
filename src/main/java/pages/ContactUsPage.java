package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.webUtils;

import java.util.List;

public class ContactUsPage extends webUtils {

    By loc_fname = By.xpath ("//input[@id='et_pb_contact_first_0']");
    By loc_lname = By.xpath ("//input[@id='et_pb_contact_last_0']");
    By loc_emailAddress = By.xpath ("//input[@id='et_pb_contact_email_0']");
    By loc_message = By.xpath ("//textarea[@id='et_pb_contact_message_0']");
    By loc_submitBtn = By.xpath ("//button[@name='et_builder_submit_button']");
    By loc_messageSubmitMsg = By.xpath ("//div[@class=\"et-pb-contact-message\"]/p");
    By loc_errormessage = By.xpath ("//div[@class='et-pb-contact-message']/p");
    By loc_requiredFiled = By.xpath ("//div[@class='et-pb-contact-message']/ul/li");

    public void submitMessage (String firstName, String lastName, String email, String message) {
        inputEmail (email);
        inputFirstName (firstName);
        inputLastName (lastName);
        inputMessage (message);
        clickOn (loc_submitBtn);
    }
    public List<WebElement> getRequiredFieldNumberInCaseOfIncompleteSubmission(){
        return findAllElements (loc_requiredFiled);
    }

    public String getSubmitMessage(){
        return getEleText (loc_messageSubmitMsg);
    }
    public void inputEmail(String email_){
        typeEle (loc_emailAddress,email_);
    }

    public void inputFirstName(String name){
        typeEle (loc_fname,name);
    }

    public void inputLastName(String lname){
        typeEle (loc_lname,lname);
    }

    public void inputMessage(String message){
        typeEle (loc_message,message);
    }
}
