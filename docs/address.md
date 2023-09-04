# Address API Spec

## Create Address

Endpoint : POST /api/contacts/{idContact}/addresses

Request Header :
- X-API-TOKEN : Token (mandatory)

Request Body :
```json
{
  "street" : "jalan apa",
  "city" : "kota",
  "province" : "provinsi",
  "country" : "negara",
  "postalCode" : "12121211212"
}
```

Response Body (Success) :
```json
{
  "data" : {
    "id" : "random String",
    "street" : "jalan apa",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "negara",
    "postalCode" : "12121211212" 
  }
}
```

Response Body (Failed):
```json
{
  "errors" : "contact is not found"
}
```

## Update Address

Endpoint : PUT /api/contacts/{idContact}/{idAdress}

Request Header :
- X-API-TOKEN : Token (mandatory)

Request Body :
```json
{
  "street" : "jalan apa",
  "city" : "kota",
  "province" : "provinsi",
  "country" : "negara",
  "postalCode" : "12121211212"
}
```

Response Body (Success) :
```json
{
  "data" : {
    "id" : "random String",
    "street" : "jalan apa",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "negara",
    "postalCode" : "12121211212" 
  }
}
```

Response Body (Failed):
```json
{
  "errors" : "address is not found"
}
```

## Get Address

Endpoint : GET /api/contacts/{idContact}/{idAddress}

Request Header :
- X-API-TOKEN : Token (mandatory)

Response Body (Success) :
```json
{
  "data" : {
    "id" : "random String",
    "street" : "jalan apa",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "negara",
    "postalCode" : "12121211212" 
  }
}
```

Response Body (Failed):
```json
{
  "errors" : "address is not found"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{idContact}/{idAddress}

Request Header :
- X-API-TOKEN : Token (mandatory)

Response Body (Success) :
```json
{
  "data" : "ok"
}
```

Response Body (Failed):
```json
{
  "errors" : "address is not found"
}
```

## List Address

Endpoint : GET /api/contacts/{idContact}/address

Request Header :
- X-API-TOKEN : Token (mandatory)

Response Body (Success) :
```json
{
  "data" : [{
        "id" : "random String",
        "street" : "jalan apa",
        "city" : "kota",
        "province" : "provinsi",
        "country" : "negara",
        "postalCode" : "12121211212" 
      }
    ]
}
```

Response Body (Failed):
```json
{
  "errors" : "address is not found"
}
```