package managers

import org.openqa.selenium.WebDriver
import pages.HomePage

class PageObjectManager(var driver: WebDriver) {

    private var homePage: HomePage = HomePage(driver, "")


    fun getHomePage(): HomePage {
        return homePage
    }
}