package delete_request;

import base_url.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyPojoDelete;

public class DeleteRequest01 extends DummyBaseUrl {


     /*
    http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
    Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
    {
    "status": "success",
    "data": "2",
    "message": "Successfully! Record has been deleted"
    }
   */


    @Test
    public void testDelete() {

        spec02.pathParams("1","api","2","v1","3","delete","4","2");


        DummyPojoDelete expectedData=new DummyPojoDelete("success",2,"Successfully! Record has been deleted");

        System.out.println("expectedData = " + expectedData);
        Response response= RestAssured.given().contentType(ContentType.JSON).spec(spec02).when().delete("/{1}/{2}/{3}/{4}");

        response.prettyPrint();


        DummyPojoDelete actualData=response.as(DummyPojoDelete.class);

        System.out.println("actualData = " + actualData);


        Assert.assertEquals(expectedData.getStatus(),actualData.getStatus());
        Assert.assertEquals(expectedData.getData(),actualData.getData());
        Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());


    }
}
