package com.todos.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.todos.pageObjects.TodosPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Setup {

	public static WebDriver driver;
	static DriverManager driverManager;

	@Before
	/**
	 * Call Browser with the design pattern Factory navigator
	 */
	public static void setup() throws IOException {

		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		driver.get("http://localhost:9090/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, TodosPage.class);
		assertThat(driver.getTitle(), is("Tout Doux"));
		Dimension d = new Dimension(600,300);
		driver.manage().window().setSize(d);
	}

	@After
	/**
	 * Clean up the test suite
	 */
	public void cleanTest() {

		driver.navigate().refresh();
		driver.quit();  
	}

}

