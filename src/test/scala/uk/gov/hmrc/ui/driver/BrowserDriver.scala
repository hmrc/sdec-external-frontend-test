package uk.gov.hmrc.ui.driver

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.specs.BaseSpec
//import uk.gov.hmrc.ui.pages.{#PAGE OBJECT NAMES HERE# e.g. ExampleRadioPage}
//import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
//import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class BrowserDriver
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Agent - Gift Aid frontend Journeys") {
    Scenario("Agent navigates to **service name**") {
      Given("Agent navigates to **page name** page")
      // CODE LINE - e.g. ExampleRadioPage.verifyPageTitle(ExampleRadioPage.pageTitle)
      And("Agent clicks 'Yes' radio button option")
      // CODE LINE - e.g. ExampleRadioPage.clickYesRadio()
      And("Agent clicks 'Continue' button")
      // CODE LINE - e.g. ExampleRadioPage.clickSubmitButton()
      And("User navigates to **next page** page")
      // CODE LINE - e.g. AnotherPage.verifyPageTitle(AnotherPage.pageTitle)
    }
  }
}
