package com.hexacta.googlewebtester.pages.modules

import com.hexacta.googlewebtester.pages.GoogleResultsPage
import com.hexacta.webtester.modules.AbstractModule;

/**
 * We are using a module to model the search function on the home and results pages.
 * 
 * @author gmassenzano
 */
class GoogleSearchModule extends AbstractModule {
 
    // a parameterized value set when the module is included
    def buttonValue
 
    // the content DSL
    static content = {
 
        // name the search input control “text”, defining it with the jQuery like navigator
        text { $("input", name: "q") }
 
        // the search button declares that it takes us to the results page, and uses the 
        // Parameterized buttonValue to define itself
        button(to: GoogleResultsPage) { 
            $("input", value: buttonValue)
        }
    }
}