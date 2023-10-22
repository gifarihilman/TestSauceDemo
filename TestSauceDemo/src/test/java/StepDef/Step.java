package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Login menggunakan Null User & Password

//Login menggunakan Registered User & Password
public class Step {
    WebDriver driver;
    @Given("I open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PAJAK\\Downloads\\Chromium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("Open saucedemo")
    public void openSaucedemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @And("I input user {string}")
    public void iInputUser(String arg0) {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("I input password {string}")
    public void iInputPassword(String arg0) {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("User click the login button")
    public void userClickTheLoginButton() {
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @Then("user succesfully login")
    public void userSuccesfullyLogin() {
        driver.findElement(By.xpath("//a[@href='https://www.saucedemo.com/inventory.html']")).isDisplayed();
        String urlinventory = driver.findElement(By.xpath("//a[@href='https://www.saucedemo.com/inventory.html']")).getText();
        System.out.println(urlinventory);

        driver.close();
        driver.quit();
    }

    //Add to basket
    @And("user add item")
    public void userAddItem() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
    }
    @Then("user can see item in basket")
    public void userCanSeeItemInBasket() {
        driver.findElement(By.xpath("//a[@href='https://www.saucedemo.com/cart.html']")).isDisplayed();
        String urlcart = driver.findElement(By.xpath("//a[@href='https://www.saucedemo.com/cart.html']")).getText();
        System.out.println(urlcart);

        driver.close();
        driver.quit();
    }

    //Checkout
    @And("user click cart button")
    public void userClickCartButton() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']")).click();
    }

    @And("user fill the form")
    public void userFillTheForm() {
        driver.findElement(By.name("firstName")).sendKeys("Gipari");
        driver.findElement(By.name("lastName")).sendKeys("Hilman");
        driver.findElement(By.name("postalCode")).sendKeys("40232");
    }

    @And("user click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium cart_button']")).click();
    }

    @Then("checkout complete webpage is showing")
    public void checkoutCompleteWebpageIsShowing() {
        driver.findElement(By.xpath("//a[@href='https://www.saucedemo.com/checkout-complete.html']")).isDisplayed();
        String urlCompleted = driver.findElement(By.xpath("//a[@href='https://www.saucedemo.com/checkout-complete.html']")).getText();
        System.out.println(urlCompleted);
        driver.findElement(By.xpath("//button=[@id=react-burger-menu-btn']")).click();
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();

        driver.close();
        driver.quit();
    }

    //Login With Unregistered User

    @And("I input wrong user {string}")
    public void iInputWrongUser(String arg0) {
        driver.findElement(By.name("user-name")).sendKeys("gipari");
    }

    @And("I input wrong password {string}")
    public void iInputWrongPassword(String arg0) {
        driver.findElement(By.name("password")).sendKeys("gipari");
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @Then("user can't succesfully login")
    public void userCanTSuccesfullyLogin() {
        driver.findElement(By.xpath("//a[@href='https://www.saucedemo.com']")).isDisplayed();
        String urlfailed = driver.findElement(By.xpath("//a[@href='https://www.saucedemo.com']")).getText();
        System.out.println(urlfailed);
        driver.close();
        driver.quit();
    }


}
