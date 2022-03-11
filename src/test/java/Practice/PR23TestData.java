package Practice;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;
import test_data.DummyTestData2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PR23TestData extends DummyBaseUrl {


      /*
   http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
   Status kodun 200 olduğunu,
   14. Çalışan isminin "Haley Kennedy" olduğunu,
   Çalışan sayısının 24 olduğunu,
   Sondan 3. çalışanın maaşının 675000 olduğunu
   40,21 ve 19 yaslarında çalışanlar olup olmadığını
   10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi
   {
           "id": 10,
           "employee_name": "Sonya Frost",
           "employee_salary": 103600,
           "employee_age": 23,
           "profile_image": ""
    }
     olduğunu test edin.
   */


    @Test
    public void pr23(){

        spec02.pathParams("bir","api","iki","v1","uc","employees");

        Response response=given().spec(spec02).when().get("/{bir}/{iki}/{uc}");

        response.prettyPrint();
        // De-Serialization

        DummyTestData2 dummyTestData2=new DummyTestData2();

        HashMap<String , Object> expectedData=dummyTestData2.setUpData();

        System.out.println(expectedData);
        HashMap<String,Object> actualData=response.as(HashMap.class);

        System.out.println(actualData);

        //Status kodun 200 olduğunu,
       Assert.assertEquals(expectedData.get("Status Kod"),response.statusCode());
      // 14. Çalışan isminin "Haley Kennedy" olduğunu,
       Assert.assertEquals(expectedData.get("ondorduncuCalisan"),((HashMap)((List)actualData.get("data")).get(13)).get("employee_name"));

       // Çalışan sayısının 24 olduğunu,
        Assert.assertEquals(expectedData.get("calisanSayisi"),((List<?>) actualData.get("data")).size());

       // Sondan 3. çalışanın maaşının 675000 olduğunu

        Assert.assertEquals(expectedData.get("sondanUcuncuCalisanMaasi"),((HashMap)((List<?>) actualData.get("data"))
                .get(((List<?>) actualData.get("data")).size()-3)).get("employee_salary"));

        // 40,21 ve 19 yaslarında çalışanlar olup olmadığını

        int dataSize=((List<?>) actualData.get("data")).size();
        System.out.println(dataSize);
        List<Integer> butunYaslar=new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
                butunYaslar.add((Integer) ((HashMap)((List<?>) actualData.get("data"))
                        .get(i)).get("employee_age"));
        }

        Assert.assertTrue(butunYaslar.containsAll((Collection<?>) expectedData.get("yaslar")));


        //   10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi
        //   {
        //           "id": 10,
        //           "employee_name": "Sonya Frost",
        //           "employee_salary": 103600,
        //           "employee_age": 23,
        //           "profile_image": ""
        //    }


        HashMap<String,Object> onuncuCalisanMap= (HashMap<String, Object>) expectedData.get("onuncuCalisan");

      //  System.out.println(onuncuCalisanMap);

        Assert.assertEquals(onuncuCalisanMap.get("id"),((HashMap)((List<?>) actualData.get("data")).get(9)).get("id"));
        Assert.assertEquals(onuncuCalisanMap.get("employee_name"),((HashMap)((List<?>) actualData.get("data")).get(9)).get("employee_name"));
        Assert.assertEquals(onuncuCalisanMap.get("employee_salary"),((HashMap)((List<?>) actualData.get("data")).get(9)).get("employee_salary"));
        Assert.assertEquals(onuncuCalisanMap.get("employee_age"),((HashMap)((List<?>) actualData.get("data")).get(9)).get("employee_age"));
        Assert.assertEquals(onuncuCalisanMap.get("profile_image"),((HashMap)((List<?>) actualData.get("data")).get(9)).get("profile_image"));
    }



}
