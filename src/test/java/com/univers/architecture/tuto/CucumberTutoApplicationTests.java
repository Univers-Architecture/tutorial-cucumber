package com.univers.architecture.tuto;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = "src/test/resources",
		glue = {"classpath:com/univers/architecture/tuto"},
		plugin= 
		{
			"pretty",
			"html:target/cucumber-reports"
		},
		monochrome = true, 
		snippets=SnippetType.CAMELCASE
		) 
public class CucumberTutoApplicationTests {

	
}
