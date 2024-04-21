---
type: article
title: "BlazeGuard: A Wildfire Resource Management System"
date: 2024-03-04T14:23:59Z
draft: false
---



<!--

https://edition.cnn.com/2024/01/25/americas/colombia-disaster-wildfires-el-nino-intl-latam/index.html
https://es.mongabay.com/2024/01/gobierno-colombiano-declara-situacion-de-desastre-y-calamidad-en-el-pais-ante-el-grave-impacto-de-incendios-forestales/
-->

## 1. Problem Description
In January of this year, Colombia experienced numerous wildfires[^1MRIOS], burning away tens of thousands hectares of wilderness[^2]. Even though the Firefighting Corps of the Nation are well trained in order to combat these emergencies, there are still challenges that they need to overcome to do so more efficiently. In particular, we want to focus on two pressing issues that hinder the corps in their efforts for the specific case of Colombia:

- Difficulty in coordinating resources during emergencies.
- Difficulty in detecting wildfires.

**Our mission** is to help in the protection of Colombia's wilderness and communities from the devastating impact of wildfires by delivering cutting-edge software technology that aids in wildfire detection and resource management.

### 1.1 Analysis of Existing Solution

To understand how these issues are identified and why they are present, we have delved into the management of wildfires in Colombia today. The protocol used by the Firefighter Corps in Colombia is called the Incident Command System (ICS), and was originally designed in the US, and further adapted to a general use within South American countries[^3]. This protocol consists of 8 steps that are followed until the emergency is contained[^4]:

- Inform the base of arrival to site.
- Take command of the situation and establish a command post (CP).
- Evaluate the situation.
- Establish a security perimeter.
- Define objectives.
- Define strategies.
- Determine Resources needed.
- Prepare the information to transfer command.
  To follow the protocol, the Corps are provided with a software to optimize their efforts. This software consists mainly of a digital platform for filling documents to track everything that can occur during emergencies [Appendix A], with some extra functionalities that can help in the planning of tasks. Based on the review of the existing software (which mainly focuses on the ICS) and interviews of a Volunteer Firefighter [^3], we found two challenges that the ICS protocol does not handle.

