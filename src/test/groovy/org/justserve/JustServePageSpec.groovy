package org.justserve

import geb.spock.GebSpec
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import org.justserve.pages.AboutUsPage
import org.justserve.pages.HomePage
import org.justserve.pages.JustServePage
import org.justserve.pages.OrganizationsPage
import org.justserve.pages.ProjectsPage
import org.justserve.pages.SuccessStoriesPage
import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.RemoteWebDriver
import software.xdev.testcontainers.selenium.containers.browser.CapabilitiesBrowserWebDriverContainer
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
    def "click #link link in the header navigates to the #link page. Use screen size #screenSize with #language locale"() {
        when:"configure language and screen size to #language and #screenSize"
        
        driver.manage().window().setSize(screenSize as Dimension)
        to JustServePage
        JustServePage page = browser.page(JustServePage)
        page.header.setLanguage(language as Language)

        and:"call #methodName method"
        page.header."$methodName"()

        then:"navigate to #expectedPage"
        at expectedPage

        where:
        [[link, methodName, expectedPage], screenSize, language] << [
                [
                        ["About Us", "clickAboutUs", AboutUsPage],
                        ["Projects", "clickProjects", ProjectsPage],
                        ["Organizations", "clickOrganizations", OrganizationsPage],
                        ["Success Stories", "clickSuccessStories", SuccessStoriesPage],
                        ["Home Page", "clickHeaderLogo", HomePage]
                ],
                screenSizes,
                Language.values()
        ].combinations()
    }

    def "ad hoc"() {
        when:
        to JustServePage


        then:
        at JustServePage
        driver.manage().window().setSize(new Dimension(1920, 1080))
        JustServePage page = browser.page(JustServePage)


        when:
        page.header.clickSuccessStories()

        then:
        at SuccessStoriesPage
    }
}
