import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities

baseUrl = "http://mordor.hexacta.com:8181/qapplication/"

// --------------------------------------------------------------------------------------------
//  Reports
// --------------------------------------------------------------------------------------------
reportsDir = new File("target/geb-reports")
// Currently this flag is only supported by the TestNG adapter. Support for JUnit, Spock and other frameworks is forthcoming.
reportOnTestFailureOnly = true

// --------------------------------------------------------------------------------------------
//  Waiting
// --------------------------------------------------------------------------------------------
waiting {
	timeout = 2
	retryInterval = 0.1
}

// --------------------------------------------------------------------------------------------
//  Driver
// --------------------------------------------------------------------------------------------

// run as grails test-app -functional
// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = {
	def driver = new HtmlUnitDriver()
	driver.javascriptEnabled = true
	driver
}

def locale = "es"

environments {
	
    // run as grails -functional -Dgeb.env=chrome -Dwebdriver.chrome.driver=[path_to_driver] 
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		setDefaultSystemProperty("webdriver.chrome.driver","..\\browser-drivers\\chromedriver.exe")
		
		ChromeOptions options = new ChromeOptions()
		options.addArguments("--lang=$locale")
		driver = { new ChromeDriver(options) }
	}
	
	// run as grails test-app -functional -Dgeb.env=firefox
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		FirefoxProfile profile = new FirefoxProfile()
		profile.setPreference( "intl.accept_languages", locale )
		profile.setPreference( "app.update.enabled", false)
		profile.setPreference( "browser.tabs.autoHide", true)
		//explicitly enable native events(this is mandatory on Linux system, since they are not enabled by default
		profile.setEnableNativeEvents(true)
		driver = { new FirefoxDriver(profile) }
	}

    // run as grails test-app -functional -Dgeb.env=ie -Dwebdriver.ie.driver=[path_to_driver]
	ie {
		setDefaultSystemProperty("webdriver.ie.driver","..\\browser-drivers\\IEDriverServer.exe")
		
		// Protected Mode must be set to the same value (enabled or disabled) for all zones.
		// Get around it by using the INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS capability,
		// with a potential that some flakiness/ unreliability could be gotten while performing certain actions in IE.
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer()
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true)
		driver = { new InternetExplorerDriver(ieCapabilities) }
	}

}

/**
 * Set a system property if the received key is not previously defined.
 */
private void setDefaultSystemProperty(String key, String value) {
	if (System.getProperty(key) == null) {
		System.setProperty(key, value)
	}
}