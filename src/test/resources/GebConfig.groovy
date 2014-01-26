import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

baseUrl = "http://google.dk"

enum OperatingSystem {
	windows, linux, mac;

	static def OperatingSystem getOS() {
		String osName = ((String) System.getProperty("os.name")).toLowerCase()

		if (osName.contains("windows")) {
			return OperatingSystem.windows
		} else {
			if (osName.contains("linux")) {
				return OperatingSystem.linux
			} else {
				if (osName.contains("mac")) {
					return OperatingSystem.mac
				}
			}
		}
	}

	static def String getArch() {
		if (is64Bit()) {
			"64"
		} else {
			"32"
		}
	}

	private static def is64Bit() {
		System.getProperty("os.arch").contains("64")
	}
}

enum Browser {
	firefox, chrome, ie

	def String getExecutable() {
		switch (OperatingSystem.getOS()) {
			case (OperatingSystem.linux):
				switch (this) {
					case (chrome):
					return "chromedriver"
					break;
				}
				break;
			case (OperatingSystem.windows):
				switch (this) {
					case (chrome):
					return "chromedriver.exe"
					break;
					case (ie):
					return "IEDriverServer.exe"
					break;
				}
		}
	}

	public def String getPathToExecutable() {
		"drivers/" + this + "/" + OperatingSystem.getOS() + "/" + OperatingSystem.getArch() + "/" + getExecutable()
	}
}


def setDriverPathAndGetBrowserInstance(Browser driver) {
	if (driver != Browser.firefox) {
		System.properties["webdriver." + driver + ".driver"] = driver.getPathToExecutable()
	}

	def browserDriver = null
	switch (driver) {
		case Browser.firefox:
			return new FirefoxDriver()
			break;
		case Browser.chrome:
			return new ChromeDriver()
			break;
		default:
			return new FirefoxDriver()
	}
}

// Set this to control which browser is fired when you execute tests in your IDE
driver = { setDriverPathAndGetBrowserInstance(Browser.chrome) }

environments {

	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { setDriverPathAndGetBrowserInstance(Browser.chrome) }
	}

	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { setDriverPathAndGetBrowserInstance(Browser.firefox) }
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

