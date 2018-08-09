package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import support.TestContext;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UspsStepDefs extends UspsHeader{
    @Given("^I go to \"([^\"]*)\" page$")
    public void iGoToPage(String page) throws Throwable {
        double[] array = {5.0, 7.9, 500, 3};
        double smallestNumber = Double.MAX_VALUE;
        for(double item : array) {
            if (item < smallestNumber) {
                smallestNumber = item;
            }
        }
        //System.out.println(smallestNumber);
        if (page.equals("google")) {
            TestContext.getDriver().get("https://www.google.com/");
        } else if (page.equals("sample")) {
            getDriver().get("http://skryabin.com/webdriver/html/sample.html");
        } else if (page.equals("usps")) {
            getDriver().get("https://www.usps.com/");
        } else if (page.equals("converter")) {
            try {
                // setting page load timeout of 5 seconds
                getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                getDriver().get("https://www.unitconverters.net/");
            } catch (TimeoutException e) {
                // do not fail, proceed
            } finally {
                // setting page load timeout back to original value
                getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            }
        } else if (page.equals("ups")) {
            getDriver().get("https://www.ups.com/us/en/Home.page");
        } else if (page.equals("calculator")) {
            try {
                // setting page load timeout of 5 seconds
                getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                getDriver().get("http://www.calculator.net/");
            } catch (TimeoutException e) {
                // do not fail, proceed
            } finally {
                // setting page load timeout back to original value
                getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            }
        } else if (page.equals("stc")) {
            getDriver().get("https://my.stcinteractive.com/");
        } else if (page.equals("macys")) {
            getDriver().get("https://www.macys.com/");
        } else if (page.equals("toys")) {
            getDriver().get("https://www.toysrus.com/");
        }

        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("^I go to Lookup ZIP page by address$")
    public void iGoToLookupZIPPageByAddress() throws Throwable {
        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        actions.moveToElement(element).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']//a[@role='menuitem']")).click();
        getDriver().findElement(By.xpath("(//a[@data-location='byaddress'])[1]")).click();
    }

    @And("^I fill out \"([^\"]*)\" street, \"([^\"]*)\" city, \"([^\"]*)\" state$")
    public void iFillOutStreetCityState(String street, String city, String state) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']//option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("^I validate \"([^\"]*)\" zip code exists in the result$")
    public void iValidateZipCodeExistsInTheResult(String zip) throws Throwable {
        new WebDriverWait(getDriver(), 180, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='zipcode-result-address']")));
        String result = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText();
        assertThat(result).contains(zip);
    }

    @When("^I go to Calculate Price Page$")
    public void iGoToCalculatePricePage() throws Throwable {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//img[@id='icon-calculate']")).click();
    }

    @And("^I select \"([^\"]*)\" with \"([^\"]*)\" shape And I define \"([^\"]*)\" quantity$")
    public void iSelectWithShapeAndIDefineQuantity(String country, String shape, String quantity) throws Throwable {
        getDriver().findElement(By.xpath("//select[@id='CountryID']/option[contains(text(),'" + country + "')]")).click();
        getDriver().findElement(By.xpath("//input[@value='" + shape + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("^I calculate the price and validate cost is \"([^\"]*)\"$")
    public void iCalculateThePriceAndValidateCostIs(String expectedTotal) throws Throwable {
        getDriver().findElement(By.xpath("//input[@type='button']")).click();
        String actualTotal = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(actualTotal).isEqualTo(expectedTotal);
    }

    @When("^I go to \"([^\"]*)\" tab$")
    public void iGoToTab(String tab) throws Throwable {
        getDriver().findElement(By.xpath("//a[@aria-expanded='false'][contains(text(),'" + tab + "')]")).click();
    }

    @And("^I enter \"([^\"]*)\" into store search$")
    public void iEnterIntoStoreSearch(String searchString) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='store-search']")).sendKeys(searchString);
    }

    @Then("^I search and validate no products found$")
    public void iSearchAndValidateNoProductsFound() throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='store-search-btn']")).click();
        String actualText = getDriver().findElement(By.xpath("//div[@class='page-wrapper']")).getText();
        System.out.println(actualText);
        assertThat(actualText).contains("did not match any products");

        List<WebElement> elementList = getDriver().findElements(By.xpath("//div[@class='no-product']"));
        assertThat(elementList).isNotEmpty();
    }

    @When("^I go to \"([^\"]*)\" menu item$")
    public void iGoToMenuItem(String item) throws Throwable {
        Actions actions = new Actions(getDriver());
        WebElement mailShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        actions.moveToElement(mailShip).perform();
        getDriver().findElement(By.xpath("//a[@role='menuitem'][contains(text(),'" + item + "')]")).click();
    }

    @And("^I open Stamps$")
    public void iOpenStamps() throws Throwable {
        getDriver().findElement(By.xpath("//img[contains(@src,'stamps.png')]")).click();
    }

    @And("^choose category Priority Mail$")
    public void chooseCategoryPriorityMail() throws Throwable {
        getDriver().findElement(By.xpath("//label[contains(text(),'Priority Mail')][not(contains(text(),'Express'))]")).click();

    }

    @Then("^I verify (\\d+) item found in result$")
    public void iVerifyItemFoundInResult(int count) throws Throwable {
        int actualCount = getDriver().findElements(By.xpath("//div[contains(@class,'result-page-stamps-holder')]")).size();
        assertThat(actualCount).isEqualTo(count);
    }

    @When("^I unselect Stamps checkbox$")
    public void iUnselectStampsCheckbox() throws Throwable {
        getDriver().findElement(By.xpath("//label[@for='checkbox-type-Category-Stamps']")).click();
    }

    @When("^I go to Stamps and Supplies page$")
    public void iGoToStampsAndSuppliesPage() throws Throwable {
        Actions actions = new Actions(getDriver());
        WebElement mailShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        actions.moveToElement(mailShip).perform();
        getDriver().findElement(By.xpath("//a[@role='menuitem'][contains(text(),'Stamps & Supplies')]")).click();
    }

    @And("^select size \"([^\"]*)\"$")
    public void selectSize(String size) throws Throwable {
        getDriver().findElement(By.xpath("//label[contains(text(),'" + size + "')]")).click();
    }

    @And("^I click \"([^\"]*)\" color$")
    public void iClickColor(String color) throws Throwable {
        getDriver().findElement(By.xpath("//div[contains(@onclick,'" + color + "')]")).click();
    }

    @Then("^I verify \"([^\"]*)\" and \"([^\"]*)\" filters$")
    public void iVerifyAndFilters(String color, String size) throws Throwable {
        String actualText = getDriver().findElement(By.xpath("//div[@class='breadcrumb-cartridge']")).getText();
        assertThat(actualText).contains(color);
        assertThat(actualText).contains(size);


        WebElement colorElement = getDriver().findElement(By.xpath("//div[@class='breadcrumb-cartridge']//span[contains(text(),'" + color + "')]"));
        assertThat(colorElement.isDisplayed()).isTrue();
        WebElement sizeElement = getDriver().findElement(By.xpath("//div[@class='breadcrumb-cartridge']//span[contains(text(),'" + size + "')]"));
        assertThat(sizeElement.isDisplayed()).isTrue();
    }

    @Then("^I verify \"([^\"]*)\" text$")
    public void iVerifyText(String text) throws Throwable {
        String actualText = getDriver().findElement(By.xpath("//div[@class='results-product-desc']")).getText();
        assertThat(actualText).isEqualTo(text);
    }


    @When("^I initiate Passports search$")
    public void iInitiatePassportsSearch() throws Throwable {
        Actions actions = new Actions(getDriver());
        WebElement searchElement = getDriver().findElement(By.xpath("//li[contains(@class,'nav-search')]"));
        actions.moveToElement(searchElement).perform();
        getDriver().findElement(By.xpath("//div[@class='repos']//a[text()='PASSPORTS']")).click();
    }

    @And("^I go to \"([^\"]*)\" results$")
    public void iGoToResults(String resultsText) throws Throwable {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + resultsText + "')]")).click();
    }

    @And("^I select \"([^\"]*)\" location, \"([^\"]*)\" zip code within \"([^\"]*)\"$")
    public void iSelectLocationZipCodeWithin(String location, String zip, String within) throws Throwable {

        getDriver().findElement(By.xpath("//div[@id='locationTypeList']")).click();
        getDriver().findElement(By.xpath("//div[@id='locationTypeList']//a[text()='" + location + "']")).click();

        getDriver().findElement(By.xpath("//input[@id='tCityStateZip']")).sendKeys(zip);

        getDriver().findElement(By.xpath("//div[@id='sWithinList']")).click();
        getDriver().findElement(By.xpath("//div[@id='sWithinList']//a[text()='" + within + "']")).click();
    }

    @And("^I initiate search$")
    public void iInitiateSearch() throws Throwable {
//        Thread.sleep(500);
        getDriver().findElement(By.xpath("//input[@id='bSearch']")).click();
    }

    @Then("^I verify \"([^\"]*)\" present in search results$")
    public void iVerifyPresentInSearchResults(String expectedResult) throws Throwable {
        String actualResult = getDriver().findElement(By.xpath("//tbody[@class='resultRows']")).getText();
        assertThat(actualResult).contains(expectedResult);
    }

    @When("^I open \"([^\"]*)\" search results$")
    public void iOpenSearchResults(String resultText) throws Throwable {
        getDriver().findElement(By.xpath("//span[text()='" + resultText + "'][not(@id='city')]")).click();
    }

    @Then("^I verify \"([^\"]*)\" address, \"([^\"]*)\" walk-in hours, \"([^\"]*)\" photo hours$")
    public void iVerifyAddressWalkInHoursPhotoHours(String address, String walkInHours, String photoHours) throws Throwable {
        String actualAddress = getDriver().findElement(By.xpath("//*[@id='addrHeading']")).getText();
        assertThat(actualAddress).contains(address);

        String actualWalkInHours = getDriver().findElement(By.xpath("//div[@id='passportWlkHours']")).getText();
        assertThat(actualWalkInHours).contains(walkInHours);

        String actualPhotoHours = getDriver().findElement(By.xpath("//div[@id='passportPhotoHours']")).getText();
        assertThat(actualPhotoHours).contains(photoHours);
    }

    @When("^I go back to list$")
    public void iGoBackToList() throws Throwable {
        getDriver().findElement(By.xpath("//a[@id='back-to-list']")).click();
    }

    @Then("^I verify I'm on Find Locations search page$")
    public void iVerifyIMOnFindLocationsSearchPage() throws Throwable {
        WebElement zipSearch = getDriver().findElement(By.xpath("//input[@id='tCityStateZip']"));
        assertThat(zipSearch.isDisplayed()).isTrue();

        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle).contains("Find Locations");
    }


    @Given("^I go to usps page object$")
    public void iGoToUspsPageObject() throws Throwable {
        new UspsHeader().open();
    }

    @When("^I go to Lookup ZIP page object by address$")
    public void iGoToLookupZIPPageObjectByAddress() throws Throwable {
        UspsHeader usps = new UspsHeader();
        usps.clickLookupByZip();
        new LookupByZip().clickFindByAdress();
        Thread.sleep(500);

    }

    @And("^I fill out \"([^\"]*)\" street, \"([^\"]*)\" city, \"([^\"]*)\" state page object$")
    public void iFillOutStreetCityStatePageObject(String street, String city, String state) throws Throwable {
        ByAdressForm form = new ByAdressForm();
        form.fillStreetAddress(street);
        form.fillStreetCity(city);
        form.fillStreetState(state);
        form.clickFindButton();

    }

    @Then("^I validate \"([^\"]*)\" zip code exists in the result page object$")
    public void iValidateZipCodeExistsInTheResultPageObject(String zip) throws Throwable {
//       String results = new ByAdressForm().getSearchResultText();
//        assertThat(results).contains(zip);
    }

    @When("^I go to Calculate Price page object$")
    public void iGoToCalculatePricePageObject() throws Throwable {
        new UspsHeader().goToCalculatePrice();


    }

    @And("^I select \"([^\"]*)\" with \"([^\"]*)\" shape And I define \"([^\"]*)\" quantity page object$")
    public void iSelectWithShapeAndIDefineQuantityPageObject(String selectText, String shape, String quantety) throws Throwable {

        PriceCalculator priceCalculator = new PriceCalculator();

       priceCalculator.selectCountry(getData(selectText));
       priceCalculator.chooseShape(shape);

       new PostcardCalculator().fillQuantity(quantety);


    }

    @Then("^I calculate the price and validate cost is \"([^\"]*)\" page object$")
    public void iCalculateThePriceAndValidateCostIsPageObject(String cost) throws Throwable {
        PostcardCalculator postcardCalculator = new PostcardCalculator();
        postcardCalculator.clickCalculate();
        assertThat(postcardCalculator.getTotal()).isEqualTo(cost);


    }
}
