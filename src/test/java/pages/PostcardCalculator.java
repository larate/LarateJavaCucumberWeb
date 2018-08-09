package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostcardCalculator extends PriceCalculator {
    @FindBy(xpath = "//input[@id='quantity-0']")
    private WebElement quantity;
    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateButton;
    @FindBy(xpath = "//div[@id='total']")
    private WebElement totalResult;

    public String getTotal(){
        return totalResult.getText();
    }

    public void fillQuantity(String text){
        sendKeys(quantity, text);
    }

    public void clickCalculate(){
        click(calculateButton);
    }
}
