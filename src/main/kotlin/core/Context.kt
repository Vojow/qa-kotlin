package core

import managers.PageObjectManager
import managers.WebDriverManager

object Context {
    var driverManager: WebDriverManager = WebDriverManager()
    var pages: PageObjectManager

    init {
        pages = PageObjectManager(driverManager.driver)
    }

}