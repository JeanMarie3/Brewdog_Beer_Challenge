package ABV;

import com.educatifu.utils.QueryParamConfig;
import com.educatifu.utils.RestAssuredConfig;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class AbvOverFourTest {

    @Test
    public void testAbvIsOverFour() {
        RestAssured.baseURI = RestAssuredConfig.BASE_URI;
        given()
                .queryParam(QueryParamConfig.BREWED_AFTER_PARAM, QueryParamConfig.DEFAULT_BREWED_AFTER_VALUE)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("abv", Matchers.greaterThanOrEqualTo(4.0));
    }
}
