package com.hexacta.googletester.pages.modules

import com.hexacta.googletester.pages.GoogleResultsPage
import com.hexacta.weet.modules.WeetModule;

/**
 * We are using a module to model the search function on the home and results pages.
 * 
 * @author gmassenzano
 */
class GoogleSearchModule extends WeetModule {
 
    // the content DSL
    static content = {
 
        // name the search input control “text”, defining it with the jQuery like navigator
        text { $("input", name: "q") }
 
        // the search button 
        button { $("button", name: "btnG") }
    }
}