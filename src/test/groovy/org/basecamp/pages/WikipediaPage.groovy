package org.basecamp.pages

import geb.Page

class WikipediaPage extends Page {
    static at = { title.startsWith("Wikipedia") }
}