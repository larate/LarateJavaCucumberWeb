package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;


import static com.sun.javafx.runtime.async.BackgroundExecutor.getExecutor;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class FormStepdefs {
    @When("^I fill out all page fields$")
    public void iWillOutAllPageFields() throws Throwable {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("skryabin");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("skryabin@skryabin.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("password");

        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Slava");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Skryabin");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();

        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("12345678");

        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();

        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']/option[@value='10']")).click();

        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']/option[@value ='1982']")).click();

        getDriver().findElement(By.xpath("//td[@data-handler='selectDay']/a[contains(text(),17)]")).click();

        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")).click();
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']/option[@value='Austria']")).click();
        getDriver().findElement(By.xpath("//input[@name='gender'][@value='male']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).click();

        WebElement iframe = getDriver().findElement(By.xpath(("//iframe[@name='additionalInfo']")));
        new Actions(getDriver()).moveToElement(iframe).perform();

        WebElement bmw = getDriver().findElement(By.xpath("//option[@value='BMW']"));
        WebElement toyota = getDriver().findElement(By.xpath("//option[@value='Toyota']"));

        new Actions((getDriver())).keyDown(Keys.CONTROL).click(toyota).click(bmw).keyDown(Keys.CONTROL).perform();

        WebElement privacyPolicy = getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"));
        TestContext.getExecutor().executeScript("arguments[0].click();", privacyPolicy);

        WebElement thirdPartyButton = getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']"));
        TestContext.getExecutor().executeScript("arguments[0].click();", thirdPartyButton);

        getDriver().switchTo().alert().accept();

        getDriver().switchTo().frame(iframe);
        getDriver().findElement(By.xpath("//*[@id='contactPersonName']")).sendKeys("Jone");
        getDriver().findElement(By.xpath("//*[@id='contactPersonPhone']")).sendKeys("12345678");
        getDriver().switchTo().defaultContent();

        getDriver().findElement(By.xpath("//*[contains(@onclick,'new_window')]")).click();

        String originalWindow = getDriver().getWindowHandle();

        for (String handle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(handle);
        }
        // verification
        assertThat(getDriver().getTitle()).isEqualTo("Documents Page");
        String pageText = getDriver().findElement(By.xpath("/html")).getText();
        assertThat(pageText).contains("Document 2");

        getDriver().close();
        getDriver().switchTo().window(originalWindow);

        //new Actions(getDriver()).moveToElement()
        getDriver().findElement(By.xpath("//input[@id='attachment']")).sendKeys("C:\\Users\\Teacher\\IdeaProjects\\LarateJavaCucumberWeb\\src\\test\\resources\\downloads\\test.txt");


    }
    @Then("^I submit the form$")
    public void iSubmitTheForm() throws Throwable {
        TestContext.getDriver().findElement(By.xpath("//*[@id ='formSubmit']")).click();
    }

    @Then("^I verify all filled out fields$")
    public void iVerifyAllFilledOutFields() throws Throwable {

        Thread.sleep(5000);
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[@name='username']")));
        WebElement container = getDriver().findElement(By.xpath("//legend[@class='applicationResult']/../section"));
        assertThat(container.getText().contains("skryabin"));
        assertThat(container.getText().contains("skryabin@skryabin.com"));
        assertThat(container.getText().contains("Slava"));
        assertThat(container.getText().contains("Skryabin"));
        assertThat(container.getText().contains("Slava Skryabin"));
        assertThat(container.getText().contains("12345678"));
        assertThat(container.getText().contains("11/17/1982 "));
        assertThat(container.getText().contains("Austria"));
        assertThat(container.getText().contains("male"));
        assertThat(container.getText().contains("Toyota, BMW"));
        assertThat(container.getText().contains(" Los Altos, CA 94022"));

        String passwordText = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(passwordText).isEqualTo("[entered]");

        String allowedToContact = getDriver().findElement(By.xpath("//b[@name ='allowedToContact']")).getText();
        assertThat(allowedToContact).isEqualTo("true");

        String agreed = getDriver().findElement(By.xpath("//b[@name = 'agreedToPrivacyPolicy']")).getText();
        assertThat(agreed).isEqualTo("true");
    }
}
