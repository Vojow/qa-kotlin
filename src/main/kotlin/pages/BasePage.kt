package pages

import core.Context
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import utils.ConfigReader

private val logger = KotlinLogging.logger {}


abstract class BasePage(private var driver: WebDriver, private val relativeUrl: String) {

    private val baseUrl: String = ConfigReader.getUrl()

    init {
        PageFactory.initElements(driver, this)
    }

    public fun goToUrl() {
        driver.get("$baseUrl/$relativeUrl");
        logger.info { "Go to url: $baseUrl/$relativeUrl" }
    }


}