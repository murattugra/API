package get_http_request;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest19 extends DummyBaseUrl {

     /*
   http://dummy.restapiexample.com/api/v1/employees
   1) Status kodunun 200,
   2) 10’dan büyük tüm id’leri ekrana yazdırın ve 10’dan büyük 14 id olduğunu,
   3) 30’dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu
   4) Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın
      ve bunların içerisinde “Charde Marshall” olduğunu test edin
   */

    @Test
    public void test19(){

        spec02.pathParams("bir","api","iki","v1","uc","employees");

        Response response=given().spec(spec02).when().get("/{bir}/{iki}/{uc}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        JsonPath jsonPath=response.jsonPath();

        List<Integer> idList=jsonPath.getList("data.findAll{it.id>10}.id");
        System.out.println("isList : "+idList);

       // 3) 30’dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu

           List<Integer> sartliyaslar=jsonPath.getList("data.findAll{it.employee_age<30}.employee_age");
        Collections.sort(sartliyaslar);
   //    Assert.assertTrue(sartliyaslar.get(sartliyaslar.size()-1)==23);\

        Assert.assertEquals( (Integer)23,sartliyaslar.get(sartliyaslar.size()-1));

        System.out.println(sartliyaslar);
        // 4) Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın
      //  ve bunların içerisinde “Charde Marshall” olduğunu test edin

        List<String> maasSartliIsimler=jsonPath.getList("data.findAll{it.employee_salary>350000}.employee_name");

        Assert.assertTrue(maasSartliIsimler.contains("Charde Marshall"));



    }

}
