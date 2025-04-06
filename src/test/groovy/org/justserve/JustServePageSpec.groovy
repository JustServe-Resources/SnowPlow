package org.justserve

import geb.spock.GebSpec
import spock.lang.Unroll

class JustServePageSpec extends GebSpec {

    def setupSpec() {
        if (System.getProperty("geb.build.baseUrl") == null) {
            System.setProperty("geb.build.baseUrl", "https://JustServe.org")
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
