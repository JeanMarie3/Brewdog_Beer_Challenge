package Additional.FirstBrewed;

import com.educatifu.utils.QueryParamConfig;
import com.educatifu.utils.RestAssuredConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BeerFirstBrewedValidationTest {

    @Test
    public void testFirstBrewedIsValidFormat() {
        RestAssured.baseURI = RestAssuredConfig.BASE_URI;
        Response response = given()
                .queryParam(QueryParamConfig.BREWED_AFTER_PARAM, QueryParamConfig.DEFAULT_BREWED_AFTER_VALUE)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("first_brewed", everyItem(notNullValue()))
                .body("first_brewed", everyItem(matchesPattern("^(0[1-9]|1[012])/[0-9]{4}$")))
                .extract()
                .response();

        System.out.println(response.asString());
    }
}

