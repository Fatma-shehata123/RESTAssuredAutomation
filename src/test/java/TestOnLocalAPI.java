import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import static org.hamcrest.Matchers.*;
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
                body("firstName", equalTo("John")).
                body("id", notNullValue()).
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
                put("/users/e186").
        then().
                body("firstName", equalTo("omar")).
                body("id", notNullValue()).
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
                patch("/users/161a").
        then().
                body("firstName", equalTo("Omar")).
                body("id", notNullValue()).
                statusCode(200).
                log().all();
    }

    @Test
    public void delete(){
        baseURI = "http://localhost:3000";

            when().
                delete("/users/8885").
            then().
                statusCode(200).
                log().all();
    }

}
