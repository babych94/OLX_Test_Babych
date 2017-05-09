import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by babych on 06.05.2017.
 */
public class AddAnnouncementTest extends BasicTest{

    String userEmail = "babych94@ukr.net";
    String userPassword = "140494bvi";


    @Test
    public void AddAnnouncement(){
        homePage.open();
        homePage.openLoginPage();
        loginPage.userLogin(userEmail, userPassword);
        myAccountPage.clickOnPostButton();
        postNewAnnouncementPage.fillAllRequiredFields();
        if (advertisingPage.skipAdvertising().equals("Розміщення оголошень у рубриці Комп'ютери та комплектуючі / Комплектуючі та аксесуари платне. Будь ласка, оберіть один з варіантів")) {
            Assert.assertTrue("Limit of free announcement exceeded. Waite announcement created", false);
        }else {
            Assert.assertTrue("Creating process finished", confirmCreatingPage.confirmMessageText());
        }
    }

}
