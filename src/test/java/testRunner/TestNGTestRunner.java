package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features",glue="stepDefinition",
monochrome=false,dryRun=false,plugin= {"pretty","html:target/cucumber.html"
        ,"json:target/cucumber.json"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
