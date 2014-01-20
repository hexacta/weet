package com.hexacta.googlewebtest.pages

import com.hexacta.web_test_robot.AbstractPage

class WikipediaPage extends AbstractPage {
    static at = {  title.startsWith "Wikipedia" }
}