package com.kommuru.steps;

import com.kommuru.page.SearchPage;
import com.kommuru.page.BasePage;
import com.kommuru.page.CarRegistraionPage;
import com.kommuru.utils.FileHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

/**
 * The class is used for step definitions
 *
 * @author Nagendra Kommuru
 */
public class CheckRegistrationStepDef extends BasePage {

    private List<String> regNumbers;
    private SearchPage searchpage;
    private CarRegistraionPage carRegistraionPage;
    private Map<String, List<String>> listMap;

    @Before
    public void setup() {
        BasePage.initializeBrowser();
    }

    @Given("^user navigates to car tax check site and read registation numbers from input file (.*)$")
    public void userNavigatesToCarTaxCheckSiteAndReadRegistationNumbersFromInputFile(String inputFileName) throws IOException {
        regNumbers = FileHelper.getRegNumber(inputFileName);
    }

    @When("^i enter registration number and click on search button$")
    public void iEnterRegistrationNumberAndClickOnSearchButton() {
        listMap = new HashMap<String, List<String>>();
        searchpage = new SearchPage();
        for (String carRegistrationNumber : regNumbers) {
            List<String> list = new ArrayList<String>();
            carRegistraionPage = searchpage.sendRegistraionNum(carRegistrationNumber);
            list.add(carRegistraionPage.getRegistrionNumber());
            list.add(carRegistraionPage.getMake());
            list.add(carRegistraionPage.getModel());
            list.add(carRegistraionPage.getColour());
            list.add(carRegistraionPage.getYear());
            listMap.put(carRegistrationNumber, list);
            searchpage.searchOption();
        }
    }

    @Then("^verify the car registration details with output file (.*)$")
    public void verifyTheCarRegistrationDetailsWithOutputFile(String outputFileName) throws IOException {
        Map<String, List<String>> expectedMap = FileHelper.expectedRecords(outputFileName);
        for (Map.Entry<String, List<String>> entry : expectedMap.entrySet()) {
            System.out.println("Expected Key : " + entry.getKey() + ", Value : " + entry.getValue());

        }
        for (Map.Entry<String, List<String>> entry : listMap.entrySet()) {
            System.out.println("Actual Key : " + entry.getKey() + ", Value : " + entry.getValue());

        }

        assertFalse(listMap.equals(expectedMap));
    }

    @After
    public void tearDown() {
        BasePage.close();
    }

}

