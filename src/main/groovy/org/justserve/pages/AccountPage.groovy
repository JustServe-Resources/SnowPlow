package org.justserve.pages

class AccountPage extends JustServePage{

    static at = {
        ["My Account", "Mi cuenta", "Mon compte", "Minha conta", "Felhasználói fiókom", "Mein Konto"].any {
            h1Text -> $(By.xpath("//h1[@data-test=\"pageHeaderTitle\"]")).text() == h1Text
        }
    }
}
