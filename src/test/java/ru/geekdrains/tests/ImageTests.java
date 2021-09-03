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
import static ru.geekbrains.Images.IMAGE_URL;

public class ImageTests extends BaseTest {


    static final String IMAGE_FILE = "src/test/resources/красава.jpg";
    static final String IMAGE_FILE2 = "src/test/resources/к.jpg";
    static final String IMAGE_FILE3 = "src/test/resources/аааааааааааааааааааааааааааааааааааааааааааа.jpg";
    static final String IMAGE_FILE4 = "src/test/resources/Marsel-1.jpg";
    static final String IMAGE_FILE5 = "src/test/resources/такси.jpg";
    static final String IMAGE_FILE6 = "src/test/resources/pngwing.com.png";
    static final String IMAGE_FILE7 = "src/test/resources/Векторное изображение.png";
    static final String IMAGE_FILE8 = "src/test/resources/Стоковое изображение.jpg";
    static final String IMAGE_FILE9 = "src/test/resources/krutye-gifki-humoraf-12.gif";
    static final String IMAGE_FILE10 = "src/test/resources/1рх.png";
    static final String IMAGE_FILE11 = "src/test/resources/барс.jpg";
    String imageDeleteHash;
    RequestSpecification multiPartReqSpec;
    String base64Image;
    RequestSpecification imageRequestSpecification;

    @BeforeEach
    void setUp() throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp2 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE2));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp3 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE3));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp4 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE4));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp5 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE5));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp6 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE6));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp7 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE7));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp8 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE8));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp9 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE9));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp10 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE10));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }

    void setUp11 () throws IOException {
        byte[] imageBytesArray = FileUtils.readFileToByteArray(new File(IMAGE_FILE11));
        base64Image = Base64.getEncoder().encodeToString(imageBytesArray);
    }




    @Test
    void uploadImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }


    @Test
    void shortNameImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE2))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void longNameImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE3))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void largeFileSizeImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE4))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void smallFileSizeImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE5))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void pingImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE6))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void vectorImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE7))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void stockImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE8))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void GifImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE9))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void рхImageFileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE10))
                .expect()
                .statusCode(200)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void uploadFileWithLinkTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", IMAGE_URL.getPath())
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadBase64FileTest() {
        imageDeleteHash=  given()
                .headers("Authorization", token)
                .multiPart("image", base64Image)
                .when()
                .post("https://api.imgur.com/3/image")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void JPEGfileTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .multiPart("image", new File(IMAGE_FILE11))
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
