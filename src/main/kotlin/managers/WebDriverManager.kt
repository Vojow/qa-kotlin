package managers

import enums.BrowserType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.safari.SafariDriver
import utils.ConfigReader
import java.util.concurrent.TimeUnit

class WebDriverManager {
    var configReader = ConfigReader()

    private var browserType: BrowserType
    private var baseUrl: String
    var driver: WebDriver? = null


    init {
        browserType = configReader.getBrowserType()
        baseUrl = configReader.getUrl()
        initDriver()
    }

    fun initDriver() {
        createDriver()
        maxmizeWindow()
        setImplicitWait()
    }

    fun createDriver() {
        driver = when (browserType) {
            BrowserType.CHROME -> ChromeDriver()
            BrowserType.SAFARI -> SafariDriver()
            BrowserType.IE -> InternetExplorerDriver()
            BrowserType.EDGE -> EdgeDriver()
            BrowserType.FIREFOX -> FirefoxDriver()
        }
    }

    fun maxmizeWindow() {
        if (configReader.getMaximizeVaule()) driver!!.manage().window().maximize()
    }

    fun setImplicitWait() {
        driver!!.manage().timeouts().implicitlyWait(configReader.getImplicitWaitValue(), TimeUnit.SECONDS)
    }

    fun driverQuit() {
        driver!!.quit()
    }
}