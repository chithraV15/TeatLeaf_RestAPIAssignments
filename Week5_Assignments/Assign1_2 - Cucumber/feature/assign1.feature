Feature: SNow Incident Creation Using Cucumber
Scenario Outline: Create an Incident through file

Given endpoint set up
And provide the auth
When pass the request body as "<filePath>"
Then send the request
And validate the response


Examples:
|filePath|
|./src/test/resources/Incident1.json|
|./src/test/resources/Incident2.json|
|./src/test/resources/Incident3.json|