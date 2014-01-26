package org.basecamp.pages

import geb.junit4.GebReportingTest

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class PageTest extends GebReportingTest {
	
	@Test
	void loadpage () {
		given:
		
		when:
		to GoogleSearch
		
		then:
		at GoogleSearch
	}
}
