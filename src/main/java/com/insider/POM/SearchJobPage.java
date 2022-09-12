package com.insider.POM;

import com.insider.Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchJobPage extends BasePage {

    private static final String except_Url = "https://useinsider.com/careers/";

    @FindBy(xpath= "//a[@id='wt-cli-accept-all-btn']")
    private WebElement popUp;

    @FindBy(xpath = "//a[contains(@class,'d-flex')]/h5[contains(text(),'Careers')]")
    private WebElement moreToolBarCareers;
    @FindBy(xpath = "//span[@title='Quality Assurance']")
    private WebElement filterbyDepartment;

    @FindBy(xpath = "//h3[contains(text(),'Our Locations ')]")
    private WebElement ourLocations;

    @FindBy(xpath = "//h2[contains(text(),'Life at Insider')]")
    private WebElement txtLifeAtInsider;

    @FindBy(xpath = "//h3[contains(text(),'Quality Assurance')]")
    private WebElement qualityAssuranceButton;
    @FindBy(xpath = "//label[contains(text(),'Filter by Department')]")
    private WebElement filterbyDepartment1;

    @FindBy(xpath = "//a[contains(text(),'See all teams')]")
    private WebElement seeAllTeamsButton;

    @FindBy(xpath="//p[contains(text(),'Hesabım')]")
    private WebElement accountButton;

    @FindBy(xpath="//div[@class='button-group d-flex flex-row']")
    private WebElement allQAJobsBtn;

    @FindBy(xpath="//*[@id='select2-filter-by-location-container']")
    private WebElement allQAJobsBtn2;

    @FindBy(xpath="//option[contains(text(),'Istanbul')]")
    private WebElement Istanbul;

    @FindBy(xpath="//div[2]/div/a[contains(text(),'Apply Now')]")
    private WebElement QaulityAssuranceApplyButton;

    @FindBy(xpath="//*[@id='jobs-list']/div[1]//p[contains(text(),'Software QA Tester')]")
    private WebElement job1;

    @FindBy(xpath="//*[@id='jobs-list']/div[2]//p[contains(text(),'Software Quality Assurance Engineer')]")
    private WebElement job2;
    @FindBy(xpath="//h2[contains(text(),'Software Quality Assurance Engineer')]")
    private WebElement resultQATitle;

    @FindBy(xpath ="//a[contains(text(),'Apply for this job')]")
    private WebElement resultApplyButton;

    @FindBy(xpath = "//div[contains(text(),'Istanbul, Turkey')]")
    private WebElement resultIstanbul;

    WebDriver driver;

    public SearchJobPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickCareersButton(String dropDownCareers) throws InterruptedException {
        Assert.assertEquals(dropDownCareers,getText(moreToolBarCareers));
        click(moreToolBarCareers);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),except_Url);
        wait.until(ExpectedConditions.elementToBeClickable(popUp));
        click(popUp);
    }
    public void CheckTitles(String locations,String teams,String lifeAtInsider) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2450)", "");
        Assert.assertTrue(seeAllTeamsButton.getText().contains(teams),"terimler eşleşmiyor");
        Assert.assertTrue(ourLocations.getText().contains(locations),"terimler eşleşmiyor");
        js.executeScript("window.scrollBy(0,1450)", "");
        Assert.assertEquals(txtLifeAtInsider.getText(),lifeAtInsider,"terimler eşleşmiyor");
    }
  public void FilterJobLıst(String jobName) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
      Thread.sleep(9000);
        js.executeScript("window.scrollBy(1450,900)", "");
        Thread.sleep(9000);
        click(seeAllTeamsButton);
        js.executeScript("window.scrollBy(1450,2100)", "");
        Thread.sleep(9000);
        click(qualityAssuranceButton);
        click(allQAJobsBtn);
        click(allQAJobsBtn2);
        click(Istanbul);
        click(filterbyDepartment1);
        js.executeScript("window.scrollBy(0,600)", "");
        Thread.sleep(9000);
        isEnabled(job1);
        isEnabled(job2);
        isEnabled(filterbyDepartment);
        Thread.sleep(9000);
        hoverElement(QaulityAssuranceApplyButton);
        Thread.sleep(9000);
    }

    public void ApplyJobPage() {
        switchToScreen();
        isEnabled(resultQATitle);
        isEnabled(resultApplyButton);
        isEnabled(resultIstanbul);
    }

}
