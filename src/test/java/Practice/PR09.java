package Practice;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PR09 extends DummyBaseUrl {
     /*
    http://dummy.restapiexample.com/api/v1/employee/12 URL'E GiT.
    1) Matcher CLASS ile
    2) JsonPath ile dogrulayin.
    */


@Test
    public void pr09(){

    spec02.pathParams("bir","api","iki","v1","uc","employee","dort","12");

    Response response=given().spec(spec02).when().get("/{bir}/{iki}/{uc}/{dort}");

    response.prettyPrint();

    //Matcher Class
    response.then().assertThat().body("data.id",equalTo(12),
            "data.employee_name",equalTo("Quinn Flynn"),
            "data.employee_salary",equalTo(342000));

    //JSONPAth ile


    JsonPath json=response.jsonPath();

    Assert.assertEquals(12,json.getInt("data.id"));
    Assert.assertEquals("Quinn Flynn",json.getString("data.employee_name"));
    Assert.assertEquals(342000,json.getInt("data.employee_salary"));


}

}
