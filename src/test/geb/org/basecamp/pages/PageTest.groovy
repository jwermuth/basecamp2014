package org.basecamp.pages

import geb.spock.GebSpec

class PageTest extends GebSpec {
	
	def loadpage () {
		given:
		
		when:
		to GoogleSearch
		
		then:
		at GoogleSearch
	}
}
