package integration.factory.steps;
import integration.factory.funcs.LoginFunc;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStep {

    LoginFunc loginFunc = new LoginFunc();


    @Given("I access the {string} to realize login")
    public void accessWebSite(String Url) {
        loginFunc.accessUrl(Url);
    }

    @When("I realize login with the user {string} and password {string}")
    public void realizeLogin(String Username,String Password){
        loginFunc.realizeLogin(Username,Password);
    }
}
