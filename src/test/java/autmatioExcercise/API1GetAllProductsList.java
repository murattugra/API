package autmatioExcercise;

import base_url.AutomationExcerciseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;

public class API1GetAllProductsList extends AutomationExcerciseUrl {



    //API URL: https://automationexercise.com/api/productsList
    //Request Method: GET
    //Response Code: 200
    //Response JSON: All products list


    @Test
    public void aut01(){

        spec06.pathParams("first","productsList");

        Response response=given().spec(spec06).when().get("/{first}");


        response.prettyPrint();

        response.then().assertThat().body("body.responseCode", Matchers.equalTo(200));


    }

}
