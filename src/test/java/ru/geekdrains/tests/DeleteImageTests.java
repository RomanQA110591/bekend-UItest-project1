package ru.geekdrains.tests;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static ru.geekbrains.Endpoints.UPLOAD_IMAGE;

public class DeleteImageTests extends BaseTest{

    static final String IMAGE_FILE = "src/test/resources/красава.jpg";

    String imageDeleteHash;
    RequestSpecification multiPartReqSpec;
    String base64Image;

    @BeforeEach

    void setUp() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE))
                .when()
                .post(UPLOAD_IMAGE)
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void deleteExistentImageTest() {
        given()
                .header("Authorization", token)
                .when()
                .delete("image/{imageHash}", imageDeleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}