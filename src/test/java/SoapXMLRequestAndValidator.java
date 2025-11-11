import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoapXMLRequestAndValidator {

    @Test
    public void testSoapXMLRequest()  throws IOException {
        File file = new File("SoapRequest/Add.xml");
        if (file.exists()){
            System.out.println("File exists");
        }

        FileInputStream fileInputStream = new FileInputStream(file);    // Open file to read
        String requestBody = IOUtils.toString (fileInputStream , "UTF-8");  //Convert file to string

        baseURI = "http://www.dneonline.com";

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
        when().
                post("/calculator.asmx").
        then().
                statusCode(200).log().all().
        and().
                body("//*:AddResult.text()" , equalTo("0")).

        and().
                assertThat().body(matchesXsdInClasspath("calculator.xsd"));
    }


}
