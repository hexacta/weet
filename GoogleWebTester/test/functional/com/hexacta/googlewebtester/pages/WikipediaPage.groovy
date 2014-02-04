package com.hexacta.googlewebtester.pages

import com.hexacta.webtester.AbstractPage

class WikipediaPage extends AbstractPage {
    static at = {  title.startsWith "Wikipedia" }
}