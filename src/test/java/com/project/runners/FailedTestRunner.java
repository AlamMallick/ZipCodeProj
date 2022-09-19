package com.project.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "@target/rerun.txt",
         glue = "com/project/step_Definitions",
         dryRun = false
)

public class FailedTestRunner {



}
