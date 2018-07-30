package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleForm extends Page {
    public SampleForm( ) {
        setUrl("http://skryabin.com/webdriver/html/sample.html");

    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;



    @FindBy(xpath = "//button[@id='formSubmit']")
    WebElement submitButton;

    public  void fillUsername(String text){
        username.sendKeys(text);
    }

    public  void  fillEmail(String text){
        email.sendKeys(text);
    }

    public  void  fillPassword(String text){
        password.sendKeys(text);
    }


    public  void clickSubmit(){
        submitButton.click();
    }


}
