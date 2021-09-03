package ru.geekdrains.tests;

import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static ru.geekbrains.Endpoints.UPLOAD_IMAGE;

public class VideoTests extends BaseTest {


    static final String VIDEO_FILE = "src/test/resources/Разбег.mp4";
    static final String VIDEO_FILE2 = "src/test/resources/к.jpg";
    static final String VIDEO_FILE3 = "src/test/resources/аааааааааааааааааааааааааааааааааааааааааааа.jpg";
    static final String VIDEO_FILE4 = "src/test/resources/Marsel-1.jpg";
    static final String VIDEO_FILE5 = "src/test/resources/такси.jpg";
    static final String VIDEO_FILE6 = "src/test/resources/Скоро осень, друзья.3gp";

    String imageDeleteHash;
    RequestSpecification multiPartReqSpec;
    String base64Image;
    RequestSpecification imageRequestSpecification;

    @BeforeEach
    void setUp() throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(VIDEO_FILE));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp2 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(VIDEO_FILE2));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp3 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(VIDEO_FILE3));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp4 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(VIDEO_FILE4));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp5 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(VIDEO_FILE5));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp6 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(VIDEO_FILE6));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }





    @Test
    void uploadVideoFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(VIDEO_FILE))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }


    @Test
    void shortNameVideoFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(VIDEO_FILE2))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void longNameVideoFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(VIDEO_FILE3))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void largeFileSizeVideoFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(VIDEO_FILE4))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void smallFileSizeVideoFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(VIDEO_FILE5))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void ЗgpFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(VIDEO_FILE6))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
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
