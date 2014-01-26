import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

baseUrl = "http://google.dk"

enum DriverPath {
	firefox(""), chrome("chromedriver"), ie("IEDriverServer.exe")

	DriverPath(executable) {
		this.executable = executable
	}
	private String executable
	private String os = getOS()
	private String arch = getArch()

	def String getOS() {
		String osName = ((String) System.getProperty("os.name")).toLowerCase()
		
		if (osName.contains("windows")) {
			return "windows"
		} else {
		if (osName.contains("linux")) {
			return "linux"
		} else {
		if (osName.contains("mac")) {
			return "mac"
		}
	}

	def String getArch() {
		if (is64Bit()) {
			"64"
		} else {
			"32"
		}
	}

	def is64Bit() {
	}

	public def String getPathToExecutable() {
		"drivers/" + this + "/" + getOS() + "/" + getArch() + "/" + this.executable
	}
}


def setDriverPathAndGetBrowserInstance(DriverPath driver) {
	if (driver != DriverPath.firefox) {
		System.properties["webdriver." + driver + ".driver"] = driver.getPathToExecutable()
	}

	def browserDriver = null
	switch (driver) {
		case DriverPath.firefox:
			return new FirefoxDriver()
			break;
		case DriverPath.chrome:
			return new ChromeDriver()
			break;
		default:
			return new FirefoxDriver()
	}
}

// Set this to control which browser is fired when you execute tests in your IDE
driver = { setDriverPathAndGetBrowserInstance(DriverPath.firefox) }

environments {

	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { setDriverPathAndGetBrowserInstance(DriverPath.chrome) }
	}

	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { setDriverPathAndGetBrowserInstance(DriverPath.firefox) }
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

