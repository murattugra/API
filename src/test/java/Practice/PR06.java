package Practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PR06 {

    // https://restful-booker.herokuapp.com/booking/5 url’ine
    //accept type’i “application/json” olan GET request’i yolladigimda
    //gelen response’un
    //status kodunun 200
    //ve content type’inin “application/json”
    //ve firstname’in “Eric”
    //ve totalprice’in 600
    //ve checkin date’in 2015-06-12"oldugunu test edin

    @Test
    public void pr06(){

        Response response=given().when().get("https://restful-booker.herokuapp.com/booking/5");

        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        response.then().assertThat()
                .body("firstname", Matchers.equalTo("Eric")
                ,"totalprice",898).body("bookingdates.checkin",Matchers.equalTo("2020-02-27"));



    }
}
