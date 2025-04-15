package org.justserve

import geb.Module
import geb.navigator.Navigator
import org.openqa.selenium.By
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.util.function.Supplier

/**
 * Header Module
 */
class HeaderModule extends Module {

    private static Logger log = LoggerFactory.getLogger(HeaderModule.class)

    @SuppressWarnings("unused")
    static content = {
        logo { $("a.js-logo-link") }
        mobileHamburgerMenu { $("button", class: "menu-icon") }

        projectsDesktop { $(By.xpath("//a[@data-test=\"projectsHeaderLink\"]")) }
        projectsMobile { $(By.xpath("//a[@data-test=\"menuProjectsLink\"]")) }

        organizationsDesktop { $(By.xpath("//a[@data-test=\"organizationsHeaderLink\"]")) }
        organizationsMobile { $(By.xpath("//a[@data-test=\"menuOrganizationsLink\"]")) }

        successStoriesDesktop { $(By.xpath("//a[@data-test=\"successStoriesHeaderLink\"]")) }
        successStoriesMobile { $(By.xpath("//a[@data-test=\"menuSuccessStoriesLink\"]")) }

        aboutUsDesktop { $(By.xpath("//a[@data-test=\"aboutUsHeaderLink\"]")) }
        aboutUsMobile { $(By.xpath("//a[@data-test=\"menuAboutUsLink\"]")) }

    }

    /**
     * Clicks the About Us link in the header.
     * @return a new instance of the AboutUsPage
     */
    @SuppressWarnings("unused")
    AboutUsPage clickAboutUs() {
        if(mobileHamburgerMenu.isDisplayed()) {
            mobileHamburgerMenu.click()
            aboutUsMobile.click()
        } else {
            aboutUsDesktop.click()
        }
        return new AboutUsPage()
    }

    /**
     * Clicks the Projects link in the header.
     * @return a new instance of the ProjectsPage
     */
    @SuppressWarnings("unused")
    ProjectsPage clickProjects() {
        if (mobileHamburgerMenu.isDisplayed()) {
            mobileHamburgerMenu.click()
            projectsMobile.click()
        } else {
            projectsDesktop.click()
        }
        return new ProjectsPage()
    }

    /**
     * Clicks the Organizations link in the header
     * @return a new instance of the OrganizationsPage
     */
    @SuppressWarnings("unused")
    OrganizationsPage clickOrganizations() {
        if (mobileHamburgerMenu.isDisplayed()) {
            mobileHamburgerMenu.click()
            organizationsMobile.click()
        } else {
            organizationsDesktop.click()
        }
        return new OrganizationsPage()
    }

    /**
     * Clicks the Success Stories link in the header
     * @return a new instance of the SuccessStoriesPage
     */
    @SuppressWarnings("unused")
    SuccessStoriesPage clickSuccessStories() {
        if (mobileHamburgerMenu.isDisplayed()) {
            mobileHamburgerMenu.click()
            successStoriesMobile.click()
        } else {
            successStoriesDesktop.click()
        }
        return new SuccessStoriesPage()
    }

    /**
     * Clicks the logo in the header.
     * @return a new instance of the HomePage
     */
    @SuppressWarnings("unused")
    Closure<HomePage> clickHeaderLogo = {
        logo.click()
        return new HomePage()
    }
}
