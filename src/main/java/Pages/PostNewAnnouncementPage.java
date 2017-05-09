package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by babych on 07.05.2017.
 */
public class PostNewAnnouncementPage extends PageAbstract {

    @FindBy(id = "add-title")
    protected WebElement titleField;

    @FindBy(css = "#targetrenderSelect1-0>dt>a")
    protected WebElement dropDownHeading;

    @FindBy(id = "cat-38")
    protected WebElement headingTypeButton;

    @FindBy(xpath = ".//*[@id='parameter-div-price']/div[2]/div/div[1]/p[3]/input")
    protected WebElement priceField;

    @FindBy(id = "targetparam51")
    protected WebElement typeDropdown;

    @FindBy(xpath = ".//*[@id='targetparam51']/dd/ul/li[3]/a")
    protected WebElement typeValue;

    @FindBy(id = "targetparam13")
    protected WebElement stateDropdown;

    @FindBy(xpath = ".//*[@id='targetparam13']/dd/ul/li[2]/a")
    protected WebElement stateValue;

    @FindBy(id = "targetid_private_business")
    protected WebElement ownerDropdown;

    @FindBy(xpath = ".//*[@id='targetid_private_business']/dd/ul/li[2]/a")
    protected WebElement ownerValue;

    @FindBy(id = "add-description")
    protected WebElement descriptionField;

    @FindBy(id = "save")
    protected WebElement saveButton;




    public PostNewAnnouncementPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {

    }

    public void fillAllRequiredFields(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("add-title")));
        type(titleField, "Module Asus");
        dropDownHeading.click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("cat-38")));
        headingTypeButton.click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='parameter-div-price']/div[2]/div/div[1]/p[3]/input")));
        type(priceField, "1000");
        selectTypeValue();
        selectStateValue();
        selectOwnerValue();
        type(descriptionField, "Test descriptio about test module");
        scroll_to_element(saveButton);
        saveButton.click();

    }

    public void selectTypeValue(){
        typeDropdown.click();
        typeValue.click();
    }

    public void selectStateValue(){
        stateDropdown.click();
        stateValue.click();
    }

    public void selectOwnerValue(){
        scroll_to_element(ownerDropdown);
        ownerDropdown.click();
        ownerValue.click();
    }


}
