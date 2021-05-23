package com.kommuru.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

/**
 * The class is a runner file where is used to run all the scenarios.
 *
 * @author Nagendra Kommuru
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "target/test-classes"},
        plugin = {
                "pretty", "html:target/car-registration-report",
                "json:target/car-registration-report/cucumber.json",
                "rerun:target/car-registration-report/rerun.txt"},
        tags = "@car-reg-details",
        glue = {"com/kommuru/steps/"})
public class RunnerTest {
}
