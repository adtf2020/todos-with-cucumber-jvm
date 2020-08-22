package com.todos.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.todos.pageObjects.TodosPage;
import com.todos.utils.Setup;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CategorizeTodoStepDefinition {

	public WebDriver driver;
	private TodosPage todosPage = new TodosPage(driver);

	public CategorizeTodoStepDefinition() {

		driver = Setup.driver;
	}
	
	@Then("^Page Should Not Contain Element category \"([^\"]*)\" and \"([^\"]*)\"$")
	public void pageShouldNotContainElementCategoryAnd(String categoryPer, String categoryPro) throws Throwable {
	
		String elementTodo1 = todosPage.checkElementContain(TodosPage.todo1);
		Assert.assertFalse(elementTodo1.contains(categoryPer));
		Assert.assertFalse(elementTodo1.contains(categoryPro));
	}
	
	@When("^select category \"([^\"]*)\"$")
	public void selectCategory(String category) throws Throwable {
		
		todosPage.selectCategory(category);
	}

	@Then("^First Element Text Should Be category \"([^\"]*)\"$")
	public void firstElementTextShouldBeCategory(String category) throws Throwable {

		String elementTodo2 = todosPage.checkElementContain(TodosPage.todo2);
		Assert.assertTrue(elementTodo2.contains(category));
	}

	@Then("^Second Element Text Should Be category \"([^\"]*)\"$")
	public void secondElementTextShouldBeCategory(String category) throws Throwable {

		String elementTodo3 = todosPage.checkElementContain(TodosPage.todo3);
		Assert.assertTrue(elementTodo3.contains(category));
	}

	@Then("^Third Element Text Should Be category \"([^\"]*)\"$")
	public void thirdElementTextShouldBeCategory(String category) throws Throwable {

		String elementTodo4 = todosPage.checkElementContain(TodosPage.todo4);
		Assert.assertTrue(elementTodo4.contains(category));
	}

}
