package com.hexacta.weet.utils

import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
import org.springframework.context.ApplicationContext

/**
 * Provides string utility methods.
 * 
 * @author gmassenzano
 */
class SpringUtils {

	static def servletContext = ServletContextHolder.getServletContext()
	
	static getConfig() {
		ApplicationContext appContext = servletContext.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT)
		def grailsApplication = appContext.getBean('grailsApplication')
		def config = grailsApplication.config
	}

}
