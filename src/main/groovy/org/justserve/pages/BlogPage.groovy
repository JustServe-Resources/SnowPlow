package org.justserve.pages

import org.openqa.selenium.By

/**
 * Page object for https://www.justserve.org/blog
 */
class BlogPage extends JustServePage {

    @SuppressWarnings("unused")
    static at = {
        ["Blog"].any {
            expectedTitle -> title.startsWith(expectedTitle)
        }
    }
}
