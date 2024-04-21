---
type: article
title: "BlazeGuard: Architecture for Firefighting Resource Management"
date: 2024-03-15T14:23:59Z
draft: false
---

In order to aid Colombia’s firefighters in containing the increasing amount of wildfires that occur due to 'El Niño' phenomenon [^1], we designed BlazeGuard, a wildfire alert and resource management system. In this document we will explain the process of designing BlazeGuard, by explaining its architecture through different views of the system, important architectural decisions made, and a Proof of Concept to show the strengths of the decisions made for the system.


A complete overview of this document is as follows:

- Introduction
- Solution Strategy
- Building Block View
- Runtime View
- Deployment View
- Architectural Decisions
- Exploring the design choice
- Proof of Concept

# 1. Introduction

During problem analysis step [^2], we identified some critical aspects of the system, it’s environment and the users. Before diving into the architectural design, we will remind the reader of the key points from the problem analysis. Below, you will find the use-case diagram originally presented in our Blog post 1, outlining the functional requirements of BlazeGuard. Through a stakeholder analysis we identified high-priority expectations of BlazeGuard and the corresponding software architecture requirements, all of which are explored in the next section.

{{<image file="usecaseDiagram.png" caption="Use Case diagram">}}

After outlining the functional requirements of the system through the use case diagram, the next step is to delve into the structural aspect of the system by representing its domain model. This transition is facilitated through the creation of an Entity-Relationship (ER) diagram, which captures the essential entities and their relationships within the system.

{{<image file="ER_diagram_1.png" caption="Domain Model">}}

Our domain holds multiple types of `Users`, mapped as `Personnel`. Each personnel is assigned a rank and belong to a certain `Base`. `Personnel` and `Equipments` together form the resources that are available for firefighting emergencies, and `Equipments` are mapped to `Personnel` through `Skill`. For ICO to keep track of what `Personnel` entities are doing we created a `Task Mappings` relation, that map `Tasks` to `Users`. Moreover, to keep track of availability of `Equipments` and `Personnel` we have `Status`.Other independent tables are `Post Incident Details`, that is used to log firefighting reports, and `Sensor Data`, which is a Time series database. The microservice boundaries are inspired from the domain discussed, hence supporting our Domain Driven Design principle.


# 2. Solution Strategy

Here we propose the solution strategy we followed for BlazeGuard's design. We aim to implement robust architectural paradigms, follow best practices in software design, and prioritize code quality and maintainability. BlazeGuard aims to deliver a robust solution that meets the needs of stakeholders. The solution approaches, derived from the quality goals, are summarized in the table below.

### Quality Goals

| Key Quality Goal | Scenario                                                                    | Solution Approach                         |
| ---------------- | --------------------------------------------------------------------------- | ----------------------------------------- |
| Scalability      | High workload during wildfire emergencies                                   | Microservices Architecture                |
| Testability      | System should be testable and any changes in the system are flagged quickly | Test Driven Development                   |
| Resilience       | System should not lose critical information, in case of downtime or service failure  | Event-Driven Communication                |
| Maintainability  | Easy to understand, modularized components in codebase and comprehensive documentation                                    | Clean Code Architecture, SOLID Principles |

Solution approaches are motivated by the desire to build a _scalable_, _testable_, _resilient_, and _maintainable_ system, our key quality goals. These are identified as the most significant quality attributes from the problem analysis. The table below provides a summary of how they were derived from our stakeholder analysis. We will be elaborating on and reference the table further in this section. 

{{<image file="quality_attrs_table.png" caption="Detailed Quality Attributes">}}

By keeping these quality goals in mind, readers can better grasp the reasoning behind our chosen solutions and how they align with the project's overarching objectives.

We will now elaborate on our solution approaches which can be divided into two categories: Technology Decisions, and Design Principles and Guidelines.

### Technology Decisions

