package PageObject.PageElements;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Collections;
import java.util.List;

public class HeaderPage extends BasePage {

    @FindBy(id = "main-menu")
    protected WebElement headerContainer;

    @FindBys(@FindBy(className = "bar__module"))
    protected List<WebElement> headerSections;

    @FindBys(@FindBy(css = "li.dropdown"))
    protected List<WebElement> menuItemsContainer;

    public WebElement logo = headerSections.get(0);

    public WebElement subscribeBtn = headerSections.get(2);

    public WebElement homeMenuItem = menuItemsContainer.get(0);

    public WebElement aboutMenuItem = menuItemsContainer.get(1);

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

}
