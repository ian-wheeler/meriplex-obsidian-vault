---
id: 20240626155937
type: Meeting Note
tags:
  - meeting
  - kickoff
  - project
  - platypus
  - connectwise
  - task
  - deliverable
  - migration
  - permanent
---
# Touchpoint on Platypus to ConnectWise Migration Ask

> [!Note]
> This meeting focuses on the migration initiative from Platypus to ConnectWise Manage. The project aims to address previous migration challenges, ensure data accuracy, and streamline billing processes. Key objectives include matching accounts, agreements, and additions between the two systems, verifying billing amounts, and successfully deactivating customers in Platypus post-migration. The desired outcome is a smooth transition of approximately 140 accounts, with special attention to telecom items and blended billing situations. The project will involve close collaboration with the Finance team and careful consideration of resource allocation to ensure a successful migration.

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

- **Project Background**
    - Initial migration attempt from Platypus to ConnectWise Manage was unsuccessful
    - Some customers have blended billing (partially in Platypus, partially in ConnectWise)
- **Project Scope**
    - Match agreements and billing amounts between Platypus and ConnectWise
    - Verify data accuracy with Finance team (Alex Midkif, Billing Team)
    - Deactivate customers in Platypus after confirmation
- **Resource Allocation**
    - One additional resource to be assigned
    - Brian Jones has prepared three files with initial match attempts
- **Project Stakeholders**
    - Key stakeholder: Paul Guillo
    - Finance team involvement for verification
- **Data Overview**
    - Approximately 140 accounts to be migrated
    - Special consideration for telecom items:
        - Remove from ConnectWise if not in Platypus
        - Exception: Retain if on an Avalara Agreement that's currently billing
- **Migration Strategy**
    - Start with a small batch of accounts
    - Begin by matching accounts, then proceed to agreements and additions
- **Infrastructure**
    - Team needs access to the Platypus Server

## Action Items

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

### Next Meeting Date

```Datetime
Wednesday, July 3, 2024 | 04:00 PM CST - 04:30 PM CST 
```

### Next Meeting Location

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