package org.justserve

import geb.Module
/**
 * Header Module
 */
class HeaderModule extends Module{

    @SuppressWarnings("unused")
    static content = {
        headerLogo { $("a.js-logo-link")}
        headerProjects { $("a", class: "header-link", text: "Projects") }
        headerOrganizations { $("a", class: "header-link", text: "Organizations") }
        headerSuccessStories { $("a", class: "header-link", text: "Success Stories") }
        headerAboutUs { $("a", class: "header-link", text: "About Us") }
    }

    /**
     * Clicks the About Us link in the header.
     * @return a new instance of the AboutUsPage
     */
    @SuppressWarnings("unused")
    AboutUsPage clickAboutUs() {
        headerAboutUs.click()
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
