package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class SampleVerify extends Page {

    public SampleVerify() {
    }

    @FindBy(xpath = "//div[@id='samplePageResult']")
    WebElement result;
    @FindBy(xpath = "//b[@name='password']")
    WebElement passwoResult;

    @FindBy(xpath = "//b[@name='password']")
    WebElement allowedToContact;

    @FindBy(xpath = "//body[@class='ng-scope']")
    WebElement agreedToPrivacyPolicy;

    public String getallowedToContact(){
        return  allowedToContact.getText();
    }

    public String getAgreedToPrivacyPolicy(){
        return  agreedToPrivacyPolicy.getText();
    }

    public String getResult() {
        waitForVisible(result);
        return result.getText();
    }

    public String getPassword() {
        return passwoResult.getText();
    }
}

