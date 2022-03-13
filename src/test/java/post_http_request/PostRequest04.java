package post_http_request;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import javax.swing.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class PostRequest04 extends JsonPlaceHolderBaseUrl {
      /*
    https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
    Request body{
    "userId": 21,
    "id": 201,
    "title": "Tidy your room",
    "completed": false
    }
    Status kodun 201, response body ‘nin ise
    {
    "userId": 21,
    "id": 201,
    "title": "Tidy your room",
    "completed": false
    }
    */


    @Test
    public void POstRequest04(){

        spec04.pathParams("parameter","todos");

        JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();

        JSONObject expectedData=jsonPlaceHolderTestData.request02();


        Response response= RestAssured.given().contentType(ContentType.JSON).spec(spec04).body(expectedData.toString()).post("/{parameter}");
        response.prettyPrint();

     

        //Status kodun 201, response body ‘nin ise
        //    {
        //    "userId": 21,
        //    "id": 201,
        //    "title": "Tidy your room",
        //    "completed": false
        //    }
        HashMap<String,Object> actualData=response.as( HashMap.class);

        Assert.assertEquals(201,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.getInt("id"),actualData.get("id"));
        Assert.assertEquals(expectedData.getBoolean("completed"),actualData.get("completed"));






    }


}
