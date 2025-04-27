package org.justserve

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class JustServePageSpec extends Specification{

    @Shared
    Playwright playwright
    @Shared
    Browser browser
    @Shared
    BrowserContext context
    @Shared
    Page page

    setupSpec(){
        playwright = Playwright.create()
        browser = playwright.firefox().launch()
    }

    cleanupSpec(){
        playwright.close()
    }

    setup(){
        context = browser.newContext()
        page = context.newPage()
    }

    cleanup(){
        context.close()
    }
}
