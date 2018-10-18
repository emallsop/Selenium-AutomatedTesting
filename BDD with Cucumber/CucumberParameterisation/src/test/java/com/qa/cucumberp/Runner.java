package com.qa.cucumberp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\Parametisation.feature", glue = {"com.qa.cucumberp"})


public class Runner {

}
