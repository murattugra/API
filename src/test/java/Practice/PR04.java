package Practice;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PR04 {
        /*
http://dummy.restapiexample.com/api/v1/employees  url'ine
 GET request'i yolladigimda gelen response'un
 status kodunun 200 ve content type'inin "application/json"
ve employees sayisinin 24
ve employee'lerden birinin "Ashton Cox"
ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
 */


    @Test
    public void pr04(){

        Response response=given().when().get("http://dummy.restapiexample.com/api/v1/employees");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("data", Matchers.hasSize(24)).body("data.employee_name",Matchers.hasItem("Ashton Cox"))
                .body("data.employee_age",Matchers.hasItems(21,61,23));



    }
}
