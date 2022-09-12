package com.insider.stepDefinitions;

import com.insider.POM.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
    HomePage homePage;

    @When("Anasayfa açılır ve kontrolü sağlanır.")
    public void onHomePage() {
        homePage = new HomePage();
        homePage.openHomePage();
    }

  @When("Açılan ekrandaki üst bar üzerinden {string} butonuna tıklanır.")
    public void clickMoreButton(String toolBarMore) throws InterruptedException {
        homePage.clickMoreButton(toolBarMore);
    }



    @Then("Wait for the home page to load and checkout login")
    public void waitForTheHomePageToLoad() throws InterruptedException {
        homePage.waitForHomePageToLoad();
        homePage.checkoutLogin();
    }
}


