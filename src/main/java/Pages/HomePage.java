package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by babych on 06.05.2017.
 */
public class HomePage extends PageAbstract {

    @FindBy(className = "user-box__photo")
    protected WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        driver.get("https://www.olx.ua/uk/");
    }

    @Step
    public void openLoginPage(){
        loginButton.click();
    }
}
