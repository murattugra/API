package test_data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> setUpTestData(){

        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("completed", false);
        expectedData.put("userId", 1);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("Server", "cloudflare");
        return expectedData;
    }

    /*
        {
    "userId": 55,
    "title": "Tidy your room",
    "completed": false
  }
     */

    public JSONObject setUpPostData(){
        JSONObject expectedRequest = new JSONObject();
        expectedRequest.put("userId", 55);
        expectedRequest.put("title", "Tidy your room");
        expectedRequest.put("completed", false);
     //   expectedRequest.put("statusCode", 201);
      //  expectedRequest.put("id", 201);
        return expectedRequest;
    }


    public HashMap<String,Object> expectedRequest(){
        // "userId": 55,
        //    "title": "Tidy your room",
        //    "completed": false

        HashMap<String,Object> expectedRequest=new HashMap<>();

        expectedRequest.put("userID",55);
        expectedRequest.put("title","Tidy your room");
        expectedRequest.put("completed",false);


        return expectedRequest;

    }

    public JSONObject request02(){
        //"userId": 21,
        //    "id": 201,
        //    "title": "Tidy your room",
        //    "completed": false

        JSONObject request=new JSONObject();
        request.put("userId",21);
        request.put("id",201);
        request.put("title","Tidy your room");
        request.put("completed",false);


        return request;
    }



}
