package com.qa.Cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaMenuPage {
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement greenteaText;
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong")
	private WebElement redteaText;
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong")
	private WebElement oolongteaText;

	public String getText1() {
		return greenteaText.getText();
	}

	public String getText2() {
		return redteaText.getText();
	}

	public String getText3() {
		return oolongteaText.getText();
	}

}