Most of this information, and information presented in the section 1.2 was obtained by means of an interview with a Volunteer Firefighter in Bogotá. The **video interview and transcript** is present in [Appendix C](#appendix).
<!-- Could meantion the lack of user roles, since we argue that user roles give different perimission etc, see Proposed solution and benefits -->

### 1.2 Main Challenges <!--... To Tackle -->

#### Difficulty in coordinating resources during emergencies.

Resources are expensive and limited therefore, it is necessary to use and distribute them in an efficient way in order to optimize their use. Furthermore, the areas subject to wildfires can be spread out and distant, and there are several types of resources that can be needed depending on the situation. Coordination of resources is therefore crucial to effectively suppress wildfire emergencies. Resource management is not handled in any way by either the ICS or the existing software.

<!--
  Can add a sentence about why it is hard to tackle/not tackled by now
  Also, maybe mention the tracking of ffs tasks (to decide after meeting to change scope)
 -->

#### Difficulty in detecting wildfires.

In order to minimize the damage made by wildfires, Firefighter Corps need to promptly respond to these emergencies. This heavily relies on how quickly wildfires are detected and subsequently Corps are alerted. Currently most Corps rely on visual detection of fires by traveling through historical high risk areas [^3]. An exceptional case occurs in a specific region in Colombia, Aburra Valley, where the SIATA system uses sensors placed around the valley to measure different environmental variables, and sends alerts to the firefighter corps when needed [^5]. A big issue with this approach is the sole reliance on SIATA to do this tasks, a failure on their part could hinder the corps in being alerted.

<!--
https://siata.gov.co/sitio_web/index.php/
-->

### 1.3 Stakeholder Analysis

<!-- Why? -->

To properly design a system that tackles the targeted challenges, it is necessary to understand the needs of everyone involved. Using stakeholder analysis we derive usecases , scenarios and requirements of the system. The main stakeholders in our case, are presented in the following diagram:

<a name="stakeholders"></a>
<!---
![Stakeholder Matrix](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3/content/projects/03-wildfires/images/2x2_matrix.png "Stakeholder Matrix")
-->
{{<image file="2x2_matrix.png" caption="Stakeholder matrix">}}

**Manage Closely:** These stakeholders are our main focus, since they will be the main users of the software. The Incident Command Officer (ICO), who is typically a Firefighter Captain or Commander, directs operations on-site and has the authority to request additional resources. Similarly, the Resource Manager, manages resource requests . Both these stakeholders play crucial roles, and ensuring their needs are met is essential for the system's success.

**Keep Satisfied:** _[Colombian Government](https://petro.presidencia.gov.co)_: The government, as a stakeholder in the system, holds significant power due to its authority, jurisdiction, and control over policies and resources related to wildfire management. However, its interest in the operational details of the system may be relatively low compared to other stakeholders.

**Keep Informed:** We must keep these groups informed throughout the software development process:
Incident Responders are the actors directly engaged in fire suppression efforts. Emergency services, including police, medical professionals, and other responders, play vital roles in coordinating emergency response efforts, although their specific involvement may vary. Developers have the technical expertise to influence the system's design and functionality to meet the objectives. Additionally, Data Providers, such as sensor mainframes, offer valuable data that aids in wildfire detection. Keeping these stakeholders informed ensures that the system meets the diverse needs of all involved parties.

**Monitor:** Media outlets, although their influence on system operations is limited, maintain an observational role. It's important to maintain communication with the media to ensure accurate reporting. Resource suppliers engage primarily in transactional interactions, providing essential resources for emergency response efforts. Monitoring their activities ensures timely access to necessary resources, optimizing emergency response efforts.

### 1.4 Ethical Considerations

Before designing a system, it is necessary to consider its ethical impacts. We found three main sources of concern:

**Civilian population**

The main objective of designing this system is to minimize any harm the civilian population may endure. To do so, it is necessary that the system is reliable and that it is an useful tool for firefighter corps to use in the handling of emergencies. The consequences for civilians can, in the worst case scenario, be fatal. Therefore, the system should not perpetuate any bias in resource management or hinder/delay the Firefighter Corps in any way. Additionally, the data sources the system gets the information from, should be reliable and notify of wildfires with no false positives or negatives.

**Firefighters**

The main ethical concern related to the firefighters is to keep in mind that they are still people even though the system allows to handle them as resources. For this reason, it must be essential that resource managers ensure that firefighters that are sent to handle an emergency are not overly overworked (eg. sending a firefighter to handle an emergency when they were just closing another one). Also, during the handling of the emergency, the ICO must be able to keep track of the amount of work that's being done by the firefighters under his command, so they won't get too overworked, specially since their working conditions are extremely dangerous and need to be in full capacity to minimize the risk. In other words, the system should account for human resources and their rights as personnel.

**Environment**

The concern is to mitigate the potential indirect environmental impact of this system. This impact may arise when dispatching resources to an Incident Command Officer (ICO) during emergencies in remote areas, where the absence of proper roads necessitates vehicles to forge paths wherever feasible to ensure resource delivery. Additionally, the system should address the environmental implications of resource allocation and coordination. Distributing all resources nationwide could result in environmental harm due to increased carbon emissions.

<!-- ASK IF WE CAN ADD ALGORITHM IN REQUEST MODULE, TO SUGGEST OPTIMAL RESOURCE ALLOCATION, based on bases-->

### 1.5 Sources of Ambiguity

To ensure a robust system design, it's vital to address and resolve ambiguity before proceeding to solution design. Here are some key areas where ambiguity needs to be tackled:

**Data Sources:**
IoT and sensor data may vary in format and frequency of measurement. Determining which sensors and data sources our system will utilize requires clarity. Data sources should be reliable in performance and data needs to be accurate. To clear out this ambiguity, this project's focus will not comprehend the data sources in it self, but rather assume the presence of existing data sources. The systems focus is the compatibility with several different data sources.

**Understanding Colombian Government Systems:**
Limited insights into government systems hinder tailoring efforts until official agreements are made.
Uncertainty exists regarding current processes for collaboration and resource sharing.
A solution is needed that can adapt to existing databases and streamline integration.

**Coordination and Collaboration:**
Cooperation and support from various sections and partner organizations are essential.
The system should be user-friendly such that collaboration will be easy. 
By addressing this ambiguity, we lay a solid foundation for designing a system that effectively meets the needs of stakeholders and operates smoothly within the Colombian context.

**System's goal and solution:**
The scope of managing wildfires is huge. There are numerous factors, both human, machine and environmental. To be able to propose a solution for a system, the team should have a clear, concise and common understanding of what the system is trying to solve. The system cannot address the enormous scope of the problem at hand hence, we created a list of requirements [appendix](#appendix) to help the team stay focused, aligned and effective in development process.

**Explanation of terms:**
For the team, and who ever is interested in the projects it is important to have a clear understanding of what we mean with domain specific terminology. These are words or phrases that can be general, used in different manner or vague. To prevent problems or misunderstanding arising due to this we have defined the most ambiguous terms used by the project:

- Firefighter Corps: Refers to the organized group of firefighters responsible for combating wildfires and managing emergency situations related to wildfires.
- Incident Command Officer (ICO): A designated officer within the Firefighter Corps who assumes command and control responsibilities at the scene of a wildfire emergency. The ICO is typically a senior-ranking firefighter tasked with directing firefighting efforts, making critical decisions, coordinating resources, and ensuring the safety and effectiveness of response operations.
- Resource Manager: Entity responsible for managing and coordinating the allocation of resources needed to combat wildfires. This role involves assessing resource requirements, organizing available resources, responding to resource requests from Incident Command Officers (ICOs), and ensuring efficient utilization of resources during firefighting operations.
- Users: Resource Managers and Incident Command Officers (ICO).
- Personnel: FireFighters and ICO's. 
- Resources: Personnels and equipment used for firefighting. 
- Base camp: Designates a central location established by firefighters at or near the scene of a wildfire emergency. The base camp serves as a logistical hub for coordinating firefighting operations, managing resources, providing support services to personnel, and facilitating communication between responders. Base camps can be both permanent and temperate.
- Resource Requests: Requests made by Incident Command Officers (ICOs) to Resource Managers for specific resources needed to address wildfire emergencies. These requests typically include equipment, personnel, supplies, or other resources necessary for firefighting operations.
- Dispatch: Allocate resources to be used for emergency within one base, marking the resources as unavailable

## 2. Solution Design

### 2.1 Proposed Solution and Benefits

The proposed solution envisions a resource management system specifically designed for firefighters in the handling of wildfire emergencies.
This solution provides the following benefits:

- Having user roles for different user permissions and access. Ensuring safe and reliant use of systems. <!-- link better to stakeholder analysis -->
- An active record of available and non available resources for better resource management.
- Analyzing tool to support allocation of resources in an effective and environmental way <!-- dashboard, not analyzing, filter opertunities based on location-->
- Retrieve information from different sources to detect and alarm about wildfires.

This system aims to streamline coordination between active firefighters and the emergency command centers, gather data from multiple sources to enhance emergency detection and response, and efficiently manage both human and material resources.

As mentioned before, to be able to align the development within a team there should be a clear and common understanding of the systems goal on a functional level. To minimize ambiguity the team has taken advantage of the analysis of the existing system and stakeholders to define requirements using MoSCoW prioritization, see [Appendix](#appendix). To further understand the users point of view, user actions our systems supports are defined from these requirements and visualized in the use case diagram below.

<!-- ![Use Case Diagram](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/blob/group-3/content/projects/03-wildfires/images/usecaseDiagram.png "Use Case Diagram") -->
{{<image file="usecaseDiagram.png" caption="Use case diagram">}}

### 2.2 Quality Attributes

We derived quality attributes for the system based on the defined requirements and stakeholder needs. Based on that we define the desirable qualities of the system further categorized into internal and external attributes. We also identified some risks and recommendations in [Appendix](#appendix).

#### Internal Quality Attributes:

1. **Maintainability**: is prioritized for stakeholders, like developers, who require informed updates. Our focus is on ensuring that our low-level code is designed in a manner that allows for easy testing, modification, and independent reuse.

2. **Testability**: This remains a priority for developers. Our approach will involve adopting modular and domain-driven design principles to facilitate effective testing of the codebase.

#### External Quality Attributes:

1. **Scalability**: This is essential for stakeholders using the system and with high interest. Our system is designed to handle increased workloads without sacrificing performance as the organization's wildfire management needs grow over time.

2. **Performance**: The system should perform efficiently, with fast response times and minimal latency, to support time-sensitive decision-making and resource allocation. This is crucial for stakeholders like ICO's and resource managers during emergency situations.

3. **Security**: The system should prioritise the security of sensitive data, ensuring that only authorized users have access to certain information and that communication channels are encrypted to protect against unauthorized access.This is primarily important for the Colombian government.

### 2.3 Scenarios

After analysing stakeholders and defining requirements of the systems, we can use this information to prepare user scenarios. Scenarios lets us envision the usage of the proposed solution. This contributes to understanding the domain, but also a valuable resource for supporting the architectural design process, as it can reveal context and dependencies within the system.
Next up is an overview of the use case scenarios for the system. The complete definition of each scenario is in the Appendix at the end of this document.

#### Overview of Scenarios

---

- **UC1 An User logs in to the system**: either a Resource Manager or an ICO wants to log in to the system.
- **UC2 An ICO sets up a Command Post/Base Camp**: upon detection of a emergency and ICO arrives to scene, they want to set up a base camp to handle the emergency.
- **UC3 An ICO requests resources to a Resource Manager**: when needed, an ICO can request resources to be delivered to the current base camp.
- **UC4 An ICO modifies a resource request**: after sending a resource request, in case they need to adjust resources ordered or delete the request.
- **UC5 An ICO closes the current Command Post/Base Camp**: once an emergency is contained, an ICO can close the current base camp, as it is not needed any more.
- **UC6 A Resource Manager processes requests from ICOs**: a Resource Manager can evaluate resource requests sent by ICOs.
- **UC7 An ICO assigns a task to a Firefighter**: an ICO can assign a task to a firefighter under their command to complete during an emergency.
- **UC8 An ICO marks a task as completed**: once a firefighter completes an assigned task, the ICO can mark it as completed to free up the firefighter.
- **UC9 An ICO updates the status of a wildfire**: an ICO can update the status of a wildfire they are currently managing.

### 2.4 Initial concept

<!--
![Context View](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3/content/projects/03-wildfires/images/context_diagram_v2.png "Context View")
-->
{{<image file="context_diagram_v2.png" caption="Context View">}}
Below, we outline our initial architectural concepts, informed by our domain analysis. To explain the idea and concept behind this post, we provide a visual high-level overview of the system's external dependencies and interactions, in the form of a context diagram. BlazeGuard is tailored to Colombia and aims to coordinate with various external systems, including the NASA API, LookOut Wildfire Detection Service, LookOutCam app and SIATA.

**Technical dependencies**

- SIATA: Provides a comprehensive system for the detection and monitoring of environmental variables in Colombia's Aburrá Valley. The data includes information on air quality, weather conditions, and other environmental factors relevant to wildfire risk assessment. Integrating with SIATA, gives access to real-time environmental data. <!-- references -->
- NASA API/FIRMS: An NASA API that offers daily global fire data, including data for Colombia. The data includes satellite-based fire detections, active fire locations, and fire intensity measurements. By leveraging the FIRMS API, the wildfire resource coordination system can access daily reports on active wildfires and their locations across Colombia. <!-- references -->
- LookOut wildfire detection service: This is a distributer of surveillance cameras to detect wildfires. These give our system hourly reports based on camera surveillance. <!-- reference -->
- LookOutCam App: This is an application allowing users to report fires, detected smoke or other signs of wildfire they might discover. By making BlazeGuard integrable with LookOutCam our systems supports detection of fire that cannot be done by sensors, or that might be detected by humans before IoT devices. <!-- reference -->
  <!-- Mention that the system should be integratable with new and different data sources -->

**Organizational dependencies**

- The systems relies on the working forces within wildfire (see [Stakeholders](#stakeholders)) incorporating our system for coordination, allocation and status update of resources.
- Responsible entities should provide the software and training to all users.
- We assume that incoming external aid will be reported through APC, Agencia Presidencial de Cooperacion Internacional, therefore, no changes to the organizational dependencies from the system used in Colombia today.

For the next iteration of development of BlazeGuard, we need to have an understanding of how the system works, not only the high-level context it is in ( the context view). As the problem description explains, the system relies on two different user types, resource manager and regular user (ICO). The reason for this it to allow different actions with authorization. Functionality is dependent on user type. The users interact with the system through a web application, which is dependent on the data from the sensor mainframe and location services. The service API's provide CRUD features.  

{{<image file="c4_container_2.png" caption="Container View">}}

The Domain Model below captures the essential entities, attributes, relationships, and behaviors relevant to the domain, providing a structured framework for understanding and discussing the problem at hand. In our model we have the following relationships and behaviors for the entities. 
- The base has an ICO personnel and equipment assigned to it.
- Each equipment requires skill to run. 
- Each personnel has a rank(military ranks) and tasks assigned to them.
- Each personnel has status available/non-available to dispatch associated with them.
- Users are defined as ICO and resource managers with admin and non admin user types respectively.
- All personnel can view wildfire details , sensor data and post incident details on the dashboard.  




{{<image file="Domain_Model_V2.png" caption="Domain  model">}}

## 3. Proposed Roadmap

We have divided our roadmap into 4 phases as illustrated below, we intend to follow this plan for our system. This is partly inspired by [aim42's](https://www.aim42.org/) software improvement phases. We understand and evaluate the system, then implement the solution and further improve and optimize the system. This iterative cycle aligns stakeholder requirements, aids developers in strategic planning, and guides project development to ensure adaptability to change.

<!--
![RoadMap](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3/content/projects/03-wildfires/images/roadmap.png "RoadMap")
-->
{{<image file="roadmap.jpg" caption="Roadmap">}}
## 4. Pricing Model
BlazeGuard's pricing model is structured around our mission to safeguarding Colombia's wilderness and communities from the destructive force of wildfires. Recognizing the essential nature of our mission, we prioritize sustainability over profit. Hence, we propose a Recurring Revenue Model designed to ensure the continuous support and enhancement of our wildfire detection and management system. Under this model, we request an annual payment from the the government or beneficiaries, tailored to cover the costs of maintaining the software and providing ongoing support.

# Appendix

## Appendix A: Use Cases

### UC1 - An User logs in to the system.

**Preconditions**:

- The user is registered in the system.
- The user is in possession of their credentials.

**Postconditions**:

- The user successfully logs in the system

**Flow Diagram**:

The following diagram displays the flow of this use case. It clearly displays the steps that are to be followed for an user to successfully log in the system:

<!--
![UC1](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r1-reqs-suecases/content/projects/03-wildfires/images/UC1%20-%20Log%20in%20to%20the%20System.jpg)
-->
{{<image file="UC1 - Log in to the System.jpg" caption="Use Case 1">}}

### UC2 - An ICO sets up a Command Post/Base Camp.

**Preconditions**:

- The ICO is registered in the system
- The ICO is assigned to respond to the wildfire

**Postconditions**:

- Base camp is successfully set up

**Flow Diagram**:

The following diagram displays the flow of this use case. It clearly displays the steps that are to be followed for an ICO to successfully set up a base camp to handle a wildfire emergency:

<!--
![UC2](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r1-reqs-suecases/content/projects/03-wildfires/images/UC2%20-%20Set%20up%20a%20base%20camp%20upon%20emergency.jpg) 
-->
{{<image file="UC2 - Set up a base camp upon emergency.jpg" caption="Use Case 2">}}

### UC3 - An ICO requests resources to a Resource Manager.

**Preconditions**:

- The ICO has a base camp setted up.

**Postconditions**:

- A request is successfully sent to the Resource Manager (RM)

**Flow Diagram**:

The following diagram displays the flow of this use case. It clearly displays the steps that are to be followed for an ICO to send a resource request to the RM:

<!--
![UC3](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r1-reqs-suecases/content/projects/03-wildfires/images/UC3%20-%20ICO%20wants%20to%20request%20resources.jpg)
-->
{{<image file="UC3 - ICO wants to request resources.jpg" caption="Use Case 3">}}
### UC4 - An ICO modifies a resource request.

**Preconditions**:

- The ICO has previously sent a resource request

**Postconditions**:

- The request is successfully modified in case it has not been dispatched yet.

**Flow Diagram**:

The following diagram displays the flow of this use case. It clearly displays the steps that are to be followed for an ICO to modify a resource request they have already sent:
<!--
![UC4](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r1-reqs-suecases/content/projects/03-wildfires/images/UC4%20-%20ICO%20Modifies%20resource%20request.jpg)
-->
{{<image file="UC4 - ICO Modifies resource request.jpg" caption="Use Case 4">}}
### UC5 - An ICO closes the current Command Post/Base Camp.

**Preconditions**:

- The ICO is assigned to a base camp.
- The wildfire emergency's status currently being handled has its status changed to contained/completed.

**Postconditions**:

- The base camp is successfully closed.

**Flow Diagram**:

The following diagram displays the flow of this use case. It clearly displays the steps that are to be followed for an ICO to close the base camp they are assigned to:
<!--
![UC5](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r1-reqs-suecases/content/projects/03-wildfires/images/UC5%20-%20ICO%20closes%20base%20camp%20after%20emergency%20is%20contained.jpg)
-->
{{<image file="UC5 - ICO closes base camp after emergency is contained.jpg" caption="Use Case 5">}}
### UC6 - A Resource Manager processes requests from ICOs.

**Preconditions**:

- The Resource Manager is logged into the system.

**Postconditions**:

- The resource request is handled.

**Flow Diagram**

The following diagram displays the flow of this use case. It clearly displays the steps that are to be followed for a Resource Manager to handle a resource request from an ICO:
<!--
![UC6](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r1-reqs-suecases/content/projects/03-wildfires/images/UC6%20-%20Resource%20request%20is%20handled.jpg)
-->
{{<image file="UC6 - Resource request is handled.jpg" caption="Use Case 6">}}
### UC7 - An ICO assigns a task to a Firefighter.

**Preconditions**:

- The ICO is logged in the system.
- The ICO has at least one firefighter currently assigned to the base camp.

**Postconditions**:

- The task is successfully assigned to the firefighter

**Flow Diagram**:

The following diagram displays the flow of this use case. It clearly displays the steps that are to be followed for an ICO to assign a task to a firefighter:
<!--
![UC7](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r1-reqs-suecases/content/projects/03-wildfires/images/UC7%20-%20ICO%20assigns%20task%20to%20a%20firefighter.jpg)
-->
{{<image file="UC7 - ICO assigns task to a firefighter.jpg" caption="Use Case 7">}}
### UC8 - An ICO marks a task as completed.

**Preconditions**:

- The ICO is logged in the system.
- The ICO has assigned a task to a firefighter in the basecamp.
- The firefighter has completed the task.

**Postconditions**:

- The task is successfully marked as completed, freeing the firefighter from it.

**Flow Diagram**:

The following diagram displays the flow of this use case. It clearly displays the steps that are to be followed for an ICO to mark a task assigned to a firefighter in the base camp as completed:
<!--
![UC8](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r1-reqs-suecases/content/projects/03-wildfires/images/UC8%20-%20A%20task%20is%20completed.jpg)
-->
{{<image file="UC8 - A task is completed.jpg" caption="Use Case 8">}}
### UC9 - An ICO updates the status of a wildfire.

**Preconditions**:

- The ICO is assigned to a base camp.

**Postconditions**:

- The status of the wildfire is successfully changed.

**Flow Diagram**:

The following diagram displays the flow of this use case. It clearly displays the steps that are to be followed for an ICO to change the status of a wildfire:
<!--
![UC9](https://gitlab.ewi.tudelft.nl/in4315/2023-2024/desosa2024.gitlab.io/-/raw/group-3-r1-reqs-suecases/content/projects/03-wildfires/images/UC9%20-%20Changing%20status%20of%20wildfire.jpg)
-->
{{<image file="UC9 - Changing status of wildfire.jpg" caption="Use Case 9">}}
<!-- Dont know where this should go -->

## Appendix B: Requirements

#### Functional Requirements:

To further be able to prioritize development, the team has divided the requirements into different severity levels (_must_, _should_, _could_, _won't_ and _non functional_) for the project.

##### Must

- A user must login/logout
- A user must receive a notification when a wildfire is detected.
- A user must be able to view wildfire incident details like severity, containment status, location etc.
- A user must be able to view all base camps.
- An ICO must be able to see the inventory of resources currently at their base camp.
- An ICO must be able to view all basecamp locations.
- An ICO must be able to dispatch the resources of their own base camp in case of an incident.
- An ICO must be able to request resources to the resource manager.
- An ICO must be able to view which resources they are allocated.
- A resource manager must be able to dispatch the resources of all base camp in case of an incident.
- A resource manager must be able to log new resources in the inventory.
- A resource manager must be able to view resource requests from ICOs.
- A resource manager must be able to accept dispatch requests.
- A resource manager must be able to deny dispatch requests.
  A resource manager must be able to modify dispatch requests.(if 10 resources are requested , but only 8 are available, the resource manager must be able to approve 8).
- A resource manager must be able to view and track the inventory of total resources of the corps(including all allocated resources to all other base camps) based on availability and utilization in real time.
- A resource manager must be able to add new users to the system.

**Should:**

- A user should be able to access information on historical wildfire incidents.
- A user should be able to generate reports on past wildfire incidents, including details like location, size , duration and impact.
- A resource manager should be able to access historical data for resource allocation.
- An ICO should be able to document and track incident-related communications, decisions, and actions within the system for accountability and record-keeping purposes.
- An ICO should be able to generate incident reports summarizing key information, actions taken, and outcomes for post-incident analysis and documentation.
- An ICO should not be able to overwrite a resource manager

**Could:**

- A resource manager could give a reason for the denial/partial denial of a request.
- A resource manager could conduct resource allocation simulations within the system to optimize resource deployment strategies based on different scenarios.
- A resource manager could communicate with resource suppliers directly through the system to request additional resources.

**Won't:**

- A non-ICO user wont be able request resources
- An ICO wont be able to handle two separate base camp wildfire incidents simultaneously.

#### Non-Functional Requirements:

- The system will provide well documented RESTful API.
- The system will have a design that is easy to implement.
- The system will be designed using SOLID principles.
- The system will contain microservices architecture for modularity and scalability.
- The system will comply with interoperability standards and protocols established by relevant organizations like NIMS, ICS, EDXL.
- The system will provide security features for authentication , authorization and accountability using the identity service.
- The system should be able to integrate data for wildfire detection from multiple sources
- The system should have an intuitive user-friendly interface for users with varying level of familiarity with technical systems.
- The system should be interoperable with existing government databases, weather forecasting services and communication platforms for data exchange.
- Comprehensive documentation and technical support will be provided for the system to facilitate effective utilization.

### Quality Attributes:

1. **Maintainability**:

   - **Background:** Developing maintainable code is crucial for the long-term sustainability of our software system. Without proper maintainability practices, the codebase can become difficult to manage and update, leading to increased technical debt and decreased developer productivity.
   - **Risks Identified:** The risk of poor maintainability includes longer development cycles, increased likelihood of introducing bugs during modifications, and difficulty in onboarding new developers to the project.
   - **Recommendation:** To address this risk, we recommend implementing modular design principles, clear documentation, and consistent coding standards to ensure that the codebase remains maintainable throughout its lifecycle.

2. **Testability**:

   - **Background:** Testability is essential for ensuring the reliability and stability of our software system. Without adequate testability measures, it becomes challenging to verify the correctness of the code and detect potential defects early in the development process.
   - **Risks Identified:** Inadequate testability can lead to increased regression issues, decreased software quality, and difficulties in achieving test coverage goals.
   - **Recommendation:** To mitigate these risks, we recommend implementing modular design patterns, dependency injection, and automated testing frameworks to improve the testability of our codebase.

3. **Scalability**:
   - **Background**: Scalability is essential for ensuring that our software system can accommodate growing user bases and data volumes without experiencing performance degradation or service disruptions.
   - **Risks Identified:** Risks associated with scalability limitations include decreased user satisfaction, increased downtime, and potential loss of business opportunities.
   - **Recommendation:** To mitigate these risks, we recommend adopting scalable architectures, distributed computing paradigms, and horizontal scaling strategies

## Appendix C: Interview with Volunteer Firefighter
Interview video is present in the following url (spanish): https://youtu.be/M0NXRZvkQ9k
The full transcript of the interview in english is present in the following document: https://docs.google.com/document/d/1HFL6Uxy1Oo1XIRbS0rddSTvBzY8dvc7OfmHIKStZ_6I/edit?usp=sharing

Note that due to the length of the interview, it was not practical to transcribe and translate it manually, so ChatGPT was used.

[^1MRIOS]: **M. Rios. "Colombia declares a disaster due to wildfires as it calls for international help. CNN.**  
https://edition.cnn.com/2024/01/25/americas/colombia-disaster-wildfires-el-nino-intl-latam/index.html. Last accessed March 25 2024.


[^2]: **J. C. Granados. "Gobierno colombiano declara situación de desastre y calamidad en el país ante el grave impacto de incendios forestales". Mongbay.**
https://es.mongabay.com/2024/01/gobierno-colombiano-declara-situacion-de-desastre-y-calamidad-en-el-pais-ante-el-grave-impacto-de-incendios-forestales/

[^3]: **Interview with Volunteer Firefighter Nicolas Lastre.**
https://youtu.be/M0NXRZvkQ9k

[^4]: **idc appdrones. "Operaciones de Emergencia: Sistema Comando de Incidentes". IDC.**
 https://idc.apddrones.com/humanitario/operaciones-de-emergencia-sistema-comando-de-incidentes/#:~:text=El%20Sistema%20Comando%20de%20Incidentes%20es%20una%20herramienta%20de%20manejo,incidentes%20y%20manejo%20de%20eventos. Last accessed March 25 2024.

[^5]: **SIATA**
https://siata.gov.co/sitio_web/index.php/