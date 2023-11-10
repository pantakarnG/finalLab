import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class DandDPractice {

	@Test
	void test() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		By drag = By.xpath("//*[@id='draggable']");
		WebElement from = driver.findElement(drag);

		By drop = By.xpath("//*[@id='droptarget']");
		WebElement to = driver.findElement(drop);
		System.out.println("Before : " + to.getText());

		Actions act = new Actions(driver);

		act.dragAndDrop(from, to).build().perform();

		System.out.println("After : " + to.getText());

		Thread.sleep(5000);
		driver.close();
		System.out.println(" Finish !!!");

	}

}