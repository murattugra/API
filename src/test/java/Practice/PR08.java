package Practice;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PR08 extends DummyBaseUrl {
      /*
   http://dummy.restapiexample.com/api/v1/employees url'inde bulunan
   // 1) Butun calisanlarin isimlerini consola yazdıralim
        // 2) 3. calisan kisinin ismini konsola yazdıralim
        //3) Ilk 5 calisanin adini konsola yazdiralim
        //3) Ilk 5 calisanin adini konsola yazdiralim
        // 4) En son calisanin adini konsola yazdiralim

*/

    @Test
    public void pr08(){


      //  Response response=given().spec(spec02).when().get("/api/v1"); direk bu sekildede yazilabilir
        spec02.pathParams("p1","api","p2","v1",
                "p3","employees");

        Response response=given().spec(spec02).when().get("/{p1}/{p2}/{p3}");

    //    response.prettyPrint();

        // 1) Butun calisanlarin isimlerini consola yazdıralim

        JsonPath json=response.jsonPath();

        List<String> lst=json.getList("data.employee_name");
        System.out.println(lst);

        // System.out.println(json.getString("data.employee_name"));  buda olur

        // 2) 3. calisan kisinin ismini konsola yazdıralim

        System.out.println("3. calisan kisi  :"+json.getString("data[2].employee_name"));

        //3) Ilk 5 calisanin adini konsola yazdiralim

        //1.Yontem
        System.out.println(json.getString("data[0,1,2,3,4].employee_name"));
        //2.Yontem
        for (int i = 0; i <5 ; i++) {
            System.out.println(json.getString("data["+ i+ "].employee_name"));
        }
        //3.yontem
        json.getList("data.employee_name").stream().limit(4).forEach(t-> System.out.println(t));


        // 4) En son calisanin adini konsola yazdiralim

        System.out.println(json.getString("data[-1].employee_name"));


    }



}
