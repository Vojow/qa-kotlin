package steps

import core.Context
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class GoogleSteps {

    @When("I go to google homepage")
    public fun goToGoogleHome() {
        Context.pages.getHomePage().goToUrl()
    }

    @Then("I want to see search")
    public fun isSearchDisplayed() {
        Context.pages.getHomePage().isSearchDisplayed()
    }
}