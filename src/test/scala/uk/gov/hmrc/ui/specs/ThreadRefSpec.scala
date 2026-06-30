package uk.gov.hmrc.ui.specs

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.must.Matchers
import uk.gov.hmrc.ui.pages.AuthLoginPage.{driver, login}
import uk.gov.hmrc.ui.specs.tags.AcceptanceTests

import java.time.Duration

class ThreadRefSpec extends BaseSpec {
  Feature("Internal User Journey") {

    Scenario("Get Landing Page", AcceptanceTests) {

      Given("User Logins with Credential ID") // This might be the wrong way for internal HMRC staff to login for now
      login()

      When("the thread reference page loads")
      Then("the system must display a dashboard page layout")

    }

  }
}