
package eventhub.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eventhub.baseutility.BaseClass;
import eventhub.pageobjectmodel.Events;
import eventhub.pageobjectmodel.Login;
import eventhub.pageobjectmodel.Registration;

/**
 * This class contains test cases for the login and registration flow.
 * It uses data-driven testing with a JSON data provider.
 */
public class LoginAndRegisterFlow extends BaseClass {

    /**
     * Test method for the login and registration flow.
     * 
     * @param input A HashMap containing test data for the flow.
     */
    @Test(dataProvider = "getData")
    public void loginFlow(HashMap<String, String> input) {
        // Step 1: Launch the application and initialize the Login page object
        Login login = new Login(driver);
        login.launchApplication();

        // Step 2: Scroll to the "Register" link to ensure it is visible
        WebElement registerLink = login.getRegisterLinkElement(); // Method to locate the register link
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", registerLink);

        // Step 3: Click on the "Register" link
        login.clickOnRegisterLink();

        // Step 4: Complete the registration process
        Registration registration = new Registration(driver);
        registration.completeRegistration(input.get("emailidV"), input.get("passV"), input.get("confirmPasswordV"));

        // Step 5: Relaunch the application and perform login
        login.launchApplication();
        login.loginToApplication(input.get("emailIdV"), input.get("passwordV"));

        // Step 6: Navigate to the "Events" tab and perform event booking
        Events events = new Events(driver);
        events.clickOnEventsTab();
        events.clickOnEvent(input.get("eventNameV"));
        events.bookTicketsDetailsFill(input.get("firstNameV"), input.get("emailV"), input.get("phoneNumberV"));

        // Step 7: Confirm the booking
        events.clickOnConfirmBooking();
    }

    /**
     * Data provider method to supply test data from a JSON file.
     * 
     * @return A 2D Object array containing test data.
     * @throws IOException If there is an issue reading the JSON file.
     */
    @DataProvider
    public Object[][] getData() throws IOException {
        // Read test data from the JSON file
        List<HashMap<String, String>> data = getJson(System.getProperty("user.dir") + "\\src\\test\\java\\eventhub\\resources\\data.json");
        return new Object[][] { { data.get(0) } };
    }
}
