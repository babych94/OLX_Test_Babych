package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by babych on 09.05.2017.
 */
public class NotActiveAnnouncementsPage extends PageAbstract {

    @FindAll(@FindBy(css = ".icon.f_checkbox.inlblk.vtop"))
    protected List<WebElement> selectAllNotActiveCheckbox;

    @FindBy(xpath = ".//*[@id='removeme']/a/span")
    protected WebElement deleteAllNotActiveButton;

    public NotActiveAnnouncementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        driver.get("https://www.olx.ua/uk/myaccount/archive/");
    }

    public void deleteAllNotActiveAnnouncements(){
        selectAllNotActiveCheckbox.get(0).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='removeme']/a/span")));
        deleteAllNotActiveButton.click();
    }

}
