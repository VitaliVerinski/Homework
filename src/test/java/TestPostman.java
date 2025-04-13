import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPostman {

    @Test
    public void testGetMethod() {
        given()
                .baseUri("https://postman-echo.com/")
                .params("foo1", "bar1")
                .params("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostMethod() {
        given()
                .baseUri("https://postman-echo.com/")
                .contentType("application/json")
                .body("{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo1", equalTo("bar1"));
    }

    @Test
    public void testPutMethod() {
        given()
                .baseUri("https://postman-echo.com/")
                .contentType("application/json")
                .body("{\"foo1\":\"bar1\", \"foo2\":\"bar2\"}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }

    @Test
    public void testPatchMethod() {
        given()
                .baseUri("https://postman-echo.com/")
                .contentType("application/json")
                .body("{\"foo1\":\"updatedBar1\"}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.foo1", equalTo("updatedBar1"));
    }

    @Test
    public void testDeleteMethod() {
        given()
                .baseUri("https://postman-echo.com/")
                .contentType("application/json")
                .body("{\"foo1\":\"bar1\", \"foo2\":\"bar2\"}")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }
}
