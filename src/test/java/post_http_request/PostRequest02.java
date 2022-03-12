package post_http_request;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;
import test_data.DummyTestData;

import java.sql.ResultSet;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends DummyBaseUrl {
    /*
   http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
   {
       "name":"Ali Can",
       "salary":"2000",
       "age":"40",
   }
   gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin,
   {
       "status": "success",
       "data": {
       “id”:…
   },
       "message": "Successfully! Record has been added."
   }
   olduğunu test edin
    */

    @Test
    public void postTest02(){

        //1) URL OLUSTUR
        spec02.pathParams("1","api","2","v1","3","create");

        //2) EXPECTED DATA
        DummyTestData dummyTestData=new DummyTestData();


        JSONObject requestBody=dummyTestData.setUpTestAndRequestData();

        //3) REQUEST VE RESPONSE
        Response response = given()
                            .accept(ContentType.JSON)
                            .spec(spec02)
                            .body(requestBody
                            .toString())
                            .post("/{1}/{2}/{3}");

        response.prettyPrint();



        // DOGRULAMA

        JSONObject expectedData=dummyTestData.expectedRequest();

        JsonPath json=response.jsonPath();

        Assert.assertEquals(expectedData.getInt("statusCode"),response.statusCode());
        Assert.assertEquals(expectedData.getString("status"),json.getString("status"));
        Assert.assertEquals(expectedData.getString("message"),json.getString("message"));







    }



}
