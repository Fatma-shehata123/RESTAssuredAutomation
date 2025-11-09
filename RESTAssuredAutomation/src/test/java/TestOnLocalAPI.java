import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestOnLocalAPI {
    @Test
    public void get(){
        baseURI = "http://localhost:3000";
        given().
                get("/users").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void post(){
        JSONObject requset = new JSONObject();
        requset.put("firstName", "John");
        requset.put("lastName", "Doe");
        requset.put("subjectId" , 1);

        baseURI = "http://localhost:3000";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(requset.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();
    }

    @Test
    public void put(){
        JSONObject requset = new JSONObject();
        requset.put("firstName", "omar");
        requset.put("lastName", "elbably");
        requset.put("subjectId" , 1);

        baseURI = "http://localhost:3000";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(requset.toJSONString()).
        when().
                put("/users/4eb5").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void patch(){
        JSONObject requset = new JSONObject();
        requset.put("firstName", "Omar");
        requset.put("lastName", "Elbably");

        baseURI = "http://localhost:3000";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(requset.toJSONString()).
        when().
                patch("/users/4eb5").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void delete(){
        baseURI = "http://localhost:3000";

            when().
                delete("/users/3").
            then().
                statusCode(200).
                log().all();
    }

}
