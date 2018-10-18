package utils

import enums.BrowserType
import enums.ConfigVariables
import java.io.BufferedReader
import java.io.FileReader
import java.util.*

object ConfigReader {

    private var properties: Properties = Properties()
    private const val propertiesFilePath: String = "configuration.properties"

    init {
        val bufferedReader = BufferedReader(FileReader(propertiesFilePath))
        properties.load(bufferedReader)
    }

    fun getBrowserType(): BrowserType {
        return when (properties.getProperty(ConfigVariables.BROWSER.name).toLowerCase()) {
            "chrome" -> BrowserType.CHROME
            "firefox" -> BrowserType.FIREFOX
            "edge" -> BrowserType.EDGE
            "ie" -> BrowserType.IE
            "safari" -> BrowserType.SAFARI
            else -> BrowserType.CHROME
        }
    }

    fun getMaximizeValue(): Boolean {
        return properties.getProperty(ConfigVariables.WINDOW_MAXIMIZE.name)!!.toBoolean()
    }

    fun getImplicitWaitValue(): Long {
        return properties.getProperty(ConfigVariables.IMPLICIT_WAIT.name).toLong()
    }

    fun getUrl(): String {
        return properties.getProperty(ConfigVariables.URL.name)
    }

}