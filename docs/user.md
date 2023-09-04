# User API Spec

## Register User

Endpoint : POST /api/users

Request Body:
```json
{
  "username" : "userApi",
  "Password" : "passApi",
  "name" : "user api"
}
```

Response Body(Success):
```json
{
   "data" : "OK"
}
```

Response Body(Failed):
```json
{
  "error" : "keterangan error"
}
```

## Login User
Endpoint : POST /api/auth/login

Request Body:
```json
{
  "username" : "userApi",
  "Password" : "passApi"
}
```

Response Body(Success):
```json
{
   "data" : {
     "token" : "TOKEN",
     "expiredAt" : 1212121 //milisecond
   }
}
```

Response Body(Failed):
```json
{
  "error" : "wrong username/ password"
}
```

## Get User 
Endpoint : GET /api/users/current

Request Header :
- X-API-TOKEN : Token (mandatory) --> menggunakan argumen resolver, jika ada class user, ambil headernya

Response Body(Success):
```json
{
   "data" : {
     "username" : "userApi",
     "name" : "user api"
   }
}
```

Response Body(Failed):
```json
{
  "error" : "unauthorized"
}
```

## Update User
Endpoint : PATCH /api/users/current

Request Header :
- X-API-TOKEN : Token (mandatory)

Request Body :
```json
{
  "name" : "user API", //put in only want to update name
  "password" : "new password" //put in only want to update password
}
```

Response Body(Success):
```json
{
   "data" : {
     "username" : "userApi",
     "name" : "user api"
   }
}
```

Response Body(Failed):
```json
{
  "error" : "unauthorized"
}
```

## Logout User
Endpoint : DELETE /api/auth/logout

Request Header :
- X-API-TOKEN : Token (mandatory)

Response Body(Success):
```json
{
   "data" : "ok"
}
```
