package S3API.recource;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.is;

public class ProfileResourceTest {
    @Test
    void testGetProfileById() {

    }

    @Test
    void testAddProfile() {

    }

    @Test
    void testAllProfiles() {
        given()
                .when().get("/api/profiles")
                .then()
                .statusCode(200);
    }
}
