package managers

import enums.BrowserType
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.safari.SafariDriver
import utils.ConfigReader
import java.util.concurrent.TimeUnit

private val logger = KotlinLogging.logger {}


class WebDriverManager {

    private val browserType: BrowserType = ConfigReader.getBrowserType()
    lateinit var driver: WebDriver


    fun initDriver() {
        createDriver()
        maximizeWindow()
        setImplicitWait()
    }

    private fun createDriver() {
        driver = when (browserType) {
            BrowserType.CHROME -> ChromeDriver()
            BrowserType.SAFARI -> SafariDriver()
            BrowserType.IE -> InternetExplorerDriver()
            BrowserType.EDGE -> EdgeDriver()
            BrowserType.FIREFOX -> FirefoxDriver()
        }
        logger.debug { "Create driver with type: $browserType" }
    }

    private fun maximizeWindow() {
        if (ConfigReader.getMaximizeValue()) driver.manage().window().maximize()
    }

    private fun setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(ConfigReader.getImplicitWaitValue(), TimeUnit.SECONDS)
    }

    fun driverQuit() {
        driver.quit()
        logger.debug { "Driver quit" }
    }
}