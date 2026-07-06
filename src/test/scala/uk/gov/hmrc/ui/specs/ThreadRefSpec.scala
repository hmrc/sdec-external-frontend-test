/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.must.Matchers
import uk.gov.hmrc.ui.pages.AuthLoginPage.{driver, login}
import uk.gov.hmrc.ui.pages.ThreadReferencePage
import uk.gov.hmrc.ui.pages.ThreadReferencePage
import uk.gov.hmrc.ui.specs.tags.AcceptanceTests

import java.time.Duration

class ThreadRefSpec extends BaseSpec {
  Feature("Internal User Journey") {

    Scenario("Enter thread reference page - page display", AcceptanceTests) {

      Given("User logs in")
      login()

      When("the Enter thread reference page loads")

      val wait = new WebDriverWait(driver, Duration.ofSeconds(15))

      val threadRefPage = new ThreadReferencePage(driver)

      Then("the system must display the input field and continue button")

      threadRefPage.getThreadReferenceText shouldBe "Enter the thread reference number"

      val inputDisplayed  = threadRefPage.isThreadReferenceInputDisplayed
      val buttonDisplayed = threadRefPage.isContinueButtonDisplayed
      val buttonEnabled   = threadRefPage.isContinueButtonEnabled
      val buttonText      = threadRefPage.getContinueButtonText
      val captionText     = threadRefPage.getCaptionText

      inputDisplayed shouldBe true

      And("the system must display the service caption")
      captionText shouldBe "Share Files Securely with HMRC"

      And("the system must display a continue button")
      buttonDisplayed shouldBe true

      And("the button must be selectable")
      buttonEnabled shouldBe true

      And("the button must follow GOV.UK Design System standards")
      buttonText shouldBe "Continue"
    }

  }
}
