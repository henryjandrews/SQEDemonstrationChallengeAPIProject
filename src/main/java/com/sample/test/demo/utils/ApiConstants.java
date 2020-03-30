package com.sample.test.demo.utils;
import static com.sample.test.demo.utils.ApiConstants.Servers.BASE_URL;
import static com.sample.test.demo.utils.ApiConstants.Path.BASE_PATH;

public class ApiConstants {

    public static class RunVariable{
        public static String server = BASE_URL;
        public static String path = BASE_PATH;
    }

    public static class Servers{
        public static String BASE_URL = "https://my-json-server.typicode.com/";
    }

    public static class Path {
        public static String BASE_PATH = "sa2225/demo/";
    }

    public static class Endpoints{

        public static String PIZZAS_ENDPOINT = "pizzas";

        public static String TOPPINGS_ENDPOINT = "toppings";

        public static String ORDERS_ENDPOINT= "orders";

        public static String DB_ENDPOINT = "db";

    }
}
