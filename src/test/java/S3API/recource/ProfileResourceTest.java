package S3API.recource;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class ProfileResourceTest {
    @Test
    void testGetProfileById() {

    }

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
                .when().get("/api/profiles")
                .then()
                .statusCode(200);
    }

    @Test
    void testCheckForIdGoodId() {
        given()
                .when().get("/api/profiles/check/auth0|62458f8ca375a5006927d196")
                .then()
                .equals(true);
    }

    @Test
    void testCheckForIdWrongId() {
        given()
                .when().get("/api/profiles/check/auth0&up4f51ll5bgfe6d004bedc33")
                .then()
                .equals(false);
    }

    @Test
    void testDeleteProfileKnownID() {
        given()
                .when().delete("/api/profiles/delete/auth0&pp4f51ll5bgfe6d004bedc373")
                .then()
                .statusCode(204);
    }

    @Test
    void testDeleteProfileUnknownID() {
        given()
                .when().delete("/api/profiles/delete/thisIsAUnknownId")
                .then()
                .statusCode(500);
    }
}
