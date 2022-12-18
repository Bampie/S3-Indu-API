package S3API.recource;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
@Tag("integration")
class ProfileResourceTest {

    // this test checks the complete spectrum of getAllProfiles
    @Test
    void testGetProfile() {

        given().contentType(ContentType.JSON)
                .when().get("/api/profiles")
                .then().statusCode(200)
                .assertThat()
                .body("size()", is(3))
                .body("auth0Id", hasItem("auth0|111e54f55bdae0d184bedc37"))
                .body("auth0Id", hasItem("auth0|634e54f55bdae0d184bedc37"))
                .body("auth0Id", hasItem("auth0|222e54f55bdae0d184bedc37"));
    }

    // this fucntion checks all the functionalities of get by Id
    @Test
    void testProfilesById() {

        String profile = given()
                .when().get("/api/profiles/auth0|222e54f55bdae0d184bedc37")
                .then().statusCode(200).extract().asString();
        assertThat(profile)
                .isNotNull();
    }

    @Test
    void testProfilesByIdWrongId() {

        given()
                .when().get("/api/profiles/auth0|222e54f55bdae0d184bedc44")
                .then().statusCode(204);

    }

    // these next two tests check if the check profile is true or false.
    @Test
    void testCheckForIdGoodId() {
        given().contentType(ContentType.JSON)
                .when().get("/api/profiles/check/auth0|634e54f55bdae0d184bedc37")
                .then()
                .body("isIdFound", is(true));
    }

    @Test
    void testCheckForIdWrongId() {
        given()
                .when().get("/api/profiles/check/auth0&up4f51ll5bgfe6d004bed")
                .then()
                .body("isIdFound", is(false));
    }

    @Test
    void testDeleteProfileUnknownID() {
        given()
                .when().delete("/api/profiles/delete/thisIsAUnknownId")
                .then()
                .statusCode(500);
    }

}
