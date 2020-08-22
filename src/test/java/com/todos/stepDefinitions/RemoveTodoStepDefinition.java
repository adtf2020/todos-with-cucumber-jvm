package com.todos.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.todos.pageObjects.TodosPage;
import com.todos.utils.Setup;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RemoveTodoStepDefinition {
	
	public WebDriver driver;
	private TodosPage todosPage = new TodosPage(driver);

	public RemoveTodoStepDefinition() {

		driver = Setup.driver;
	}

	@Then("^Page Should Contain button remove todo$")
	public void pageShouldContainButtonRemoveTodo() throws Throwable {

		boolean buttonRemove = todosPage.isElementDisplayed(TodosPage.buttonRemove);
		Assert.assertTrue(buttonRemove);
	}

	@When("^Click button remove todo$")
	public void clickButtonRemoveTodo() throws Throwable {

		todosPage.removeTodo();
	}

	@Then("^Page Should Not Contain Element \"([^\"]*)\"$")
	public void pageShouldNotContainElement(String todo) throws Throwable {

		String element = driver.getPageSource();
		Assert.assertFalse(element.contains(todo));
	}
}
