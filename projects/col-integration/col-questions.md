# Questions, Comments, Concerns

## Questions
---
1. Do we have the ability to select items from our ConnectWise inventory prior to purchase? How?
	- Can we treat our CW environment as a vendor so that we have in-stock inventory visibility?
2. Do we have the ability to go back and forth with revision for quotes? How? (**This functionality is NEEDED**)
	- How can an opportunity/quote be synced back to ChannelOnline for revisions, if necessary?
3. When syncing the opportunity/quote to ConnectWise do all vendor SKUs and product SKUs come over on either the opportunity or attached quote document?
4. What are the details of the product creation process?
	- How are they created / can they be created?
	- Can these products sync to ConnectWise? How?
	- Can vendors sync to ConnectWise? How?
5. Are all required fields captured on documents that come over?
	- GL Account
	- Category
	- Sub Category
	- Type
	- Class
6. Can we lockdown unapproved vendors? How?
7. Where in the process will documents sync to CW? How?
	- Do they come over as opportunity attachments, etc.?
8. Is there a shipping connector for COL? Can we uplift the value globally?
9. Can we display the manual sync button at the dashboard level for all records related to that sales representative in COL? How?

## Comments
---
- We want to notify the client at various stages in the quoting process. When?
	- When the quote is requested
	- When the quote is signed
	- When the order is delivered
	- When the process is completed
- We do not want to manually validate MRR v. NRR Cases in Salesforce
- All Meriplex employees should have have the location `Meriplex Solutions` set as their default on their member record, not `Meriplex Communications`.
## Concerns
---
1. What is going to be the syncing logic of the current custom integration developed between ConnectWise and Salesforce (accounting for the to-be quoting process)?
## Issues
---
### ConnectWise Integration

1. "You called the draw() method with the wrong type of data rather than a DataTable or DataView"

![[col-issue-1.png]]

2. There is no documentation on the [Map Product Info](https://stage.channelonline.com/enhancedtech-stage/home/ImportExport/Integration/CW/productInfoMapping) section.
	- What is and how do we configure the:
	- Shipping Catalog Item Id
	- Supplier Handling Fee Catalog Item
	- Purchase Order Tax Catalog Item

3. The [Import and Map Customers from ConnectWise](https://ccs-stage.channelonline.com/enhancedtech-stage/home/pt.epl?errand=cw_cust_mapping&dir=cw_cust_mapping&type=customer "Import and Map Customers from ConnectWise") link is broken in the staging environment.

4. The [Account Types Mapping](https://stage.channelonline.com/enhancedtech-stage/home/ImportExport/Integration/CW/AccountTypeMapping "Account Types Mapping") section is not pulling the full list of account types available in the connected [ConnectWise environment](https://cwdev.meriplex.com/v4_6_release/ConnectWise.aspx?locale=en_US#XQAACAD3AAAAAAAAAAA9iIoG07$U9XZqpLgsNhRsIxDiSt5jjN5fOx8L26COGHXJa4h4YruSL$0AZMlhTU5vIbaU21bIUdSioQiQpXPcKuNyFjs2UnA1AusSgAyO2LVSFfNdH_QbesxRhExr1opBoiLoeY6x591qsmeOKcRMGrFo23CHoM_nQds7FdfNY7tWYD0l3PUVvskRgAIyj3py3Ix1vp__if8AAA==).

5. 

