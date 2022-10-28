package S3API.service;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class ProfileServiceTest {
    @Test
    void testAddProfile() {

    }

    @Test
    void testAllProfiles() {

    }

    @Test
    void testCheckForIdGoodId() {
        given()
                .when().get("/api/profiles/check/auth0%7C634e54f55bdae0d184bedc37")
                .then()
                .equals(true);
    }

    @Test
    void testCheckForIdWrongId() {
        given()
                .when().get("/api/profiles/check/auth0%7C634e54f55bdae0d184bedc")
                .then()
                .equals(false);
    }

    @Test
    void testDeleteProfile() {

    }

    @Test
    void testGetProfileById() {

    }
}
