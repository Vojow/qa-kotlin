package steps

import core.Context
import cucumber.api.java.After
import cucumber.api.java.Before

class Hooks {

    @Before
    fun beforeAll() {
        Context.driverManager.initDriver()
    }

    @After
    fun afterAll() {
        Context.driverManager.driverQuit()
    }
}