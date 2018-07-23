package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class BasePage(val driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }


}