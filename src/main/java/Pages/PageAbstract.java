package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by babych on 06.05.2017.
 */
public abstract class PageAbstract {

    public WebDriver driver;
    public PageAbstract(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Open page")
    public abstract void open();

    public void type(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public void selectDropDownByValue(WebElement dropDownName, String value){
        Select dropDown = new Select(dropDownName);
        dropDown.selectByValue(value);
    }

    public void scroll_to_element(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

}
