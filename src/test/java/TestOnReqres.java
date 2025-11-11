import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOnReqres {

    @BeforeClass
    public void setup() {

        baseURI = "https://reqres.in/api";
    }

    @Test
    public void testGet() {

        given().
                headers("x-api-key" , "reqres-free-v1").
                get("/users?page=2").
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

        given().
                header("Content-Type" , "application/json").
                headers("x-api-key" , "reqres-free-v1").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                body("job", equalTo("leader")).
                statusCode(201);

    }

    @Test
    public void testPut() {
        JSONObject request = new JSONObject();

        request.put("name", "morpheus");
        request.put("job", "zion resident");

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
    public void testPatch() {
        JSONObject request = new JSONObject();

        request.put("name", "morpheus");
        request.put("job", "zion resident");

        given().
                header("Content-Type" , "application/json").
                headers("x-api-key" , "reqres-free-v1").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                patch("/users/2").
        then().
                statusCode(200)
                .body("job", equalTo("zion resident"))
                .log().all();

    }

    @Test
    public void testDelete() {

        given().
                headers("x-api-key" , "reqres-free-v1").
        when().
                delete("api/user/2").
        then().
                statusCode(204)
                .log().all();
    }
}
