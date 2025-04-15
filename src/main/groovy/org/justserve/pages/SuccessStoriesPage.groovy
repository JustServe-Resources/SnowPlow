package org.justserve.pages

import org.openqa.selenium.By

/**
 * Page object for justserve.org/stories
 */
class SuccessStoriesPage extends JustServePage {

    @SuppressWarnings("unused")
    static at = {
        ["Erfolgsgeschichten", "Success Stories", "Historias de éxito", "Exemples de réussite", "Histórias de sucesso",
         "Sikertörténetek"].any {
            expectedTitle -> title.startsWith(expectedTitle)
        }
    }
}
