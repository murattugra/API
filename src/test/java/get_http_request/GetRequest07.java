package get_http_request;

import base_url.RegresinBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest07 extends RegresinBaseUrl {

    /*
    https://reqres.in/api/users URL request olustur.
    body icerisindeki idsi 5 olan datayi
    1) Matcher CLASS ile
    2) JsonPath ile dogrulayin.
    */

    @Test
    public void test07(){

        spec01.pathParams("parametre1", "api" , "parametre2", "users");

        //  https://reqres.in
        Response response = given().spec(spec01).when().get("/{parametre1}/{parametre2}");
        // "/{parametre1}/{parametre2}" -> /api/users

        response.prettyPrint();

        response.then().assertThat().body("data[4].email", equalTo("charles.morris@reqres.in"),
                "data[4].first_name", equalTo("Charles"),
                "data[4].last_name", equalTo("Morris"),
                "data[4].avatar", equalTo("https://reqres.in/img/faces/5-image.jpg"));


        //JsonPath

        JsonPath json =  response.jsonPath();

        System.out.println(json.getList("data.email"));

        System.out.println(json.getString("data.first_name"));

        assertEquals("charles.morris@reqres.in",json.getString("data[4].email"));

        assertEquals("Charles",json.getString("data[4].first_name"));


    }
}