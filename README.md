# dbs-web-crawler 

#How to setup the project

1.Create a database schema "dbs-crawler" in mysql

2.Clone the project to your local machine (latest code available in the master branch)

3.Update the application.properties file with your mysql user name and password

4.Build the project mvn clean install

5.Run the web-crawler-0.0.1-SNAPSHOT.jar file

#How to execute the routes

Once the application is started, the below two route can be executed on Postman.

1.To Feed URLs
  
  route : http://localhost:8080/url
  
  method : POST
  
  body data 
  
    key : 'url' value : url_value
    
    key : depthLimit   value : the depth number that you need to scan
    
2.To Seach text
  
  route : http://localhost:8080/seach?keyword=<seach_text>
  
  method : GET


