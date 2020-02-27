package com.test.SeleniumBatch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) {

		WebDriver  driver;
		System.setProperty("webdriver.chrome.driver", "/Users/pankajtiwari/Applications/chromedriver");
		driver = new ChromeDriver();

	}

}
