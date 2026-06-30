package uk.gov.hmrc.ui.driver

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.WebDriver
import uk.gov.hmrc.selenium.webdriver.Driver

trait BrowserDriver extends LazyLogging {
  def driver: WebDriver = {
    if Option(Driver.instance).isEmpty then {
      val msg = "WebDriver (Driver.instance) is null! Make sure startBrowser() was called before using driver."
      logger.error(msg)
      throw new IllegalStateException(msg)
    }
    Driver.instance
  }
}
