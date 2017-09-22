package api.rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Reqres {

    @BeforeClass
    public void setUrlService(){
        RestAssured.baseURI="https://reqres.in/api";
    }

    @Test()
    public void createUser(){
        given().contentType("application/json").body("{ \"name\" : \"ivan\" , \"job\" : \"butcher\" }").when().post("/users").then().statusCode(201);
    }

    @Test()
    public void updateUser(){
        given().contentType("application/json").body("{ \"name\" : \"ivan\" , \"job\" : \"butcher\" }").when().put("/users/1").then().statusCode(200).body("name",equalTo("ivan")).body("job",equalTo("butcher"));
    }

    @Test()
    public void getUsers(){
        get("/users").then().statusCode(200);
        String response = get("/users").asString();
        Integer id = JsonPath.from(response).get("data.find { it.first_name == 'Emma' }.id");
        given().when().get("users/"+id).then().statusCode(200).body("data.first_name",equalTo("Emma")).body("data.last_name",equalTo("Wong")).body("data.avatar",equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg"));
    }
}
