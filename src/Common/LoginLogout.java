package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLogout {
	WebDriver driver;
	//Base URL	
	public static final String BaseURL = "http://live.guru99.com";

	//Login
	public static By linkAccount = By.xpath(".//a/span[contains(text(),'Account')]");
	public static By linkLogin = By.xpath("//a[contains(text(),'Log In')]"); 

	//Logout
	public static By linkLogout = By.xpath(".//a[contains(text(),'Log Out')]");
	
	//Actual Text
	public static By ActualText = By.xpath(".//h1[contains(text(),'My Dashboard')]");

	public static By txtEmail = By.id("email");
	public static By txtPass = By.id("pass");
	public static By btnSubmit = By.id("send2");
	
	//Go to Logout

		public static void Goto_Logout(WebDriver driver) { 
			driver.findElement(linkAccount).click();
			driver.findElement(linkLogout).click();
		}

				
		public static void LoginWith (WebDriver driver,String Email, String Password) throws InterruptedException{
			driver.findElement(txtEmail).sendKeys(Email);
			driver.findElement(txtPass).sendKeys(Password);
			driver.findElement(btnSubmit).click();
		}
}
