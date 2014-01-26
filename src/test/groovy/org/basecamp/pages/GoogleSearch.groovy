package org.basecamp.pages

import geb.Page;

class GoogleSearch extends Page {
	static url = "http://google.dk"
	static at = { title == "Google" }
}
