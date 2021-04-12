import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PostsTest {

    @Test
    void shouldFilterByUserId() {
        given()
            .baseUri("https://jsonplaceholder.typicode.com")
        .when()
            .get("/posts?userId=1")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
                // Checking that response matches schema
            .body(matchesJsonSchemaInClasspath("posts.schema.json"))
                // ... and not empty
            .body("", hasSize(greaterThan(0)))
                // ... and userId for each entity is 1
            .body("userId", everyItem(is(1)));
    }

    @Test
    void shouldGetPostById() {
        String expectedTitle = "[qui est esse]";
        // Get post with id=2
        String actualTitle =
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
        .when()
                .get("/posts?id=2")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(matchesJsonSchemaInClasspath("posts.schema.json"))
                // ... and extract its title
        .extract()
                .jsonPath().getString("title");
        // Compare actual and expected results
        assertThat(actualTitle, equalTo(expectedTitle));
    }

    @Test
    void shouldGetList() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
        .when()
                .get("/posts/")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(matchesJsonSchemaInClasspath("posts.schema.json"));
    }
}
