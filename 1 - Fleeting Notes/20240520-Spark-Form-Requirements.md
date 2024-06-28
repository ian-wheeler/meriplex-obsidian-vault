---
id: 202405208093347
type: fleeting
tags:
  - fleeting
  - meeting
---
## Process

1. User Logs into Salesforce or ConnectWise and Navigates to Spark Form
	1. Hosted in ConnectWise Pod in ConnectWise
	2. Hosted in Account Tab in Salesforce
2. Spark form (NRR) submission creates an opportunity in Salesforce
3. Opportunity is assigned to the Solutions Consultant (according to the Teams tab in ConnectWise)
	1. Fallback: assign the opportunity to John Powell
4. Email notification should occur at the following junctions:
	1. Quote requested
	2. Opportunity Created
	3. Opportunity Quoted
	4. Quote Delivered
	5. Quote Signed
	6. Order Placed
	7. Order Received
5. IF `T&M Only?` is checked then it bypasses Salesforce etc., and creates a ticket on the `Prof-Svcs` board in ConnectWise

## Required Fields & Type

1. Account: Account(Lookup); auto-populated
2. Solutions Consultant (Owner): Member(Lookup); auto-populated
3. Requester: String(50)
4. Source: Single-Selection Picklist
	Business Development
	Sales Rep
	Marketing
	Referral
	Acquisition
5. Sub-Source: Single-Selection Picklist 

	![[Pasted image 20240520093330.png]]

6. Billing Contact: Contact(Lookup); selected
7. Billing Site: Site(Lookup); selected
8. Shipping Contact: Contact(Lookup); selected
9. Shipping Site: Site(Lookup); selected
10. Professional Services Required: Boolean (Checkbox)
11. Emergency Action Required: Boolean (Checkbox)
12. Time and Materials Only: Boolean (Checkbox)
13. Description: String(32000)
14. Document(s): Attachments
15. Expected Close Date: Date
16. Campaign: Single-Selection Picklist 

```SQL
SELECT * FROM Marketing_Campaign
WHERE Inactive_Flag = 0
ORDER BY Marketing_ID
```

17. Stage: Hard-coded = `Identifying`
18. Status: Hard-coded = `Open`
19. Type: Single-Selection Picklist

```SQL
SELECT * FROM SO_Type
WHERE Inactive_Flag = 0
ORDER BY Description
```

20. Department: Single-Selection Picklist

```SQL
SELECT * FROM Department
ORDER BY Department_Name
```

21. Location: Single-Selection Picklist 

```SQL
SELECT * FROM Owner_Level
WHERE Location_Flag = 1
ORDER BY Description
```
