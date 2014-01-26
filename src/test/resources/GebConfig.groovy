import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

import com.sun.java.util.jar.pack.Instruction.Switch;

baseUrl = "http://google.dk"

enum Driver { firefox, chrome
	Driver() {
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
	
	def getPathToExecutable() {
		if (isWindows()) {
			if (is64Bit()) {
				
			} else {
			
			}
		} else if (isLinux()) {
			if (is64Bit()) {
				"/home/jaw/workspaces/basecamp/pure-gradle/drivers/chrome/linux/64/chromedriver"
			} else {
			
			}
		}
	}
	
}


def setDriverPathAndGetBrowserInstance(Driver driver) {
	if (driver != Driver.firefox) {
		System.properties["webdriver." + driver + ".driver"] = driver.getPathToExecutable()
	}
	
	def browserDriver = null
	switch (driver) {
		case Driver.firefox:
			return new FirefoxDriver()
			break;
		case Driver.chrome:
			return new ChromeDriver()
			break;
		default:
			return new FirefoxDriver()
			
	}
}

// Set this to control which browser is fired when you execute tests in your IDE
driver = { setDriverPathAndGetBrowserInstance(Driver.firefox) }

environments {

    // run via “./gradlew chromeTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = setDriverPathAndGetBrowserInstance(Driver.chrome)
	}

    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = setDriverPathAndGetBrowserInstance(Driver.firefox)
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

