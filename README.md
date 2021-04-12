## Test cases
| Summary | Steps | Expected result |
| :--- | :--- | :--- |
| Create resource with fill all mandatory fields. | 1. In Postman create POST request on URL https://jsonplaceholder.typicode.com/posts . Set  format raw JSON in tab "Body". Enter in request body: <br> ``` {"userId": 2,"title": "some text for title", "body": "some else text for body"}``` <br> Send request. <br /> 2. Create GET request on the same url. In tab Params enter KEY: id, VALUE: 101. Send request. | 1. Response should have code  201. Response body:```[{"userId": 2, "title": "some text for title", "body": "some else text for body", "id": 101}]``` <br />2. Response should have code 200. Response body: ```[ { "userId": 2, "id": 101, "title": "some text for title", "body": "some else text for body"}]``` |
| Create resource with empty title | 1. In Postman create POST request on URL  https://jsonplaceholder.typicode.com/posts . Set  format raw JSON in tab «Body». Enter in request body: <br> ```{"userId": 2, "body": "some else text for body"}``` <br> Send request. | 1. Response should have massage about all fields that mast be filled |
| Update resource title and body | 1. In Postman create PUT request on URL https://jsonplaceholder.typicode.com/posts . In tab Params enter KEY: id, VALUE: 3. Set  format raw JSON in tab «Body». Enter in request body: ```{"userId": 1, "title": "some text for change title", "body": "some else text for change body"}``` <br>Send request. <br> 2. Create GET request on the same URL. In tab Params enter KEY: id, VALUE: 3. Send request. | 1. Response should have code 201. Response body: ```[{"userId": 1, "id": 3, "title": "some text for change title", "body": "some else text for change body"}]``` <br> 2. Response should have code 200. Response body: ```[{"userId": 2, "id": 101, "title": "some text for change title", "body": "some else text for change body"}]``` |
| Delete resource by id | 1. In Postman create DELETE request on URL https://jsonplaceholder.typicode.com/posts . In tab Params enter KEY: id, VALUE: 3. Send request. <br> 2. Create GET request on the same URL. In tab Params enter KEY: userId, VALUE: 1. Send request. | 1. Response should have massage about successful resource deletion (I guess the code should be 204) <br> 2. Response should include all user resources for userId=1 without resource with id=3.







