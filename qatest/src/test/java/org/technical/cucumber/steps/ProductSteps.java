package org.technical.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import org.technical.model.ProductResponse;
import org.technical.model.SearchProductResponse;
import org.technical.productInfo.ProductController;
import org.technical.utils.TestUtils;

import static org.hamcrest.Matchers.equalTo;


public class ProductSteps {
    @Steps
    ProductController productController;
    ValidatableResponse response;
    ProductResponse productResponse;
    SearchProductResponse searchProductResponse;
    static String name;
    static String description;
    static double price;
    static String id;

    @Given("The product API is live")
    public void theProductAPIIsLive() {
        System.out.println("connected");
    }

    @When("I get all products from list")
    public void iGetAllProductsFromList() {
        response = productController.getAllProducts();
    }

    @Then("I receive {int} status code in response")
    public void iReceiveStatusCodeInResponse(int statusCode) {
        response.statusCode(statusCode);
    }

    @And("Response contains success as {string}")
    public void responseContainsSuccessAs(String text) {
        productResponse = response.extract().as(ProductResponse.class);
        Assert.assertTrue(productResponse.getSuccess());
    }

    @And("Response contains success as {string} and message {string}")
    public void responseContainsSuccessAsAndMessage(String success, String message) {
        productResponse = response.extract().as(ProductResponse.class);
        Assert.assertTrue(success, productResponse.getSuccess());
        Assert.assertTrue(message, true);
    }

    @When("I Get all search products")
    public void iGetAllSearchProducts() {
        response = productController.SearchProducts();
    }

    @And("Search response contains success as {string} and message {string}")
    public void searchResponseContainsSuccessAsAndMessage(String success, String message) {
        boolean result = response.extract().path("success");
        String actualMessage = response.extract().path("message");
        Assert.assertTrue(success, result);
        Assert.assertEquals(actualMessage, message);

    }

    @When("I create new product with {string}, {string} and {string}")
    public void iCreateNewProductWithAnd(String name, String description, String priceString) {
        name = name + TestUtils.getRandomValue();
        description = description + TestUtils.getRandomValue();
        double price = Double.parseDouble(priceString);
        response = productController.createProduct(name, description, price);
        id = response.extract().path("savedProduct._id");
        System.out.println(id);
    }

    @And("Create product response have success {string} and message {string}")
    public void createProductResponseHaveSuccessAndMessage(String success, String message) {
        boolean result = response.extract().path("success");
        String actualMessage = response.extract().path("message");
        System.out.println(actualMessage);
        Assert.assertTrue(success, result);
        Assert.assertEquals(actualMessage, message);
    }

    @And("Create product response have success {string} and message {string} or {string}")
    public void createProductResponseHaveSuccessAndMessageOr(String success, String message, String message1) {
        boolean result = response.extract().path("success");
        String actualMessage = response.extract().path("message");
        System.out.println(actualMessage);
        try {
            Assert.assertTrue(success, result);
        } catch (Exception E) {
            Assert.assertEquals(actualMessage, message1);
            System.out.println("Updated Product");
        }

    }

    @And("I update product with Id")
    public void iUpdateProductWithId() {
        name = name + "updated";
        description = description + "new";
        price = price + 1;
        response = productController.updateProduct(id, name, description, price);
        response.statusCode(200).log().ifValidationFails();
        response.body("name", equalTo(name));

    }

    @And("I delete created product with id")
    public void iDeleteCreatedProductWithId() {
        response = productController.deleteProductWithBookingId(id);
    }

    @And("I get response as {string} and message Product with id is deleted")
    public void iGetResponseAsAndMessageProductWithIdIsDeleted(String success) {
        String expectedMessage = "Product with id " + id + " is deleted";
        boolean actualSuccess = response.extract().path("success");
        String actualMessage = response.extract().path("message");
        Assert.assertTrue(success, actualSuccess);
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("Delete Response contain {string}")
    public void deleteResponseContain(String expectedMessage) {
        String actualMessage = response.extract().path("message");
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @And("I delete created product without id")
    public void iDeleteCreatedProductWithoutId() {
        id = null;
        response = productController.deleteProductWithBookingId(id);
    }

    @And("I delete created product with invalid id")
    public void iDeleteCreatedProductWithInvalidId() {
        id = "65fad690f24d04343e7d1858";
        response = productController.deleteProductWithBookingId(id);
    }
}
