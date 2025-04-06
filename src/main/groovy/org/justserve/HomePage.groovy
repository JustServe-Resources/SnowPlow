package org.justserve

/**
 * Page object for justserve.org
 */
class HomePage extends JustServePage{

    @SuppressWarnings("unused")
    static at = {
        $("div", id:"home-search-title").text()
                .equalsIgnoreCase("Find Volunteer Opportunities in Your Area")
    }
}
