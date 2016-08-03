package TestScript;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Common.Constant;
import Common.ExcelUtils;
import Common.LoginLogout;
import Common.Register;;

public class TestRegister {
	static WebDriver driver = new FirefoxDriver();
	String baseURL = "http://live.guru99.com/index.php/customer/account/create/";
	@BeforeTest
	public void beforeTest() {
		//open browser
		driver.get(baseURL);

		//maximize browser
		driver.manage().window().maximize();
	}
	@Test
	public void DataDriven_Register() throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		String FirstName=ExcelUtils.getCellData(1, 1);
		String LastName=ExcelUtils.getCellData(1, 2);
		String Email=ExcelUtils.getCellData(1, 3);
		String Pass=ExcelUtils.getCellData(1, 4);
		String ConfirmPass = ExcelUtils.getCellData(1, 5);
		Register.RegisterWith(driver, FirstName, LastName, Email, Pass, ConfirmPass);

		//Verify Text
		String strExpectText = "Thank you for registering with Main Website Store.";
		String strActualText = driver.findElement(Register.ActualText).getText(); 
		Thread.sleep(2000);
		Assert.assertEquals(strExpectText, strActualText);
	}
	@AfterTest
	public void afterTest() {
		//Quit
		LoginLogout.Goto_Logout(driver);

	}
}
