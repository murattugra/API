package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationExcerciseUrl {

    protected RequestSpecification spec06;

    @Before
    public void setUp(){

        spec06= new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();

    }

}
