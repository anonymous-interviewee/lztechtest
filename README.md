#Description
This is a basic implementation of what was requested. It represents approx 2h:05min of learning spring/programming effort as opposed to the proposed 4h for people with no springboot experience. This is a result of my limited personal time :).

What I didn't do due to the aforementioned constraints :
1. "The end user should be able to enter the card data manually, one row at a time". I with posting the csv.
2. Validation of any sort.
3. Write tests for the bean in the *.models package.

#Instructions
Running this is pretty clear, clone the repository and then:
1. `mvn clean install`
2. `java -jar target/runnable-artifact.jar`

This appears to run the application in an embedded tomcat server. For a Web Application Resource it should be sufficient to change the packaging to WAR in the pom file.

Thanks for your time.