import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;
import io.restassured.response.Response;
public class JsonSchemaValidator{
    @Test
    public void  jsonSchemaValidator(){
        baseURI = "https://reqres.in/";
        given().
                get("api/users?page=2").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("Schema.json")).
                statusCode(200);
    }

}
