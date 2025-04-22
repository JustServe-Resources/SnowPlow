package org.justserve.pages

import org.openqa.selenium.By

/**
 * Page object for https://www.justserve.org/legal/terms
 */
class TermsOfUsePage extends JustServePage {

    @SuppressWarnings("unused")
    static at = {
        ["Terms of Use", "Condiciones de uso", "Conditions d’utilisation", "Termos de uso", "Használati feltételek", "Nutzungsbedingungen"].any {
            expectedTitle -> title.startsWith(expectedTitle)
        }
    }
}
