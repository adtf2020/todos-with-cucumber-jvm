package com.todos.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.todos.pageObjects.TodosPage;
import com.todos.utils.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddTodoStepDefinition {

	public WebDriver driver;
	private TodosPage todosPage = new TodosPage(driver);

	public AddTodoStepDefinition() {

		driver = Setup.driver;
	}

	@Given("^Page Should Contain Element input text description$")
	public void pageShouldContainElementInputTextDescription() throws Throwable {
 
		boolean elementText = todosPage.isElementDisplayed(TodosPage.inputText);
		Assert.assertTrue(elementText);
	}

	@When("^Submit a todo \"([^\"]*)\"$")
	public void submitAFirstTodo(String todo) throws Throwable {
		
		todosPage.submitTodo(todo);
	}

	@Then("^Element Should Contain \"([^\"]*)\"$")
	public void elementShouldContain(String todo1) throws Throwable {

		String elementTodo = todosPage.checkElementContain(TodosPage.element1);
		Assert.assertTrue(elementTodo.contains(todo1));
	}

	@Then("^Checkbox Should Not Be Selected$")
	public void checkboxShouldNotBeSelected() throws Throwable {

		boolean checkbox = todosPage.isCheckboxSelected(TodosPage.checkbox);
		Assert.assertFalse(checkbox);
	}
	
}
