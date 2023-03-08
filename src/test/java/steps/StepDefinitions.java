package steps;

import io.ApiTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {


    ApiTest apiTEST=new ApiTest();


    @Given("test GET for ListUsers with status code {int}")
    public void testGETListUsersWithStatusCode(int statusCode) {
        apiTEST.ListUsers_Get(statusCode);
    }

    @And("test Delete with status code {int}")
    public void testDeleteWithStatusCode(int statusCode) {
        apiTEST.request_Delete(statusCode);
    }

    @Then("test GET for userNotFound with status code {int}")
    public void testGETForUserNotFoundWithStatusCode(int statusCode) {
        apiTEST.userNotFound_Get(statusCode);
    }




    @Given("test POST for Login with {string} and {string} status code {int}")
    public void testPOSTForLoginWithAndStatusCode(String Email, String Password, int statusCode) {
        apiTEST.login_Post(Email,Password,statusCode);
    }

    @Then("test POST for create user with {string} and {string} status code {int}")
    public void testPOSTForCreateUserAndStatusCode(String Email, String Password, int statusCode) {
        apiTEST.create_Post(Email,Password,statusCode);
    }

    @And("test POST for register user with {string} and {string} status code {int}")
    public void testPOSTForRegisterUserWithAndStatusCode(String Email, String Password, int statusCode) {
        apiTEST.register_Post(Email,Password,statusCode);
    }
}
