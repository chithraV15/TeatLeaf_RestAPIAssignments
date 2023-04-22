Feature: Service Now Create Incident Management

Scenario: Create a incident table
Given add the description as "This is inc creation" and category as "software"
When send the create request
Then validate the response for below
|result.urgency|3|
|result.approval|not requested|
|result.knowledge|false|
|result.number|INC|

Scenario: To update incident table with 6 random alphanumeric descp
Given add the random digit in body
When send the put request
Then validate the response for update request

Scenario: To delete incident table 
When send the delete request
Then validate the response for delete request
And verify the deleted inc