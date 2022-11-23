package S3API.recource;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@Tag("integration")
public class ProfileResourceTest {
    @Test
    void testAddProfile() {
        given()
                .when().post("/api/profiles")
                .then()
                .body(is(""));
    }

    @Test
    void testAllProfiles() {
        given()
                .when()
                .get("/api/profiles")
                .then()
                .statusCode(200);
    }

    @Test
    void testCheckForIdGoodId() {
        given()
                .when().get("/api/profiles/check/auth0|634e54f55bdae0d184bedc37")
                .then()
                .equals(true);
    }

    @Test
    void testCheckForIdWrongId() {
        given()
                .when().get("/api/profiles/check/auth0&up4f51ll5bgfe6d004bed")
                .then()
                .equals(false);
    }

    // @Test
    // void testDeleteProfileUnknownID() {
    // given()
    // .when().delete("/api/profiles/delete/thisIsAUnknownId")
    // .then()
    // .statusCode(403);
    // }
}
