package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by babych on 07.05.2017.
 */
public class LoginPage extends PageAbstract {

    @FindBy(id = "userEmail")
    protected WebElement emailField;

    @FindBy(id = "userPass")
    protected WebElement passwordField;

    @FindBy(id = "se_userLogin")
    protected WebElement loginButton;



    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {

    }

    public void userLogin(String email, String password){
        type(emailField, email);
        type(passwordField, password);
        loginButton.click();
    }

}
