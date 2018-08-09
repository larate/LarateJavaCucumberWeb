package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import support.TestContext;

public class PriceCalculator extends Page{

    @FindBy(xpath = "//select[@id='CountryID']")
    private  WebElement country;



    public void selectCountry(String value) {
        new Select(country).selectByValue(value);

    }

    public void chooseShape(String value){
        click(getByXpath("//input[@value='"+value+"']"));

    }


}
