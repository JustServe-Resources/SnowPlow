package org.justserve.page

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page
import jakarta.inject.Singleton

@Singleton
open class JustServePage(val page: Page) {

    //------ header
    val justServeLogoButton: Locator by lazy { page.locator("a.js-logo-link") }
    val mobileHamburgerMenu: Locator by lazy { page.locator("button.menu-icon") }
    val projectsDesktop: Locator by lazy { page.locator("//a[@data-test=\"projectsHeaderLink\"]") }
    val projectsMobile: Locator by lazy { page.locator("//a[@data-test=\"menuProjectsLink\"]") }

    val organizationsDesktop: Locator by lazy { page.locator("//a[@data-test=\"organizationsHeaderLink\"]") }
    val organizationsMobile: Locator by lazy { page.locator("//a[@data-test=\"menuOrganizationsLink\"]") }

    val successStoriesDesktop: Locator by lazy { page.locator("//a[@data-test=\"successStoriesHeaderLink\"]") }
    val successStoriesMobile: Locator by lazy { page.locator("//a[@data-test=\"menuSuccessStoriesLink\"]") }

    val aboutUsDesktop: Locator by lazy { page.locator("//a[@data-test=\"aboutUsHeaderLink\"]") }
    val aboutUsMobile: Locator by lazy { page.locator("//a[@data-test=\"menuAboutUsLink\"]") }

    val languageButtonDesktop: Locator by lazy {
        page.locator("//div[@class=\"right-container desktop\"]//button[@class=\"languageBtn\"]")
    }
    val languageButtonMobile: Locator by lazy { page.locator("//button[@data-test=\"headerLanguageButton\"]") }

    //------ footer

    fun clickAboutUs(): AboutUsPage {
        if (mobileHamburgerMenu.isVisible) {
            mobileHamburgerMenu.click()
            aboutUsMobile.click()
        } else {
            aboutUsDesktop.click()
        }
        return AboutUsPage(page)
    }
}
