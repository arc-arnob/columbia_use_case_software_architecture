Blazeguard: Wildlife Fire Resource Management System



## Motivation for Choosing the Project:
Our mission is to help in the protection of Colombia's wilderness and communities from the devastating impact of wildfires by delivering cutting-edge software technology that aids in wildfire detection and resource management.

## Key Features:

The Key features of this system is Resource Management, Message Broker, Dispatcher Service etc. Although due to time constraint we were not able to implement all the services and limited our selves to implement features that will best show the potential of the system and present clear opportunities for extensions.

## Stakeholders:

Stakeholders could include ICO(Incident commanders), Resource Admin, Government, Data Providers, Media, Resource Suppliers, Emergency Services and Developers. 

## Current POC
Current POC is aimed at showing Quality Attributes like Maintainability, Testability and Scalability.
So far we have used Sonarqube to show Maintainability. Testability is evident by the way code is written(Dependency Inversion).

In code we have 2 Main Services that basically does same thing but are structured in different way.
``rms-common`` is built using a common MVC pattern that comes out of the box in Spring boot and ``rms-clean-architecture`` is made using [Clean code architecture](http://cleancoder.com/products), guidelines by Robert C. Martin.

### Our Hypotheses
We hypothesise that by rewriting code in ```rms-common``` using clean architecture in ``rms-clean-architecture`` makes it more maintainable. 
We used [Sonarqube](https://www.sonarsource.com/products/sonarqube) that provides static code analysis and clear metrics from Maintainable, Cyclomatic Complexity and Cognitive Complexity.

## Installation guide
### Prerequisites

Before you begin, ensure you have met the following requirements:

- You have installed the latest version of **Java 17**, **Java 19**, **Docker**, and **Postgres**.

### Installing Packages
#### Java:
1. Install Java 17 and 19
2. maven
   1. MAC OSX: brew install maven
   2. Windows: install maven and add binary to env variables
#### Docker:
Make sure you install Docker and have it running in the background.


### Running the code
1. Edit ```application.properties``` in services to add credentials to connect to your local Postgres
### Java Services:
1. Use Intellij Idea for quick starter **OR**
2. ```mvn spring-boot:run```
### Step to install SonarQube

```bash
docker pull sonarqube
```

```bash
docker run -d --name sonarqube-db -e POSTGRES_USER=sonar -e POSTGRES_PASSWORD=sonar -e POSTGRES_DB=sonarqube postgres:alpine
```

Run SonarQube

```bash
docker run -d --name sonarqube -p 9000:9000 --link sonarqube-db:db -e SONAR_JDBC_URL=jdbc:postgresql://db:5432/sonarqube -e SONAR_JDBC_USERNAME=sonar -e SONAR_JDBC_PASSWORD=sonar sonarqube
```

This command sets up the SonarQube container with a link to the PostgreSQL database.

Set Sonar Scanner Home
```bash
nano ~/.bashrc

export SONAR_SCANNER_HOME=/path/to/sonar-scanner

Add Sonar Scanner to PATH
export PATH=$SONAR_SCANNER_HOME/bin:$PATH
```
### Running Code analysis for POC proofs
1. Open ```http://localhost:9000/```
2. Sign in with username ``admin`` and password ``admin``
3. Create a Local Project
4.  Select ```Use the global setting```
5. Under ```Analysis Method``` Choose locally
6. Generate a token.

To Individually compare Code Quality of ```rms-common``` and ``rms-clean-architecture`` you need to make 2 such projects in Sonarqube as shown above and `cd` into each service in IDE individually and run the bash command with respective project keys as shown below.
1. ```cd``` in ```rms-common```
2. run:
```bash
mvn clean verify sonar:sonar \
-Dsonar.projectKey=<project-name> \
-Dsonar.projectName='<project-name>' \
-Dsonar.host.url=http://localhost:9000 \
-Dsonar.token=sqp_4e1ab4c431b4ac9cc2fb576edf8270f0061f13e6
```
you will also find it on the Sonarqube dashboard once you finish setup.

### Kafka
1. Make sure Docker is installed on your machine
2. Run Docker Compose to start Kafka, Zookeeper, and Kafka UI services mentioned in the docker-compose.yaml file 
```bash
docker-compose up
```
Once the services are up and running, you can access Kafka UI in your browser at http://localhost:8090.

## Configuration Details
Services:
1. Zookeeper: Provides coordination services for Kafka broker nodes.  Exposesd on port 22181 on localhost
2. Kafka: Distributed event streaming platform. Exposed on port 29092 on localhost.
3. Kafka UI: User interface for managing and monitoring Kafka clusters. Exposed on port 8090 on localhost.


To produce a message , start kafka spring boot application , this will create a topic: 'Wildfire-Alert',
in Kafka UI dashboard , create a message - E.g 'Emergency' under this topic.
The Notification service will consume this message and print on the console. 

```Note``` : To demonstrate resilience , create a message on the Kafka-UI with the springboot kafka service down,
once this service starts again , the alert will be consumed by the client. 
