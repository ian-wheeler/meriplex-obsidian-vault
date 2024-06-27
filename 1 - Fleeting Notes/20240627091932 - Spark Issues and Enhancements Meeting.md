---
id: 20240627091932
type: Meeting Note
tags:
  - fleeting
  - meeting
  - deliverable
---
# Spark Issues and Enhancements Meeting

> [!Note]
> - 

## Date & Time

```Datetime
Thursday, June, 27, 2024 | 09:00 AM - 10:00 AM CST
```

## Location

Microsoft Teams: [Join conversation](https://teams.microsoft.com/l/meetup-join/19%3ameeting_NTc1OGRhMWUtYTdmMi00Nzg0LWEzNTYtZjUzNzMxOGZjZTE3%40thread.v2/0?context=%7b%22Tid%22%3a%226d4422b6-9fe9-4ec2-8904-ccaa320bd30a%22%2c%22Oid%22%3a%22d1265f8e-b7dc-4ea8-8bf5-e57147f74946%22%7d)

## Participants

| Name        | Role                  | Email                    | Company  |
| ----------- | --------------------- | ------------------------ | -------- |
| Ian Wheeler | Lead Business Analyst | ian.wheeler@meriplex.com | Meriplex |


## Goals
<!-- What we want to achieve in this meeting -->
- 

## Agenda 
<!-- What, who & duration planned in advance -->
- 

## Discussion Notes
<!-- Cover discussion topics -->
- Add a `Summary` field to the spark form
- Re-label the `Contact` field to `Approver`
- Add a field for `Requestor` -> drop-down list for contact if everyone has permission to create contacts -> maps to the notes section of the `Opportunity`
- Everything captured in the spark form needs to come through on the notification email.
- Create ConnectWise `Workflows` to notify the `Your Name` when:
	- Spark form is submitted 
	- The opportunity is quoted and sent to the customer
	- When the customer signs the quote
	- When Contract Distribution Wins the quote
	- When procurement orders the items
- Create ConnectWise `Workflows` to notify the `Solutions Consultant` when:
	- Email notice to solution consultant from SPARK needs to contain all submitted information. i.e. Client Name, Subject line, Description of Need, Client Contact, Submitter information, date needed. 
	- Currently only shows: Opportunity#: 44962 has been created with quote request ticket#: 11203533 attached 
	- CW Manage ticket needs to contain all submitted information. 
	- Currently only shows "NRR Request" 
	- Files added in Spark need to be attached to email, SF and Manage ticket.
- Create ConnectWise `Workflows` to notify the `Customer`/`Approver` when:
	- Items are ordered
	- Items are shipped 
    - Labor is scheduled
- The file is not being attached to the quote request when spark form is submitted. -> should come through in the email
- `Notes`/`Description` Field needs to be extended to maximum available string length in line with Salesforce.
- Ticket being created from quote request needs to have `Opportunity Owner` assigned as a `Resource`
## Action Items
<!-- Add tasks, task owners and due dates -->
- 

## Decisions
<!-- Record of decisions you make in this meeting -->
- Next meeting date and place: 
- Documents to be included in the meeting notes:


---
# Back Matter
## Questions
<!-- What remains for you to consider? --> 
- 

## Terms
<!-- Links to definition pages -->
- 

## References
<!-- Links to pages not referenced in the content -->
- 