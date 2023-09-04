# RESTAPI-PZW
Spring Boot RESTfull API dari programmer Zaman Now

## source
- https://www.youtube.com/watch?v=eFIBOVXilK4&t=27s

## sampai dengan menit 
- 2.24.44 - Create Contact API

## koneksi db :
- mysql : localhost:3306
- user: root
- pass: rootPassword

## manual project
- set up project, https://start.spring.io
- dependency :
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Lombok
  - Validation
- setup API Specification:
  - docs/contact.md
  - docs/address.md
  - docs/user.md
- Create table
- Create Entity
  - bikin entity dari tiap table
  - pasang annotation dari lombok
  - pasang annotation @ManyToOne, baik di table sumber, maupun foreign key
- Create Request Model
  - create RegisterUserRequest sesuai API Spec
  - pasang validasi menggunakan annotation validation @NotBlank, @Size dll
- Create Response Model
  - create WebResponse dengan class generic (T), dikarenakan bentuk response bervariasi
- Create Repository
  - create User Repository, UserRepository
- Create Service
  - create User Service, UserService
  - gunakan interface validator untuk validasi request
  - untuk simpan password, gunakan fungsi BCrypt.
  - BCrypt ambil dari github, ada di package security/BCrypt. jangan lupa sesuaikan packagenya
- Create Controller
  - create UserController
  - create ErrorController untuk handling error, gunakan annotation @RestControllerAdvice
- Create Unit Test UserControllerTest
  - create Controller Test, UserControllerTest
  - create testRegisterSuccess
  - create testRegisterBadRequest
  - create testRegisterDuplicate
  - pastikan semua test berhasil
- Create User Login API
  - create login request, RegisterUserRequest
  - create token response, TokenResponse
  - create AuthService untuk authentikasi, response token
  - token bentuknya UUID.randomString
- Create Unit Test AuthControllerTest
  - create Controller Test, AuthControllerTest
  - create loginFailedUserNotFound
  - create loginFailedWrongPassword
  - create loginSuccess
  - pastikan semua test berhasil
