This project implements a basic Spring Boot application with MVC architecture, security, and Spring Data JPA support. It includes a REST API layer for managing students and subjects, and features JWT-based authentication with roles for "student" and "admin".

Steps to run the project
 1. Import the project in spring tool suite.
 2. After importing right click on application and click on run as spring boot app.
 3.Now the embedded tomcat server will start . After the server is started you can login as either student or admin.



   	
1.Student should signUp first before loggin in.

Hit: https://localhost:8080/swagger-ui/index.html

Now select user-signin-signUp controller inside it hit users/signup

{
  "email": "shrinit@gmail.com",
  "firstName": "shrinit",
  "lastName": "patel",
  "password": "securePass456",
  "contactNo": "9730808232",
  "subjects": [
    "DSA","OS","DBMS"
  ]
}

Add few more values and hit again.
Output Student created successfully .You can check by loging in to h2 database with the following url

2.Student can login:

For this use user-signin-signUp controller:
{
  "email": "shrinit@gmail.com",
  "password": "securePass123"
}
ON successful login jwt token and current user details will be returned.

2. Admin has following functionalities.

1. 
For admin login use the ******below credentials only because admin is manually inserted in database*****.

{
  "email": "patelshrinit@gmail.com",
  "password": "securePass123"

}
ON successful login jwt token and current user details will be returned.


2.
Admin can add subject for this after loggin in from swagger copy the jwt token and use postman.
And then authorization and paste the token and then make the api (Post) call.

    Step 1: For adding Subject hit the url---> https://localhost:8080/admin/addSubject
with the json 
{
  "subjectName": "Operating Systems"
}

3.
Admin can fetch all students 
    Step:1 FOr fetching all the students GET call url-->https://localhost:8080/admin/getAllStudents

	 
4.Admin can fetch all subjects
    Step:1 FOr fetching all the subjects GET call url-->https://localhost:8080/admin/getAllSubjects
	

Please Note that security is enabled so generate the token first through swagger ui by user/signin and then use postman to access the functionalities.
And admin entry is made manually in the table using databaseinitialization.java so use this credentials only to login as admin user.
{
  "email": "patelshrinit@gmail.com",
  "password": "securePass123"

}
************************************
contact details:patelshrinit@gmail.com
mobile Number:9730808232
Name : Shrinit Patel
