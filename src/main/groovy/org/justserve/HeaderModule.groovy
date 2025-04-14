package org.justserve

import geb.Module
import org.openqa.selenium.By
import org.slf4j.Logger
import org.slf4j.LoggerFactory
/**
 * Header Module
 */
class HeaderModule extends Module {

    private static Logger log = LoggerFactory.getLogger(HeaderModule.class)

    @SuppressWarnings("unused")
    static content = {
        headerLogo { $("a.js-logo-link") }
        headerProjects { $("a", href: "/projects") }
        headerOrganizations { $("a", class: "header-link", text: "Organizations") }
        headerSuccessStories { $("a", class: "header-link", text: "Success Stories") }
        headerAboutUsDesktop { $("a", class: "header-link", href: "/about") }

        //geb misreads the quick notation to be no class, it seems. Xpath works as expected
        headerAboutUsMobile { $(By.xpath("//a[@class=\" \" and @href=\"/about\"]")) }
        mobileHamburgerMenu { $("button", class: "menu-icon") }
    }

    /**
     * Clicks the About Us link in the header.
     * @return a new instance of the AboutUsPage
     */
    @SuppressWarnings("unused")
    AboutUsPage clickAboutUs() {
        if(mobileHamburgerMenu.isDisplayed()) {
            log.debug("click mobile header hamburger menu")
            mobileHamburgerMenu.click()
            log.debug("click about us link from mobile header dropdown")
            headerAboutUsMobile.click()
        } else {
            log.debug("click desktop header about us link")
            headerAboutUsDesktop.click()
        }
        log.debug("return new instance of AboutUsPage")
        return new AboutUsPage()
    }

    /**
     * Clicks the Projects link in the header.
     * @return a new instance of the ProjectsPage
     */
    @SuppressWarnings("unused")
    ProjectsPage clickProjects() {
        headerProjects.click()
        return new ProjectsPage()
    }

    /**
     * Clicks the Organizations link in the header.
     * @return a new instance of the OrganizationsPage
     */
    @SuppressWarnings("unused")
    OrganizationsPage clickOrganizations() {
        headerOrganizations.click()
        return new OrganizationsPage()
    }

    /**
     * Clicks the Success Stories link in the header.
     * @return a new instance of the SuccessStoriesPage
     */
    @SuppressWarnings("unused")
    SuccessStoriesPage clickSuccessStories() {
        headerSuccessStories.click()
        return new SuccessStoriesPage()
    }

    /**
     * Clicks the logo in the header.
     * @return a new instance of the HomePage
     */
    @SuppressWarnings("unused")
    HomePage clickHeaderLogo() {
        headerLogo.click()
        return new HomePage()
    }
}
