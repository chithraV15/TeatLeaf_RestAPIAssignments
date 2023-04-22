Feature: ServiceNow Incident Management
Scenario Outline: Create Incidents

Given set the endpoint
And add the auth
And add the queryParams as "sysparm_fields" and "sys_id, number, category, short_description" 
When post the request with short description as "<short_descp>" and category as "<category>"
Then validate the response for "<value>" and "<short_descp>" and "<category>"

Examples:
|value|short_descp|category|
#1st req
|1|This is First request|software|
#2nd req
|2|This is Second request|hardware|
#3rd req
|3|This is Third request|inquiry|