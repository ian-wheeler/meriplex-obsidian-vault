# sf_account_team_member_data_load.ipynb

## Steps
1. Using Pandas, create two dataframes; 
	- `dataload_df` that will extract/read the `dataload` sheet
	- `transformed_df` that will store the transformed data
2. Save the `transformed_df` to a csv named `sf_account_team_member_dataload.csv`

---
## Logic
Starting at row two, loop four times per row.
	 This is because each company has four account team members, each of which is an individual record when loading to Salesforce

---
### 1st Loop: 
#### Mapped Values
- `Company_Rec_ID__c` to `Company_Rec_ID__c`
- `Account_Id` to `Account_Id`
- `Client` to `Account_Name`
- `RecID: NRR - Solutions Consultant` to `User_Rec_ID__c`
#### Static Values
- `AccountAccessLevel` = "Edit"
- `CaseAccessLevel` = "Edit"
- `OpportunityAccessLevel`= "Edit"
- `TeamMemberRole` = "NRR - Solutions Consultant"
- `UserId` = ' '

---
### 2nd Loop:
#### Mapped Values
- `Company_Rec_ID__c` to `Company_Rec_ID__c`
- `Account_Id` to `Account_Id`
- `Client` to `Account_Name`
- `RecID: NRR - Renewals Specialist` to `User_Rec_ID__c`
#### Static Values
- `AccountAccessLevel` = "Edit"
- `CaseAccessLevel` = "Edit"
- `OpportunityAccessLevel`= "Edit"
- `TeamMemberRole` = "NRR - Renewals Specialist"
- `UserId` = ' '

---
### 3rd Loop:
#### Mapped Values
- `Company_Rec_ID__c` to `Company_Rec_ID__c`
- `Account_Id` to `Account_Id`
- `Client` to `Account_Name`
- `RecID: NRR - Quoting Specialist` to `User_Rec_ID__c`
#### Static Values
- `AccountAccessLevel` = "Edit"
- `CaseAccessLevel` = "Edit"
- `OpportunityAccessLevel`= "Edit"
- `TeamMemberRole` = "NRR - Quoting Specialist"
- `UserId` = ' '

---
### 4th Loop:
#### Mapped Values
- `Company_Rec_ID__c` to `Company_Rec_ID__c`
- `Account_Id` to `Account_Id`
- `Client` to `Account_Name`
- `RecID: NRR - Solutions Consulting Engineer` to `User_Rec_ID__c`
#### Static Values
- `AccountAccessLevel` = "Edit"
- `CaseAccessLevel` = "Edit"
- `OpportunityAccessLevel`= "Edit"
- `TeamMemberRole` = "NRR - Solutions Consulting Engineer"
- `UserId` = ' '

---


