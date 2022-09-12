package com.insider.POM;
import com.insider.Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@id='mega-menu-1']/span[contains(text(),'More')]")
    private WebElement moreToolBarMore;

    @FindBy(id = "Group-38")
    private WebElement popupLocator;

    @FindBy(xpath = "//div[@id='myAccount']//span[contains(text(),'Hesabım')]")
    private WebElement checkoutMyAccount;


    WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickAcceptPopupButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(popupLocator));
        click(popupLocator);
    }

    public void waitForHomePageToLoad() throws InterruptedException {
        Thread.sleep(3000);
    }

   public void clickMoreButton(String toolBarMore) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)", "");
        Assert.assertEquals(toolBarMore,getText(moreToolBarMore));
        click(moreToolBarMore);
        Thread.sleep(3000);
    }

    public void checkoutLogin() {
        var x = wait.until(ExpectedConditions.visibilityOf(checkoutMyAccount)).isDisplayed();
        Assert.assertTrue(x);
    }
}
