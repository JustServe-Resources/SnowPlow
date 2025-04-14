package org.justserve

import geb.spock.GebSpec
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import org.openqa.selenium.Dimension
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
    ArrayList<Dimension> screenSizes = [
            new Dimension(375, 667),
            new Dimension(768, 1024),
            new Dimension(1920, 1080),
    ]

    @Shared
    def languages = ["English (US)",
                     "English (GB)",
                     "Espanol",
                     "Francais",
                     "Portugues",
                     "Magyar",
                     "Deutsch"]

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
    def "clicking #link link in the header navigates to the #link page on #screenSize in #language"() {
        when:
//        driver.manage().window().setSize(screenSize as Dimension)
        to JustServePage
        JustServePage page = browser.page(JustServePage)


        then: "set JustServe language to #language"
//        page.header."set$language"()

        when:
        page.header."$methodName"()

        then:
        at expectedPage

        where:
        [link, methodName, expectedPage, language, screenSize] << [
                ["About Us", "Projects", "Organizations", "Success Stories", "Home Page"],
                ["clickAboutUs", "clickProjects", "clickOrganizations", "clickSuccessStories", "clickHeaderLogo"],
                [AboutUsPage, ProjectsPage, OrganizationsPage, SuccessStoriesPage, HomePage],
                [languages],
                [screenSizes]
        ].combinations()
    }

    def "ad hoc"() {
        when:
        to JustServePage


        then:
        at JustServePage
        driver.manage().window().setSize(new Dimension(412 , 915))
        JustServePage page = browser.page(JustServePage)


        when:
        page.header.clickAboutUs()

        then:
        at AboutUsPage
    }
}
