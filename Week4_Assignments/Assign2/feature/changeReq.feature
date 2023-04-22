Feature: Service Now Change Request Management

Scenario: Create a Change Request
Given set the endpoint
And add the auth
And contruct the request
When send the request for crTable
Then validate the response for crTable