package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PriceCalculator extends Page{

    @FindBy(xpath = "//select[@id='CountryID']")
    private  WebElement country;

    @FindBy(xpath = "//input[@id='Origin']")
    private  WebElement zipCodeMailingFrom;

    @FindBy (xpath = "//input[@id='Destination']")
    private  WebElement zipCodeMailingTo;

    @FindBy(xpath = "//input[@id='ShippingDate']")
    private WebElement shippingDate;

    @FindBy(xpath = "//select[@id='ShippingTime']")
    private  WebElement shippingTime;

    public void setCountry(String value) {
        new Select(country).selectByValue(value);

    }

    public void chooseShape(String value){

    }


}
