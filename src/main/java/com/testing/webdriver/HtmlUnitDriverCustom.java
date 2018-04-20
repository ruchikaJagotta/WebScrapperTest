package com.testing.webdriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;

/**
 * This class has been created to override HtmlUnitDriver WebClient options for
 * RedirectEnabled.
 *
 */
public class HtmlUnitDriverCustom extends HtmlUnitDriver {

	public HtmlUnitDriverCustom(boolean javascriptEnabled) {
		super(javascriptEnabled);
	}

	@Override
	public WebClient modifyWebClient(WebClient client) {
		client.getOptions().setRedirectEnabled(false);
		return client;
	}

}
