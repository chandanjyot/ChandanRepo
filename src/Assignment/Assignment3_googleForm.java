package Assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;

public class Assignment3_googleForm {
	
	public static void main(String[] args) throws InterruptedException{

		WebDriver d = setChromeDrivePath();

	d.get("https://docs.google.com/forms/d/1uZohjwz4oYQnyc8qKRhRvURgMAi3nCIaI0GSMVAKSRM/viewform?c=0&w=1&usp=mail_form_link");

	d.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
	WebElement titleVerify = d.findElement(By.xpath(".//div[@class='freebirdFormviewerViewHeaderTitleRow']"));
	Assert.assertEquals("Accessing forms - Selenium", titleVerify.getText());

	WebElement name = d.findElement(By.xpath("//div[@class='quantumWizTextinputPapertextareaContentArea exportContentArea']//textarea"));
	Assert.assertTrue(name.isDisplayed());
	name.sendKeys("Chandan Jyot");

	WebElement paragraph = d.findElement(By.xpath("//input[@aria-label='Paragraph Type']"));
	Assert.assertTrue(paragraph.isDisplayed());
	paragraph.sendKeys("optional");

	WebElement radioButton = d.findElement(By.xpath("//div[@role='radiogroup']/content/label/div//span[text()='Radio 5']"));
	radioButton.click();

	WebElement checkbox = d.findElement(By.xpath("//div[@role='group']/div[4]/label"));
	Assert.assertTrue(checkbox.isDisplayed());
	checkbox.click();

	WebElement row1Radio_button = d.findElement(By.xpath("//div[@class='freebirdFormviewerViewItemsGridScrollingData']/div[2]//label[3]/div"));
	Assert.assertTrue(row1Radio_button.isDisplayed());
	row1Radio_button.click();

	WebElement row2Radio_button = d.findElement(By.xpath("//div[@class='freebirdFormviewerViewItemsGridScrollingData']/div[3]//label[2]"));
	Assert.assertTrue(row2Radio_button.isDisplayed());
	row2Radio_button.click();

	WebElement row3Radio_button = d.findElement(By.xpath("//div[@class='freebirdFormviewerViewItemsGridScrollingData']/div[4]//label[2]"));
	Assert.assertTrue(row3Radio_button.isDisplayed());
	row3Radio_button.click();

	WebElement mainMenuBTN = d.findElement(By.xpath("//div[@class='quantumWizTextinputPapertextareaUnderline exportUnderline']"));
	Actions builder = new Actions(d);
	builder.moveToElement(mainMenuBTN).click().perform();
	//builder.click();

	//subMenuBTN.click();

		}
	
	public static ChromeDriver setChromeDrivePath() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return new ChromeDriver(cap);
	}

}