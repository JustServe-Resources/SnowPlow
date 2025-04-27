package org.justserve.page

import com.microsoft.playwright.Page
import jakarta.inject.Singleton

/**
 * /organizations page
 * @since 0.1.0
 * @author Jonathan Zollinger
 */
@Singleton
class OrganizationsPage(page: Page, override val path: String = "/organizations") : JustServePage(page) {}
