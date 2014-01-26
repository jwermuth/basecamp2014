import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

import com.sun.java.util.jar.pack.Instruction.Switch;

baseUrl = "http://google.dk"

//driver = {new HtmlUnitDriver() }
//driver = { new ChromeDriver() }
//driver = { new FirefoxDriver() }
//driver = "firefox"

// Set env to run with chrome
driver = setDriverPath("chrome")

def setDriverPath(browserName) {
	System.properties["webdriver." + browserName + ".driver"] = getDriver()
	browserName
}

def is64Bit() {
	System.getProperty("os.arch").contains("64")
}

def isWindows() {
	System.getProperty("os.name").toLowerCase().contains("windows")
}

def isLinux() {
	System.getProperty("os.name").toLowerCase().contains("linux")
}

def getDriver() {
	if (isWindows()) {
		if (is64Bit()) {
			
		} else {
		
		}
	} else if (isLinux()) {
		if (is64Bit()) {
			"/home/jaw/workspaces/basecamp/pure-gradle/drivers/chrome/chromedriver"
		} else {
		
		}
	}
}

environments {

    // run via “./gradlew chromeTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
/*    chrome {
        driver = { new ChromeDriver() }
    }
*/
    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	chrome {
		setDriverPath("chrome")
		driver = { new ChromeDriver() }
	}

    firefox {
        driver = { new FirefoxDriver() }
    }
	
/*	htmlunit {
		driver = { new HtmlUnitDriver() }
	}
*/
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

