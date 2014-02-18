import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.ie.InternetExplorerDriver

// run as grails test-app -functional
// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = { 
	def driver = new HtmlUnitDriver()
	driver.javascriptEnabled = true
	driver
}

baseUrl = "http://mordor.hexacta.com:8181/qapplication/"
reportsDir = new File("target/geb-reports")
// Currently this flag is only supported by the TestNG adapter. Support for JUnit, Spock and other frameworks is forthcoming.
reportOnTestFailureOnly = true

waiting {
	timeout = 2
	retryInterval = 0.1
}

environments {
	
    // run as grails -functional -Dgeb.env=chrome -Dwebdriver.chrome.driver=..\browser-drivers\chromedriver.exe 
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run as grails test-app -functional -Dgeb.env=firefox
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		FirefoxProfile profile = new FirefoxProfile()
		//explicitly enable native events(this is mandatory on Linux system, since they
		//are not enabled by default
		profile.setEnableNativeEvents(true)
		driver = { new FirefoxDriver(profile) }
	}

    // run as grails test-app -functional -Dgeb.env=ie -Dwebdriver.ie.driver=..\browser-drivers\IEDriverServer.exe
	ie {
		driver = { new InternetExplorerDriver() }
	}

}