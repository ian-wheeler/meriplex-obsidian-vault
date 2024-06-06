General
- (3) S1 Tenants (Multitenant)
	- CPI Acquisisiton 
	- Meriplex (Legacy Cloud)
	- Meriplex (OneBox) = CPI and Legacy will be rolled up here

- CPI Acquisition 
	- Send email for each alert (Routing unknown)
	- Rewst grabs the email > performs enrichment > creates the ticket on the `CPI-SOC` Board
- Meriplex (Legacy Cloud)
	- Send email for each alert (Routing unknown) ~ same email as other meriplex S1 tenant
	- Rewst grabs the email > performs enrichment > creates the ticket on the `SOC Alerts` Board
- Meriplex (OneBox) = CPI and Legacy will be rolled up here
	- Send email for each alert (Routing unknown) ~ same email as other meriplex S1 tenant
	- Rewst grabs the email > performs enrichment > creates the ticket on the `SOC Alerts` Board

POC:
Stephen L.

|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
|SR_Service_RecID|SR_Type_RecID|SR_Location_RecID|SR_Status_RecID|SR_Source_RecID|SR_Urgency_RecID|SR_Team_RecID|Entered_By|Entered_Notify_Flag|Date_Entered|Date_Req|Company_RecID|Contact_RecID|Assigned_By_RecID|Assigned_Notify_Flag|Billing_Unit_RecID|Red_Flag|Updated_By|Last_Update|Address_Line1|Address_Line2|City|State_ID|Zip|Contact_Name|PhoneNbr|Extension|Owner_Level_RecID|Email_Address|Summary|Publish_Flag|Closed_By|Date_Closed|DB_Timestamp|Hours_Budget|sr_billing_method_id|billing_amount|Time_Billable_Flag|Exp_Billable_Flag|TimeBillable_Flag|ExpBillable_Flag|Activity_Class_RecID|Activity_Type_RecID|PO_Number|Reference|EstRevenue_removed|BillComplete_Flag|BillSR_Flag|BillUnapp_Flag|Bill_Method|Company_Address_RecID|AGR_Header_RecID|ProdInvoice_Flag|ExpInvoice_Flag|TimeInvoice_Flag|ProdBillable_Flag|Override_Flag|AGR_Amount|AGR_Month|AGR_Year|SR_Severity_RecID|SR_Impact_RecID|SR_Board_RecID|Billing_Company_RecID|Billing_Address_RecID|External_Hours_Worked|Opportunity_RecID|Approved_Flag|External_Xref|Site_Name|Sub_Date_Accepted|Sub_Company_Name|Sub_Company_RecID|Sub_Contact_Name|Sub_Contact_RecID|Sub_Email_Address|Sub_PhoneNbr|Sub_Extension|Sub_Billing_Method_ID|Sub_Billing_Amount|Sub_Ticket_Nbr|Sub_Override_Flag|Rejected_Flag|Date_Rejected|Cn_Survey_Completed_Flag|Mobile_Guid|PM_Phase_RecID|WBS_Code|Rec_Type|EmailContact_Flag|EmailResource_Flag|EmailCC_Flag|EmailCC|CustUpdate_Flag|Country_RecID|KB_Category_RecID|KB_SubCategory_RecID|KB_Link_RecID|KB_Link_Type|SR_SLA_RecID|Order_Header_RecID|SR_SubType_RecID|Date_Entered_UTC|Last_Update_UTC|Date_Closed_UTC|Sub_Date_Accepted_UTC|Date_Rejected_UTC|SR_SubTypeItem_RecID|Restrict_Downpayment_Flag|Est_Start_Date_UTC|Ava_Validated_Flag|Ticket_Owner_RecID|Billing_Contact_RecID|Billing_Terms_RecID|Tax_Code_RecID|Shipping_Company_RecID|Shipping_Address_RecID|Shipping_Contact_RecID|Est_Time_Revenue|Est_Expense_Revenue|Est_Product_Revenue|Est_Time_Cost|Est_Expense_Cost|Est_Product_Cost|Currency_RecID|SR_Service_RecID_Computed|IsClosed_Flag|Parent_RecID|Latest_Sentiment_Score|Id|
