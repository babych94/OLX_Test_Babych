package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by babych on 07.05.2017.
 */
public class MyAccountPage extends PageAbstract {

    @FindBy(id = "postNewAdLink")
    protected WebElement postNewButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        driver.get("https://www.olx.ua/uk/myaccount/");
    }

    public void clickOnPostButton(){
        postNewButton.click();
    }
}
