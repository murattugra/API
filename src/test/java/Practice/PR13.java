package Practice;

import base_url.GMIBankBaseUrl;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PR13 extends GMIBankBaseUrl {

    /*
    http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın
    "firstName": "Della",
    "lastName": "Heaney",
    "mobilePhoneNumber": "123-456-7893",
    "address": "75164 McClure Stream",
    "country" : "USA"
    "state": "New York43"
    "CREDIT_CARD",hesabında 69700$ ,
    "CHECKING" hesabında 11190$
     */

    @Test
    public void pr13(){
        spec03.pathParams("iki","tp-customers"
        ,"uc","114351");

        Response response=given().spec(spec03).header("Authorization","Bearer "+generateToken()
                ).when().get("/{iki}/{uc}");

        Map<String,Object> expectedMap=new HashMap<>();
        expectedMap.put("firstName","Della");
        expectedMap.put("lastName","Heaney");
        expectedMap.put("mobilePhoneNumber","123-456-7893");
        expectedMap.put("address","75164 McClure Stream");
        expectedMap.put("country","USA");
        expectedMap.put("state","New York43");

        Map<String,Object> actualMap=response.as(HashMap.class);

        System.out.println(actualMap);

        Assert.assertEquals(expectedMap.get("firstName"),actualMap.get("firstName"));
        Assert.assertEquals(expectedMap.get("lastName"),actualMap.get("lastName"));
        Assert.assertEquals(expectedMap.get("mobilePhoneNumber"),actualMap.get("mobilePhoneNumber"));
        Assert.assertEquals(expectedMap.get("address"),actualMap.get("address"));
       response.then().assertThat().body("country.name", Matchers.equalTo(expectedMap.get("country")));
       Assert.assertEquals(expectedMap.get("state"),actualMap.get("state"));

        response.prettyPrint();




    }

}
