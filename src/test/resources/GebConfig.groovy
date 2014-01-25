import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.remote.CommandExecutor
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

baseUrl = "http://google.dk"

//driver = { new FirefoxDriver() }
//driver = {new HtmlUnitDriver() }
driver = { new ChromeDriver() }


environments {

    // run via “./gradlew chromeTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = { new ChromeDriver() }
    }

    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }
	
	htmlunit {
		driver = { new HtmlUnitDriver() }
	}

////    ie {
////        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
////        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
////        driver = {new InternetExplorerDriver(ieCapabilities)}
////    }
}



reportsDir = new File("geb-reports")
reportOnTestFailureOnly = true

// Wait for all at's, e.g. static at = { title == "Some title" }
atCheckWaiting = 20

