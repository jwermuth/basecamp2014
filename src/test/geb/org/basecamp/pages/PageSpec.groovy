package org.basecamp.pages

import geb.spock.GebReportingSpec;
import geb.spock.GebSpec

class PageSpec extends GebReportingSpec {
	
	def loadpage () {
		given:
		
		when:
		to GoogleSearch
		
		then:
		at GoogleSearch
	}
}
