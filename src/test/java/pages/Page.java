package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class Page {

    private String url;

    public Page() {
        PageFactory.initElements(getDriver(), this);

    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void open (){
        getDriver().get(url);
    }

    public  void  waitForVisible(WebElement element){
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element){
        waitForVisible(element);
        clickWithJS(element);
    }


    public void clickWithJS(WebElement element){

          getExecutor().executeScript("arguments[0].click()", element);
   }


}
