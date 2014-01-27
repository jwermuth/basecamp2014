package org.basecamp.pages

import geb.Browser
import geb.Page
import geb.Module
 
// modules are reusable fragments that can be used across pages that can be paramaterised
// here we are using a module to model the search function on the home and results pages
class GoogleSearchModule extends Module {
 
    // a paramaterised value set when the module is included
    def buttonValue
 
    // the content DSL
    static content = {
 
        // name the search input control “field”, defining it with the jQuery like navigator
        field { $("input", name: "q") }
 
        // the search button declares that it takes us to the results page, and uses the 
        // parameterised buttonValue to define itself
        button(to: GoogleResultsPage) { 
            $("input", value: buttonValue)
        }
    }
}
 