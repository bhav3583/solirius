package org.technical.productTest;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.technical.constants.HttpStatusCode;
import org.technical.productInfo.ProductController;
import org.technical.testbase.TestBase;
import org.technical.utils.TestUtils;

import static org.hamcrest.Matchers.equalTo;

//This is optional have created feature file and stepdef


/**
 * Created by Bhavesh Patel
 */
@RunWith(SerenityRunner.class)
public class ProductCURDTest extends TestBase {

    static String name = "fruit" + TestUtils.getRandomValue();
    static String description = "product" + TestUtils.getRandomValue();
    static double price = 25.99;
    static String id;

    @Steps
    ProductController productController;

    @Title("Getting all products")
    @Test
    public void test01() {
        ValidatableResponse response = productController.getAllProducts();
        response.statusCode(HttpStatusCode.OK.getCode());

    }

    @Title("Search all products")
    @Test
    public void test02() {
        ValidatableResponse response = productController.SearchProducts();
        boolean result =response.extract().path("success");
        Assert.assertTrue(result);

    }

    @Title("Creating new product")
    @Test
    public void test03() {
        ValidatableResponse response = productController.createProduct(name, description, price);
        response.statusCode(HttpStatusCode.OK.getCode());
        id = response.extract().path("savedProduct._id");
        System.out.println(id);
    }

    @Title("update product")
    @Test
    public void test04() {
        name = name + "updated";
        description = description+"new";
        price = price + 1;
        ValidatableResponse response = productController.updateProduct(id, name, description, price);
        response.statusCode(HttpStatusCode.OK.getCode()).log().ifValidationFails();
        response.body("name", equalTo(name));
    }

    @Title("delete product")
    @Test
    public void test05() {
        ValidatableResponse response = productController.deleteProductWithBookingId(id);
        response.statusCode(HttpStatusCode.OK.getCode()).log().ifValidationFails();
    }


}
