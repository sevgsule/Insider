package com.insider.stepDefinitions;

import io.cucumber.java.en.When;

public class SearchJobPageSteps {
    com.insider.POM.SearchJobPage searchJobPage = new com.insider.POM.SearchJobPage();

    @When("More butonuna tıklandığında gelen menü içerisinden {string} butonuna tıklanır ve sayfanın açıldığı doğrulanır.")
    public void clickCareersButton(String dropDownCareers) throws InterruptedException {
        searchJobPage.clickCareersButton(dropDownCareers);
    }

  @When("Açılan kariyer sayfası üzerinde {string} , {string} ve {string} ifadelerinin aktif biçimde bulunduğu kontrol edilir.")
    public void CheckTitles(String locations,String teams,String lifeAtInsider) throws InterruptedException {
        searchJobPage.CheckTitles(locations,teams,lifeAtInsider);
    }
  @When("{string} iş ilanları listesi çıkarılır.")
    public void FilterJobLıst(String jobName) throws InterruptedException {
        searchJobPage.FilterJobLıst(jobName);
    }
    @When("İş başvuru sayfası açılır.")
    public void ApplyJobPage() throws InterruptedException {
        searchJobPage.ApplyJobPage();
    }

}

