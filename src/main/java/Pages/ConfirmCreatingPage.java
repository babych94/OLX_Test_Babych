package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by babych on 08.05.2017.
 */
public class ConfirmCreatingPage extends PageAbstract {

    @FindBy(tagName = "h3")
    protected WebElement confirmMessage;

    public ConfirmCreatingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {

    }

    public boolean confirmMessageText(){

        if (confirmMessage.getText().equals("Дякуємо за публікацію оголошення. Оголошення скоро з'явиться на сервісі")){
            return true;
        }else {
            return false;
        }
    }
}
