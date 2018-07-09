package gmailtest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	WebElement waiting;
	
	public GmailPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
		wait = new WebDriverWait(driver,50);
	}
	
	public void enterEmailToOpenWelcomePage() {
		js.executeScript("document.querySelector('#identifierId').value = 'sun14star14moon';");
		js.executeScript("document.querySelector('#identifierNext > content').click();");
		waiting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		String welcome = js.executeScript("return document.querySelector('#headingText').textContent;").toString();
		assertEquals(welcome, "Welcome");
	}
	
	public void enteringPasswordOpensGmailInbox() {
		js.executeScript("document.querySelector('#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input').value = 'sunstar56';");
		js.executeScript("document.querySelector('#passwordNext > content').click();");
		waiting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("J-Ke n0")));
		String inbox = js.executeScript("return document.getElementsByClassName('J-Ke n0')[0].innerHTML").toString();
		assertTrue(inbox.contains("Inbox"));
	}
	
	public void signOutOfGmail() {
		js.executeScript("document.querySelector('#gb > div.gb_Qf.gb_Pg > div.gb_nb.gb_Pg.gb_R.gb_Og.gb_T > div.gb_Hc.gb_Pg.gb_R > div.gb_jb.gb_bd.gb_Pg.gb_R > div.gb_Sc.gb_mb.gb_Pg.gb_R > a > span').click();");
		js.executeScript("document.querySelector('#gb_71').click();");
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		*/
	}
}
