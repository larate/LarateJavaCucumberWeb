package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.TestContext;

import static support.TestContext.getExecutor;

public class SampleForm extends Page {

    public SampleForm() {
        setUrl("http://skryabin.com/webdriver/html/sample.html");
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;



    public void fillUsername(String text) {
        sendKeys(username, text);

    }

    public void fillEmail(String text) {

        sendKeys(email, text);
    }

    public void fillPassword(String text) {
        sendKeys(password, text);

    }

    public void fillConfirmPassword(String text) {
        sendKeys(confirmPassword, text);

    }



    public void clickPrivacyPolicy() {
       click(privacyPolicy);
        // getExecutor().executeScript("arguments[0].click()", privacyPolicy);

    }


    public void fillName(String firstName, String middleName, String lastName) {
        click(name);

        SampleFormNameDialog dialog = new SampleFormNameDialog();
        dialog.fillFirstName(firstName);
        dialog.fillLastName(lastName);
        dialog.fillMiddleName(middleName);
        dialog.clickSaveButton();
    }


    public void clickSubmit() {

       click(submitButton);
//        getExecutor().executeScript("arguments[0].click()", submitButton);
    }


}
