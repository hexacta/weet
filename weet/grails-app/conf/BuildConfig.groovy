grails.project.work.dir = 'target'

def spockVersion = "0.7"
def seleniumVersion = "2.39.0"
def gebVersion = "0.9.2"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility
    repositories {
        grailsCentral()
        mavenCentral()
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.21'
		test "org.gebish:geb-spock:$gebVersion"
		test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") { excludes "xml-apis","commons-codec","commons-io" }
		test("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion")
		test("org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"){ excludes "commons-io" }
		test("org.seleniumhq.selenium:selenium-ie-driver:$seleniumVersion")
		test "org.seleniumhq.selenium:selenium-support:$seleniumVersion"
		test("org.seleniumhq.selenium:selenium-remote-driver:$seleniumVersion")
		
		test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }

    plugins {
        build(":tomcat:$grailsVersion",
              ":release:2.2.1",
              ":rest-client-builder:1.0.3") {
            export = false
        }
			  
 		// It provides a functional specification, giving a better readability to the test.
		test ":spock:$spockVersion" {
			exclude "spock-grails-support"
		}
		
		// Functional testing, based on Selenium.
		 test ":geb:$gebVersion"       
    }
}
