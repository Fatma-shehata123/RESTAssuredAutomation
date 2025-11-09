import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExamples {

    @Test
    public void testOne() {
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("Response: " + response.asString());
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
        System.out.println("Time token: " +response.getTime());
        System.out.println("Headers: " + response.getHeader("content-type"));

        int statusCode =  response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void testTwo() {

        baseURI = "https://reqres.in/api";
        given().
            get("/users?page=2").
        then().
            statusCode(200).
            body("data[1].id" , equalTo(8)).
            log().all();
    }

    @Test
    public void testGet() {
        baseURI = "https://reqres.in/";
        given().
            get("api/users?page=2").
        then().
            statusCode(200).
            body("data[0].first_name" , equalTo("Michael")).
            body("data.first_name" , hasItems("Lindsay","Tobias"));
    }

    @Test
    public void testPost() {
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "leader");
        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type" , "application/json").
                headers("x-api-key" , "reqres-free-v1").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201);

    }

    @Test
    public void testPut() {
        JSONObject request = new JSONObject();

        request.put("name", "morpheus");
        request.put("job", "zion resident");
        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type" , "application/json").
                headers("x-api-key" , "reqres-free-v1").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("/users/2").
        then().
                statusCode(200)
                .body("job", equalTo("zion resident"))
                .log().all();

    }

    @Test
    public void testDelete() {
        baseURI = "https://reqres.in";
        given().
                headers("x-api-key" , "reqres-free-v1").
        when().
                delete("api/user/2").
        then().
                statusCode(204)
                .log().all();
    }
}
