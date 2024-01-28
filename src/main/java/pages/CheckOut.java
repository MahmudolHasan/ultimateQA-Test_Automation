package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import utils.webUtils;

import java.util.ArrayList;
import java.util.List;

public class CheckOut extends webUtils {
	By loc_increaseProductAmount = By.xpath("//button[@aria-label='Increment']//*[name()='svg']");
	By loc_decreaseProductAmount = By.xpath("//button[@aria-label='Decrement']");
	By loc_productUnitPrice = By.xpath("//span[@class='product-price__value']");
	By loc_totalPrice = By.xpath("//div[@class='total-price']");
	By loc_unitFiled = By.xpath("//input[@id='quantity']");

	public List<String> increaseProductNumberByOne() throws InterruptedException {
		threadSleep(1);
		List<String> value = new ArrayList<>();
		value.add(getAttributeValue(loc_unitFiled, "value"));
		clickOn(loc_increaseProductAmount);
		threadSleep(1);
		value.add(getUnitNumber());
		return value;
	}

	public List<String> decreaseProductNumberByOne() throws InterruptedException {
		List<String> value = new ArrayList<>();
		try {
			value.add(getUnitNumber());
			clickOn(loc_decreaseProductAmount);
			threadSleep(2);
			value.add(getUnitNumber());
		} catch (ElementClickInterceptedException e) {
			return null;
		}
		return value;
	}

	public void inputNumberInNumberField(String number) {
		typeEle(loc_unitFiled, number);
	}

	public boolean getDecrementBtnStatus() {
		return doesElementExist(loc_decreaseProductAmount);
	}

	public String getUnitNumber() {
		return getAttributeValue(loc_unitFiled, "value");
	}

	public String getTotalPrice() {
		return getEleText(loc_totalPrice);
	}

}
