package org.justserve.page

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page
import jakarta.inject.Singleton
import org.justserve.Language

/**
 * Parent class for all pages born post 2024
 * @since 0.1.0
 * @author Jonathan Zollinger
 */
@Singleton
open class JustServePage(private val page: Page) {

    //------ header
    private val justServeLogoButton: Locator by lazy { page.locator("a.js-logo-link") }

    private val mobileHamburgerMenu: Locator by lazy { page.locator("button.menu-icon") }
    private val projectsDesktop: Locator by lazy { page.locator("//a[@data-test=\"projectsHeaderLink\"]") }
    private val projectsMobile: Locator by lazy { page.locator("//a[@data-test=\"menuProjectsLink\"]") }

    private val organizationsDesktop: Locator by lazy { page.locator("//a[@data-test=\"organizationsHeaderLink\"]") }
    private val organizationsMobile: Locator by lazy { page.locator("//a[@data-test=\"menuOrganizationsLink\"]") }

    private val successStoriesDesktop: Locator by lazy { page.locator("//a[@data-test=\"successStoriesHeaderLink\"]") }
    private val successStoriesMobile: Locator by lazy { page.locator("//a[@data-test=\"menuSuccessStoriesLink\"]") }

    private val aboutUsDesktop: Locator by lazy { page.locator("//a[@data-test=\"aboutUsHeaderLink\"]") }
    private val aboutUsMobile: Locator by lazy { page.locator("//a[@data-test=\"menuAboutUsLink\"]") }

    private val languageButtonDesktop: Locator by lazy {
        page.locator("//div[@class=\"right-container desktop\"]//button[@class=\"languageBtn\"]")
    }
    private val languageButtonMobile: Locator by lazy { page.locator("//button[@data-test=\"headerLanguageButton\"]") }

    //------ footer

    /**
     * Clicks a header link regardless of whether the browser is a mobile
     *
     * @param mobileLink The locator to click if the mobile hamburger menu is visible.
     * @param desktopLink The locator to click if the mobile hamburger menu is not visible.
     * @return The page object of the page that was navigated to.
     */
    private fun <T : JustServePage> clickMenuLink(mobileLink: Locator, desktopLink: Locator, childPage: (Page) -> T): T {
        if (mobileHamburgerMenu.isVisible) {
            mobileHamburgerMenu.click()
            mobileLink.click()
        } else {
            desktopLink.click()
        }
        return childPage(page)
    }

    /**
     * Click the 'About Us' link in the header
     */
    fun clickAboutUs(): AboutUsPage {
        return clickMenuLink(aboutUsMobile, aboutUsDesktop) { AboutUsPage(it) }
    }
    /**
     * Click the 'Projects' link in the header
     */
    fun clickProjects(): ProjectsPage {
        return clickMenuLink(projectsMobile, projectsDesktop) { ProjectsPage(it) }
    }
    /**
     * Click the 'Organizations' link in the header
     */
    fun clickOrganizations(): OrganizationsPage {
        return clickMenuLink(organizationsMobile, organizationsDesktop) { OrganizationsPage(it) }
    }
    /**
     * Click the 'Success Stories' link in the header
     */
    fun clickSuccessStories(): SuccessStoriesPage {
        return clickMenuLink(successStoriesMobile, successStoriesDesktop) { SuccessStoriesPage(it) }
    }

    /**
     * Change the language within JustServe
     */
    fun setLanguage(language: Language) {
        if (mobileHamburgerMenu.isVisible) {
            languageButtonMobile.click()
        } else {
            languageButtonDesktop.click()
        }
        page.locator("//button[@data-test=\"languageMenu$language\"]").click()
    }

    fun goHome(): HomePage {
        justServeLogoButton.click()
        return HomePage(page)
    }
}
