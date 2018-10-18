package core

import managers.PageObjectManager
import managers.WebDriverManager

object Context {
    val driverManager: WebDriverManager = WebDriverManager()
    val pages: PageObjectManager = PageObjectManager(driverManager.driver)

}