**Microservices:** allows for the decomposition of the system into smaller, loosely coupled, manageable services that can be developed, deployed, and scaled independently [^3]. Each microservice is responsible for a specific domain or functionality within the BlazeGuard ecosystem, this enables the system to scale horizontally by distributing the workload across the independently deployable services. The specific services for BlazeGuard are defined and explained in section 3, [Building Block View](#container-view).

**Event-driven architecture:** The communication between microservices is determined by how events control the flow of information exchange and interaction among components. Events signify incidents within the system, that trigger actions across services. With Event-Driven architecture, BlazeGuard ensures efficient collaboration among its components without tight dependencies [^4]. Utilizing Kafka as the event bus, BlazeGuard manages communication between its microservices.

### Design Principles and Guidelines

**Clean Code Architecture:** ensures that the system’s code base remains modular, readable, and maintainable [^5]. This approach promotes separation of concerns, making it easier to understand and modify the code as the system evolves. By adhering to these principles, developers can navigate the codebase more efficiently, reducing the risk of introducing errors or unintended side effects during maintenance or updates.  

**SOLID Principles:** SOLID principles (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion) guides the design of software components, fostering code that is flexible, robust, and extensible [^5]. Dependency inversion and interface segregation principles help minimize dependencies between modules, reducing coupling and enhancing modularity. By following these principles, we aim to reduce code complexity and minimize dependencies between modules, enhancing the system’s overall stability.

**Test Driven Principles:** Ensuring robust testing practices is essential to validate the system’s functionality and reliability. Test-Driven Development (TDD) promotes testability by requiring tests to be written before code implementation, fostering a comprehensive suite of automated tests that validate the system’s behavior [^6].

Now, we will explain the quality attribute table introduced earlier, highlighting which approaches support each quality goal (*italicized*) and meet the corresponding stakeholder expectations from the [Detailed Quality Attributes table](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3/content/projects/03-wildfires/images/quality_attrs_table.png){:target="_blank"} (marked with [i]). 

**Scalability**
_Microservices_ architecture and _event-driven_ paradigm : As we have seen in Technological Decisions, Microservices and Event Driven architecture will allow BlazeGuard to handle sudden spikes in activity, that is periods of high wildfire activity, effectively meeting several stakeholders needs [1]. 
<!-- Link to table here -->

**Testability**
The _Test Driven Principles_ in conjunction with the _Microservice_ _Event-Driven_ architecture, will allow the developers to write tests for each of the systems components in isolation. Through unit testing, integration testing, and end-to-end testing the expected behavior of the system can be verified for each component before it integrates into the larger system, ensuring that all parts function correctly. BlazeGuard seeks to satisfy the developers need for an understandable and an effective code structure [8], the ICO's need for a reliable system [4] and the incident responders need for a safe work environment [7].  

**Resilience**
BlazeGuard adopts an *event-driven architecture* combined with *microservices*. This architectural choice enables the system to withstand and recover from failures gracefully. Additionally, event-driven architecture facilitates the implementation of robust error handling mechanisms, such as retries, circuit breakers, and dead-letter queues, which enhance the system's resilience to failures. By prioritizing resilience, BlazeGuard aims to meet the needs of stakeholders, so that critical information is not lost [2]. 

**Maintainability**
Emphasis on _Clean Code architecture_ and adherence to _SOLID principles_ enhances maintainability of the system. By adhering to these principles, the system can accommodate evolving requirements and needs without requiring extensive refactoring or redesign. Together these solutions solve the Resource managers and ICO's need for an adaptive system [3], [4], [5], [6] while also making it easy for developers to understand and work on the existing as well as new features, faster [9]. 

Hopefully, these decisions serve as an understanding for developers , stakeholders and architects alike. These decisions are, the cornerstones upon which the architecture of BlazeGuard is built. They provide a direction and rationale for the subsequent system implementation.

# 3. Building Block View

To further understand the system and architecture in detail, we provide visualization of five different levels of abstraction:

1. Context view: Context and environment the system exists in, external dependencies
2. Container view: Overall architecture of the entire system
3. Component view: Detailed overview of container
   * BlazeGuards microservices 
   * API Pattern
4. Class view: Detailed overview of each class within the components.
5. Code view: Detailed description of the class.


## Context view

A context diagram offers a high-level view of a system’s environment, depicting its boundaries and
interactions with external entities. It serves as a foundational element for understanding a system’s
functionality within its operational context. 

{{<image file="context_diagram_v2.png" caption="Context diagram">}}

The model depicts how BlazeGuard fits into the existing environment, with the external dependencies that detect wildfires at different report frequencies. These dependencies include the NASA API, LookOut Wildfire, LookOut Cam, and SIATA [^5] [^6] [^7]. Keeping in mind the quality attributes, especially *maintainability*, BlazeGuard should be adaptive to new data sources. 

## Container View

Now that we understand how BlazeGuard fits in the environment, let us focus on the system boundary. The following figure shows a high level view of the entire system that will operate as a unit. 

{{<image file="c4_container_2.png" caption="Container diagram">}}

In the figure, it is shown how the Users, Resource Managers and ICOs, access the system through a Website that is a Single Page Application (SPA). This SPA, developed using JavaScript and Vue is the main access point for all the app's features. It communicates with the backend, an API Application built with Java, TypeScript, and Python, facilitating services through secure HTTPS/JSON protocols. This API Application is the gateway to both external sensor data sourced from the Mainframe Sensor System and internal databases that include time-series and SQL databases. Through this architecture, BlazeGuard ensures efficient data retrieval and manipulation, supporting critical wildfire detection and reporting functions.

## Component View

 This view depicts the major building blocks of the system and the interactions among them, showcasing the components within our system.


{{<image file="component_diagram.png" caption="Component diagram">}}

In the model, each component, or microservice, is designed around a distinct domain, adhering to the principles of Domain-Driven Design (DDD). This approach helps aligning the system with the business needs, facilitating a more intuitive development and maintenance process. By employing DDD, we define microservice as the domain's subdomain. This results in each microservice managing its distinct domain logic. This enhances system modularity and maintainability, supporting our architectural goal of creating loosely coupled components. The `Kafka Client`, which functions as the event bus, is used for the transmission of messages among the most critical services like the fire locator service, and the resources request and request management services.

Now we will be summarize each microservice:

`API Gateway`: This gateway serves as the secure entry point for users, directing requests to the appropriate microservices with efficiency and security.

`Dispatcher Service`: This service coordinates the allocation and dispatch of firefighting resources to incident sites, ensuring a rapid response to wildfire outbreaks.

`Location Service`: Acting as the system’s navigator, this service provides precise location data crucial for mapping the spread and intensity of wildfires.

`Fire Locator Service`: Constantly analyzing sensor data, this service is on the lookout for anomalies that may indicate a wildfire, serving as an early warning system.

`Request Resource Service`: This service handles the request of resources from the ICOs during a wildfire fighting operation.

`Post-Incident Recovery Service`: Focused on learning and adaptation, this service facilitates post-incident assertion to aid in recovery and prepare for future incidents.

`Resource Management Service`: Overseeing the distribution of resources, this service allows for allocating resources to where they are needed.

`Alert System`: This system ensures that all relevant parties receive timely notifications about wildfire detections and resource request and deployments, keeping everyone informed and ready to act.

We chose Java Spring boot as our development framework. For databases, we opted for a combination of SQL and NoSQL time series databases. Specifically, we selected MongoDB for the `Fire Locator Service` due to its NoSQL nature and time series capabilities, while we settled on MySQL for all other services.

### API Pattern
For interaction amongst the services we decided to go with a data-oriented approach to ensure clarity and ease of use. To address the inherent linkage between services and their functionalities, the concept of a Solution-Internal API[^21] was used. This architectural pattern restricts access to APIs exclusively to internal components within Blazeguard ecosystem. By logically decomposing the application into distinct components, each equipped with its own set of APIs, the system ensures that only authorized services within the application backend can interact with designated functionalities. This approach enhances security and encapsulation within Blazeguard Wildfire Resource Management System, safeguarding sensitive data communication between internal components.

## Classes View

The components we talked about are now turned into [code artifacts](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r2/content/projects/03-wildfires/images/class_view_final_1.png). In each service, we define its domain and use cases, which interact with its own interface and data layer. We create each service in a particular way, which we will explain in the next section. Looking at this view, we noticed it's quite complex, which might make it harder for the team to communicate as the project grows.

{{<image file="class_view_final_1.png" caption="Classes diagram">}}


## Code View
The Code View diagram provides a detailed structural overview of the services that follow the Clean Code Architecture pattern. At its core, the diagram features the domain layer, which is fundamental to the application. This layer houses the business logic and essential entities that drive the application's primary functions through various use cases. The separation of data layer allows us to keep our system extensible to any type of data source without changing any line of code in the domain or interface layers.

Surrounding the core domain layer are two critical interface layers: the external interfaces and the data layer. The external interfaces are comprised of controllers or adapters that manage incoming requests and output data to users or external systems. The data layer, on the other hand, handles interactions with the database.

The domain layer serves as an intermediary between the data layer and external interfaces, orchestrating the execution of business logic through use cases. 

Dependencies between layers adhere to the Dependency Inversion Principle, with higher-level modules depending on abstractions rather than concrete implementations. This modular structure promotes separation of concerns, facilitates testability, and enables flexibility and maintainability throughout the software system. We arrived to this decision by following Conway’s Law[^19] which is essentially the observation that the architectures of software systems look remarkably similar to the organization of the development team that built it.

{{<image file="clean_code_arch.png" caption="Clean Code diagram">}}

# 4. Runtime view

To understand how the building blocks of the system behave, we’ve decided to depict two sceranios in our sequence diagram.

1. Begins with an event, triggered by the Fire Locator Service. This event initiates a notification process directed towards the Incident Command Officer (ICO). Subsequently, the ICO may decide to engage the Dispatcher Service to allocate resources to their designated base.
2. Extends the narrative, illustrating situations where the ICO might require additional resources. In such cases, a Resource Manager is involved to review and approve the request for transferring resources among bases.

<!-- Sequence Diagram here  -->

{{<image file="sequence_diagram.png" caption="Sequence diagram">}}

It's imperative to note that the services deployed in our system operate under high emergency conditions, where any downtime could potentially result in severe consequences, including ecological damage and possibly loss of life. Therefore, we've opted for a microservices with event driven architecture to ensure resilience and reliability.

<!-- Rather explain the diagram then the architecture -->

# 5. Deployment View
The deployment diagram illustrates the system, designed for incident response, featuring a network of components and their interconnections. At its core are the Users, initiating requests and engaging with the system through various workstations, including an ICO workstation and an Resource Manager(RM) workstation. Anchoring the system are multiple servers, comprising a message handler server (where the Kafka client is hosted), a database server (which holds the complete inventory of the corps and other important information), and a final server that hosts services such as the fire detection or the alert system. External entities, labeled as Third Parties, contribute data related to wildfire detection to the fire locator service. The flow of data starts with Requests originating from user Workstations, funneled to the main server, which orchestrates interactions with all of its components. 

{{<image file="deployment.png" caption="Deployment diagram">}}

The Message Handler facilitates message routing, while the Base Camp serves as a central coordination hub. Kafka supports real-time messaging, FIRMS provides satellite data of active hotspots, sourced from NASA, and LookOut Cam provides direct fire detection via live visualization using cameras. SIATA aids in retrieving a more precise and frequent measurement of meteorological data. The Resource Manager Service oversees resource allocation during incidents, while the Alert System disseminates critical information. Post-Incident Recovery Service assists in restoring normalcy, and databases store configuration and inventory data. The Fire Locator Service pinpoints fire locations.
Finally, it is important to note that the third parties services will likely expand in the future, as more systems get deployed throughout Colombia.

# 6. Architecture Decisions

In this section, we delve into a significant architectural decision we have made: adopting a Microservices Event-Driven Architecture, our hybrid approach. We aim to provide a detailed explanation of our rationale, explore alternative options, conduct a thorough analysis of their tradeoffs, and ultimately justify our chosen design approach.

## Exploring the design choice: Microservices and Event-Driven architecture

### Layered Architecture

Layered Architecture is a design pattern that organizes software components into distinct layers, each responsible for a specific set of functionalities [^10]. These layers are arranged hierarchically, with each layer building upon the functionalities provided by the layer beneath it. Layers in Layered Architecture:

- Presentation layer: The topmost layer of the architecture, responsible for handling user interaction and presenting information to users. This layer typically includes user interfaces, such as web interfaces, mobile apps, or desktop applications.
- Application layer: The middle layer that contains the core
  business logic and application-specific functionalities. This layer orchestrates the flow of data and processes within the system, handling business rules, validations, and workflow logic.
- Data Access layer: The bottommost layer responsible for interacting with the data storage systems, such as databases or external services. This layer abstracts the details of data persistence and retrieval, providing a unified interface for accessing and manipulating data

Even though it sounds seem very organized it still has some drawbacks, namely:

- Communication overhead between layers can impact performance.
- Tight coupling risks if layer boundaries aren’t well-defined.
- May become overly complex with numerous layers.

### Monolithic Architecture

Monolithic Architecture is a traditional approach where the entire application is developed and deployed as a single, cohesive unit [^11]. It lacks the modularity and scalability advantages of Microservices. While less common now, it’s still seen in some legacy systems. The fact that there are many Legacy systems still using this we conclude that it still delivers value but with some drawbacks:

- Limited scalability, as the entire application must be scaled.
- Difficulty in maintaining and updating due to tight coupling.
- Deployment of updates can be riskier.

### Microkernel Architecture

Microkernel Architecture, also known as ”plugin architecture,” separates the core system from extended functionalities, enabling flexibility and customization [^12]. However, it may introduce complexity and performance overhead. This architecture seemed a good option for our usecase but we had to drop it since we were not sure what external sensor mainframe our system might integrate in future. With this we identified more drawbacks:

- Communication between core and plugins can introduce overhead.
- Plugins may have dependencies on specific core versions.
- Managing interactions between core and plugins can become complex.

### Peer-to-Peer Architecture

In the traditional client-server model, a central server is the main hub that provides services to many client devices. This model works well, but it’s very centralized, meaning the server is the most important part of the network. On the other hand, Peer-to-Peer (P2P) architecture changes things by breaking away from this centralized setup. Instead, it promotes a more equal model where each node, or ’peer’, is just as important as the others in the network [^13]. In a P2P network, every peer has a double role – it acts as both a client and a server. This means that peers can directly communicate with each other and share things like processing power, storage space, and network capacity without relying on a central server. This decentralization is at the heart of P2P architecture, giving it some special advantages and making it a great option for lots of different applications. Though this brings in some inherent advantages like robustness, scalability and efficiency, it comes with it’s own set of drawbacks:

- Security concerns due to direct connections between nodes.
- Scalability challenges in very large networks.
- Lack of central control can lead to coordination issues

With all the above knowledge we went ahead and did a tradeoff analysis of five architectures, four explained above and one is our hybrid Microservice Event Driven Architecture.

<!-- Trade off picture figure here -->
### Trade-off Analysis

Here we perform a tradeoff analysis,

| Architecture Pattern | Performance | Scalability | Testability | Ease of deployment | Easy of development
|----------|----------|----------|----------|----------|----------|
| Layered Pattern | Low | Low| High | High | High |
| Monolithic Pattern | Variable | Low | High | Low | High |
| Microkernel Pattern | Low | High | High | High | High |
| Peer-2-Peer Pattern | High | High | High | High | High |
| Microservice Event Driven | High | High | High | High | High |

For the layered architecture's case, performance could be low due to overhead of multiple layers. Scalability might be constrained by layer dependencies. Although testability is good since layered architecture aids unit testing.

For the monolithic architecture's case, we believe performance could be high since direct function call reduces network call overhead. Scaling would be difficult since it requires duplicating the entire monolith architecture. Testability would be high as components can be tested within the monolith.

When it comes to the microkernel architecture, performance is said to be low due to indirection overhead. Scalability is high due to plug and play extensions which also extends to ease of testing as core and extension can be tested easily.

A Peer-to-Peer (P2P) system is often considered optimal across all criteria for several reasons: distributed computing capabilities, the ability to add any number of nodes, the ability to test peers individually, and the dynamic joining and leaving of peers from the network, among others.

For Microservice Event Driven architecture, performance is high due to distributed nature and scalable services. Testing is simplified with independent microservices, enhancing test coverage. Deployment is agile with independent services, minimizing downtime. Development benefits from modular design and rapid iterations.

In choosing the Microservice Event-Driven architecture, we're drawn to its many advantages and adaptability. This architecture relies on events or messages to connect different parts of the application, triggered by changes in its state. It offers several benefits: Firstly, it enables easy communication between services, allowing us to add or remove them as needed without hassle. Secondly, it allows us to introduce new services without disturbing the existing ones, making it simpler to add new features. Thirdly, it reduces the risk of failure by allowing services to communicate asynchronously. Lastly, it ensures swift communication between services, enabling real-time updates and interactions. These advantages are aligned with our project's needs, making Microservice Event-Driven architecture the ideal choice for ensuring scalability, flexibility, resilience, and speed in our system's design.

# 7. Proof of Concept

Now that we've explained and justified our decision-making process, it's time to move on to some proof of concepts (PoC) of the system. Our PoCs are a simplified, experimental version of components of the final system, aimed at demonstrating BlazeGuards resilience and maintainability. Ultimately, a successful PoC should instill confidence in the viability of the idea and help guide future development and investment decisions.

**We performed two experiments namely:** 
- Code Maintainability: using Springboot with clean architecture.
- Resilience: using Kafka event bus.

Given that no similar system has been deployed in Colombia, the ability to develop and integrate the system quickly and continuously will be crucial in ensuring its long-term serviceability. We chose not to demonstrate common metrics like scalability and fault tolerance since these are inherent to common architectures like Microservices.


### **1. Code Maintainability:**
This experiment aims to evaluate the maintainability of our codebase. To do this, we will analyze code readability, adherence to coding standards, and ease of understanding and modifying the code. We aim to ensure that our codebase remains maintainable and extensible over time, by adherence to clean coding practices and SOLID principles. This experiment showcases a practice which introduce an overhead of scaffolding and writing contracts within the code. However, while it may appear redundant for small-scale projects, it plays a vital role in ensuring the maintainability and extensibility of large-scale projects over time, such as BlazeGuard.

<!-- This experiment aims to evaluate the maintainability of our codebase. We will analyze factors such as code readability, adherence to coding standards, and ease of understanding and modifying the code. By emphasizing clean coding practices and adherence to coding principles such as SOLID, we aim to ensure that our codebase remains maintainable and extensible over time. This experiment seem a bit out of place as following this practice introduces an overhead of scaffolding and writing lot of contracts within the code that on small scale looks redundant but it is essential for large scale projects. -->


Spring Boot stands out as the most known framework for Java-based web applications, emphasizing simplicity in application setup with its "just run" approach. Its architecture reflects this simplicity, structured in layers with hierarchical communication between them. At the core of Spring Boot's architecture lies its simplified design as shown in the diagram below, characterized by layered communication. Notably, the Repository and Data Transfer Objects (DTOs) layer introduces additional dependencies, particularly impacting the Model layer. Additionally, all layers rely on framework code, rendering them susceptible to changes in the its interface. While these issues may seem insignificant in smaller projects with fewer developers, they escalate with project scale and complexity. As projects grow, these dependencies result in more substantial and costly code modifications.

{{<image file="POC.png" caption="Simple Architecture">}}

The simple architecture is implemented with following folder structure:
{{<image file="simple_fs.png" caption="Simple Architecture Project Structure">}}

**Methodology:**
Addressing the problem outlined above, we propose a solution by applying Clean Code Architecture, which is domain-centric and aligns with our objective of adopting a Domain-Driven Design approach. This architecture is structured with defined communication protocols between its layers to ensure clarity and maintainability in the system's evolution. Spring Boot combined with Clean Architecture principles, necessitates isolating domain logic from framework details. This involves utilizing gateways and interfaces for dependency inversion within layers.

The proposed architecture consists of three layers: Infrastructure, Use Case, and Entity, with a strict hierarchy ensuring inner layers remain unaware of outer layers. The Infrastructure layer integrates framework-dependent code such as controllers, JPA repositories, and domain model schemas. This decision aims to bridge conventional Clean Architecture layers, enhancing clarity. The subsequent layers operate independently from framework code. The Use Case layer houses system logic and DTO contracts for data exchange between application layers. The Entity layer encompasses domain models and contracts for database interaction, ensuring consistency in data manipulation.
{{<image file="POC_1.png" caption="Clean Architecture">}}

The Clean Architecture is implemented with the following folder structure:
{{<image file="clean_fs.png" caption="Clean Architecture Project Structure">}}

**Metrics:**
We used SonarQube[^14] for measuring metrics for our POC. SonarQube helps make applications last longer by simplifying code, removing duplicates, and preventing bugs. It promotes clean architecture and more unit tests, making software easier to maintain and adapt to changes.
#### Readability and Maintainability:
SonarQube use clean code approach to measure the readability and maintainability[^15].
{{<image file="metrics.png" caption="Reliability and Maintainability Issues">}}

We implemented the same business logic in two ways, one using the Simple architecture, `rms-simple` and other using the clean architecture, `rms-clean-code-arch`. It's evident from the readings in the figure above that `rms-clean-code-arch` have less reliability and maintainability issues. Although this came with a cost of code duplication due to redundant code needed to make framework work with the framework free domain layer. 
#### Code Cognitive Complexity
This defines how hard it is to understand the code's control flow[^16]. From the figures below it is evident from metrics that clean code[^17] did cause a decreased cognitive complexity but had an increased cyclomatic complexity due to addition of code that facilitated contracts and constraints on communication amongst the layers.
{{<image file="cog_simp.png" caption="Cognitive Complexity For Simple Architecture">}}
{{<image file="cog_clean.png" caption="Cognitive Complexity For Clean Architecture">}}

### 2. Resilience, Shutting and resuming a service:
This experiment holds significant importance as certain services are crucial for wildfire management. Any service failure should gracefully fallback and recover to ensure uninterrupted operations. Through this experiment, we aim to illustrate the rationale behind incorporating Event-Driven Architecture into Microservices. We will intentionally shut down selected services subscribed to the Message Broker and then restart them after a period. We anticipate the restarted servers to resume receiving messages that were not yet consumed due to the earlier failure.
We have implemented producer and consumer services for our system. The producer service collects data from the sensor mainframe and generates emergency alert messages. These alerts are then consumed by notification services subscribed to the 'Wildfire-Alert' topic. If we shut down the consumer service, the alert messages produced will queue up, awaiting consumption. Upon restarting the services, the queued messages are processed, and alerts are dispatched accordingly.

To follow or extend our proof of concept, you can refer to our repository [^18].


<!-- ## Demonstrating Maintainability through Clean Code and SOLID Principles: A Practical Experiment

We found it hard to portray Code Maintainability as an experiment but we came up with a methodology that we think will suffice to convince different stakeholders of the benefits. Since we do not have any external reviewer for code, we shall try these experiments within the team by exchanging different services that we built and report on the analysis.

**Methodology:**

- Code Review Session: Conduct code review sessions where developers analyze specific modules or components of the software system. During these sessions, focus on identifying adherence to Clean Code principles such as meaningful naming, single responsibility, and readability. Also, evaluate the application of SOLID principles within the codebase.
- Refactor Exercise: Perform a refactoring exercise where developers refactor a portion of the codebase to improve maintainability. Encourage them to apply Clean Code techniques and SOLID principles during the refactoring process. Measure the impact of refactoring on code readability, complexity, and modifiability.
- Unit Testing Demonstration: Showcase the importance of unit testing in maintaining code quality and facilitating future modifications. Guide developers through writing unit tests for specific modules or components of the software system. Evaluate the effectiveness of unit tests in ensuring code correctness and detecting regressions. -->



[^1]: **Wildfire report** https://edition.cnn.com/2024/01/25/americas/colombia-disaster-wildfires-el-nino-intl-latam/index.html

[^2]: **Problem Analysis** https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/blob/master/content/projects/03-wildfires/posts/r1_problem_analysis.md?ref_type=heads

[^3]: **Mircoservices** https://aws.amazon.com/microservices/

[^4]: **Event Driven Architecture** https://aws.amazon.com/event-driven-architecture/

[^5]: **SOLID Principles** https://blog.cleancoder.com/uncle-bob/2020/10/18/Solid-Relevance.html

[^6]: **TDD Real World Example** https://medium.com/@dees3g/a-guide-to-test-driven-development-tdd-with-real-world-examples-d92f7c801607

[^7]: **NASA firm API** https://firms.modaps.eosdis.nasa.gov/map/#d:24hrs;@0.0,0.0,3.0z

[^8]: **LookOut Cam** https://roboticscats.com/lookout/

[^9]: **SIATA** https://siata.gov.co/siata_nuevo/

[^10]: **High assurance software architecture and design** https://www-sciencedirect-com.tudelft.idm.oclc.org/science/article/pii/B9780323902403000151

[^11]: **Monolith Vs Microservice** https://www.atlassian.com/microservices/microservices-architecture/microservices-vs-monolith

[^12]: **Architecture Patterns** https://www.oreilly.com/library/view/software-architecture-patterns/9781098134280/ch04.html

[^13]: **Cognitive Complexity** https://medium.com/@nikhiljain1203/peer-to-peer-architecture-a-deep-dive-into-the-future-of-networking-d0f07945dca5
https://www.sonarsource.com/resources/cognitive-complexity

[^14]: **Sonarqube** https://docs.sonarsource.com/sonarqube/latest/

[^15]: **Sonar Clean Code Approach** https://docs.sonarsource.com/sonarqube/latest/user-guide/clean-as-you-code/

[^16]: **Sonarqube Cognitive Complexity**

[^17]: **Sonar Clean Code** https://docs.sonarsource.com/sonarqube/latest/user-guide/clean-code/definition/

[^18]: **POC github repo** https://gitlab.ewi.tudelft.nl/in4315/2023-2024/groups/team-3/

[^19]: **Conway's Law** https://martinfowler.com/bliki/ConwaysLaw.html

[^20]: **Clean Code Architecture** https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html

[^21]: **Solution Internal API** https://microservice-api-patterns.org/patterns/foundation/SolutionInternalAPI







