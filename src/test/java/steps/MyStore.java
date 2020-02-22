package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.Assert.assertTrue;

public class MyStore {
    WebDriver driver;
    private String name = "Marian";
    private String lastName = "Paździoch";
    private String randomEmail = randomNumeric(6) + "_maniek@wp.pl";

    @Before
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("^Navigate to shop page$")
    public void navigateToShopPage() {

        driver.get("https://prod-kurs.coderslab.pl/index.php");

    }

    @When("^click on sign in$")
    public void clickOnSignIn() {

        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.partialLinkText("No account")).click();
    }

    @And("^Create account$")
    public void createAccount() {
        driver.findElements(By.className("radio-inline")).get(0).click();
        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("email")).sendKeys(randomEmail);
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.name("birthday")).sendKeys("01/01/1990");
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.className("btn-primary")).click();


    }

    @Then("^Create an account form$")
    public void createAnAccountForm() {
        assertTrue(driver.findElement(By.className("account")).getText().contains(name + " " + lastName));

    }
}
