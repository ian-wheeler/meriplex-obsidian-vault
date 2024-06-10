Issues

- Campaign; Not Required and Hidden
- Secondary Sales Rep; Not Required and Hidden
- Retroactively Repair Territory and Location
- Territory and Location; Read-Only if possible
- Werner W. and Glenn M. understand Territory and Location Logic
- Department; change Salesforce displayed fields to show
	- Non-Recurring
	- Monthly Recurring
	- Revenue Fields
- Shipping Contact added to Salesforce
- When Opportunity Type in SF is NRR create the ticket on the NRR Quoting board in CW; else create the ticket on the MRR Quoting board.
	- Change opp type name to "3. Non-Recurring Revenue"
- When opportunity webhook is received from CW-SELL with Opportunity Type of NRR close the ticket
	- Mark all resources done 
	- Change status to ">Quote Delivered"
	- Notify the user that the quote is delivered via existing notification system
- Hide RecID fields in CW-SELL
- When a signed email is received attach the signed PDF to the opp in SF and change stage to Signed

Action Items:

Issue: `Campaign` field in CW-Manage is required
Solution: Make this field non-required and hidden

Issue: `Secondary Sales Rep` field in CW-Manage is required
Solution: Make this field non-required and hidden

Issue: 
Solution: 