# Home

## Overview

### [Check list for issues](#check-list-for-issues)

### [Sprints](#sprints)

### Meetings

| Week | Group Meeting notes                                                                     | TA Meeting notes             | Feedback                 |
| ---- | --------------------------------------------------------------------------------------- | ---------------------------- | ------------------------ |
| 2    | ADD_MEETING_WITH_FFVOLUNTEER                                                            |                              |                          |
| 3    | [Group Meeting](#group-meeting-notes-w3)                                                |                              |                          |
| 4    | [Group Meeting](#group-meeting-notes-w4)                                                | [TA Meeting](#ta-meeting-w4) | [Feedback](#feedback-w4) |
| 5    | [Group Meeting](#group-meeting-notes-w5)                                                |                              | [Feedback](#feedback-w5) |
| 6    | [Group Meeting 1](#group-meeting-notes1-w6) [Group Meeting 2](#group-meeting-notes2-w6) | [TA Meeting](#ta-meeting-w6) | [Feedback](#feedback-w6) |

## Check list for issues

- [ ] Label (unassigned/doing/ready for review)
- [ ] Task type (coding/report/diagrams)
- [ ] Issue must be split into managable tasks
- [ ] Assigned to 1 (max 2 persons)

[Issue template](#issue-template)

## Sprints

- [x] 3: 27.feb.march - 3.march
- [x] 4: 5.march - 11.march
- [x] 5: 12.march - 18.march
- [ ] 6: 19.march -25.march

## Meetings

### Week 3

#### Group Meeting notes w3

Agenda

- Date: 3.march
- Start: 13.45
- End: 15.45
- Where: Drebbelweg study hall 3
- Goal:
  - [x] Define all parts of R1 that needs to be looked at before hand in
  - [x] Work through each section of the report

##### To do

- [x] Container view
- [x] Create presentation for TA group 30 meeting

### Week 4

#### Group Meeting notes w4

#### TA meeting notes w4

Agenda

- Date: 7.march
- Start: 17.30
- End: 18.30
- What do you do about all the external data? What data is chosen out of all the data sources?
- What will you do about the connection? If the data is in unconnected areas?
  - What about logging stuff in the system if the fire is in areas without network?
  - Base operation/camps
    - Should there be an offline system
- What did you mean by the conceptual problem, did not get it - TA
- Request slide 5. and slide 7. are a lot
  - Narrow it down
  - This is way to much
  - Start by taking look at quality attributes, what are the most important quality attributes
    - That people know where the fire is?
      - Getting info from the banks, news, may not that important
- Limit external
  - How important is the NASA data?
- Google use-case diagram not UML diagram
- Link quality attributes to other stuff, have a flow, mckinseys pyramid

#### Feedback w4

- [TA meeting notes w4](#ta-meeting-notes-w4)
- Slide 5 requirements, that's very broad, like the scope of your app seems gigantic
- Domain model could be use case diagram, slide 6
- Slide 7, GIGANTIC context, you should definitely scale down
- General for presentations: put slide numbers on all slides
- Do you know why the satellite only get data once a day?
  only go over columbia once a day
- Conceptual problem, I didn't really understand what you meant?
  A lot of gaps, not sure what to focus on
- You have a lot of moving parts? Large scale.
  Will nail down a lot of details later
  Process external data first
  So like a design pattern? -> yes
- How do you get sensor data if you don't have network connection?
  they sort of assume sensor will work, assumption is that they have internet at a base

### Week 5

#### Group Meeting notes w5

Agenda

- Date: 11.march
- Start: 13.30
- End: 15.30
- Where: Drebbelweg study hall 1
- Goal:
  - [x] Refine domain
  - [x] Go over [feedback w5](#feedback-w5)
  - [x] Go over [TA meeting notes w4](#ta-meeting-notes-w4)

1. Domain

- Domain is refined, see updated diagrams on discord.
  - External data sources are reduced (no need to predefine where the data is comming from)
    - May emmulate from a specific data source and specify in report

1. Feedback

- Stakeholder analysis should be categorized
  - Government
  - Resource manager
  - ICO
  - Media
  - Resource suppliers
  - Developers
  - Incident Responders
  - Data providers
  - Emergency services
- Is our app in any way targetting the victims as stakeholders?
  - No, not within our scope
- Roadmap needs to be fixed
  - Mitali fixes
- We need to rewrite requirements in MoSCoW
  - Must
    -
- Need sequence diagram

##### To do

- [ ] Roadmap
- [ ] Explain diagrams
- [ ] Rewrite requirements
- [x] Use Case Diagram
- [ ] Sequence diagram
- [ ] Rename diagrams to C4 model names
- [ ] Rorder qulity attibutes higher in report
- [ ] Ethics

#### Feedback w5

- I like that you are putting links!
- You should categorize the stakeholders, see Lucidchart stakeholder analysis template (diagram)
- Is your app in any way targetting the victims as stakeholders?
- Roadmap is very vague, you can be more concrete with your goals, look at how game developers make roadmaps
- For requirements I'd write them in sentences and sort with MoSCoW, and if you want you can link them to gitlab issues for "status"
- For scenarios it would be really good to have a use case diagram
- For timing different tasks, explaining some scenarios happen, you could also do a sequence diagram
- "Domain Model" I think this what Arie calls in the lecture "Context diagram", if yes, try to name them using the C4 model names
- I'd put the quality attributes higher up in the report and sort of based your design decisions (diagrams, scenarios, requirements) off of them
- For ethics it's very vague, try to be more concrete about for e.g. exactly how fairness applies for your system
- Diagrams are nice, but please explain the

### Week 6

#### Group Meeting notes1 w6

Agenda

- Date: 18.march
- Start: 13.30
- End: 15.30
- Where: Echo 1.450
- Goal:
  - [x] Go over diagrams
  - [x] Go over architecture

1. Go over diagrams from R1

   - Container view
     - Post-Incident Recovery -> Post incident assesement
     - User on the system -> User of the system
   - Component view:
     - Machniery -> Equipment
     - Post-Incident Recovery -> Post incident assesement
   - Use case diagram is updated
     - Finalized
   - UML diagram
     - Weak entity for skill mapping

2.

##### To Do

- [ ] Mitali - roadmap, R2
- [ ] Pia - R1, homePage
- [ ] Nicolas - R1, requirements
- [ ] Arnob - Diagrams, R2

#### Group Meeting notes2 w6

Agenda

- Date: 24.march
- Start: 15.00
- End: 15.30
- Where: Discord
- Goal:
  - [ ] Finish R1
    - [ ] Common walk-through of entire report
    - Specially
      - [ ] Use Cases
      - [ ] Requirements
      - [ ] Pricing model
      - [ ] Sources of ambiguity
      - [ ] Models and Images
  - [ ] Create clear and task divided path to finish R

#### TA meeting notes w6

#### Feedback w6

## Issue template

<!-- Start -->

\# Details

\_Please specify a description\_

\# Definition of Done

\_Please specify a definition of done\_

- [ ] Subtask 1 ...
- [ ] Subtask 2 ...

\# Possible Solutions

\_Please specify a solution for the assignee to try\_

<!-- End -->
