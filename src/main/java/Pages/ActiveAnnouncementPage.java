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
public class ActiveAnnouncementPage extends PageAbstract {

    @FindAll(@FindBy(css = ".icon.f_checkbox.inlblk.vtop"))
    protected List<WebElement> selectAllActiveCheckbox;

    @FindBy(xpath = ".//*[@id='deactivateme']/a/span")
    protected WebElement deactivateAllActiveButton;

    @FindBy(xpath = ".//*[@id='adsTable']/thead/tr/th[1]/label")
    protected WebElement mainCheckbox;

    @FindBy(xpath = ".//*[@id='reasonInnerHeight']/div[3]/label[3]/span")
    protected WebElement confirmDeletingButton;


    public ActiveAnnouncementPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        driver.get("https://www.olx.ua/uk/myaccount/");
    }

    public boolean deleteAllActiveAnnouncement(){

        Boolean isPresent = driver.findElements(By.xpath((".//*[@id='adsTable']/thead/tr/th[1]/label"))).size() > 0;

        if (isPresent != true){
            return true;
        } else if (isPresent == true) {
            selectAllActiveCheckbox.get(0).click();
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='deactivateme']/a/span")));
            deactivateAllActiveButton.click();
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='reasonInnerHeight']/div[3]/label[3]/span")));
            confirmDeletingButton.click();
        }
        return false;
    }


}
