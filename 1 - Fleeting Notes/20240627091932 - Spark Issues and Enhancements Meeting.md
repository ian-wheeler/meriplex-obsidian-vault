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

| Name               | Role                         | Email                           | Company  |
| ------------------ | ---------------------------- | ------------------------------- | -------- |
| Ian Wheeler        | Lead Business Analyst        | ian.wheeler@meriplex.com        | Meriplex |
| Brian Jones        | CTO                          | brian.jones@meriplex.com        | Meriplex |
| Anthony Kazlauskas | Solutions Consultant         | anthony.kazlauskas@meriplex.com | Meriplex |
| Ron Walker         | Solutions Consultant         | rwalker@meriplex.com            | Meriplex |
| Brian McShane      | Solutions Quoting Specialist | brian.mcshane@meriplex.com      | Meriplex |
| John Powell        | VP, Service Delivery (NRR)   | jpowell@meriplex.com            | Meriplex |


## Goals

To review and resolve issues with the Spark form, gather feedback, and plan optimizations.

## Agenda 

1. Identify and prioritize current Spark form issues
2. Share and discuss user feedback and feature requests
3. Propose and evaluate potential form optimizations and changes
4. Develop an action plan for implementing agreed-upon improvements

## Discussion Notes

- Add a `Summary` field to the Spark form
    - Maps to opportunity name in Salesforce
- Rename `Contact` field to `Approver`
- Add a new `Requestor` field:
    - If all users can create contacts:
        - Field Type: Single-Value Dropdown (Contact Lookup)
    - Otherwise:
        - Field Type: String
        - Maps to the notes section of the `Opportunity`
- Implement ConnectWise `Workflows` to notify the `Requestor` when:
    - Spark form is submitted 
    - Opportunity is quoted and sent to the customer
    - Customer signs the quote
    - Contract Distribution wins the quote
    - Procurement orders the items
- Enhance ConnectWise `Workflows` for `Solutions Consultant` notifications:
    - Include all submitted information in email notices (Client Name, Subject line, Description of Need, Client Contact, Submitter information, date needed)
    - Update CW Manage ticket to contain all submitted information
    - Ensure files added in Spark are attached to email, Salesforce, and Manage ticket
- Create ConnectWise `Workflows` to notify the customer (`Contact`/`Approver`) when:
    - Items are ordered
    - Items are shipped 
    - Labor is scheduled
- Fix issue: File not being attached to quote request upon Spark form submission
- Extend `Notes`/`Description` field to maximum available string length (align with Salesforce)
- Assign `Opportunity Owner` as a `Resource` to ticket created from quote request
- Ensure all information captured in the Spark form (including new fields and attachments) is included in notification emails
## Action Items

| Task | Description | Task Owner | Due Date | Status |
| ---- | ----------- | ---------- | -------- | ------ |
|      |             |            |          |        |

## Decisions

### Next Meeting Date

```Datetime

```

### Next Meeting Location

- Microsoft Teams: 

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