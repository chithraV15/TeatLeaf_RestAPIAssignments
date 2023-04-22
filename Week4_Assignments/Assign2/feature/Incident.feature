Feature: Service Now Incident Management

Background:
Given set the endpoint
And add the auth
And contruct the request

@E2ETest @RegressionTest
Scenario: Create incident
Given send the post request
Then validate the response for post

@E2ETest @RegressionTest
Scenario: Get incident
Given send the get request
Then validate the response for get

@SanityTest
Scenario: Get all incidents
Given send the get request for all incidents
Then validate the response for getAll

@E2ETest @RegressionTest
Scenario: Update incident
Given send the put request
Then validate the response for put

@E2ETest
Scenario: Delete incident
Given send the delete request
Then validate the response for delete