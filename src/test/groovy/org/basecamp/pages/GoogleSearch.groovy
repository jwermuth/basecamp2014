package org.basecamp.pages

import geb.Page;

class GoogleSearch extends Page {
	static url = "http://google.dk"
	static at = { title == "Google" }
	static content = {
		input  { $("input", id:"gbqfq", name:"q") }
		searchButton  { $("button.gbqfba") } 
	}
	
	
	def search(q) {
		input << q
		searchButton.click()
	}
	
}
