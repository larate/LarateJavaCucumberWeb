package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UspsHeader extends Page{

   public UspsHeader(){
       setUrl("https://www.usps.com/");
   }

   @FindBy(xpath = "//a[@id='mail-ship-width']")
    private WebElement mailAndShip;

    @FindBy(xpath = "//li[@class='tool-zip']//a")
    private WebElement lookupByZip;

    @FindBy(xpath = "//a[contains(@href,'byaddress')][contains(@class,'code-address')]")
    private WebElement findByAddres;

    public  void clickFindByAdress(){
    click(findByAddres);
    }

    @FindBy(xpath = "//a[@role='menuitem'][contains(text(),'Calculate a Price')]" )
    private WebElement calculatePrice;


   public void mouseOverMailAndShip(){
        moveToElement(mailAndShip);
    }

    public  void goToCalculatePrice() {
        mouseOverMailAndShip();
        click(calculatePrice);
    }

   public void clickLookupByZip(){
        mouseOverMailAndShip();
       click(lookupByZip);
   }

    //a[contains(text(),'Find by Address')]
    //a[contains(@href,'byaddress')][contains(@class,'code-address')]
//a[@id='mail-ship-width']
//li[@class='tool-zip']//a

}
