package Assignment;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Assignment6_Mouseactions {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d = setChromeDrivePath();
		d.get("https://www.burbank.com.au/victoria");
		
		Actions actions = new Actions(d);
		
		WebElement mouseHover = d.findElement(By.xpath("//a[@id='p_lt_ctl01_Submenunav_lblaboutburbank']/span"));
		actions.moveToElement(mouseHover).perform();
		System.out.println("hovered successfully");
		
		d.get("https://www.google.co.in/?gfe_rd=cr&ei=eG6DV8XeILHj8AfNsoyYDQ&gws_rd=ssl");
		WebElement searchBox = d.findElement(By.id("lst-ib"));
		Actions moreActions = actions.moveToElement(searchBox).click().keyDown(searchBox,Keys.SHIFT).sendKeys(searchBox,"hello");
		
		org.openqa.selenium.interactions.Action caps = moreActions.build();
		caps.perform();
		
		System.out.println("Helo printed in Caps successfully");
		
		d.close();
		
	
	}
	public static ChromeDriver setChromeDrivePath() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return new ChromeDriver(cap);
		}
}

