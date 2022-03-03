package get_http_request;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest04 {


    /*
http://dummy.restapiexample.com/api/v1/employees  url'ine
 GET request'i yolladigimda gelen response'un
 status kodunun 200 ve content type'inin "application/json"
ve employees sayisinin 24
ve employee'lerden birinin "Ashton Cox"
ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
 */

    @Test
    public void test04(){

        String url="http://dummy.restapiexample.com/api/v1/employees";


        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200).contentType("application/json");

        response.prettyPrint();

        response.then().assertThat().body("data", Matchers.hasSize(24));//hasSiz ile burada 24 tane data var mi dedik

        response.then().assertThat().body("data.employee_name",Matchers.hasItem("Ashton Cox"));// employee_name ler icerisinde
                                                                                                 // "Ashton Cox varmidir?

        response.then().assertThat().body("data.employee_age",Matchers.hasItems(21,61,23));// bir kac tane icerir mi de hasItems kullnili
                                                                                            // bi tane icerir mide hasItem kullanilir




    }


}
