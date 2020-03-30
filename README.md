## API Demo Challenge

### Project Setup
1. Clone this project.
2. Setup the project in your IDE.
3. From command line run mvn clean install -U -DskipTests
5. Make sure you can run the DemoTest

### Expectations
We will be evaluating
1. Quality of test cases
2. Variety  of testing types (examples: boundary, happy path, negative, etc)
3. Code structure and organization
4. Naming conventions
5. Code readability
6. Code modularity


### Exercise
1. Review the spec in the root directory, PizzaAPIReferenceDoc.  API endpoints for this exercise can be found here
   https://my-json-server.typicode.com/sa2225/demo/
2. In the Read me file, write up all of the test cases you think are necessary to test the endpoints defined in the provided spec.
3. Code up a few examples of 
  - order get call including response validation
  - order post call
4. When complete please check your code into a public git repo

### Test Cases
- Coded test examples can be found in this repo [here](https://github.com/henryjandrews/SQEDemonstrationChallengeAPIProject/blob/master/src/main/java/com/sample/test/demo/tests/PizzaApiTest.java)
#### /pizzas
 1. **Test GET all pizzas**
  - **Description:** Execute a GET request on the /pizzas endpoint
  - **Verify** Response contains all pizzas, the json schema is correct, and the status code is 200
  
 2. **Test GET single pizza**
  - **Description:** Execute a GET request on the /pizzas/1 endpoint
  - **Verify** Response contains a single pizza, the json schema is correct, and the status code is 200
  
 3. **Test GET invalid pizza**
  - **Description:** Execute a GET request on the /pizzas/4 endpoint
  - **Verify** The status code is 404
  
 4. **Test POST new pizza**
  - **Description:** Execute a POST request on the /pizzas endpoint to add a new pizza
  - **Verify** Response body contains new pizza with new id field assigned and the status code is 201
  - **NOTE:** This test case was an observation and not specified in the PizzaAPIReferenceDoc.pdf. I would either file as a                 bug or ask for documentation to be added
  
  5. **Test DELETE pizza**
  - **Description:** Execute a DELETE request on the /pizzas/1 endpoint to add a new pizza
  - **Verify** The status code and if the topping was deleted
  - **NOTE:** This test case was an observation and not specified in the PizzaAPIReferenceDoc.pdf. I would either file as a                 bug or ask for documentation to be added
 
#### /toppings
 1. **Test GET all toppings**
  - **Description:** Execute a GET request on the /toppings endpoint
  - **Verify** Response contains all toppings, the json schema is correct, and the status code is 200
  
 2. **Test GET single topping**
  - **Description:** Execute a GET request on the /toppings/1 endpoint
  - **Verify** Response contains a single topping, the json schema is correct, and the status code is 200
  
 3. **Test GET invalid topping**
  - **Description:** Execute a GET request on the /toppings/9999999 endpoint
  - **Verify** The status code is 404
  
 4. **Test POST new topping**
  - **Description:** Execute a POST request on the /toppings endpoint to add a new topping
  - **Verify** No response body and the status code is 204
  
 5. **Test POST existing topping**
  - **Description:** Execute a POST request on the /toppings endpoint to add an existing topping
  - **Verify** No response body and the status code is 405
  
 6. **Test DELETE topping**
  - **Description:** Execute a DELETE request on the /toppings/1 endpoint to delete the first topping
  - **Verify** The status code is 204 and the topping was deleted
  
#### /orders
 1. **Test GET all orders**
  - **Description:** Execute a GET request on the /orders endpoint
  - **Verify** Response contains all orders, the json schema is correct, and the status code is 200
  
 2. **Test GET single order**
  - **Description:** Execute a GET request on the /orders/1 endpoint
  - **Verify** Response contains a single order, the json schema is correct, and the status code is 200
  
 3. **Test GET invalid order**
  - **Description:** Execute a GET request on the /orders/55 endpoint
  - **Verify** The status code is 404
  
 4. **Test POST new order**
  - **Description:** Execute a POST request on the /orders endpoint to add a new topping
  - **Verify** The response body is the correct order and the status code is 201
  
 5. **Test POST order with incorrect number of toppings**
  - **Description:** Execute a POST request on the /orders endpoint that contains an incorrect number of toppings
  - **Verify** The status code is 406
 
 6. **Test POST order with an invalid pizza**
  - **Description:** Execute a POST request on the /orders endpoint that contains an invalid pizza object
  - **Verify** The status code is 407
  
 7. **Test POST order without a pizza**
  - **Description:** Execute a POST request on the /orders endpoint that contains no pizza objects
  - **Verify** The status code is 408
 
#### /db
 1. **Test GET whole db**
  - **Description:** Execute a GET request on the /db endpoint
  - **Verify** Response contains all pizzas, toppings, and orders, the json schema is correct, and the status code is 200
  - **NOTE:** This test case was an observation and not specified in the PizzaAPIReferenceDoc.pdf. I would either file as a                 bug or ask for documentation to be added
 2. **Test GET db query**
  - **Description:** Execute a GET request on the /db endpoint with queryParams 
  - **Verify** Response contains all pizzas, toppings, and orders specified by the queryParams, the json schema is correct,                  and the status code is 200
  - **NOTE:** This test case was an observation and not specified in the PizzaAPIReferenceDoc.pdf. I would either file as a                 bug or ask for documentation to be added

