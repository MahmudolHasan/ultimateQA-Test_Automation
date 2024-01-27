package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.CoursesPage;
import pages.HomePage;
import utils.AllureListener;
import utils.RetryAnalyzer;

@Listeners(AllureListener.class)
public class Test_CoursesPage extends BaseTest {
	CoursesPage coursesPage;

	@BeforeMethod
	public void navigateToCoursePage() {
		coursesPage = new HomePage().navigateToCourses();
	}

	// 1 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void ValidateSearchFunctionalityWithValidKeyword() throws InterruptedException {
		coursesPage.searchWith("Java");
		Assert.assertTrue(coursesPage.isKeyWordShown());
	}

	// 2 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateSearchReturnTheRightProducts() throws InterruptedException {
		String actualKeyword = coursesPage.searchWith("Java");
		Assert.assertEquals(actualKeyword, "Java", "Keywords didn't matched");
	}

	// 3 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validatingSearchWithEmptyInput() throws InterruptedException {
		coursesPage.searchWith("");
		String expectedTitle = "https://courses.ultimateqa.com/collections?q=";
		String actualUrl = getPageUrl();
		Assert.assertEquals(actualUrl, expectedTitle, "Search Error!");
	}

	//  //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void searchWithInvalidKeyword() throws InterruptedException {
		coursesPage.searchWith("rdshdfg");
		Assert.assertTrue(coursesPage.invalidKeywordSearchErrorMsg());
	}

}
