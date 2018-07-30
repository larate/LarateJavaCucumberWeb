package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import support.TestContext;

import static support.TestContext.getDriver;

public class UpsStepdefs {
    @And("^I open Shipping menu$")
    public void iOpenShippingMenu() throws Throwable {
        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks1']")).click();
    }

    @And("^I go to Create a Shipment$")
    public void iGoToCreateAShipment() throws Throwable {
        getDriver().findElement(By.xpath("//a[contains(@href, 'ship?loc')][@data-event-id ='21']")).click();
    }

    @When("^I fill out origin shipment fields$")
    public void iFillOutOriginShipmentFields() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I submit the shipment form$")
    public void iSubmitTheShipmentForm() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I verify origin shipment fields submitted$")
    public void iVerifyOriginShipmentFieldsSubmitted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I cancel the shipment form$")
    public void iCancelTheShipmentForm() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I verify shipment form is reset$")
    public void iVerifyShipmentFormIsReset() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
