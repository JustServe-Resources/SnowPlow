package org.justserve

import geb.Page

/**
 * Parent Object Model for JustServe Pages
 */
class JustServePage extends Page {

    @SuppressWarnings("unused")
    static content = {
        header { module(HeaderModule) }
    }

    @SuppressWarnings("unused")
    static at = { waitFor { title.equalsIgnoreCase("JustServe") } }
}
