Feature: Discovery-Go Feature
Description: Navigate to URL and Add Videos to Favourite

Scenario:  Add to Favourite

Given Open a ChromeBrowser
When Enter the URL "https://www.discovery.com/"
And Click on More
And Hover And Select the My Video Dropdown
Then User Navigate to Child Window
When User click on Home screenicon
And Navigate to Home screen
And Scroll down to Recommended for you
And Select one Video from recommended for you section
And Select another Video from recommended for you section
And Click on My Videos from the menu icon
And Navigate to Favorite Section
Then Verify the Name of the Added Videos and Close the browser