package com.hexacta.liqhabtester.specs

import groovy.sql.Sql

import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
import org.springframework.context.ApplicationContext

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.webtester.specs.CRUDSpec
abstract class LiquidacionHaberesCRUDSpec extends CRUDSpec {

	@Shared Sql sql
	
	static def servletContext = ServletContextHolder.getServletContext()
	
	def setupSpec() {
		def config = getConfig()
		def dbUrl = config.dbUrl
		def dbUser = config.dbUser
		def dbPassword = config.dbPassword
		sql = Sql.newInstance(dbUrl, dbUser, dbPassword, 'net.sourceforge.jtds.jdbc.Driver' )
	}

	static getConfig() {
		ApplicationContext appContext = servletContext.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT)
		def grailsApplication = appContext.getBean('grailsApplication')
		def config = grailsApplication.config
	}
	
	def getInitialPage() {
		HomePage
	}
	
	def getLoginPage() {
		LoginPage
	}
}