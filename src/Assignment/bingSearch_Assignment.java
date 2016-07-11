package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class bingSearch_Assignment {
	
	public static void main(String[] args){
		
		WebDriver d = setChromeDrivePath();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.get("https://www.bing.com/");		
		d.manage().window().maximize();
		
		if(d.findElement(By.xpath(".//div[@class='hp_sw_logo hpcLogoWhite']")).isDisplayed())
			System.out.println("Bing logo is displayed");
		
		WebElement searchBox = d.findElement(By.className("b_searchbox"));
		searchBox.sendKeys("automation testing");
		
		WebElement searchButton = d.findElement(By.id("sb_form_go"));
		searchButton.click();
		
		List<WebElement> searchResult =  d.findElements(By.className("b_algo"));
		int lsize = searchResult.size();
		for(int i=0; i<lsize;i++)
			//System.out.println(searchResult.get(i).getText());
		if(searchResult.get(i).getText().contains("Auto"))
			System.out.println("Automation results are displayed");
		
		
		//calculate number of results 
		
		int results = d.findElements(By.className("b_algo")).size();
		System.out.println(results + " results are appearing");		
		
	}
	
	public static ChromeDriver setChromeDrivePath() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return new ChromeDriver(cap);
	}
}
