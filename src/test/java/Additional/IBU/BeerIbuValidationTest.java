package Additional.IBU;

import com.educatifu.utils.QueryParamConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BeerIbuValidationTest {

    @Test
    public void testIbuIsValid() {
        RestAssured.baseURI = "https://api.punkapi.com/v2/beers";
        Response response = given()
                .queryParam(QueryParamConfig.BREWED_AFTER_PARAM, QueryParamConfig.DEFAULT_BREWED_AFTER_VALUE)
                .when()
                .get()
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("ibu", everyItem(notNullValue()))
                .body("ibu", everyItem(greaterThanOrEqualTo(0)))
                .extract()
                .response();

        System.out.println(response.asString());
        }
}

