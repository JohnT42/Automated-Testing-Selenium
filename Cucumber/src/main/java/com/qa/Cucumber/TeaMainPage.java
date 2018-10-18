package com.qa.Cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaMainPage {
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menubutton;
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	private WebElement checkoutbutton;

	public boolean getmenu()  {
		try {
			menubutton.click(); 
			return true;
		} catch (Exception e) {return false;
		}
	}
	public boolean getcheckout() {
		try {
			checkoutbutton.click();return true;
		} catch (Exception e) {return false;
		}
	}
}
