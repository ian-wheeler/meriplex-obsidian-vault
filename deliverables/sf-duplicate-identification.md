# Identifying Salesforce Duplicate Accounts
1. Login to Workbench [Workbench (developerforce.com)](https://workbench.developerforce.com/login.php)
2. Navigate to [Workbench: SOQL Query (developerforce.com)](https://workbench.developerforce.com/query.php)
3. Run the `all_accounts` SOQL Query 

## SOQL Query `all_accounts` 
This SOQL query retrieves a partial dataset for all `Account` objects from Salesforce, excluding the `BillingAddress` and `ShippingAddress` fields. These fields are compound data fields that contain detailed address information. Including them in the query results in the error message: 

```
Failed: InvalidBatch: Failed to process query: FUNCTIONALITY_NOT_ENABLED: Selecting compound data not supported in Bulk Query."
```

This limitation is due to the Salesforce platform's restriction on selecting compound data in bulk queries.

```SOQL
SELECT AccountSource,Active_Status__c,AnnualRevenue,At_Risk_MRR__c,At_Risk__c,BillingCity,BillingCountry,BillingPostalCode,BillingState,BillingStreet,Company_ID__c,Company_Rec_ID__c,Description,GCC_High_Referral_Partner__c,Id,Industry,IsDeleted,Market__c,MasterRecordId,Name,Non_solicitation_Agreement__c,ParentId,Phone,ShippingCity,ShippingCountry,ShippingPostalCode,ShippingState,ShippingStreet,Status__c,Sub_Source__c,Territory__c,Type,Website FROM Account WHERE IsDeleted = false
```


```Python
import pandas as pd

# Load the SF_AllAccounts sheet into a DataFrame
file_path = '/content/cw_sf_data.xlsx'
df = pd.read_excel(file_path, sheet_name='SF_Accounts')

# Define the list of address fields to check for duplicates
address_fields = ['BillingCity', 'BillingCountry', 'BillingPostalCode', 'BillingState', 'BillingStreet']

# Drop rows where any of the address fields is NaN before checking for duplicates
df_cleaned = df.dropna(subset=address_fields, how='any')

# Sort the DataFrame based on the address fields to group duplicates together
df_sorted = df_cleaned.sort_values(by=address_fields)

# Identify the indices of the rows with duplicate address fields
duplicate_indices = df_sorted.duplicated(subset=address_fields, keep=False)

# Filter the sorted DataFrame to only include the duplicate row
duplicates_grouped = df_sorted[duplicate_indices]

# Save the grouped duplicates to a new Excel file
output_file = '/content/sf_duplicate_accounts_by_address.xlsx'
duplicates_grouped.to_excel(output_file, index=False)

output_file
```
