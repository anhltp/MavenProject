package TestScript;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.Constant;
import Common.ExcelUtils;
import Common.LoginLogout;

public class TestLoginLogout {
	static WebDriver driver = new FirefoxDriver();
	String baseURL = "http://live.guru99.com/index.php/customer/account/login/";
	@BeforeTest
	public void beforeTest() {
		//open browser
		driver.get(baseURL);

		//maximize browser
		driver.manage().window().maximize();
	}
	@Test
	public void DataDriven_Login() throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Login");
		String Email=ExcelUtils.getCellData(1, 1);
		String Pass=ExcelUtils.getCellData(1, 2);
		LoginLogout.LoginWith(driver, Email, Pass);
		//Verify Text
		String strExpectText = "MY DASHBOARD";
		String strActualText = driver.findElement(LoginLogout.ActualText).getText(); 
		Thread.sleep(2000);
		Assert.assertEquals(strExpectText, strActualText);
	}
	@AfterTest
	public void afterTest() {
		//Quit
		LoginLogout.Goto_Logout(driver);

	}
}
