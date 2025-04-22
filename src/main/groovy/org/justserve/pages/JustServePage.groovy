package org.justserve.pages

import geb.Page
import org.justserve.pages.modules.HeaderModule
import org.justserve.pages.modules.FooterModule



/**
 * Parent Object Model for JustServe Pages
 */
class JustServePage extends Page {

    @SuppressWarnings("unused")
    static content = {
        header { module(HeaderModule) }
        footer { module(FooterModule) }
    }

    @SuppressWarnings("unused")
    static at = { waitFor { title.endsWith("JustServe") } }
}
