package get_http_request;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest20 extends JsonPlaceHolderBaseUrl {

        /*
   https://jsonplaceholder.typicode.com/todos/2
   1) Status kodunun 200,
   2) respose body'de,
            "completed": değerinin false
            "title”: değerinin “quis ut nam facilis et officia qui”
            "userId" sinin 1 ve
       header değerlerinden
            "via" değerinin “1.1 vegur” ve
            "Server" değerinin “cloudflare” olduğunu test edin…
   */


    @Test
    public void test20(){

        spec04.pathParams("bir","todos","iki","2");

        Response response =given().spec(spec04).when().get("/{bir}/{iki}");

        response.prettyPrint();

      response.then().assertThat().header("via", "1.1 vegur").header("Server","cloudflare");

        Map<String,Object> expectedData=new HashMap<>();

      //  "completed": değerinin false
      //  "title”: değerinin “quis ut nam facilis et officia qui”
      //  "userId" sinin 1 ve

        //De -Serialization
        expectedData.put("completed",false);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("userId",1);


        Map<String,Object> actualData=response.as(HashMap.class);

        System.out.println(actualData);

        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));

        //Matchers

        response.then().assertThat().body("userId", Matchers.equalTo(1)
                ,"title",Matchers.equalTo("quis ut nam facilis et officia qui")
        ,"completed",Matchers.equalTo(false));

        //JsonPath

        JsonPath json=response.jsonPath();

        Assert.assertEquals(1,json.getInt("userId"));
        Assert.assertEquals("quis ut nam facilis et officia qui",json.getString("title"));
        Assert.assertEquals(false,json.getBoolean("completed"));



    }
}
