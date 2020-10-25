package com.test.SeleniumBatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) {

		WebDriver  driver;
		System.setProperty("webdriver.chrome.driver", "/Users/pankajtiwari/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://hugelearning.com/iframe-practice-page/");
		driver.switchTo().frame("st_gdpr_iframe");
		driver.findElement(By.name("s")).sendKeys("Pankaj");
		

	}

}
