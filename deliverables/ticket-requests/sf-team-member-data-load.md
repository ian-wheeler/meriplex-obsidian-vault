I need your assistance cleansing some systems before matching some ID's between systems and loading new data; first i'm going to give some context for the document loaded.

# Name: Meriplex_Client_Breakout_Future_State.xlsx

---

## Sheets:

### dataload
The data we want to load to salesforce before transformation. 
Column B `Company_RecID` should have a matching unique value in the `SF_AllAccounts` sheet. We need to find the matching Salesforce `Id` after deduplicating `SF_AllAccounts`

### SF_Dataload
We need to transform the data in the `dataload` sheet so that it's in the following structure (so we can bulk load to Salesforce):

- Column A `AccountAccessLevel` will always have the value `Edit`
- Column B `AccountId` should have the corresponding `Id` value from the `SF_AllAccounts` sheet
- Column C `CaseAccessLevel` will always have the value `Edit`
- Column D `Id` is the unique identifier when an `AccountTeamMember` is created
- Column E `OpportunityAccessLevel` will always have the value `Edit`
- Column F `TeamMemberRole` will have the corresponding role for each User being loaded as an `AccountTeamMember` (indicated by the column header names in column C, E, G, I of the `dataload` sheet); Roles:
	- NRR - Quoting Specialist
	- NRR - Renewals Specialist
	- NRR - Solutions Consultant
	- NRR - Solutions Consulting Engineer
- Column G `UserId` will have the corresponding `Id` value from the `SF_AllUsers` sheet 
### SF_AllAccounts
All Salesforce Accounts

- Column A `Company_ID__c` = ConnectWise `Company_ID`
- Column B `Company_Rec_ID__c` = ConnectWise `Company_RecID`
- Column C `Id` = Salesforce `AccountId`
- Column D `IsDeleted`
- Column E `Name`
- Column F `Phone`
- Column G `Website`
### SF_AllUsers
All Salesforce Users

- Column A `FirstName`
- Column B `Id` = Salesforce `UserId`
- Column C `LastName`
- Column D `User_Casesafe_Id__c`
- Column E `User_Rec_ID__c` = ConnectWise `Member_RecID`
### CW_AllCompanies
All ConnectWise Companies

- Column A `Company_RecID` = Salesforce `Company_Rec_ID__c`
- Column B `Company_ID` = Salesforce `Company_ID__c`
- Column C `Company_Name`
- Column D `PhoneNbr`
- Column E `Website_URL`
### CW_AllUsers

---

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


