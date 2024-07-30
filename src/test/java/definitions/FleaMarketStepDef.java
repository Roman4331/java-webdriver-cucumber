package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static support.DriverFactory.getDriver;

public class FleaMarketStepDef {
    @Given("I navigate to fleaMarket Page")
    public void iNavigateToFleaMarketPage() {
        getDriver().get("https://store-qa.portnov.com/");
    }

    @Then("I verify title of the page is {string}")
    public void iVerifyTitleOfThePageIs(String title) {
        assertThat(getDriver().getTitle()).isEqualTo(title);
    }

    @When("I add {string} from the Landing Page")
    public void iAddFromTheLandingPage(String product) {
        String id = "";
        switch(product) {
            case "AirPods Pro":
                id = "58";
                break;
            case "Apple Watch Series 6":
                id = "48";
                break;
            case "iMac":
                id = "46";
                break;
            case "IPhone XR":
                id = "55";
                break;
            case "Macbook Air":
                id = "42";
                break;
            default:
                System.out.println("Bad var");
        }
        getDriver().findElement(By.xpath("//a[@data-product_id='" + id +"']")).click();
    }

    @And("I click the View Cart button from the Landing Page")
    public void iClickTheViewCartButton() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View cart']")));
        getDriver().findElement(By.xpath("//a[@title='View cart']")).click();
    }

    @When("I click Proceed to checkout from the cart page")
    public void iClickProceedToCheckoutFromTheCartPage() {
        getDriver().findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
    }

    @When("I fill out all the required information at checkout")
    public void iFillOutAllTheRequiredInformationAtCheckout() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id("main")));
        getDriver().findElement(By.id("billing_first_name")).sendKeys("firtName");
        getDriver().findElement(By.id("billing_last_name")).sendKeys("lastName");
        getDriver().findElement(By.id("billing_address_1")).sendKeys("123 Main st");
        getDriver().findElement(By.id("billing_city")).sendKeys("Testsvile");
        getDriver().findElement(By.id("billing_postcode")).sendKeys("94858");
        getDriver().findElement(By.id("billing_email")).sendKeys("test@test.com");
    }

    @And("I click Place Order button")
    public void iClickPlaceOrderButton() throws Exception {
        Thread.sleep(2000);
        getDriver().findElement(By.id("place_order")).click();
    }

    @Then("I verify I landed on Order Received page")
    public void iVerifyILandedOnOrderReceivedPage() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")));
        assertThat(getDriver().findElement(By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")).getText()).isEqualTo("Thank you. Your order has been received.");
    }

    @Then("I verify that {string} appears in my order details")
    public void iVerifyThatAppearsInMyOrderDetails(String product) {
        String text = getDriver().findElement(By.xpath("//table[@class='woocommerce-table woocommerce-table--order-details shop_table order_details']")).getText();
        System.out.println(text);
        assertThat(text).contains(product);
    }
}
