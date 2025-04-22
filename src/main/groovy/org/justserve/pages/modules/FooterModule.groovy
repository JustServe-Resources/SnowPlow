package org.justserve.pages.modules

import geb.Module
import org.justserve.Language
import org.justserve.pages.TermsOfUsePage
import org.justserve.pages.PrivacyNoticePage
import org.justserve.pages.CookiePreferencesModal
import org.justserve.pages.BlogPage
import org.openqa.selenium.By
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class FooterModule extends Module {
    private static Logger log = LoggerFactory.getLogger(HeaderModule.class)

    @SuppressWarnings("unused")
    static content = {
        mobileHamburgerMenu { $("button", class: "menu-icon") }
        termsOfUse { $(By.xpath("//a[@data-test=\"footerTermsLink\"]")) }
        privacyNotice { $(By.xpath("//a[@data-test=\"footerPrivacyLink\"]")) }
        cookiePreferences { $(By.xpath("//a[@//a[@id=\"icon-id03071815292845953\"]")) }
        blog { $(By.xpath("//a[@data-test=\"footerBlogLink\"]")) }

        languageButtonDesktop { $( By.xpath("//div[@class=\"right-container desktop\"]//button[@class=\"languageBtn\"]"))}
        languageButtonMobile { $( By.xpath("//button[@data-test=\"headerLanguageButton\"]"))}
    }

    /**
     * Clicks the Terms of Use link in the footer.
     * @return a new instance of the TermsOfUsePage
     */
    @SuppressWarnings("unused")
    TermsOfUsePage clickTermsOfUse() {
        termsOfUse.click()
        return new TermsOfUsePage()
    }

    /**
     * Clicks the Privacy Notice link in the footer.
     * @return a new instance of the PrivacyNoticePage
     */
    @SuppressWarnings("unused")
    PrivacyNoticePage clickPrivacyNotice() {
        privacyNotice.click()
        return new PrivacyNoticePage()
    }

    /**
     * Clicks the Cookie Preferences link in the footer.
     * @return a new instance of the CookiePreferencesModal
     */
    @SuppressWarnings("unused")
    CookiePreferencesModal clickCookiePreferences() {
        cookiePreferences.click()
        return new CookiePreferencesModal()
    }

    /**
     * Clicks the Blog link in the footer.
     * @return a new instance of the BlogPage
     */
    @SuppressWarnings("unused")
    BlogPage clickBlog() {
        blog.click()
        return new BlogPage()
    }

    def setLanguage(Language language) {
        if (mobileHamburgerMenu.isDisplayed()) {
            mobileHamburgerMenu.click()
            languageButtonMobile.click()
        } else {
            languageButtonDesktop.click()
        }
        $(By.xpath("//button[@data-test=\"languageMenu$language\"]")).click()
    }
}
