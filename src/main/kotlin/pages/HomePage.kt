package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class HomePage(driver: WebDriver, relativeUrl: String) : BasePage(driver, relativeUrl) {

    @FindBy(xpath = "//div[@class='lst-c']")
    lateinit var search: WebElement

    fun isSearchDisplayed(): Boolean {
        return search.isDisplayed
    }
}