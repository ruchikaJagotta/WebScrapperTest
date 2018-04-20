# WebScrapperTest
This is repository for Test basic Webscrapper login function

## Softwares used: 
 
1.Eclipse IDE 

2.Selenium Server             version 3.11.0

3.Apache maven plugin         eclipse embedded

4.ChromeDriver                Version 65.0.3325.181 (Official Build)

5.TestNG                      Version 6.9.4

### Environment Setup

Clone or download source from project code. Clone repository to eclipse git repositories. 
Import project from cloned git repository. It is an maven project.

Install TestNG plugin to eclpise if it is not installed.

## Running the tests via Eclipse

Open or navigate to TestLogin.java file and run as TestNG.
```
Run As TestNG > TestLogin.java 
```

## Running the tests via command line mvn . 
>Navigate to Base folder when project source is extracted.

```
mvn clean install 
```

#Note: 
In case, interactive Selenium Driver need to be tested, uncomment below section from TestLogin.java in getWebDriver() method.

```
/*  
    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    driver = new ChromeDriver();
  */
```
And comment section for HtmlUnitDriver. 
```
driver = new HtmlUnitDriver(true);
```
