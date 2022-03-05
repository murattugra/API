package Practice;


import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PR10 extends DummyBaseUrl {
       /*
    http://dummy.restapiexample.com/api/v1/employees
    url ine bir istek gönderildiğinde,
    status kodun 200,
    gelen body de,
    5. çalışanın isminin "Airi Satou" olduğunu ,
    6. çalışanın maaşının "372000" olduğunu ,
    Toplam 24 tane çalışan olduğunu,
    "Rhona Davidson" ın employee lerden biri olduğunu
    "21", "23", "61" yaşlarında employeeler olduğunu test edin
    JSONPATH KULLARAK
*/

    @Test
    public void pr10(){

        spec02.pathParams("first", "api", "second", "v1", "third", "employees");


        Response response = given().spec(spec02).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(200,response.statusCode());

        Assert.assertEquals("Airi Satou",jsonPath.getString("data[4].employee_name"));
        Assert.assertEquals(372000,jsonPath.getInt("data[5].employee_salary"));
        Assert.assertEquals(24,jsonPath.getList("data.id").size());
        Assert.assertTrue(jsonPath.getString("data.employee_name").contains("Rhona Davidson"));
        List<Integer> age=new ArrayList<>();
        age.add(21);
        age.add(23);
        age.add(61);
        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(age));








    }

}




