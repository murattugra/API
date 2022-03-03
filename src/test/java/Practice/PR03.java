package Practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PR03 {
    /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'in "Sally"
ve lastname'in "Ericsson"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin
     */


    @Test
    public void pr03(){

        Response response=given().when().get("https://restful-booker.herokuapp.com/booking/7");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mark")
                ,"lastname",Matchers.equalTo("Wilson")
                ,"bookingdates.checkin",Matchers.equalTo("2022-02-21"));

    }
}
