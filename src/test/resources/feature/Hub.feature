Feature: each post is a part of a hub

  Scenario: Get all posts by hub
    Given I am on hub page
    When I search hub "IT systems testing"
    And choose found hub
    And each post has hub lable "IT systems testing"