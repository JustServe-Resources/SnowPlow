package org.justserve.pages

import org.openqa.selenium.By

/**
 * Page object for https://www.justserve.org/legal/privacy
 */
class PrivacyNoticePage extends JustServePage {

    @SuppressWarnings("unused")
    static at = {
        ["Privacy Notice", "Norma de privacidad", "Règles de confidentialité", "Normas de privacidade", "Adatvédelmi irányelv", "Datenschutzmitteilung"].any {
            expectedTitle -> title.startsWith(expectedTitle)
        }
    }
}
