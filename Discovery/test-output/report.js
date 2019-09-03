$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("feature1.feature");
formatter.feature({
  "line": 1,
  "name": "Discovery-Go Feature",
  "description": "Description: Navigate to URL and Add Videos to Favourite",
  "id": "discovery-go-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Add to Favourite",
  "description": "",
  "id": "discovery-go-feature;add-to-favourite",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Open a Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Enter the URL \"https://www.discovery.com/\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Click on More",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Hover And Select the My Video Dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User Navigate to Child Window with URL \"\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AddToFavourite.open_a_Browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.discovery.com/",
      "offset": 15
    }
  ],
  "location": "AddToFavourite.enter_the_URL(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AddToFavourite.click_on_More()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AddToFavourite.Hover_And_Select_the_My_Video_Dropdown()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 40
    }
  ],
  "location": "AddToFavourite.user_Navigate_to_Child_Window_with_URL(String)"
});
formatter.result({
  "status": "skipped"
});
});