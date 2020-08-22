package com.todos.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.todos.pageObjects.TodosPage;
import com.todos.utils.Setup;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelectTodoStepDefinition {

	public WebDriver driver;
	private TodosPage todosPage = new TodosPage(driver);

	public SelectTodoStepDefinition() {

		driver = Setup.driver;
	}

	@Then("^First Element Should Contain \"([^\"]*)\"$")
	public void firstElementShouldContain(String element) throws Throwable {
		
		String elementTodo1 = todosPage.checkElementContain(TodosPage.element1);
		Assert.assertTrue(elementTodo1.contains(element));
	}

	@Then("^Second Element Should Contain \"([^\"]*)\"$")
	public void secondElementShouldContain(String element) throws Throwable {

		String elementTodo2 = todosPage.checkElementContain(TodosPage.element2);
		Assert.assertTrue(elementTodo2.contains(element));
	}

	@Then("^Third Element Should Contain \"([^\"]*)\"$")
	public void thirdElementShouldContain(String element) throws Throwable {

		String elementTodo3 = todosPage.checkElementContain(TodosPage.element3);
		Assert.assertTrue(elementTodo3.contains(element));
	}

	@When("^Select first Checkbox todo$")
	public void selectFirstCheckboxTodo() throws Throwable {

		todosPage.clickCheckbox();
	}

	@Then("^First Checkbox Should Be Selected$")
	public void firstCheckboxShouldBeSelected() throws Throwable {

		boolean checkbox = todosPage.isCheckboxSelected(TodosPage.checkbox);
		Assert.assertTrue(checkbox);
	}

	@Then("^Second Checkbox Should Not Be Selected$")
	public void secondCheckboxShouldNotBeSelected() throws Throwable {

		boolean checkbox2 = todosPage.isCheckboxSelected(TodosPage.checkbox2);
		Assert.assertFalse(checkbox2);
	}

	@Then("^Third Checkbox Should Not Be Selected$")
	public void thirdCheckboxShouldNotBeSelectedCheckboxDone() throws Throwable {

		boolean checkbox3 = todosPage.isCheckboxSelected(TodosPage.checkbox3);
		Assert.assertFalse(checkbox3);
	}

}
