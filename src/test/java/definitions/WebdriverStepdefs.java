package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import support.TestContext;

import static support.TestContext.getDriver;

public class WebdriverStepdefs {
    @Given("^I go the \"([^\"]*)\" page and print details$")
    public void iGoThePageAndPrintDetails(String page) throws Throwable {
        if (page.equals("ask portnov")){
            getDriver().get("http://ask.portnov.com/");
        }else if(page.equals("sample")){
            getDriver().get("http://skryabin.com/webdriver/html/sample.html");
        }
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getWindowHandle());
    }


    @And("^I go back and forward and refresh the fpage$")
    public void iGoBackAndForwardAndRefreshTheFpage() throws Throwable {
       getDriver().navigate().back();
       getDriver().navigate().forward();
       getDriver().navigate().refresh();
    }

    @And("^I print the logs to the console$")
    public void iPrintTheLogsToTheConsole() throws Throwable {
        LogEntries logEntries = getDriver().manage().logs().get("browser");
        for(LogEntry element : logEntries){
            System.out.println();
            System.out.println(element);
        }
    }
}
