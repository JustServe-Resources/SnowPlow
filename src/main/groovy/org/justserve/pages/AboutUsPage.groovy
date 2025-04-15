package org.justserve.pages

import org.openqa.selenium.By

/**
 * Page object for justserve.org/about
 */
class AboutUsPage extends JustServePage{

    @SuppressWarnings("unused")
    static at = {
        ["About Us", "Acerca de nosotros", "Qui sommes-nous", "Quem somos", "Rólunk", "Über uns"].any {
           expectedTitle -> title.startsWith(expectedTitle)
        }}
}
