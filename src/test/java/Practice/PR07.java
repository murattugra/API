package Practice;

import base_url.RegresinBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PR07 extends RegresinBaseUrl {
    /*
    https://reqres.in/api/users URL request olustur.
    body icerisindeki idsi 5 olan datayi
    1) Matcher CLASS ile
    2) JsonPath ile dogrulayin.
    */


    @Test
    public void pr07(){

        spec01.pathParams("pr1","api","pr2","users");

        Response response=given().spec(spec01).when().get("/{pr1}/{pr2}");

    //    response.prettyPrint();

        //Matcher Class ile
        response.then().assertThat().body("data[4].first_name", Matchers.equalTo("Charles"));

        //JsonPath ile

        JsonPath json=response.jsonPath();

       Assert.assertEquals("Charles", json.getString("data[4].first_name"));



    }
}
