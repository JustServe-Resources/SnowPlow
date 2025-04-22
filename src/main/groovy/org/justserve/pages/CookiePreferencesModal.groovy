package org.justserve.pages
/**
 * Page object for cookie preferences modal
 */
class CookiePreferencesModal extends JustServePage {

    @SuppressWarnings("unused")
    static at = {
        ["Cookie Preferences"].any {
            expectedTitle -> title.startsWith(expectedTitle)
        }
    }
}
