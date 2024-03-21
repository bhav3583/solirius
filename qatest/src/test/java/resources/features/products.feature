Feature: Product

  @Positive
  Scenario: Get all products
    Given The product API is live
    When I get all products from list
    Then I receive 200 status code in response
    And Response contains success as "true" and message "All products have been fetched!"


  @Positive
  Scenario: Search all product from the list of products
    When I Get all search products
    Then I receive 200 status code in response
    And  Search response contains success as "true" and message "Item(s) found!"


  @Positive
  Scenario Outline: Create new product
    When I create new product with "<name>", "<description>" and "<price>"
    Then I receive 200 status code in response
    And Create product response have success "true" and message "New Product saved successfully!!" or "Product's variant updated and saved successfully"

    Examples:
      | name  | description | price |
      | fruit | product     | 25.99 |

  @Positive
  Scenario Outline: E2E Journey
    When I create new product with "<name>", "<description>" and "<price>"
    Then I receive 200 status code in response
    And Create product response have success "true" and message "New Product saved successfully!!" or "Product's variant updated and saved successfully"
    #And I update product with Id ----------> Is it Bug?
    #Then I receive 200 status code in response
    And I delete created product with id
    Then I receive 200 status code in response
    And I get response as "true" and message Product with id is deleted

    Examples:
      | name     | description | price |
      | mushroom | wild        | 5.99  |

  @Negative
  Scenario: Try to delete product which doesn't exist or invalid id
    And I delete created product with invalid id
    Then I receive 404 status code in response
    And  Delete Response contain "Product was not found."

  @Negative
  Scenario: Try to delete product which doesn't exist or without id
    And I delete created product without id
    Then I receive 500 status code in response

    # I have created 2 test one with feature file which you run with runner class
    # second created CRUD test under using Serenity--> ProductCURDTest.java

    # To generate Reports run it from terminal  mvn clean Verify

