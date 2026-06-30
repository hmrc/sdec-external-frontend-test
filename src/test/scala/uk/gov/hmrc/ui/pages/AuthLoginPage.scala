package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.ui.conf.TestConfiguration
import uk.gov.hmrc.ui.driver.BrowserDriver

object AuthLoginPage extends BrowserDriver with BasePage {

  val url: String         = s"${TestConfiguration.url("auth-login-stub")}/gg-sign-in"
  val frontEndUrl: String = TestConfiguration.url("sdec-internal-frontend")

  object Fields {
    val credId: By      = By.id("authorityId")
    val redirectUrl: By = By.id("redirectionUrl")
  }

  private val redirectUrls: Map[String, String] = Map(
    "sdec-internal-frontend" -> frontEndUrl
  )

  private def resolveRedirect(page: String): String =
    redirectUrls.getOrElse(
      page,
      throw new IllegalArgumentException(s"Unknown redirect page: $page")
    )

  def login(
    credId: String = "258798531149531"
  ): Unit = {
    navigateTo(url)
    sendKeys(Fields.credId, credId)
    sendKeys(Fields.redirectUrl, resolveRedirect("sdec-internal-frontend"))
    continue()
  }
}
