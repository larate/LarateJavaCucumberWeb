package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ByAdressForm extends UspsHeader{

    @FindBy(xpath = "//input[@id='tAddress']")
    private WebElement streetAddress;

    @FindBy(xpath = "//input[@id='tCity']")
    private  WebElement city;

    @FindBy(xpath = "//select[@id='tState']")
    private WebElement state;

    @FindBy(xpath = "//a[@id='zip-by-address']")
    private WebElement findButton;

    public  void  fillStreetAddress(String text){
        sendKeys(streetAddress, text);

    }
    public  void  fillStreetCity(String text){
        sendKeys(city, text);

    }
    public  void  fillStreetState(String text){
        sendKeys(state, text);
    }
    public void  clickFindButton(){
        findButton.click();
    }
}
