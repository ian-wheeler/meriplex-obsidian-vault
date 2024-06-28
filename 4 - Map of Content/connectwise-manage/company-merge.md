# Company Merge Process
---
### Step 1:
Select the two company entities to be merged.
- Acquired Company (Deleted after merging)* 
- Resulting Company (Retained after merging)*

### Step 2:
Select the company data you want to carry over from {{`Acquired Company`}} to {{`Resulting Company`}}. These options are only necessary if you want to override the current settings of the {{`Resulting Company`}}.

- Standard Fields
- User Defined Fields

### Step 3:
Select which types of records you want to carry over from {{`Acquired Company`}} to {{`Resulting Company`}}. Options:
- Notes
- Sites
- Activities
- Opportunities
- Services
- Projects
- Contacts
- Groups
- Attachments
- Sales Orders
- Procurements

# ConnectWise Company Merge Logic
---
When you merge the {{`Acquired Company`}} to the {{`Resulting Company`}}:
- The unique RecID's for the migrated records are retained.
- Webhooks are not triggered/fired.