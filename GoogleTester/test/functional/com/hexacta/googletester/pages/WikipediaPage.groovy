package com.hexacta.googletester.pages

import com.hexacta.weet.pages.WeetPage;

class WikipediaPage extends WeetPage {
    static at = {  title.startsWith "Wikipedia" }
}