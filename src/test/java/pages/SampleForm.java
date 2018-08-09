package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import support.TestContext;

import static support.TestContext.getDriver;
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

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//select[@name='countryOfOrigin']")
    private WebElement countryOfOrigin;

    @FindBy(xpath = "//input[@name='allowedToContact']")
    private WebElement allowToContact;

    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement address;


    @FindBy(xpath = "//button[@id='thirdPartyButton']")
    private WebElement thirdPartyButton;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirth;


    public void selectDateOfBirth(String day, String month, String year) {
        click(dateOfBirth);
        new DatePicker().selectDate(day, month, year);
    }

    public void acceptThitdPartyAgreenent() {
        click(thirdPartyButton);
        getDriver().switchTo().alert().accept(); //accept
    }

    public void declineThitdPartyAgreenent() {
        click(thirdPartyButton);
        getDriver().switchTo().alert().dismiss(); //dismiss
    }

    public void fillAddress(String address) {
        sendKeys(this.address, address);
    }

    public void clickAllowedToContact() {
        click(allowToContact);
    }




    public void fillPhome(String text) {
        sendKeys(phoneNumber, text);
    }

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

    public void chooseGender(String value) {
//        WebElement gender = getDriver().findElement(By.xpath("//input[@name='gender'][@value='" + value + "']"));
//        WebElement gender = getByXpath("//input[@name='gender'][@value='" + value + "']");
        click(getByXpath("//input[@name='gender'][@value='" + value + "']"));
    }

    public void selectCountryOfOrigin(String value) {
        new Select(countryOfOrigin).selectByValue(value);
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
