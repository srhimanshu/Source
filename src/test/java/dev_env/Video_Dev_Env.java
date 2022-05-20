package dev_env;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class Video_Dev_Env {
	public String username = "himanshu.khandelwalsoftraw";
	public String accesskey = "YhD7IEMizNLxbPLA0WI9qJ2MdH6KOURWeSVYb5RSs7nFHA1bsg";
	public static RemoteWebDriver driver;
	public static WebDriver driver1;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	static WebDriverWait wait;

	@BeforeClass
	@Parameters(value = { "browser", "version", "platform" })
	public void setUp(String browser, String version, String platform ) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version", version);
		capabilities.setCapability("platform", platform);
		capabilities.setCapability("build", "Video");
		capabilities.setCapability("name", "STG_Distribution");
		capabilities.setCapability("network", true);
		capabilities.setCapability("visual", true);
		capabilities.setCapability("video", true);
		capabilities.setCapability("console", true);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	}

	@Test
	public void screen() throws Exception {
		driver.get("https://experience-dev.sourcesync.io/516");

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Video_Dev_Env eng = new Video_Dev_Env();
		String parent = driver.getWindowHandle();
		
		//play video
		click("//button[@class='plyr__control plyr__control--overlaid']");

		// IFrame01
		eng.click("(//div[contains(text(),'iframe01')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// IFrame 02
		eng.click("(//div[contains(text(),'iframe02')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// Image 01
		eng.click("(//div[contains(text(),'Image01')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// Image 02
		eng.click("(//div[contains(text(),'Image02')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// Action 01
		eng.click("(//div[contains(text(),'Action01')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// Action 02
		eng.click("(//div[contains(text(),'Action02')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// social01
		eng.click("(//div[contains(text(),'Social01')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// social02
		eng.click("(//div[contains(text(),'Social02')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// social03
		eng.click("(//div[contains(text(),'Social03')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// social04
		eng.click("(//div[contains(text(),'Social04')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// video01
		eng.click("(//div[contains(text(),'Video01')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// video02
		eng.click("(//div[contains(text(),'Video02')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// video03
		eng.click("(//div[contains(text(),'Video03')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// video04
		eng.click("(//div[contains(text(),'Video04')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// Markdown01
		eng.click("(//div[contains(text(),'Markdown01')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// Markdown02
		eng.click("(//div[contains(text(),'Markdown02')])[1]");
		eng.click("(//i[@role='img'])[1]");

//		// Markdown03
//		eng.click("(//div[contains(text(),'Markdown03')])[1]");
//		eng.click("(//i[@role='img'])[1]");

		// Markdown04
		eng.click("(//div[contains(text(),'Markdown04')])[1]");
		eng.click("(//i[@role='img'])[1]");

		// Markdown05
		eng.click("(//div[contains(text(),'Markdown05')])[1]");
		eng.click("(//i[@role='img'])[1]");

//		// Markdown06
//		eng.click("(//div[contains(text(),'Markdown06')])[1]");
//		eng.click("(//i[@role='img'])[1]");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	public void click(String Xpath) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		Thread.sleep(1000);
		driver.findElement(By.xpath(Xpath)).click();
	}

	public void socialClick(Video_Dev_Env eng, WebDriverWait wait, String parent) throws InterruptedException {
		eng.clickButton("(//div[@class='q-ma-xs'])[1]", parent, eng);
		eng.clickButton("(//div[@class='q-ma-xs'])[2]", parent, eng);
		eng.clickButton("(//div[@class='q-ma-xs'])[3]", parent, eng);
		eng.clickButton("(//div[@class='q-ma-xs'])[4]", parent, eng);
		eng.clickButton("(//div[@class='q-ma-xs'])[5]", parent, eng);
		eng.clickButton("(//div[@class='q-ma-xs'])[6]", parent, eng);
		eng.clickButton("(//div[@class='q-ma-xs'])[7]", parent, eng);
		eng.clickButton("(//div[@class='q-ma-xs'])[8]", parent, eng);
	}

	public void clickButton(String Xpath, String parent, Video_Dev_Env eng) throws InterruptedException {
		eng.click(Xpath);
		Set<String> allWindows = driver.getWindowHandles();
		for (String child : allWindows) {
			if (!child.equals(parent)) {
				driver.switchTo().window(child);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}

	public void iframeClickWithStarFunctionality(String iframeXpath, Video_Dev_Env eng) throws InterruptedException {
		// Click on IFrame SAM
		eng.click(iframeXpath);

		// Click on Star
		eng.click("(//i[normalize-space()='star'])[1]");

		// Close the SAM
		eng.click("(//i[@role='img'])[1]");

		// Click on IFrame SAM
		eng.click(iframeXpath);

		// Click on Sign In
		eng.click("(//div[@class='q-ml-sm cursor-pointer'])[1]");

		// Click on Register Button
		eng.click("(//span[contains(text(),'Register here')])[1]");

		// Cancel Button
		eng.click("(//span[contains(text(),'Cancel')])[1]");

		// Forgot Password
		eng.click("(//span[contains(text(),'Forgot Password?')])[1]");

		// Back to Registration
		eng.click("(//i[normalize-space()='keyboard_backspace'])[1]");

		// Close the SAM
		eng.click("(//i[@role='img'])[1]");

	}

}