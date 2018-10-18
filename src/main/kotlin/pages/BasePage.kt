package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

open class BasePage(val driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }


}