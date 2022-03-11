package Practice;

import base_url.GMIBankBaseUrl;
import base_url.RegresinBaseUrl;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PR17 extends GMIBankBaseUrl {
     /*
       http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın

    {
       "firstName": "Della",
       "lastName": "Heaney",
       "email": "ricardo.larkin@yahoo.com",
       "mobilePhoneNumber": "123-456-7893",
    }
    */

    @Test
    public void pr17(){

        spec03.pathParams("1","tp-customers","2","114351");

        Response response=given().spec(spec03).header("Authorization" ,"Bearer "+generateToken())
                .when().get("/{1}/{2}");
     //   System.out.println(response.statusCode());
       response.prettyPrint();


       //Json PAth ile

        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals("Della",jsonPath.getString("firstName"));
        Assert.assertEquals("Heaney",jsonPath.getString("lastName"));

        //Matcher class

        response.then().assertThat().body("firstName", Matchers.equalTo("Della")
                ,"lastName",Matchers.equalTo("Heaney"));


        //De-Serialization

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstName","Della");
        expectedData.put("lastName","Heaney");

        Map<String,Object> actualData=response.as(HashMap.class);

        Assert.assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"),actualData.get("lastName"));










    }
}
