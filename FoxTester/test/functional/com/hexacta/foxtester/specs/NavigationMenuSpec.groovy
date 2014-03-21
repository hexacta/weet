package com.hexacta.foxtester.specs

import spock.lang.*

import com.hexacta.foxtester.pages.HomePage
import com.hexacta.foxtester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage
import com.hexacta.weet.utils.SpringUtils

class NavigationMenuSpec extends com.hexacta.weet.specs.NavigationMenuSpec {

	Map menuConfig = [
		'Clients'        : ['New'    : ['Client', 'Third Party'],
					        'Search' : ['Client', 'Third Party']
						   ],
		'Collection'     : ['New'    : ['Suspense Bank Transfer Lot'],
					        'Search' : ['Suspense Bank Transfer Lots', 'Suspense Bank Transfers']
						   ],
		'Reports'        : ['Reports Administration' : []
						   ],
		'Requests'       : ['Pending Requests' : [],
					        'My Sent Requests' : []
					 	   ],
		'Administration' : ['Product Brand' : [],
					  		'Books' : []
						   ],
		'Security'       : ['Profiles' : [],
					        'Roles' : [],
					        'Users' : [],
					        'Audit' : []
					 	   ]
	]
	
	def setupSpec() {
		username = config.login.username
		password = config.login.password
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