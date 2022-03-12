package post_http_request;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest03 extends JsonPlaceHolderBaseUrl {


    /*
   https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
    {
    "userId": 55,
    "title": "Tidy your room",
    "completed": false
  }
    Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
  {
    "userId": 55,
    "title": "Tidy your room",
    "completed": false,
    "id": 201
   }
*/


    @Test
    public void postTest03(){

        //1) URL OLUSTUR
        spec04.pathParam("bir", "todos");

        //2) EXPECTED DATA
        JsonPlaceHolderTestData testObje = new JsonPlaceHolderTestData();
        JSONObject expectedRequest = testObje.setUpPostData();
        System.out.println("expectedRequest = " + expectedRequest);

        //3) REQUEST VE RESPONSE
        Response response = given()
                .spec(spec04)
                .contentType(ContentType.JSON)
                .body(expectedRequest.toString())
                .when()
                .post("/{bir}");
        response.prettyPrint();

        Response response1=RestAssured.given().spec(spec04).get("/{bir}");
        response1.prettyPrint();

        //DOGRULAMA

       // Matchers Class ile

        response.then().assertThat().statusCode(201)
                                    .body("completed",equalTo(expectedRequest.get("completed"))
                                     ,"title",equalTo(expectedRequest.get("title"))
                                     ,"userId",equalTo(expectedRequest.get("userId"))
                                     ,"id",equalTo(201));

        // Json Path

        JsonPath json=response.jsonPath();

        Assert.assertEquals(201,response.statusCode());
        Assert.assertEquals(expectedRequest.getBoolean("completed"),json.getBoolean("completed"));
        Assert.assertEquals(expectedRequest.getString("title"),json.getString("title"));
        Assert.assertEquals(expectedRequest.getInt("userId"),json.getInt("userId"));
        Assert.assertEquals(201,json.getInt("id"));


        // De- Serialization


        HashMap<String,Object> actualData=response.as(HashMap.class);

        Assert.assertEquals(expectedRequest.getBoolean("completed"),actualData.get("completed"));
        Assert.assertEquals(expectedRequest.getString("title"),actualData.get("title"));
        Assert.assertEquals(expectedRequest.getInt("userId"),actualData.get("userId"));





    }


}
