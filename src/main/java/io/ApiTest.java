package io;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ApiTest {

    public void GetTest() {
        baseURI = "https://reqres.in/api";

        Response response = RestAssured.get("/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
    }

    public void ListUsers_Get(int statusCode) { //200
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(statusCode).
                body("data.id[0]", equalTo(7));

    }

    public void login_Post(String Email, String Password, int statusCode) { //basic("eve.holt@reqres.in", "pistol"). //200
        given().
                auth().
                basic(Email, Password).
                when().
                get("https://reqres.in/api/register").
                then().
                statusCode(statusCode).
                log().body();
    }


    public void userNotFound_Get(int statusCode) { //404
        given().
                get("https://reqres.in/api/unknown/23").
                then().
                statusCode(statusCode).
                log().body();
    }

    public void create_Post(String name, String job, int statusCode) { //201
        //baseURI="https://reqres.in/api";
        JSONObject request = new JSONObject();

        request.put("name", name);
        request.put("job", job);

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(statusCode).
                log().body();
    }


    public void register_Post(String email, String password, int statusCode) { // eve.holt@reqres.in ,  pistol , 200
        //baseURI="https://reqres.in/api";
        JSONObject request = new JSONObject();
        request.put("email", email);
        request.put("password", password);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/register").
                then().
                statusCode(statusCode).
                log().body();
    }

    public void request_Delete(int statusCode) { //204
        when().
                delete("https://reqres.in/api/users/2").
                then().
                statusCode(statusCode);
    }
}
