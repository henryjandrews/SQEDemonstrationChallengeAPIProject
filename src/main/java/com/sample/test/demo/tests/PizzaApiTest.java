package com.sample.test.demo.tests;
import static com.sample.test.demo.utils.ApiConstants.Endpoints.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.sample.test.demo.utils.Order;
import io.restassured.http.ContentType;

import org.testng.annotations.Test;
import com.sample.test.demo.utils.BaseTest;

public class PizzaApiTest extends BaseTest {

    @Test
    public void testGetOrdersSchema() {
        given().log().uri().
                when().get(ORDERS_ENDPOINT).
                then().body(matchesJsonSchemaInClasspath("OrdersJsonSchema.json"));
    }

    @Test
    public void testGetSingleOrder() {
        // Changes aren't persisted between calls so we need to hardcode expected response
        String expectedResponse = " id: 2 items: [ item: 1 pizza: Small 6 Slices - no toppings]";
        Order response = given().log().uri().
                when().get(ORDERS_ENDPOINT + "/2").
                then().contentType(ContentType.JSON).
                assertThat().statusCode(200).extract().response().as(Order.class);
        assertThat(expectedResponse, equalTo(response.toString()));
    }

    @Test
    public void testGetInvalidOrder() {
        given().log().uri().
                when().get(ORDERS_ENDPOINT + "/5").
                then().contentType(ContentType.JSON).
                assertThat().statusCode(404);
    }

    @Test
    public void testPostDefaultOrder() {
        Order order = makeDefaultOrder();
        Order response = given().log().uri().
                contentType("application/json").
                body(order).
                when().
                post(ORDERS_ENDPOINT).
                then().
                assertThat().statusCode(201).
                extract().response().as(Order.class);
        assertThat(order.toString(), equalTo(response.toString()));
    }

    @Test
    public void testPostInvalidOrder() {
        given().log().uri().
                contentType("application/json").
                body("abcde").
                when().
                post(ORDERS_ENDPOINT).
                then().assertThat().statusCode(500);
    }

    @Test
    public void testDeleteOrder() {
        given().log().uri().
                when().delete(ORDERS_ENDPOINT + "/3").
                then().contentType(ContentType.JSON).
                assertThat().statusCode(200).extract().response();
    }

    @Test
    public void testGetDbSchema() {
        given().log().uri().
                when().get(DB_ENDPOINT).
                then().
                body(matchesJsonSchemaInClasspath("DbJsonSchema.json"));
    }

}
