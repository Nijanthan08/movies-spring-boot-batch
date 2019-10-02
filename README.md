# movies-spring-boot-batch

# Spring Batch Application to Calculate Ratings based on User Reviews and Rank Movies

Please note the Batch Application is added to process the User Reviews submitted through the WEB APP mentioned below. Please go through the Movie Review Portal WEB APP & Rest API to understand the need for Batch Processing.

WEB APP: https://github.com/Nijanthan08/movies-web-app <br/>
REST API: https://github.com/Nijanthan08/movies-rest-api

Please follow the steps mentioned below to run the Batch Application in your local:

1. Make sure to install the following softwares mentioned below 

    Java SE Development Kit 8: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html <br/>
    Apache Maven: https://maven.apache.org/download.cgi <br/>
    Eclipse IDE: https://www.eclipse.org/downloads/packages/release/2019-09/r/eclipse-ide-enterprise-java-developers
   
2. Make use of the following link mentioned below to configure Maven

    Maven Configuration -> https://www.tutorialspoint.com/maven/maven_environment_setup.htm
    
3. Clone the repository to your local workspace

4. Import the project to Eclipse using the Existing Maven Project Option

5. Update the properties file with the SQL Database used by the REST API

6. Open commannd prompt in the project folder and run the following command mentioned below to trigger the Batch Processing

      mvn spring-boot:run
