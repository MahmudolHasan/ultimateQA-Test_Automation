package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dataGenerator.DataGenerator;
import io.qameta.allure.Description;
import pages.HomePage;
import pages.PractisePost;
import utils.AllureListener;
import utils.RetryAnalyzer;

@Listeners(AllureListener.class)
public class Test_PractisePost extends BaseTest {

	String blogTitle = "Top 17 Automated Testing Best Practices (Supported By Data)";
	String author = "Nikolay Advolodkin";
	String publishDate = "Jun 6, 2023";
	String comment = "Very Informative post.Learned many new things!";
	DataGenerator data;

	PractisePost practisePost;

	@BeforeMethod
	public void navigatedToPractisePost() {
		practisePost = new HomePage().navigateToBlogs().navigateToPractisePost();
	}
	
	// 1 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("This test checks if the page title is right")
	public void validationOfPostPage() throws InterruptedException {
		String pageTitle = getPageTitle();
		Assert.assertEquals(pageTitle, blogTitle, "Not landed in desired post page!");
	}
	
	// 2 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("This test validate if the blog post title is as described in course page!")
	public void validationOfBlogTitle() throws InterruptedException {
		String actualBlogTitle = practisePost.getPostTitle();
		Assert.assertEquals(actualBlogTitle, blogTitle, "Title didn't match!");
	}
	
	// 3 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("This test varify the publish date of the post")
	public void validationOfBlogPublishDate() {
		String actualDate = practisePost.getPostDate();
		Assert.assertEquals(actualDate, publishDate, "Date didn't match!");
	}
	
	//4 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("This test varify the author name of the post")
	public void validationOfPostAuthor() {
		String actualAuthor = practisePost.getPostAuthor();
		Assert.assertEquals(actualAuthor, author, "Author name didn't match!");
	}
	
	//5 //??
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("This test create a comment on 'Top 17 Automated Testing Best Practices' post and varify that the comment is visible!")
	public void validationOfCommentSubmission() throws InterruptedException {
		data = new DataGenerator();
		String name = data.fullNameGenerate();
		practisePost.submitComment(comment, name, data.emailGenerate());
		Assert.assertTrue(practisePost.IsCommentSubmitted(name));
	}
	//6 //Paased
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("This test valifate the comment number of this post!")
	public void validateCommentNumber() {
		String actualNumber = practisePost.getTotalCommentNumber();
		String expectedNumber = "25 comments";
		Assert.assertEquals(actualNumber, expectedNumber, "Comment number didn't match the expectation!");
	}
	
	//7 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("This test is to verfy that the website takes user to new page in case of trying to post a duplicate comment!")
	public void validationOfDuplicateCommentCatcher() throws InterruptedException {
		data = new DataGenerator();
		String pageTitle = getPageTitle();
		String email = data.emailGenerate();
		String name = data.fullNameGenerate();
		practisePost.submitComment(comment, name, email);
		practisePost.submitComment(comment, name, email);
		String newPageTitle = getPageTitle();
		Assert.assertNotEquals(newPageTitle, pageTitle);
	}
	
	//8 //Pass
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("This test is to verfy that the website takes user to new message in case of submitting comment without any input!")
	public void checkingCommentSubmissionWithoutAnyInput() throws InterruptedException {
		practisePost.submitComment("", "", "");
		Assert.assertTrue(practisePost.isDriverMovedToCommentErrorPage());
	}

}
