package org.acme.rest.json.resources;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class FruitResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
        .when().get("/fruits/wellcome")
        .then()
            .statusCode(200)
            .body(is("Hello RESTEasy"));
    }

    @Test
    public void testList() {
        given()
            .contentType(ContentType.JSON)
            .when().get("/fruits/")
            .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "name", containsInAnyOrder("Apple", "Pineapple", "Banana"),
                        "description", containsInAnyOrder("Winter fruit", "Tropical fruit", "King Kong likes"));
    }

    @Test
    public void testAdd() {
        // Add a Fruit
        given()
            .body("{\"name\": \"Pear\", \"description\": \"Great Fruit\"}")
            .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                    .post("/fruits")
                    .then()
                        .statusCode(200)
                        .body("$.size()", is(4),
                              "name", containsInAnyOrder("Apple", "Pineapple", "Banana", "Pear"),
                              "description", containsInAnyOrder("Winter fruit", "Tropical fruit", "King Kong likes", "Great Fruit"));

        // After Delete it to set the default set
        given()
                .body("{\"name\": \"Pear\", \"description\": \"Great Fruit\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/fruits")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "name", containsInAnyOrder("Apple", "Pineapple", "Banana"),
                        "description", containsInAnyOrder("Winter fruit", "Tropical fruit", "King Kong likes"));


    }

}