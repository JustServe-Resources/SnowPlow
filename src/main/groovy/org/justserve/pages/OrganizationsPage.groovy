package org.justserve.pages

import org.openqa.selenium.By

/**
 * Page object for justserve.org/organizations
 */
class OrganizationsPage extends JustServePage {

    @SuppressWarnings("unused")
    static at = {
        ["Organizations", "Organisations", "Organizaciones", "Organizações", "Szervezetek", "Organisationen"].any {
            expectedTitle -> title.startsWith(expectedTitle)
        }
    }
}
