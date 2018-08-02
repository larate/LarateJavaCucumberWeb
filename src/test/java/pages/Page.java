package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

    public void clickWithJS(WebElement element){
        getExecutor().executeScript("arguments[0].click",element);
    }


}
