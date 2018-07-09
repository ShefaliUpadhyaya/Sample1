package gmailtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailAutomate {
	WebDriver driver;
	JavascriptExecutor js;
	GmailPage gmailPage;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shefaliupadhyaya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
        js = (JavascriptExecutor)driver;	
    	driver.manage().window().maximize() ;
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gmailPage = new GmailPage(driver, js);
	}
	
	@Test(priority = 1)
	public void using_Email_To_Enter_Password_Should_Open_Welcome_Page() {
		gmailPage.enterEmailToOpenWelcomePage();
	}
	
	@Test(priority = 2)
	public void enter_Password_Should_Open_Gmail_Inbox() {
		gmailPage.enteringPasswordOpensGmailInbox();
	}
	
	@Test(priority = 3)
	public void sign_Out_Should_Log_Out_Of_Gmail() {
		gmailPage.signOutOfGmail();
	}
	
	@AfterClass
	public void closeBrowser() {
		//driver.quit();
	}
}
