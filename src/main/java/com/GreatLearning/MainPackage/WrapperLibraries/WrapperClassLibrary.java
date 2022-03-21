package com.GreatLearning.MainPackage.WrapperLibraries;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.GreatLearning.MainPackage.BaseDriver.BaseDriver;
import com.google.common.base.Function;

public class WrapperClassLibrary extends BaseDriver {
	
	public static Boolean flag = false;
	

	@SuppressWarnings("unchecked")
	public void VerifyPresenceOfElementByID(String element) throws IOException {

		Wait waitObj = new FluentWait(driver).withTimeout(2, TimeUnit.MINUTES).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(Exception.class);

		waitObj.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				try {
					return driver.findElement(By.id(element));

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		});

	}

	@SuppressWarnings("unchecked")
	public void VerifyPresenceOfElementByXpath(String element) throws IOException {

		Wait waitObj = new FluentWait(driver).withTimeout(2, TimeUnit.MINUTES).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(Exception.class);

		waitObj.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				try {
					return driver.findElement(By.xpath(element));

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		});

	}

	public Boolean MouseHover(String explorePrograms) {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(explorePrograms)));
		act.perform();
		flag = true;
		return flag;
	}

	public Boolean SelectByXpath(String testID,String Locator, String Value) {
		
		WebElement dropdown = driver.findElement((By.xpath(Locator)));
		//dropdown.click(); // assuming you have to click the "dropdown" to open it
		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
		    if (option.getText().equals(Value))
		    {
		        option.click(); // click the desired option
		        break;
		    }
		}
		//dropdown.findElement(By.cssSelector("li[data-event-type=" + Value + "]")).click();
		flag = true;
		return flag;
		
	}
	
	public Boolean SelectByID(String testID,String Locator, String Value) {
		
		Select Cloud = new Select(driver.findElement(By.id(Locator)));
		Cloud.selectByVisibleText(Value);
		Cloud.selectByIndex(5);
		flag = true;
		return flag;
		
	}

	public boolean ClickByXpath(String testID, String Locator) {
		driver.findElement(By.xpath(Locator)).click();
		flag = true;
		return flag;
	}
	
	public boolean ClickByID(String testID, String Locator) {
		driver.findElement(By.id(Locator)).click();
		flag = true;
		return flag;
	}

	public Boolean EnterText(String TestID, String Locator, String Value) throws IOException {
		
		driver.findElement(By.id(Locator)).sendKeys(Value);
		flag = true;
		return flag;
		
	}

	public boolean EnterTextAndSelect(String testID, String Locator , String Value) throws IOException {
		
		Actions act = new Actions(driver);
		driver.findElement(By.id(Locator)).sendKeys(Value);
		Point point = driver.findElement(By.id(Locator)).getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
		act.moveByOffset(xcord, ycord);
		act.click().perform();;
		flag = true;
		return flag;
	}

}
