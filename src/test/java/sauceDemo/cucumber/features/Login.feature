Feature: Login page SauceDemo

    @Login @Positive
    Scenario: Success Login
        Given Halaman login sauce demo
        When Input username
        And Input password
        And click login button
        Then User in on dashboard page

    @Login @Negative
    Scenario: Failed login
        Given Halaman login sauce demo
        When Input username
        And Input invalid password
        And click login button
        Then User get error message

    @TDD
    Scenario Outline: User login to SauceDemo
        Given Halaman login sauce demo
        When I input <username> as username
        And I input <password> as password
        And click login button
        Then I verify <status> login result

        Examples:
            | username      | password      | status  |
            | standard_user | secret_sauce  | success |
            | wrong_user    | 123455        | failed  |

    @Cart
    Scenario: User add product to cart
        Given Halaman login sauce demo
        When Input username
        And Input password
        And click login button
        Then User in on dashboard page
        And user click the Add To Cart button
        And user click checkout logo
        And user click continue shopping button
        Then User in on dashboard page
        And user click another product
        And user click checkout logo
        Then user in on checkout page

    @Checkout
    Scenario: User add product to cart
        Given Halaman login sauce demo
        When Input username
        And Input password
        And click login button
        Then User in on dashboard page
        And user click the Add To Cart button
        And user click checkout logo
        Then user in on checkout page
        And user click checkout button
        Then user in on checkout info page
        And input first name
        And input last name
        And input zip code
        And user click continue button
        Then user in on overview page