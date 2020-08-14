package PageObject.PageFunctions;

import PageObject.PageElements.HeaderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HeaderPageFunctions extends HeaderPage {

    public HeaderPageFunctions(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {

        return headerContainer.isDisplayed();
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public String elementAddressURL(WebElement element) {
        return element.findElement(By.tagName("a")).getAttribute("href");
    }

    public boolean isSubscribeBtnDisplayed() {
        return subscribeBtn.isDisplayed();
    }

    public int menuItemsNumber() {
        return menuItemsContainer.size();
    }

    public List<String> menuItemNames(List<String> strings) {
        List<String> list = new ArrayList<>();
        for (WebElement item : menuItemsContainer) {
            list.add(item.getText());
        }
        return list;
    }
    public List<String> expandedItemNames(WebElement element)  {
        List<WebElement> expandedElements = element.findElements(By.tagName("a"));
        List<String> list = new ArrayList<>();
        for (WebElement item : expandedElements) {
            list.add(item.getText());
        }
        return list;
    }

    public List<String> expandedItemAddresses(WebElement element) {
        List<WebElement> expandedElements = element.findElements(By.tagName("a"));
        List<String> list = new ArrayList<>();
        for (WebElement item : expandedElements) {
            list.add(item.getAttribute("href"));
        }
        return list;
    }
}
