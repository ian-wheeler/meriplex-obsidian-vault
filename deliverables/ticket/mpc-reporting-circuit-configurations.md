# Request
Requestee: Chantella Allen
Report of circuit configurations for Jim Kelly.
## Details
Requested Fields: 
- Configuration Name
- Configuration Type
- Configuration Status
- Configuration Location
- Configuration Vendor
- Configuration Company
- Configuration Question & Answer: Meriplex MRR Amount
- Configuration Question & Answer: Billing Circuit ID
- Configuration Question & Answer: Vendor MRC Amount
- Configuration Question & Answer: Vendor Account Number
- Configuration Question & Answer: Vendor Bill Audit Date
## Filters
- Configuration Type = Meriplex Circuit Information
- Status = Active
## Standard Fields
Table: v_ConfigAdvanceSearch
- Type Field: ConfigType
- Status Field: ConfigStatus
- Location Field: Owner_Level_Name
- Vendor Field: Manufacturer
- Company Field: Company_Name
- Name Field: Config_Name

## Custom Fields
Table: v_ConfigAdvanceSearch
- Question Field: Question
- Answer FIeld: Answer

| CS_Survey_Detail_RecID | Question                  |
|-------------------------|---------------------------|
| 702                     | Meriplex MRR Amount       |
| 714                     | Vendor MRC Amount         |
| 717                     | Vendor Account Number     |
| 735                     | Billing Circuit ID        |
| 1471                    | Vendor Bill Audit Date    |
## Query

```sql
SELECT
    Config_RecID,
    ConfigType,
    ConfigStatus,
    Config_Name,
    Company_Name,
    Manufacturer AS Vendor,
    Owner_Level_Name AS Location,
    MAX(CASE WHEN CS_Survey_Detail_RecID = 702 THEN Answer END) AS [Meriplex MRR Amount],
    MAX(CASE WHEN CS_Survey_Detail_RecID = 714 THEN Answer END) AS [Vendor MRC Amount],
    MAX(CASE WHEN CS_Survey_Detail_RecID = 717 THEN Answer END) AS [Vendor Account Number],
    MAX(CASE WHEN CS_Survey_Detail_RecID = 735 THEN Answer END) AS [Billing Circuit ID],
    MAX(CASE WHEN CS_Survey_Detail_RecID = 1471 THEN Answer END) AS [Vendor Bill Audit Date]
FROM v_ConfigAdvanceSearch
WHERE CS_Survey_Detail_RecID IN (702, 714, 717, 735, 1471) -- Only required "Questions"
    AND CS_Survey_RecID = 74 -- Only "Meriplex Circuit Information" Configuration Type
    AND Config_Status_RecID = 2 -- Only "Active" Status
GROUP BY Config_RecID, ConfigType, ConfigStatus, Config_Name, Company_Name, Manufacturer, Owner_Level_Name
```

## Solution 

[SharePoint > Service Delivery > Documents > 2024-Meriplex Circuit Audit > MeriplexCircuitInformation.xlsx](https://meriplex.sharepoint.com/:x:/s/ServiceDeliveryDept/Ef-746mxgXFAsfqTkiHFZtUBpqscgeiv0DgVjI3Cw5LYMg?e=hNvgkz)
