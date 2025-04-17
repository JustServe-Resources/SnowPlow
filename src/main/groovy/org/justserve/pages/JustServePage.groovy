package org.justserve.pages

import geb.Page
import org.justserve.pages.modules.HeaderModule


/**
 * Parent Object Model for JustServe Pages
 */
class JustServePage extends Page {

    @SuppressWarnings("unused")
    static content = {
        header { module(HeaderModule) }
    }

    @SuppressWarnings("unused")
    static at = { waitFor { title.endsWith("JustServe") } }
}
