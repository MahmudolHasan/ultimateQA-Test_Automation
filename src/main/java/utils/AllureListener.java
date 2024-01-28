package utils;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

	@Override
	public  void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Reached Override Method");
			saveFailedScreenshot(result);
		}
	}

	@Attachment
	public static void saveFailedScreenshot(ITestResult result) {
		System.out.println("Reached  saveFailedss");
		TakeScreenShot.takeFailedScreenShot(result);
	}
}
