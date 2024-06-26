---
id: 20240626155937
type: Meeting Note
tags:
  - fleeting
  - meeting
  - kickoff
  - project
  - platypus
  - connectwise
  - task
  - deliverable
  - migration
---
# Touchpoint on Platypus to ConnectWise Migration Ask

> [!Note]
> High-level description and key insights go here.

## Date & Time

```Datetime
Wednesday, June 26, 2024 | 04:00 PM CST - 04:30 PM CST 
```

## Location

- Microsoft Teams: [Join conversation](https://teams.microsoft.com/l/meetup-join/19%3ameeting_NjYzMjA2NmMtMDFiNS00MzQ1LWI1NmEtNjFmMmZhNDk4MzBi%40thread.v2/0?context=%7b%22Tid%22%3a%226d4422b6-9fe9-4ec2-8904-ccaa320bd30a%22%2c%22Oid%22%3a%229d4d2794-996a-4c9a-9792-18687f39c963%22%7d)

## Participants

| Name        | Role                  | Email                    | Company  |
| ----------- | --------------------- | ------------------------ | -------- |
| Ian Wheeler | Lead Business Analyst | ian.wheeler@meriplex.com | Meriplex |
| Brian Jones | CTO                   | brian.jones@meriplex.com | Meriplex |

## Goals

- Review the `Platypus Migration to ConnectWise Initiative`

## Discussion Notes

- Initial attempt to migrate from Platypus to ConnectWise Manage resulted in failure.
- Blended customers: billing out of PLAT and CW
- Project is to match the agreements and billing amounts and make sure they are correct in ConnectWise and then check with Finance (Alex Midkif on the Billing Team) that they are correct before deactivating the customers in Platypus.
- One other resource
- Brian has (3) files where he started trying to identify matches.
- Paul Guillo is the key stakeholder.
- (140) Accounts
- Remove telecom items if in ConnectWise and not in platypus (unless they are on an Avalara Agreement that's already billing)
	- Confirm telecom items 
- Sequence:
	- Pick some small 
	- Match `Accounts`
- First week of August 2024-08-02

Access to the Platypus Server.

## Action Items
<!-- Add tasks, task owners and due dates -->

| Task                        | Description                                                                                                                 | Task Owner  | Due Date   | Status |
| --------------------------- | --------------------------------------------------------------------------------------------------------------------------- | ----------- | ---------- | ------ |
| Match Accounts              | Match the Accounts in Platypus to Companies in ConnectWise Manage                                                           | Ian Wheeler | 08/02/2024 |        |
| Match Agreements            | Match the Agreements in Platypus to the Agreements in ConnectWise Manage                                                    | Ian Wheeler | 08/02/2024 |        |
| Match Additions             | Match the Additions in Platypus to the Additions in ConnectWise Manage                                                      | Ian Wheeler | 08/02/2024 |        |
| Telecom Addition Review     | Remove Telecom Additions in ConnectWise if they are not found in Platypus (except for Avalara Agreements currently billing) | Ian Wheeler | 08/02/2024 |        |
| Data Update - Accounts      | Update and insert Account data from Platypus to ConnectWise Manage                                                          | Ian Wheeler | 08/02/2024 |        |
| Data Update - Agreements    | Update and insert Agreement data from Platypus to ConnectWise Manage                                                        | Ian Wheeler | 08/02/2024 |        |
| Data Update - Additions     | Update and insert Addition data from Platypus to ConnectWise Manage                                                         | Ian Wheeler | 08/02/2024 |        |
| Billing Amount Verification | Verify billing amounts are correct in ConnectWise                                                                           | Ian Wheeler | 08/02/2024 |        |
| Finance Confirmation        | Check with Finance team to confirm billing data accuracy                                                                    | Ian Wheeler | 08/02/2024 |        |
| Final Review                | Conduct a final review of all migrated data before Platypus deactivation                                                    | Ian Wheeler | 08/02/2024 |        |

## Decisions
<!-- Record of decisions you make in this meeting -->
- Next meeting date and place: 
	
	- Wednesday, July 3, 2024 | 04:00 PM CST - 04:30 PM CST
- Documents to be included in the meeting notes: 

Next meeting date and place: 

```Datetime
Wednesday, July 3, 2024 | 04:00 PM CST - 04:30 PM CST 
```

## Location

- Microsoft Teams: [Join conversation](https://teams.microsoft.com/l/meetup-join/19%3ameeting_OGZlNDk1ODktNTE5Ny00ODY4LTllN2YtNzFhMTYxYWNlZjdl%40thread.v2/0?context=%7b%22Tid%22%3a%226d4422b6-9fe9-4ec2-8904-ccaa320bd30a%22%2c%22Oid%22%3a%22f8d6005d-b220-439d-ac31-8b5967a77221%22%7d)



---
# Back Matter
## Questions

- How is NetSuite integrated with ConnectWise Manage?
- What defines a `Telecom` product?

## Terms

- Platypus
- ConnectWise Manage
- Telecom Products

## References

- [[Plat_Unmatched.xlsx]]
- [[Plat_CW_Partial_Match 1.xlsx]]