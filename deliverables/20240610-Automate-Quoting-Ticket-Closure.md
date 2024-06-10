# Task Report

| **Task Title**   | Automate Quoting Ticket Closure |
| ---------------- | ------------------------------- |
| **Task ID**      | SF-                             |
| **Requested By** | [Insert Requester's Name]       |
| **Assigned To**  | [Insert Assignee's Name]        |
| **Priority**     | High                            |
| **Status**       | Not Started                     |
| **Due Date**     | [Insert Due Date]               |

## Task Description

The task involves automating the closure of quoting tickets on the appropriate service board to reduce time wasted on closing these tickets manually. This automation will be triggered by an Opportunity webhook when specific conditions are met.

## Objectives

- [ ]  Automate the closure of quoting tickets based on Opportunity webhook.
- [ ]  Mark all resources as done given `SR_Service_RecID`.
- [ ]  Change the status to ">Quote Delivered".
- [ ]  Notify the user that the quote is delivered via the existing notification system.

## Requirements

- **Functional Requirements:**
    - [ ]  Implement a webhook listener for Opportunity updates.
    - [ ]  Create logic to check for conditions: `lastUpdated` = `CW-SELL` and `Type` = `3. Non-Recurring Revenue`.
    - [ ]  Execute SQL commands to update resources and status.
    - [ ]  Integrate notification system to inform the user upon quote delivery.

- **Non-functional Requirements:**
    - [ ]  Ensure the system is robust and handles errors gracefully.
    - [ ]  Maintain security and data integrity during the process.
    - [ ]  Ensure the solution is scalable to handle increased load.

## Deliverables

- [ ]  Webhook listener for Opportunity updates.
- [ ]  SQL scripts to update resources and status.
- [ ]  Integrated notification system.
- [ ]  Documentation of the automated process.

## Milestones

1. [ ]  **Design and Planning:** [2024-06-10]
2. [ ]  **Implementation of Webhook Listener:** [N/A]
3. [ ]  **SQL Script Development and Testing:** [2024-06-11]
4. [ ]  **Integration with Notification System:** [2024-06-14]
5. [ ]  **Final Testing and Deployment:** [2024-06-14]

## Dependencies

| **Dependency**     | **Details**                                                            |
| ------------------ | ---------------------------------------------------------------------- |
| **Prerequisites**  | Existing Opportunity webhook setup;<br>Notification system integration |
| **Postrequisites** | Validate that the notification system hasn't been impacted.            |

## Risks and Mitigations

|**Risk**|**Mitigation**|
|---|---|
|Webhook listener fails to trigger|Implement logging and monitoring|
|SQL script errors|Test thoroughly in a staging environment|
|Notification not sent|Ensure notification system is correctly integrated and tested|

## Resources

- **Team Members:**
    - Cameron Ott
    - Ian Wheeler
    - Jackie Moore
    - John Powell
    - Carrie Hatley
    - Dusty Corning

- **Tools & Technologies:**
    - Webhook Listener Framework
    - SQL Database
    - Notification System

- **Budget:** N/A

## Progress Updates

| **Date**   | **Progress**                                 | **Issues** | **Next Steps** |
| ---------- | -------------------------------------------- | ---------- | -------------- |
| 2024-06-10 | Created task and socialized with Cameron Ott | N/A        | See Document   |

## Notes

- Current webhook implementation details:

```JSON
{
    "id": 44271,
    "name": "Test Opp",
    "expectedCloseDate": "2024-06-26T00:00:00Z",
    "type": {
        "id": 34,
        "name": "3. NRR - Renewal",
        "_info": {
            "type_href": "https://connect.meriplex.com/v4_6_release/apis/3.0/sales/opportunities/types/34"
        }
    },
    "_info": {
        "lastUpdated": "2024-06-07T21:48:36Z",
        "updatedBy": "CW-Sell",
        "notes_href": "https://connect.meriplex.com/v4_6_release/apis/3.0/sales/opportunities/44271/notes"
    }
}
```

- SQL scripts for updating resources and status:

```SQL
-- View the Resources given SR_Service_RecID
SELECT
	*
FROM Schedule
WHERE RecID = <SR_Service_RecID>;
```

```SQL
-- Update all resources to done given SR_Service_RecID
UPDATE Schedule
SET close_flag = 1
WHERE Ticket_ID = <SR_Service_RecID>;
```

|SR_Status_RecID|Description|SR_Board_RecID|Board_Name|
|---|---|---|---|
|587|>Quote Delivered|21|Sales - Quoting Team|
|10952|>Quote Delivered|532|NRR - Quoting|

## References

[Opportunity work in two systems is painful meeting-20240607_160110-Meeting Recording.mp4](https://meriplex-my.sharepoint.com/:v:/p/ian_wheeler/EcOpgVwHGRNMh35ORw_6-MgBejHbo5vbZsa0EcGOB5154Q?e=2Rxfav&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D)
