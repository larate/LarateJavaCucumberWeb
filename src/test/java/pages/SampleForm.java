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
        username.sendKeys(text);
    }

    public void fillEmail(String text) {
        email.sendKeys(text);
    }

    public void fillPassword(String text) {
        password.sendKeys(text);
    }

    public void fillConfirmPassword(String text) {
        confirmPassword.sendKeys(text);
    }

    public void clickPrivacyPolicy(){
        clickWithJS(privacyPolicy);


    }


    public void fillName(String firstName, String middleName, String lastName) {
        name.click();

        SampleFormNameDialog dialog = new SampleFormNameDialog();
        dialog.fillFirstName(firstName);
        dialog.fillLastName(lastName);
        dialog.fillMiddleName(middleName);
        dialog.clickSaveButton();
    }


    public void clickSubmit() {
//        submitButton.click();
        clickWithJS(submitButton);
    }


}
