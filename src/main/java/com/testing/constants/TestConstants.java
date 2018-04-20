package com.testing.constants;

public interface TestConstants {
	public static final String URL_APPLICATION = "http://testing-ground.scraping.pro/login";

	// Messages to be checked
	public static final String RESULT_WELCOME_TEXT = "WELCOME :)";
	public static final String RESULT_ACCESS_DENIED_TEXT = "ACCESS DENIED!";
	public static final String RESULT_MISSING_COOKIE_TEXT = "THE SESSION COOKIE IS MISSING OR HAS A WRONG VALUE!";
	public static final String RESULT_REDIRECTING_TEXT = "REDIRECTING...";

	// Element Locators
	public static final String RESULT_FIELD_XPATH = "//*[@id=\"case_login\"]/h3";
	public static final String LINK_BACK_XPATH = "//*[@id=\"case_login\"]/a";
	public static final String USER_FIELD_ID = "usr";
	public static final String PWD_FIELD_ID = "pwd";
	public static final String FORM_LOGIN = "form";
	public static final String LABEL_LOGIN_TEXT = "Please, login:";
	
	/*
	 *  Data to login
	 */
	public static final String USER_NAME_CORRECT = "admin";
	public static final String PASSWORD_CORRECT = "12345";
	
	public static final String USER_NAME_INCORRECT = "dummy";
	public static final String PASSWORD_INCORRECT = "dummy";	
}
