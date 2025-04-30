package org.justserve

import com.microsoft.playwright.*
import org.justserve.page.AboutUsPage
import org.justserve.page.HomePage
import spock.lang.Shared
import spock.lang.Specification

class JustServePageSpec extends Specification{

    @Shared
    Playwright playwright
    @Shared
    Browser browser
    @Shared
    BrowserContext context
    @Shared
    Page page

    def setupSpec(){
        playwright = Playwright.create()
        browser = playwright.firefox().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        )
    }

    def cleanupSpec(){
        playwright.close()
    }

    def setup(){
        context = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true))
        page = context.newPage()
    }

    def cleanup(){
        context.close()
    }

    def "ad hoc"() {
        when:"a simple homePage object"
        HomePage homepage = new HomePage(page)

        and:"navigate to the home page"
        homepage.navigate()

        then:"click the about us link"
        AboutUsPage aboutUsPage = homepage.clickAboutUs()

        and:""
        aboutUsPage.getCurrentUrl() == "https://www.justserve.org/about"
    }
}
