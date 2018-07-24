package utils

import enums.BrowserType
import java.io.BufferedReader
import java.io.FileReader
import java.util.*

object ConfigReader {

    private var properties: Properties = Properties()
    private val propertiesFilePath: String = "configuration.properties"

    init {
        val bufferedReader = BufferedReader(FileReader(propertiesFilePath))
        properties.load(bufferedReader)
    }

    fun getBrowserType(): BrowserType {
        return when (properties.getProperty("browser").toLowerCase()) {
            "chrome" -> BrowserType.CHROME
            "firefox" -> BrowserType.FIREFOX
            "edge" -> BrowserType.EDGE
            "ie" -> BrowserType.IE
            "safari" -> BrowserType.SAFARI
            else -> BrowserType.CHROME
        }
    }

    fun getMaximizeVaule(): Boolean {
        return properties.getProperty("maximize")!!.toBoolean()
    }

    fun getImplicitWaitValue(): Long {
        return properties.getProperty("implicitWait").toLong()
    }

    fun getUrl(): String {
        return properties.getProperty("url")
    }

}