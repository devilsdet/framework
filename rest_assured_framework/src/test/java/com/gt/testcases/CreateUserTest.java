package com.gt.testcases;

import com.gt.utils.PropertyFileReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void createUserTest() {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = RestAssured.given()
                                .baseUri(PropertyFileReader.getProperty("app.baseUri"))
                                .basePath("api/users")
                                .body(body)
                                .post();
        System.out.println(response.prettyPrint());
    }
}
