package org.acme.rest.json;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class LegumeResourceTest {


    @Test
    public void testList() {
        given()
                .contentType(ContentType.JSON)
                .when().get("/legumes")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "name", containsInAnyOrder("Carrot", "Zucchini"),
                        "description", containsInAnyOrder("Root vegetable, usually orange", "Summer squash"));
    }

    @Test
    public void testAdd() {
        // Add a Legume
        given()
                .body("{\"name\": \"Beans\", \"description\": \"Great Legume\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/legumes")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "name", containsInAnyOrder("Carrot", "Zucchini", "Beans"),
                        "description", containsInAnyOrder("Root vegetable, usually orange", "Summer squash", "Great Legume"));

        // After Delete it to set the default set
        given()
                .body("{\"name\": \"Beans\", \"description\": \"Great Legume\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/legumes")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "name", containsInAnyOrder("Carrot", "Zucchini"),
                        "description", containsInAnyOrder("Root vegetable, usually orange", "Summer squash"));


    }


}
