package tests;

import dataGenerator.DataGenerator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.POMPost;
import utils.AllureListener;
import utils.RetryAnalyzer;

@Listeners(AllureListener.class)
public class Test_POMPage extends BaseTest {

	POMPost pom;
	DataGenerator data;
	SoftAssert softAssert;

	@BeforeMethod
	public void goToBlogPostAboutPOM() {
		pom = new HomePage().navigateToBlogs().navigateToPOMPost();
	}
	
	
	@Test (alwaysRun = true,retryAnalyzer = RetryAnalyzer.class)
	public void validationOfCommentSubmission() throws InterruptedException {
		softAssert = new SoftAssert();
		data = new DataGenerator();
		String expectedModeratorMessage = "Your comment is awaiting moderation.";
		String name = data.fullNameGenerate();
		String comment = " PageFactory does not store the result when the driver locates the element, "
				+ "causing it to relocate the element for each operation, "
				+ "leading to inefficiency and performance issues";
		pom.submitComment(comment, name, data.emailGenerate());
		String actualModeratorMessage = pom.getModeratorMessage(name);
		softAssert.assertTrue(pom.IsCommentSubmitted(name));
		softAssert.assertEquals(actualModeratorMessage, expectedModeratorMessage, "Moderator message is not same!");
	}

}
