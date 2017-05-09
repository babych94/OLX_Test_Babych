import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

/**
 * Created by babych on 06.05.2017.
 */
public class BasicTest {
    protected WebDriver driver;
    protected ThreadLocal<WebDriver> threadDriver = null;
    protected HomePage homePage = null;
    protected LoginPage loginPage = null;
    protected MyAccountPage myAccountPage = null;
    protected AdvertisingPage advertisingPage = null;
    protected PostNewAnnouncementPage postNewAnnouncementPage = null;
    protected ConfirmCreatingPage confirmCreatingPage = null;
    protected WaitedPage waitedPage = null;
    protected ActiveAnnouncementPage activeAnnouncementPage = null;
    protected NotActiveAnnouncementsPage notActiveAnnouncementsPage = null;


    @BeforeClass
    public void setUp(){
        threadDriver = new ThreadLocal<WebDriver>();
        threadDriver.set(new ChromeDriver());
        getWebDriver().manage().window().maximize();
        homePage = new HomePage(getWebDriver());
        loginPage = new LoginPage(getWebDriver());
        myAccountPage = new MyAccountPage(getWebDriver());
        postNewAnnouncementPage = new PostNewAnnouncementPage(getWebDriver());
        advertisingPage = new AdvertisingPage(getWebDriver());
        confirmCreatingPage = new ConfirmCreatingPage(getWebDriver());
        waitedPage = new WaitedPage(getWebDriver());
        activeAnnouncementPage = new ActiveAnnouncementPage(getWebDriver());
        notActiveAnnouncementsPage = new NotActiveAnnouncementsPage(getWebDriver());
    }

    protected WebDriver getWebDriver(){
        return threadDriver.get();}

    public void closeWebDriver(){
        getWebDriver().close();
    }

    @AfterTest
    public void remove_post(){
        activeAnnouncementPage.open();
        activeAnnouncementPage.deleteAllActiveAnnouncement();
        waitedPage.open();
        waitedPage.deleteAllWaited();
        notActiveAnnouncementsPage.open();
        notActiveAnnouncementsPage.deleteAllNotActiveAnnouncements();
        closeWebDriver();
    }



}
