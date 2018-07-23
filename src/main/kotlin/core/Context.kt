package core

import managers.PageObjectManager
import managers.WebDriverManager

class Context {
    val driverManager = WebDriverManager()
    val pages = PageObjectManager(driverManager.driver!!)

    init {

    }

}