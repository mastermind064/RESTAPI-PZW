# Contact API Spec

## Create Contact

Endpoint : POST /api/contacts

Request Header :
- X-API-TOKEN : Token (mandatory)

Request Body
```json
{
  "firstname" : "userApi",
  "lastname" : "asdfasf",
  "email" : "user@api.com",
  "phone" : "1212121212"
}
```

Response Body (Success)
```json
{
  "data" : {
    "id" : "random-string",
    "firstname" : "userApi",
    "lastname" : "asdfasf",
    "email" : "user@api.com",
    "phone" : "1212121212"
  }
}
```

Response Body (Failed)
```json
{
  "errors" : "email format invalid, user salah"
}
```

## Update Contact

Endpoint : PUT /api/contacts/{idContact}

Request Header :
- X-API-TOKEN : Token (mandatory)

Request Body
```json
{
  "firstname" : "userApi",
  "lastname" : "asdfasf",
  "email" : "user@api.com",
  "phone" : "1212121212"
}
```

Response Body (Success)
```json
{
  "data" : {
    "id" : "random-string",
    "firstname" : "userApi",
    "lastname" : "asdfasf",
    "email" : "user@api.com",
    "phone" : "1212121212"
  }
}
```

Response Body (Failed)
```json
{
  "errors" : "email format invalid, user salah"
}
```

## Get Contact

Endpoint : GET /api/contacts/{idContact}

Request Header :
- X-API-TOKEN : Token (mandatory)

Response Body (Success)
```json
{
  "data" : {
    "id" : "random-string",
    "firstname" : "userApi",
    "lastname" : "asdfasf",
    "email" : "user@api.com",
    "phone" : "1212121212"
  }
}
```

Response Body (Failed)
```json
{
  "errors" : "not found"
}
```

## Search Contact

Endpoint : GET /api/contacts/

Request Param :

- name : String, contact first name or lastname , using like query, optional
- phone : String, contact phone, using like query, optional
- email : String, contact email, using like query, optional
- page : Integer, start from 0, default 0
- size : Integer, default 10

Request Header :
- X-API-TOKEN : Token (mandatory)

Response Body (Success)
```json
{
  "data" : [
    {
      "id" : "random-string",
      "firstname" : "userApi",
      "lastname" : "asdfasf",
      "email" : "user@api.com",
      "phone" : "1212121212"
    }
  ],
  "paging" : {
    "currentpage" : 0,
    "totalPage" : 10,
    "size" : 10
  }
}
```

Response Body (Failed)
```json
{
  "errors" : "Unauthorized"
}
```

## Remove Contact

Endpoint : DELETE /api/contacts/{idContact}

Response Body (Success)
```json
{
  "data" : "ok"
}
```

Response Body (Failed)
```json
{
  "errors" : "not found"
}
```