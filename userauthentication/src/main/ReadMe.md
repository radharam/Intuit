User Authentication System

Functional Requirements
Domain Object
User - (firstname, lastname, dob, contact, email, gender)

AuthenticateUser - Simple Authentication

Use Case
    1. Registration service
    2. Fetch User
    3, Delete User
    4. Update user.

Controllers (API End Points)
url - http://localhost:8085/
baseController - swagger-ui/userauthentication/

registeruser - registeruser/ - POST
fetchuser - fetchuser/{email}/ - GET
deleteuseraccount - deleteaccount/{email}/ - DELETE
updateuser - updateuser/{email}/firstname=?&lastname=?&   -PUT

Non Functional Requirements
Scalability 
Availability 
Consistent 

