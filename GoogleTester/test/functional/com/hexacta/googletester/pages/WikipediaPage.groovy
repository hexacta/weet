package com.hexacta.googletester.pages

import com.hexacta.weet.pages.AbstractPage;

class WikipediaPage extends AbstractPage {
    static at = {  title.startsWith "Wikipedia" }
}