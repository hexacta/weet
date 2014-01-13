grails.project.work.dir = 'target'

def gebVersion = "0.9.0-RC-1"
def seleniumVersion = "2.25.0"
def spockVersion = "0.7"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
//		grailsPlugins()
//		grailsHome()
//		grailsCentral()
//		mavenLocal()
//		mavenRepo "http://repo.grails.org/grails/libs-releases/"
//		mavenRepo "http://m2repo.spockframework.org/ext/"
//		mavenRepo "http://download.java.net/maven/2/"
//		mavenRepo 'http://repo.grails.org/grails/repo'
		
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
		test "org.gebish:geb-spock:$gebVersion"
		test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") { excludes "xml-apis","commons-codec","commons-io" }
		test("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion")
		test("org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"){ excludes "commons-io" }
		test("org.seleniumhq.selenium:selenium-ie-driver:$seleniumVersion")
		test "org.seleniumhq.selenium:selenium-support:$seleniumVersion"
		test("org.seleniumhq.selenium:selenium-remote-driver:$seleniumVersion")
		// test "org.codehaus.geb:geb-junit4:$gebVersion"
		// test("org.spockframework:spock-core:$spockVersion")
    }

    plugins {
        build(':release:2.2.0', ':rest-client-builder:1.0.3') {
            export = false
        }
			  
		test ":geb:$gebVersion"       // Functional testing, based on Selenium.
		test ":spock:$spockVersion"   // It provides a functional specification, giving a better readability to the test.
    }
}

