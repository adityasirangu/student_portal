# student_portal
This is a student portal application developed using springboot,Thymeleaf ,MySQL database,redis and solr for searching.
First of all we created a student Registration form for collecting the student details and store it in mySQL database.
At the same time we save the student  details like(id,password) in  solr.
The second step is creating a Login page for students to signIn.
The Authentication of the student is done by searching the Student Page in solr with respective StudentId and match with password corresponding to it.
If the Authentication is successfull,redirect to Student home page.If not then return error to the login Page stating Invalid studentId or Password.
In Student Home page display details of the Student,fetching it from redis using StudentId as rediskey ,if not present then fetch it from database and update the respective studentId to redis.

