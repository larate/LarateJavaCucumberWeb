package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LookupByZip;
import pages.UspsHeader;

public class UspsStepDef {
    @Given("^I go to usps page object$")
    public void iGoToUspsPageObject() throws Throwable {
        new UspsHeader().open();
    }

    @When("^I go to Lookup ZIP page object by address$")
    public void iGoToLookupZIPPageObjectByAddress() throws Throwable {
        UspsHeader usps = new UspsHeader();
        usps.mousOverMailAndShip();
        usps.clickLookupByZip();
        new LookupByZip().clickFindByAdress();
        Thread.sleep(500);
    }

}
