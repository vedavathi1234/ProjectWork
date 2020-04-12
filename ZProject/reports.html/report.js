$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/ZProjectfolder/project.feature");
formatter.feature({
  "name": "Practiseautomation testing",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@practiseautomation"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Saving user\u0027s Billing Address",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TC_03"
    }
  ]
});
formatter.step({
  "name": "User on home page1",
  "keyword": "Given "
});
formatter.step({
  "name": "User enters to login page",
  "keyword": "And "
});
formatter.step({
  "name": "User enters details and clicks login button",
  "keyword": "When "
});
formatter.step({
  "name": "User clicks on Address",
  "keyword": "And "
});
formatter.step({
  "name": "User click on edit option",
  "keyword": "And "
});
formatter.step({
  "name": "Start entering details \"\u003cfirstname\u003e\" \"\u003clastname\u003e\" \"\u003ccompanyname\u003e\" \"\u003cemail\u003e\" \"\u003cphone\u003e\" \"\u003caddress1\u003e\" \"\u003caddress2\u003e\" \"\u003ccity\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Click on savechanges",
  "keyword": "And "
});
formatter.step({
  "name": "User get saving notification",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "firstname",
        "lastname",
        "companyname",
        "email",
        "phone",
        "address1",
        "address2",
        "city"
      ]
    },
    {
      "cells": [
        "affu",
        "lucy",
        "webtoon",
        "afreen.md5671@gmail.com",
        "9876543210",
        "chivstrt",
        "railpet",
        "guntur"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Saving user\u0027s Billing Address",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@practiseautomation"
    },
    {
      "name": "@TC_03"
    }
  ]
});
formatter.step({
  "name": "User on home page1",
  "keyword": "Given "
});
formatter.match({
  "location": "com.stepdefinition.Test_BillingAddress.user_on_home_page1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters to login page",
  "keyword": "And "
});
formatter.match({
  "location": "com.stepdefinition.Test_BillingAddress.user_enters_to_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters details and clicks login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinition.Test_BillingAddress.user_enters_details_and_clicks_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Address",
  "keyword": "And "
});
formatter.match({
  "location": "com.stepdefinition.Test_BillingAddress.user_clicks_on_Address()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on edit option",
  "keyword": "And "
});
formatter.match({
  "location": "com.stepdefinition.Test_BillingAddress.user_click_on_edit_option()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Start entering details \"affu\" \"lucy\" \"webtoon\" \"afreen.md5671@gmail.com\" \"9876543210\" \"chivstrt\" \"railpet\" \"guntur\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinition.Test_BillingAddress.start_entering_details(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on savechanges",
  "keyword": "And "
});
formatter.match({
  "location": "com.stepdefinition.Test_BillingAddress.click_on_savechanges()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User get saving notification",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinition.Test_BillingAddress.user_get_saving_notification()"
});
formatter.result({
  "status": "passed"
});
});