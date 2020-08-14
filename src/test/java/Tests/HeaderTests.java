package Tests;

import Base.Constants;
import PageObject.PageFunctions.HeaderPageFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class HeaderTests {//extends BaseTest {

    public WebDriver driver;
    private final String url = Constants.BASE_URL;

    @BeforeEach
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @AfterEach
    public void teardown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void headerIsVisibleByDefault() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        Assert.assertTrue(header.isHeaderDisplayed());
    }

    @Test
    public void logoIsVisible() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        Assert.assertTrue(header.isLogoDisplayed());
    }

    @Test
    public void logoReturnsToHome() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        Assert.assertEquals(header.elementAddressURL(header.logo), Constants.BASE_URL);
    }

    @Test
    public void subscribeButtonIsVisible() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        Assert.assertTrue(header.isSubscribeBtnDisplayed());
    }

    @Test
    public void subscribeButtonNavigatesToSubscriptionSection() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        Assert.assertEquals(header.elementAddressURL(header.subscribeBtn), Constants.SUBSCRIBE_URL);
    }

    @Test
    public void dropdownMenuItemsCorrectNumber() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        int expectedMenuItemsNumber = 8;
        int actualMenuItemNumber = header.menuItemsNumber();
        Assert.assertEquals(actualMenuItemNumber, expectedMenuItemsNumber);
    }

    @Test
    public void dropdownMenuItemsCorrectNames() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);

        ArrayList<String> expectedMenuNames = new ArrayList<>(Arrays.asList(
                "HOME", "ABOUT", "SERVICES", "CAREERS", "PODCAST", "RESOURCES", "CONTACTS", "NEARSURANCE"));
        Assert.assertEquals(header.menuItemNames(header.expandedItemNames(header.aboutMenuItem)), expectedMenuNames);
    }

    @Test
    public void dropdownHomeAddress() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        Assert.assertEquals(header.elementAddressURL(header.homeMenuItem), Constants.BASE_URL);
    }

    @Test
    public void dropdownAboutElements() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        header.aboutMenuItem.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ArrayList<String> expectedMenuItemNames = new ArrayList<>(Arrays.asList(
                Constants.ABOUT, Constants.CLIENTS, Constants.PARTNERS, Constants.LEADERSHIP));
        Assert.assertEquals(header.expandedItemNames(header.aboutMenuItem), expectedMenuItemNames);
    }

    @Test
    public void dropdownAboutAddress() throws InterruptedException {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        header.aboutMenuItem.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ArrayList<String> expectedMenuItemAddresses = new ArrayList<>(Arrays.asList(
                Constants.ABOUT_URL, Constants.CLIENTS_URL, Constants.PARTNERS_URL, Constants.LEADERSHIP_URL));
        Assert.assertEquals(header.expandedItemAddresses(header.aboutMenuItem), expectedMenuItemAddresses);
    }

    @Test
    public void dropdownServicesElements() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        header.servicesMenuItem.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ArrayList<String> expectedMenuItemNames = new ArrayList<>(Arrays.asList(
                Constants.SERVICES, Constants.WORK_MODEL));
        Assert.assertEquals(header.expandedItemNames(header.servicesMenuItem), expectedMenuItemNames);
    }

    @Test
    public void dropdownServicesAddress() throws InterruptedException {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        header.servicesMenuItem.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ArrayList<String> expectedMenuItemAddresses = new ArrayList<>(Arrays.asList(
                Constants.SERVICES_URL, Constants.WORK_MODEL_URL));
        Assert.assertEquals(header.expandedItemAddresses(header.servicesMenuItem), expectedMenuItemAddresses);
    }

    @Test
    public void dropdownCareerElements() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        header.careersMenuItem.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ArrayList<String> expectedMenuItemNames = new ArrayList<>(Arrays.asList(
                Constants.VACANCIES, Constants.WORKING, Constants.INTERSHIP));
        Assert.assertEquals(header.expandedItemNames(header.careersMenuItem), expectedMenuItemNames);
    }

    @Test
    public void dropdownCareerAddress() throws InterruptedException {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        header.careersMenuItem.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ArrayList<String> expectedMenuItemAddresses = new ArrayList<>(Arrays.asList(
                Constants.VACANCIES_URL, Constants.WORKING_URL, Constants.INTERSHIP_URL));
        Assert.assertEquals(header.expandedItemAddresses(header.careersMenuItem), expectedMenuItemAddresses);
    }

    @Test
    public void dropdownPodcastAddress() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        Assert.assertEquals(header.elementAddressURL(header.podcastMenuItem), Constants.PODCAST_URL);
    }


    @Test
    public void dropdownResourcesElements() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        header.resourcesMenuItem.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ArrayList<String> expectedMenuItemNames = new ArrayList<>(Arrays.asList(
                Constants.BLOG, Constants.WHITEPAPERS, Constants.VIDEOS, Constants.MEDIA));
        Assert.assertEquals(header.expandedItemNames(header.resourcesMenuItem), expectedMenuItemNames);
    }

    @Test
    public void dropdownResourcesAddress() throws InterruptedException {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        header.resourcesMenuItem.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ArrayList<String> expectedMenuItemAddresses = new ArrayList<>(Arrays.asList(
                Constants.BLOG_URL, Constants.WHITEPAPERS_URL, Constants.VIDEOS_URL, Constants.MEDIA_URL));
        Assert.assertEquals(header.expandedItemAddresses(header.resourcesMenuItem), expectedMenuItemAddresses);
    }

    @Test
    public void dropdownContactAddress() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        Assert.assertEquals(header.elementAddressURL(header.contactsMenuItem), Constants.CONTACTS_URL);
    }

    @Test
    public void dropdownNearsuranceAddress() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        Assert.assertEquals(header.elementAddressURL(header.nearsuranceMenuItem), Constants.CONTACTS_URL);
    }

    @Test
    public void dropdownNearsuranceColor() {
        HeaderPageFunctions header = new HeaderPageFunctions(driver);
        String expectedColour = "text-orange";
        String itemColour = header.nearsuranceMenuItem.findElement(By.tagName("a")).getAttribute("class");
        Assert.assertEquals(itemColour, expectedColour);
    }
}
