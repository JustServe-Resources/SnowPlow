package org.justserve

import geb.spock.GebSpec
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.RemoteWebDriver
import software.xdev.testcontainers.selenium.containers.browser.CapabilitiesBrowserWebDriverContainer
import spock.lang.See
import spock.lang.Shared
import spock.lang.Unroll

/**
 * Add any value to an environment variable called "NoDocker" to use a local browser for testing
 */
@MicronautTest
class JustServePageSpec extends GebSpec {

    @Shared
    def browserContainer

    def setupSpec() {
        if (System.getenv("NoDocker") == null) {
            def capabilities = new FirefoxOptions()
            browserContainer = new CapabilitiesBrowserWebDriverContainer(capabilities)
            browserContainer.start()
            driver = new RemoteWebDriver(browserContainer.getSeleniumAddressURI().toURL(), capabilities)
        }
        if (System.getProperty("geb.build.baseUrl") == null) {
            System.setProperty("geb.build.baseUrl", "https://JustServe.org")
        }
    }

    def cleanupSpec() {
        if (System.getenv("NoDocker") == null) {
            driver.quit()
            browserContainer.stop()
        }
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
