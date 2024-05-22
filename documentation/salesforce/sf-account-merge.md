# Account Merge Process
---
### Step 1:
Select two or more account entities to be merged.
Logic:
- Acquired Company/Companies (Deleted after merging)*
- Resulting Company (Retained after merging)*
### Step 2:
Select the company data you want to carry over from {{`Acquired Company/Companies`}} to {{`Resulting Company`}}. These options are only necessary if you want to override the current settings of the {{`Resulting Company`}}.
### Step 3:
Merge the two or more selected account entities 
# Salesforce Account Merge Logic
---
When you merge the {{`Acquired Company/Companies`}} to the {{`Resulting Company`}}:
- The unique RecID's for the migrated records are retained.
- A single account webhook {{`Resulting Company`}} is triggered/fired.
- Standard object records are migrated from the {{`Acquired Company/Companies`}} to the {{`Resulting Company`}}, e.g., Contacts and Opportunities.
- Custom object records are **NOT** migrated from the {{`Acquired Company/Companies`}} to the {{`Resulting Company`}}, e.g., Sites