package com.todos;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import com.cucumber.listener.Reporter;
import cucumber.api.SnippetType;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/spec/features"},
		plugin= {"pretty","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/TodosReport.html"},
		snippets = SnippetType.CAMELCASE,
		tags= {("@todos")},
		monochrome = true
		)

public class TestRunner {

	@AfterClass
	public static void writeExtentReport() {

		Reporter.loadXMLConfig(new File("src/test/resources/configs/extent-config.xml"));
	}
}