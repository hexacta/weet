
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

// run as grails -baseUrl="http://localhost:8080/liquidacion-haberes" -functional test-app
// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = { 
	def driver = new HtmlUnitDriver()
	driver.javascriptEnabled = true
	driver
}

environments {
	
    // run as grails -baseUrl="https://hxgna01:8443/liquidacion-haberes/" -functional -Dgeb.env=chrome -Dwebdriver.chrome.driver=..\browser-drivers\chromedriver.exe test-app
	// -DDataBase=jdbc:jtds:Sqlserver://hxsqldev:1433/GNA_LiqHaberes1;instance=sql2008 -DDataBaseUser=gnaslh -DDataBasePass=epchm
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run as grails -baseUrl="https://hxgna01:8443/liquidacion-haberes/" -functional -Dgeb.env=firefox test-app
	// -DDataBase=jdbc:jtds:Sqlserver://hxsqldev:1433/GNA_LiqHaberes1;instance=sql2008 -DDataBaseUser=gnaslh -DDataBasePass=epchm
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}

    // run as grails -baseUrl="https://hxgna01:8443/liquidacion-haberes/" -functional -Dgeb.env=ie -Dwebdriver.ie.driver=..\browser-drivers\IEDriverServer.exe test-app
	// -DDataBase=jdbc:jtds:Sqlserver://hxsqldev:1433/GNA_LiqHaberes1;instance=sql2008 -DDataBaseUser=gnaslh -DDataBasePass=epchm
	ie {
		driver = { new InternetExplorerDriver() }
	}

}