package com.hexacta.liqhabtester.specs

import groovy.sql.Sql
import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage
import com.hexacta.weet.specs.CRUDSpec
abstract class LiquidacionHaberesCRUDSpec extends CRUDSpec {

	@Shared Sql sql
	
	def setupSpec() {
		def dbUrl = config.dbUrl
		def dbUser = config.dbUser
		def dbPassword = config.dbPassword
		sql = Sql.newInstance(dbUrl, dbUser, dbPassword, 'net.sourceforge.jtds.jdbc.Driver' )
	}
	
	@Override
	Class<? extends WeetPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<? extends LoginPage> getLoginPage() {
		LoginPage
	}
}