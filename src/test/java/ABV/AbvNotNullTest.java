package ABV;

import com.educatifu.utils.QueryParamConfig;
import com.educatifu.utils.RestAssuredConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Every.everyItem;

public class AbvNotNullTest {

    @Test
    public void testAbvIsNotNull() {
        RestAssured.baseURI = RestAssuredConfig.BASE_URI;
        Response response = given()
                .queryParam(QueryParamConfig.BREWED_AFTER_PARAM, QueryParamConfig.DEFAULT_BREWED_AFTER_VALUE)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("abv", everyItem(notNullValue()))
                .extract()
                .response();

        System.out.println(response.asString());
    }
}

