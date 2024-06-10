# Task Report

| **Task Title**   | Correct Quote Ticket Routing |
| ---------------- | ---------------------------- |
| **Task ID**      | SF-20240610133220            |
| **Requested By** | Jackie Moore                 |
| **Assigned To**  | Cameron Ott                  |
| **Priority**     | High                         |
| **Status**       | In-Progress                  |
| **Due Date**     | 2024-06-14                   |

## Task Description

The task involves correcting the board routing for ticket creation from Salesforce (SF) to ConnectWise (CW). The goal is to ensure that tickets are created on the appropriate service board based on the `Opportunity Type` in Salesforce.

## Objectives

- [ ]  Implement logic to route tickets to the correct board in CW based on `Opportunity Type` in SF.
- [ ]  Ensure that tickets with `Opportunity Type` as `3. Non-Recurring Revenue` are created on the NRR Quoting Board in CW.
- [ ]  Ensure that tickets with other `Opportunity Types` are created on the MRR Quoting Board in CW.

## Requirements

- **Functional Requirements:**
    - [ ]  Implement a check on `Opportunity Type` in SF during ticket creation.
    - [ ]  Route tickets to the NRR Quoting Board (`NRR - Quoting`) in CW if `Opportunity Type` is `3. Non-Recurring Revenue`.
    - [ ]  Route tickets to the MRR Quoting Board (`Sales - Quoting Team`) in CW for all other `Opportunity Types`.
    - [ ]  Ensure correct `SR_Board_RecID`, `Owner_Level_RecID`, and `Billing_Unit_RecID` are set for the tickets.

- **Non-functional Requirements:**
    - [ ]  Ensure the routing logic is efficient and does not introduce significant delays.
    - [ ]  Maintain data integrity and accuracy during the ticket creation process.
    - [ ]  Ensure the solution is scalable to handle increased load.

## Deliverables

- [ ]  Updated routing logic for ticket creation from SF to CW.
- [ ]  Documentation of the routing logic and process.
- [ ]  Testing and validation of the routing logic.

## Milestones

1. [ ]  **Design and Planning:** [N/A]
2. [ ]  **Implementation of Routing Logic:** [2024-06-11]
3. [ ]  **Testing and Validation:** [2024-06-12]
4. [ ]  **Deployment:** [2024-06-14]

## Dependencies

|**Dependency**|**Details**|
|---|---|
|**Prerequisites**|Existing ticket creation process from SF to CW|
|**Postrequisites**|Validation and testing of routing logic|

## Risks and Mitigations

|**Risk**|**Mitigation**|
|---|---|
|Incorrect routing logic implementation|Implement thorough testing and validation|
|Delays in ticket creation|Optimize the routing logic for efficiency|
|Data integrity issues|Ensure proper error handling and logging|

## Resources

- **Team Members:**
    - Cameron Ott
    - Ian Wheeler
    - Jackie Moore
    - John Powell
    - Carrie Hatley
    - Dusty Corning

- **Tools & Technologies:**
    - Salesforce
    - ConnectWise
    - SQL Database

- **Budget:** [N/A]

## Progress Updates

| **Date**   | **Progress**                                                      | **Issues** | **Next Steps** |
| ---------- | ----------------------------------------------------------------- | ---------- | -------------- |
| 2024-06-10 | Task created and socialized with assigned resource (Cameron Ott). | N/A        | See Document   |

## Notes

| SR_Board_RecID | Board_Name           | Owner_Level_RecID | Billing_Unit_RecID |
|----------------|----------------------|-------------------|--------------------|
| 532            | NRR - Quoting        | 11                | 6                  |
| 21             | Sales - Quoting Team | 11                | 6                  |

## References

[Opportunity work in two systems is painful meeting-20240607_160110-Meeting Recording.mp4](https://meriplex-my.sharepoint.com/:v:/p/ian_wheeler/EcOpgVwHGRNMh35ORw_6-MgBejHbo5vbZsa0EcGOB5154Q?e=2Rxfav&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D)
