package ru.geekdrains.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ImageTests extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/красава.jpg"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }


    @Test
    void shortNameImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/к.jpg"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void longNameImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/аааааааааааааааааааааааааааааааааааааааааааа.jpg"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void largeFileSizeImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/Marsel-1.jpg"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void smallFileSizeImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/такси.jpg"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void pingImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/pngwing.com.png"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void vectorImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/Векторное изображение.png"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void stockImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/Стоковое изображение.jpg"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void GifImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/krutye-gifki-humoraf-12.gif"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void рхImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/1рх.png"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }



     /*@AfterEach
    void tearDown() {
        given()
                .header("Authorization", token)
                .when()
                .delete("image/{imageHash}", imageDeleteHash)
                .then()
                .statusCode(200);
    }*/

}
