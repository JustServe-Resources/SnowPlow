package org.justserve

import geb.spock.GebSpec
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.RemoteWebDriver
import software.xdev.testcontainers.selenium.containers.browser.CapabilitiesBrowserWebDriverContainer
import spock.lang.Shared
import spock.lang.Unroll

@MicronautTest
class JustServePageSpec extends GebSpec {

    @Shared
    def browserContainer

    def setupSpec() {
        def capabilities = new FirefoxOptions()
        browserContainer = new CapabilitiesBrowserWebDriverContainer(capabilities)
        browserContainer.start()
        if (System.getProperty("geb.build.baseUrl") == null) {
            System.setProperty("geb.build.baseUrl", "https://JustServe.org")
        }
        driver = new RemoteWebDriver(browserContainer.getSeleniumAddressURI().toURL(), capabilities)
    }

    def cleanupSpec() {
        driver.quit()
        browserContainer.stop()
    }

    @Unroll
    def "clicking #link link in the header navigates to the #link page"() {
        when:
        to JustServePage

        then:
        JustServePage page = browser.page(JustServePage)

        when:
        page.header."$methodName"()

        then:
        at expectedPage

        where:
        link              | methodName            | expectedPage
        "About Us"        | "clickAboutUs"        | AboutUsPage
        "Projects"        | "clickProjects"       | ProjectsPage
        "Organizations"   | "clickOrganizations"  | OrganizationsPage
        "Success Stories" | "clickSuccessStories" | SuccessStoriesPage
        "Home Page"       | "clickHeaderLogo"     | HomePage
    }
}
