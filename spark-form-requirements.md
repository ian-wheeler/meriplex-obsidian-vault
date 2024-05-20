- Force the campaign and requester name fields in addition to the other required fields for converting a spark form request to a CW/SF Opportunity


1. Spark form (NRR) submission creates an opportunity in Salesforce
2. Opportunity is assigned to the Solutions Consultant (according to the Teams tab in ConnectWise)
	1. Fallback: assign the opportunity to John Powell
3. Email notification should occur at the following junctions:
	1. Quote requested
	2. Opportunity Created
	3. Opportunity Quoted
	4. Quote Delivered
	5. Quote Signed
	6. Order Placed
	7. Order Received
4. IF `T&M Only?` is checked then it bypasses Salesforce etc., and creates a ticket on the `Prof-Svcs` board in ConnectWise

## Required Fields & Type

Account: Account(Lookup); auto-populated
Solutions Consultant (Owner): Member(Lookup); auto-populated
Requester: String(50)
Lead Source: Single-Selection Picklist
	Business Development
	Sales Rep
	Marketing
	Referral
	Acquisition
Sub-Source: Single-Selection Picklist 
	![[Pasted image 20240520093330.png]]
Contact: Contact(Lookup); selected
Location: Site(Lookup); selected
Professional Services Required: Boolean (Checkbox)
Emergency Action Required:
Time and Materials Only:



