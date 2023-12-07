package ru.tinkoff.qa.apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.tinkoff.qa.hibernate.apimodels.Category;
import ru.tinkoff.qa.hibernate.apimodels.Pet;
import ru.tinkoff.qa.hibernate.apimodels.TagsItem;

import java.util.ArrayList;
import java.util.List;

public class PetsApiTests {
    private Pet petRequest;
    private final int statusCode = 200;
    @BeforeEach
    public final void init() {
        TagsItem tag = new TagsItem();
        tag.setId(1);
        tag.setName("cat");

        Category category = new Category();
        category.setId(1);
        category.setName("cat");

        List<TagsItem> tags = new ArrayList<>();
        tags.add(tag);

        List<String> photos = new ArrayList<>();
        photos.add("Photo1");
        final int id = 6;

        petRequest = new Pet();
        petRequest.setId(id);
        petRequest.setName("cat");
        petRequest.setCategory(category);
        petRequest.setTags(tags);
        petRequest.setPhotoUrls(photos);
        petRequest.setStatus("available");
    }

    @Test
    public void addPetTest() {
        RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(petRequest)
                .post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(statusCode);
    }

    @Test
    public void getPetTest() {
        RestAssured.given()
                .accept(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/pet/" + petRequest.getId())
                .then().statusCode(statusCode);
    }
    @Test
    public void updatePetTest() {
        petRequest.setName("Good_cat");
        Pet petResponse = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(petRequest)
                .post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(statusCode).extract().response().as(Pet.class);
        Assertions.assertEquals(petResponse.getName(), "Good_cat");
    }

    @Test
    public void deletePetTest() {
        RestAssured.given()
                .accept(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/pet/" + petRequest.getId())
                .then().statusCode(statusCode);
    }
}
