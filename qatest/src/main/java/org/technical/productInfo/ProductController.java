package org.technical.productInfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import org.technical.constants.EndPoints;
import org.technical.model.ProductPojo;
import org.technical.model.Variant;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductController {

    @Step
    public ValidatableResponse getAllProducts() {
        return given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PRODUCTS)
                .then().log().all();
    }

    @Step
    public ValidatableResponse createProduct(String name, String description, double price) {
        List<Variant> variants = List.of(new Variant("Variant 1 Name", "PAC123", 5.00, 100),
                new Variant("Variant 2 Name", "PAC456", 5.00, 100));
        ProductPojo requestBody = ProductPojo.getRequestBody(name, description, price, variants);
        return given().log().all().when()
                .body(requestBody)
                .header("Content-Type", "application/json" )
                .post(EndPoints.CREATE_PRODUCTS)
                .then().log().all();
    }

    @Step
    public ValidatableResponse updateProduct( String id, String name, String description, double price) {
        List<Variant> variants = List.of(new Variant("Variant 1 Name", "PAC123", 5.00, 100),
                new Variant("Variant 2 Name", "PAC456", 5.00, 100));
        ProductPojo requestBody = ProductPojo.getRequestBody(name, description, price, variants);
        return given().log().all()
                .headers("Content-Type", "application/json" )
                .body(requestBody)
                .when()
                .patch(EndPoints.PATCH_PRODUCTS+id)
                .then().log().all();
    }

    @Step
    public ValidatableResponse deleteProductWithBookingId(String id) {
        return given().log().all()
                .when()
                .delete(EndPoints.DELETE_PRODUCTS+id)
                .then().log().all();
    }

    @Step
    public ValidatableResponse SearchProducts() {
        return given().log().all()
                .when()
                .get(EndPoints.SEARCH_PRODUCTS)
                .then().log().all();
    }
}
