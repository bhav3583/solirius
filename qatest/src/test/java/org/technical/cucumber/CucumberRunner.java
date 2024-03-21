package org.technical.cucumber;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.technical.testbase.TestBase;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/features/"
        //,tags = "@Test"
)// tags are optional , could run from runner class
public class CucumberRunner extends TestBase {

}
