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

    @Unroll
    def "click #link link in the header navigates to the #link page. Use #language locale"() {
        when:"configure language and screen size to #language and #screenSize"
        
        to JustServePage
        JustServePage page = browser.page(JustServePage)
        page.header.setLanguage(language as Language)

        and:"call #methodName method"
        page.header."$methodName"()

        then:"navigate to #expectedPage"
        at expectedPage

        where:
        [[link, methodName, expectedPage], language] << [
                [
                        ["About Us", "clickAboutUs", AboutUsPage],
                        ["Projects", "clickProjects", ProjectsPage],
                        ["Organizations", "clickOrganizations", OrganizationsPage],
                        ["Success Stories", "clickSuccessStories", SuccessStoriesPage],
                        ["Home Page", "clickHeaderLogo", HomePage]
                ],
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
