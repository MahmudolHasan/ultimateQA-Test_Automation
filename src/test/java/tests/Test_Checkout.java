package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CheckOut;
import pages.HomePage;
import utils.AllureListener;
import utils.RetryAnalyzer;

import java.util.List;

@Listeners(AllureListener.class)
public class Test_Checkout extends BaseTest {
	CheckOut checkOut;

	@BeforeMethod
	public void navigateToCheckoutPage() throws InterruptedException {
		checkOut = new HomePage().navigateToCourses().navigateToSeleniumWebDriverCoursePage().clickOnBuyNow();
	}

	// 1 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateProductIncreaseButtonFunctionality() throws InterruptedException {
		List<String> values = checkOut.increaseProductNumberByOne();
		int difference = Integer.parseInt(values.get(1)) - Integer.parseInt(values.get(0));
		Assert.assertEquals(difference, 1, "Didn't increased the product number by one!");
	}

	// 2 //Passed
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void functionalityOfDecreaseButton() throws InterruptedException {
		checkOut.increaseProductNumberByOne();
		List<String> values = checkOut.decreaseProductNumberByOne();
		if (values != null) {
			int difference = Integer.parseInt(values.get(0)) - Integer.parseInt(values.get(1));
			Assert.assertEquals(difference, 1, "Didn't increased the product number by one!");
		}
		else
			Assert.fail("Element is not clicked! Error in CheckoutPage!");

	}

	//3 //Checked
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void functionalityOfDecreaseButtonWhenProductNumberIsOne() throws InterruptedException {	
		Assert.assertNull(checkOut.decreaseProductNumberByOne(),"Decrese button is clickable when product in cart is 1");
	}

}
