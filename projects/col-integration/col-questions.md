# Questions, Comments, Concerns

## Questions
---
1. Do we have the ability to select items from our ConnectWise inventory prior to purchase? How? Can we treat our CW environment as a vendor so that we have in-stock inventory visibility within COL?
	
	**Answer**: Import an inventory CSV daily which will have in an FTP enabled location. Alternatively, there is a paid service that will check the FTP location hourly.

2. Do we have the ability to go back and forth with revision for quotes? How? (**This functionality is NEEDED**) How can an opportunity/quote be synced back to ChannelOnline for revisions, if necessary?
	
	**Answer**: There is only a uni-lateral sync going from COL to CW. The CW user will update the status to revision needed and inform the account/record owner that a revision needs to be made. The account/record owner will then make the necessary revision in COL and resync the opportunity.
	
	**Issues**: E-signing in COL will automatically convert the Opportunity/Quote to a PO/SO.

3. When syncing the opportunity/quote to ConnectWise do all vendor SKUs and product SKUs come over on either the opportunity or attached quote document?

	Answer: 

4. What are the details of the product creation process? How are they created / can they be created? Can these products sync to ConnectWise? How? Can vendors sync to ConnectWise? How?

	**Answer**: Field specifics unknown; the product will be created with the category & sub-category determined by your environments mapping configuration. It will only sync the products from COL that are included in the quote/opportunity. 

5. Are all required fields captured on documents that come over? (GL Account, Category, Sub Category, Type, Class)

	**Answer**: COL will follow-up with field-specific details. These can potentially be setup as custom fields and mapped, but these can not be enforced as required fields. Required fields are only enforced at the point you convert to a PO/SO.

6. Can we lockdown unapproved vendors? How?

	**Answer**: You can enable or disable suppliers and set different profile's that determine which suppliers are available (based on the profile).

	**Issues**: Potential for mismatched Vendor RecID's and vendor's existing/being approved in one system but not the other.

7. Where in the process will documents sync to CW? How? Do they come over as opportunity attachments, etc.?
   
	**Answer**: 
   
8. Is there a shipping connector for COL? Can we uplift the value globally?
   
	**Answer**: 
   
9. Can we display the manual sync button at the dashboard level for all records related to that sales representative in COL? How?
   
	**Answer**: 
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
- **Issue**: E-signing in COL will automatically convert the Opportunity/Quote to a PO/SO.
- **Issue**: Potential for mismatched Vendor RecID's and vendor's existing/being approved in one system but not the other.
### ConnectWise Integration

1. Error Message: `You called the draw() method with the wrong type of data rather than a DataTable or DataView` was being displayed on the dashboard of the home page in each frame. 

![[col-issue-1.png]]

2. There is no documentation on the [Map Product Info](https://stage.channelonline.com/enhancedtech-stage/home/ImportExport/Integration/CW/productInfoMapping) section.
	- What is and how do we configure the:
	- Shipping Catalog Item Id
	- Supplier Handling Fee Catalog Item
	- Purchase Order Tax Catalog Item

3. The [Import and Map Customers from ConnectWise](https://ccs-stage.channelonline.com/enhancedtech-stage/home/pt.epl?errand=cw_cust_mapping&dir=cw_cust_mapping&type=customer "Import and Map Customers from ConnectWise") link is broken in the staging environment.

4. The [Account Types Mapping](https://stage.channelonline.com/enhancedtech-stage/home/ImportExport/Integration/CW/AccountTypeMapping "Account Types Mapping") section is not pulling the full list of account types available in the connected [ConnectWise environment](https://cwdev.meriplex.com/v4_6_release/ConnectWise.aspx?locale=en_US#XQAACAD3AAAAAAAAAAA9iIoG07$U9XZqpLgsNhRsIxDiSt5jjN5fOx8L26COGHXJa4h4YruSL$0AZMlhTU5vIbaU21bIUdSioQiQpXPcKuNyFjs2UnA1AusSgAyO2LVSFfNdH_QbesxRhExr1opBoiLoeY6x591qsmeOKcRMGrFo23CHoM_nQds7FdfNY7tWYD0l3PUVvskRgAIyj3py3Ix1vp__if8AAA==).