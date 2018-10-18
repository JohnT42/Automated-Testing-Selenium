package com.qa.Cucumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaStep {
	WebDriver driver = null;
	TeaMainPage tmp;
	TeaMenuPage tmp2;
	ExtentTest test;
	static ExtentReports report;
	static int testcounter = 0;

	@Before
	public void setup() throws Throwable {
		System.setProperty(CucumberConstant.webdriver, CucumberConstant.webdriverpath);
		driver = new ChromeDriver();
		tmp = PageFactory.initElements(driver, TeaMainPage.class);
		tmp2 = PageFactory.initElements(driver, TeaMenuPage.class);
		if (testcounter == 0) {
			report = new ExtentReports(CucumberConstant.reportpath, true);
		} else {
			report.endTest(test);
		}
		testcounter++;
	}

	@After
	public void teardown() {
		driver.quit();
		report.flush();

	}

	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
		driver.manage().window().maximize();
		driver.get(CucumberConstant.URL1);
		String url = driver.getCurrentUrl();
		if (testcounter == 1) {
			test = report.startTest("Test Browse Scenario");
		} else if (testcounter == 2) {
			test = report.startTest("Test Checkout Scenario");
		}
		if (url.equals(CucumberConstant.URL1)) {
			test.log(LogStatus.PASS, "Web address verified");
		} else {
			test.log(LogStatus.FAIL, "Unable to verify the web address");

			assertEquals(url, CucumberConstant.URL1);
		}
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
		boolean a = tmp.getmenu();

		String url2 = driver.getCurrentUrl();
		if (a == true) {
			test.log(LogStatus.PASS, "Menu button functionality verified");
		} else {
			test.log(LogStatus.FAIL, "Unable to verify menu button functionality");
		}

		if (url2.equals(CucumberConstant.URL2)) {
			test.log(LogStatus.PASS, "Navigation to the Menu Page verified");
		} else {
			test.log(LogStatus.FAIL, "Unable to verify navigation to the Menu Page");
		}
		assertEquals(a, true);
		assertEquals(url2, CucumberConstant.URL2);
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		if (tmp2.getText1().equals("Green Tea") && tmp2.getText2().equals("Red Tea")
				&& tmp2.getText3().equals("Oolong Tea")) {
			test.log(LogStatus.PASS, "Verified list of the available products");
		} else {
			test.log(LogStatus.FAIL, "Unable to verify list of the available products");
		}
		report.endTest(test);
		assertEquals("Green Tea", tmp2.getText1());
		assertEquals("Red Tea", tmp2.getText2());
		assertEquals("Oolong Tea", tmp2.getText3());

	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		boolean b = tmp.getcheckout();
		if (b == true) {
			test.log(LogStatus.PASS, "Checkout button functionality verified");
		} else {
			test.log(LogStatus.FAIL, "Unable to verify checkout button functionality");
		}
		assertEquals(b, true);

	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
		String url3 = driver.getCurrentUrl();
		assertEquals(url3, CucumberConstant.URL3);
		if (url3.equals(CucumberConstant.URL3)) {
			test.log(LogStatus.PASS, "Navigation to the Checkout Page verified");
		} else {
			test.log(LogStatus.FAIL, "Unable to verify navigation to the Checkout Page");
		}
	}

}
