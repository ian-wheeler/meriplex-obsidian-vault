# Quote Process Review
---
## Process
---
1. NRR Team member identifies an opportunity 
2. Create a `Quick Opportunity` in Salesforce
3. **Ticket Triaged** based on the NRR/MRR Classification
	1. (5) Boards
		1. Solutions Engineering (MRR Advanced)
		2. Sales - Quoting Team (MRR Standard)
		3. NRR - Solutions Consulting Engineers (NRR Advanced)
		4. NRR - Quoting (NRR Standard)
		5. Sales - Account Management (Catchall) <-- AS-IS all opps sync here
4. Navigate to `NRR - Quoting` or `NRR - Solutions Consulting Engineers` Board
5. Enter remaining details for the `Opportunity`
6. Click `Enter a New Note` to start a timer, add notes as the user completes the quoting process, and notify team members.
7. Navigate into CPQ and choose the appropriate template (`Non-Recurring`)
8. CPQ: Customer Setup -> 
9. CPQ: Quote Setup -> 
10. CPQ: Prepare Content -> where the representative builds the quote 
11. CPQ: Review ->
12. CPQ: Approval ->
13. CPQ: Publish and Deliver -> 
14. Client signs and approves the order (can this be e-sign) (Jason Nelson - Meriplex Attorney) <-- if not e-signed whats the process?
15. Contract Distribution validates the signed quote and kicks it back to Quoting if necessary.
## Issues
---
- Ticket Triaging to route tickets to the appropriate board
	- Solutions Engineering (MRR Advanced)
	- Sales - Quoting Team (MRR Standard)
	- NRR - Solutions Consulting Engineers (NRR Advanced)
	- NRR - Quoting (NRR Standard)
	- Sales - Account Management (Catchall)
- Automated Alerts on these boards are not helpful <-- Most from LightPoint, various sources, needs investigation
- Bring over all required fields for opportunities and tickets so that quoting team does not have to complete the opportunity details
- Appending " ticket" to the end of each ticket created (not useful)
- ***In CPQ, there are multiple `Terms & Conditions` and duplication on `8) Terms and Conditions` & `9) Order Porter T&C` *** <-- Highest Priority per John S.
	- Jason Nelson <-- 
- "Infinitely Complicated" & errors that come back are very annoying. Client should only have to sign the document, ideally e-sign.
	- CPQ needs to be reworked and a dedicated admin assigned. (Anthony K. & John S. & Greg Cambpell, CPI maybe.)
- Classify which of the (4) types of team members are responsible for the quote. <-- Recommend dedicated dispatcher for `Sales - Account Management (Catchall Board)`
- Quoting Specialists might be moving too slowly. <-- should be higher volume
	- Shaun Kilkenny <-- more comfortable in COL; find specifics that are preferred in COL
	- Brian McShane
	- Laura Emery
- Huge effort aligning the Order/Porter and the Invoice PDF so that they are stylistically similar (just Order/Porter would be ideal)
	- Setting in CWM/CPQ automatically distributes the PDF to the client (can we turn off?)
- Email Connector is being generating tickets on quoting boards with no linked opportunity; should be originating from Salesforce.
## Notes
---
- ~20 Requests in ~3 Hours
- (4) Types of Sales / Quoting Team Members
	- Renewal Consultants - responsible for quoting renewals
	- Quoting Specialist - responsible for the lowest complexity quotes, and triaging
	- Solutions Consultant - responsible for medium complexity quotes, and triaging
	- Solutions Engineer - responsible for the highest complexity quotes (internal escalation required)

## SSI
---
- Ticket comes in on `SSI-Quotes` Board with the `New Request` Status
	- Assigned: Status changed to `Quoting` 
		- Once the status is changed to quoting, the rep must finish that quote or reassign before proceeding to the next ticket
	- If pending a response, one of the `Waiting...` Statuses is selected
	- Quote completed in CPQ and sent: Ticket Status changed to `Quote Sent`
		- After (4) days 
- Quote in CPQ: Often copy items from another quote (as opposed to using tab templates like Meriplex does)
	- Only allow E-Sign Order/Porter 

## Brian Jones
---
Terms & Conditions for NRR (Jason Nelson; Send to Brian Jones 1st)
