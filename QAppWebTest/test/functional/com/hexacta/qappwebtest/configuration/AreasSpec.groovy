package com.hexacta.qappwebtest.configuration

import static com.hexacta.qappwebtest.pages.QAppEntityListPage.*
import static com.hexacta.qappwebtest.pages.QAppEntityPage.*
import static com.hexacta.qappwebtest.pages.QApplicationPage.*
import spock.lang.*

import com.hexacta.qappwebtest.specs.QApplicationSpec

@Stepwise
class AreasSpec extends QApplicationSpec {
	def setup() {
		given:
		def submenu = menu.clickItem(CONFIGURATION)
		submenu.item(CONF_AREAS).click(AreasPage)
	}


    def "Area creation"() {
        given: ""
		pageMenu.item(NEW).click(AreaNewPage)
        
        when: ""
		name = "webtest-area"
		create.click(AreaShowPage)
		
		then:
		// waitFor { at AreaShowPage }
		name == "webtest-area"
    }

	@Ignore
    def "Area update"() {
        given: ""
		pageMenu.item(NEW).click(AreaNewPage)
        
        when: ""
		name = "webtest-area"
		create
		
		then:
		waitFor { at AreaShowPage }
		name == "webtest-area"
    }

}