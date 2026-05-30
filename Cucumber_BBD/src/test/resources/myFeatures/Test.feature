Feature: Verify OpenCart Demo functionality

  Scenario Outline: Registration
    Given OpenCart home page is open
    When user clicks Register option
    And enters firstname "<firstname>"
    And enters lastname "<lastname>"
    And enters registration email "<email>"
    And enters phone "<phone>"
    And enters registration password "<password>"
    And selects privacy checkbox
    And clicks continue button
    Then registration should complete

    Examples:
      | firstname | lastname | email             | phone     | password  |
      | abc       | xyz      | ac125mp@gmail.com | 111111111 | A1234567X |

  @Smoke
  Scenario Outline: Login
    Given OpenCart home page is open
    When user clicks Login option
    And enters login credentials "<username>" "<password>"
    And clicks Login button
    Then login should complete

    Examples:
      | username         | password  |
      | xaybzc@gmail.com | A1234567X |

  @Smoke
  Scenario Outline: Change Phone Number
    Given user is logged in "<username>" "<password>"
    When user opens Edit Account
    And updates phone number
    Then account should update

    Examples:
      | username         | password  |
      | xaybzc@gmail.com | A1234567X |

  @Smoke
  Scenario Outline: Change Address
    Given user is logged in "<username>" "<password>"
    When user opens Address Book
    And updates firstname "<fname>"
    And updates lastname "<lname>"
    And updates address "<address>"
    And updates city "<city>"
    And updates postcode "<postcode>"
    Then address should update

    Examples:
      | username         | password  | fname | lname | address | city | postcode |
      | xaybzc@gmail.com | A1234567X | abc   | xyz   | newaddr | sbp  | 127458   |

  @Regression
  Scenario Outline: Multiple Search
    Given OpenCart home page is open
    When user searches "<product>"
    Then search should work

    Examples:
      | product |
      | iphone  |
      | macbook |
      | canon   |

  @Regression
  Scenario Outline: Product Detail and Cart
    Given OpenCart home page is open
    When user searches "<product>"
    And opens product detail
    And adds product to cart
    Then cart should update

    Examples:
      | product |
      | macbook |

  @Regression
  Scenario Outline: Add Delete and Checkout Cart
    Given OpenCart home page is open
    When user searches "<product>"
    And opens product detail
    And adds product to cart
    And opens shopping cart
    And removes one cart item
    And proceeds checkout
    Then cart operations should complete

    Examples:
      | product |
      | macbook |
