package com.sample.test.demo.utils;
import static com.sample.test.demo.utils.ApiConstants.RunVariable.*;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
        RestAssured.defaultParser = Parser.JSON;
    }

    public Order makeDefaultOrder(){
        List<String> toppings = new ArrayList<>();
        Pizza pizza1 = new Pizza("1", "Small 6 Slices - no toppings", toppings);
        toppings.add("Classic Pepperoni");
        Pizza pizza2 = new Pizza("2", "Medium 8 Slices - 1 topping", toppings);
        toppings.add("Extra cheese");
        Pizza pizza3 = new Pizza("3", "Large 10 Slices - 2 topping", toppings);

        List<Pizza> items = new ArrayList<>();
        items.add(pizza1);
        items.add(pizza2);
        items.add(pizza3);

        return new Order("4", items);
    }


}
