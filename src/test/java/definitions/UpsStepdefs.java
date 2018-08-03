package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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


}


