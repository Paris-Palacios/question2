How to run:

-execute jar file

make a get request to localhost:8080/getAvailability?productId=Product1 -everything should be good

you should get as a response {"productId":"Product1","Availability":8.0}

change Product1 to Product2

you should get 204 No Content

dependecies are Spring web and Lombok
