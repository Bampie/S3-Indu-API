package S3API.recource;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
@Tag("integration")
class ProfileResourceTest {
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
        // .body("$.size", is(3),
        // "name", containsInAnyOrder("Baptist Onderdonck", "Jim Aarts", "Rik van
        // Gerwen"));
    }

    @Test
    void testAllProfiles2() {
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
    // .when().delete("/api/profiles/delete/auth0|634e54f55bdae0d184bedc37")
    // .then()
    // .statusCode(200);
    // }
}
