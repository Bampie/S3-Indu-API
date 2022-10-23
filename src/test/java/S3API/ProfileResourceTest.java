package S3API;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ProfileResourceTest {

    @Test
    public void testGetProfilesEndpoint() {
        given()
                .when().get("/api/profiles")
                .then()
                .statusCode(200)
                .body(is(""));
    }

    @Test
    public void testAddProfileEndpoint() {
        given()
                .when().post("/api/profiles")
                .then()
                .statusCode(200)
                .body(is(""));
    }
}