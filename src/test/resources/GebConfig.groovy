/*
This is the Geb configuration file.
See: http://www.gebish.org/manual/current/configuration.html
*/

baseNavigatorWaiting = true
atCheckWaiting = true

import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.RemoteWebDriver
import software.xdev.testcontainers.selenium.containers.browser.CapabilitiesBrowserWebDriverContainer

def mobileDisplay = new Dimension(375, 667)
def tabletDisplay = new Dimension(768, 1024)
def desktopDisplay = new Dimension(1920, 1080)

System.setProperty("geb.build.baseUrl", System.getenv("JUSTSERVE_URL") ?: "https://dev.justserve.org")

environments {

    dockerFirefox {
        driver = {
            def capabilities = new FirefoxOptions()
            def container = new CapabilitiesBrowserWebDriverContainer(capabilities)
            container.start()
            def driverInstance = new RemoteWebDriver(container.getSeleniumAddressURI().toURL(), capabilities)
            driverInstance.manage().window().setSize(desktopDisplay)
            driverInstance
        }
    }

    dockerMobileFirefox {
        driver = {
            def capabilities = new FirefoxOptions()
            def container = new CapabilitiesBrowserWebDriverContainer(capabilities)
            container.start()
            def driverInstance = new RemoteWebDriver(container.getSeleniumAddressURI().toURL(), capabilities)
            driverInstance.manage().window().setSize(mobileDisplay)
            driverInstance
        }
    }

    dockerTabletFirefox {
        driver = {
            def capabilities = new FirefoxOptions()
            def container = new CapabilitiesBrowserWebDriverContainer(capabilities)
            container.start()
            def driverInstance = new RemoteWebDriver(container.getSeleniumAddressURI().toURL(), capabilities)
            driverInstance.manage().window().setSize(tabletDisplay)
            driverInstance
        }
    }

    dockerChrome {
        driver = {
            def capabilities = new ChromeOptions()
            def container = new CapabilitiesBrowserWebDriverContainer(capabilities)
            container.start()
            def driverInstance = new RemoteWebDriver(container.getSeleniumAddressURI().toURL(), capabilities)
            driverInstance.manage().window().setSize(desktopDisplay)
            driverInstance
        }

    }

    dockerMobileChrome {
        driver = {
            def capabilities = new ChromeOptions()
            def container = new CapabilitiesBrowserWebDriverContainer(capabilities)
            container.start()
            def driverInstance = new RemoteWebDriver(container.getSeleniumAddressURI().toURL(), capabilities)
            driverInstance.manage().window().setSize(mobileDisplay)
            driverInstance
        }
    }

    dockerTabletChrome {
        driver = {
            def capabilities = new ChromeOptions()
            def container = new CapabilitiesBrowserWebDriverContainer(capabilities)
            container.start()
            def driverInstance = new RemoteWebDriver(container.getSeleniumAddressURI().toURL(), capabilities)
            driverInstance.manage().window().setSize(tabletDisplay)
            driverInstance
        }
    }

    firefox {
        driver = {
            def driverInstance = new FirefoxDriver()
            driverInstance.manage().window().setSize(desktopDisplay)
            driverInstance
        }
    }
    mobileFirefox {
        driver = {
            def driverInstance = new FirefoxDriver()
            driverInstance.manage().window().setSize(mobileDisplay)
            driverInstance
        }
    }
    tabletFirefox {
        driver = {
            def driverInstance = new FirefoxDriver()
            driverInstance.manage().window().setSize(tabletDisplay)
            driverInstance
        }
    }
}