package Practice;

import base_url.GMIBankBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PR18 extends GMIBankBaseUrl {
        /*
           http://www.gmibank.com/api/tp-customers/43703

           "firstName": "Alda",
           "lastName": "Monahan",
           "middleInitial": "Nichelle Hermann Kohler",
           "email": "com.github.javafaker.Name@7c011174@gmail.com",
           "mobilePhoneNumber": "909-162-8114",
           "city": "St Louis",
           "ssn": "108-53-6655"

           1) MATCHERS CLASS
           2) JSON PATH
           3) De-Serialization
     */

    @Test
    public void pr18(){

        spec03.pathParams("bir","tp-customers","iki","43703");

        Response response = given()
                .spec(spec03)
                .header("Authorization","Bearer " + generateToken())
                .when()
                .get("/{bir}/{iki}");

        response.prettyPrint();

        // 1) MATCHERS CLASS

        response.then().assertThat().body("firstName", equalTo("Alda"),
                "lastName",equalTo("Monahan"),"middleInitial",equalTo("Nichelle Hermann Kohler")
        ,"email",equalTo("com.github.javafaker.Name@7c011174@gmail.com"),"mobilePhoneNumber",equalTo("909-162-8114")
        ,"city",equalTo("St Louis"),"ssn",equalTo("108-53-6655"));


        // 2) JSONPATH ile

        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals("Alda",jsonPath.getString("firstName"));
        Assert.assertEquals("Monahan",jsonPath.getString("lastName"));
        Assert.assertEquals("Nichelle Hermann Kohler",jsonPath.getString("middleInitial"));
        Assert.assertEquals("com.github.javafaker.Name@7c011174@gmail.com",jsonPath.getString("email"));
        Assert.assertEquals("909-162-8114",jsonPath.getString("mobilePhoneNumber"));
        Assert.assertEquals("St Louis",jsonPath.getString("city"));
        Assert.assertEquals("108-53-6655",jsonPath.getString("ssn"));


        // 3) De-Serialization

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstName", "Alda");
        expectedData.put("lastName", "Monahan");
        expectedData.put("middleInitial", "Nichelle Hermann Kohler");
        expectedData.put("email", "com.github.javafaker.Name@7c011174@gmail.com");
        expectedData.put("mobilePhoneNumber", "909-162-8114");
        expectedData.put("city", "St Louis");
        expectedData.put("ssn", "108-53-6655");

        Map<String,Object> actualData=response.as(HashMap.class);

        Assert.assertEquals(expectedData.get("firstName"), actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"), actualData.get("lastName"));
        Assert.assertEquals(expectedData.get("middleInitial"), actualData.get("middleInitial"));
        Assert.assertEquals(expectedData.get("email"), actualData.get("email"));
        Assert.assertEquals(expectedData.get("mobilePhoneNumber"), actualData.get("mobilePhoneNumber"));
        Assert.assertEquals(expectedData.get("city"), actualData.get("city"));
        Assert.assertEquals(expectedData.get("ssn"), actualData.get("ssn"));






    }


}
