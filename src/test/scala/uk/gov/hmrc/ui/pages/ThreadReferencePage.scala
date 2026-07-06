/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.devtools.v135.page.Page
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.component.PageObject

import java.time.Duration
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import scala.jdk.CollectionConverters.*

class ThreadReferencePage(driver: WebDriver) extends BasePage {

  private val wait = new WebDriverWait(driver, Duration.ofSeconds(10))

  // Prefer data-testid selectors if you can add them in the UI.

  private val headingLocator: By =
    By.xpath("/html/body/header/div[1]/div/div[2]/a")

  private val threadReferenceLocator: By =
    By.cssSelector("#main-content > div > div > form > fieldset > legend > h1")

  private val threadReferenceInputLocator: By =
    By.id("thread-reference")

  private val continueButtonLocator: By =
    By.xpath("//*[@id=\"main-content\"]/div/div/form/button")

  private val errorSummaryLocator: By =
    By.cssSelector(".govuk-error-summary")

  private val inlineErrorLocator: By =
    By.id("thread-reference-number-error")

  def getCaptionText: String =
    wait.until(ExpectedConditions.visibilityOfElementLocated(headingLocator)).getText.trim

  def getThreadReferenceText: String =
    wait.until(ExpectedConditions.visibilityOfElementLocated(threadReferenceLocator)).getText.trim

  def getThreadReferenceInput: WebElement =
    wait.until(ExpectedConditions.visibilityOfElementLocated(threadReferenceInputLocator))

  def isThreadReferenceInputDisplayed: Boolean =
    driver.findElements(threadReferenceInputLocator).asScala.nonEmpty &&
      getThreadReferenceInput.isDisplayed

  def isThreadReferenceInputEnabled: Boolean =
    getThreadReferenceInput.isEnabled

  def enterThreadReference(value: String): Unit =
    getThreadReferenceInput.clear()
    getThreadReferenceInput.sendKeys(value)

  def getContinueButton: WebElement =
    wait.until(ExpectedConditions.visibilityOfElementLocated(continueButtonLocator))

  def isContinueButtonDisplayed: Boolean =
    driver.findElements(continueButtonLocator).asScala.nonEmpty &&
      getContinueButton.isDisplayed

  def isContinueButtonEnabled: Boolean =
    getContinueButton.isEnabled

  def getContinueButtonText: String =
    getContinueButton.getText.trim

  def selectContinueButton(): Unit =
    getContinueButton.click()

  def isErrorSummaryDisplayed: Boolean =
    driver.findElements(errorSummaryLocator).asScala.nonEmpty &&
      wait.until(ExpectedConditions.visibilityOfElementLocated(errorSummaryLocator)).isDisplayed

  def getErrorSummaryText: String =
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorSummaryLocator)).getText.trim

  def isInlineErrorDisplayed: Boolean =
    driver.findElements(inlineErrorLocator).asScala.nonEmpty &&
      wait.until(ExpectedConditions.visibilityOfElementLocated(inlineErrorLocator)).isDisplayed

  def getInlineErrorText: String =
    wait.until(ExpectedConditions.visibilityOfElementLocated(inlineErrorLocator)).getText.trim

  def isInlineErrorShownBelowInput: Boolean = {
    val errorLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(inlineErrorLocator)).getLocation
    val inputLocation = getThreadReferenceInput.getLocation
    errorLocation.getY > inputLocation.getY
  }
}
