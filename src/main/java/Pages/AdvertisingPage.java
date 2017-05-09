package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by babych on 08.05.2017.
 */
public class AdvertisingPage extends PageAbstract {

    @FindBy(xpath = ".//*[@id='innerLayout']/section/div/ul/li[1]/div/div[3]/a[2]")
    protected WebElement skipAdvButton;

    @FindBy(className = "olx-multipay__infobox")
    protected WebElement needPayMessage;


    public AdvertisingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {

    }

    public String skipAdvertising(){
        if (needPayMessage.isDisplayed()){
           return needPayMessage.getText();
        }else {
            scroll_to_element(skipAdvButton);
            skipAdvButton.click();
        }
        return null;
    }



}
