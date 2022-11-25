package stepDefination;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="OrangeHRMApplication",
				glue="stepDefination",
				//dryRun=true,
				//tags="@Ram",
				//tags="@Babu",
				//tags="@Smoke",
				//tags="@Sanity",
				//tags="@ApplicationFunctionalityWithTestData",
				//tags= {"@Ram,@ApplicationFunctionalityWithTestData"},
				monochrome=true,
				plugin={"pretty",
						"html:target/OrangeHRMApplicationReports",
		"json:target/OrangeHRMApplicationJsonReports.json",

		"com.cucumber.listener.ExtentCucumberFormatter:target/"
		+ "OrangeHRMApplicationExtentReports.htm"
}
					)
public class TestRunner 
{

}
