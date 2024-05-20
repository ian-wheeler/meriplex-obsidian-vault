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
Billing Contact: Contact(Lookup); selected
Billing Site: Site(Lookup); selected
Shipping Contact: Contact(Lookup); selected
Shipping Site: Site(Lookup); selected
Professional Services Required: Boolean (Checkbox)
Emergency Action Required: Boolean (Checkbox)
Time and Materials Only: Boolean (Checkbox)
Description: String(32000)
Document(s): Attachments
Expected Close Date: Date
Campaign: Single-Selection Picklist (dbo.Marketing_Campaign)
Stage: Hard-coded = `Identifying`
Status: Hard-coded = `Open`
Type: Single-Selection Picklist
2. Up-sell / X-sell
3. NRR - Renewal
5. Change Order
Department:
Location: 



