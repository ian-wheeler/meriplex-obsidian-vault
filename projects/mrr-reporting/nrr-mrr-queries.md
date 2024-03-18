# Queries
---
### Additions with Churn Reason UDFV
```SQL
SELECT
    CASE WHEN ADUDFV.User_Defined_Field_RecID = 147 THEN ADUDFV.User_Defined_Field_Value ELSE NULL END AS Churn_Reason,
    AD.*
FROM 
    AGR_Detail AS AD
LEFT JOIN 
    AGR_Detail_User_Defined_Field_Value AS ADUDFV ON AD.AGR_Detail_RecID = ADUDFV.AGR_Detail_RecID
    AND ADUDFV.User_Defined_Field_RecID = 147
```

This query is used for getting a monthly snapshot of the additions table with the churn reason user defined field value so that we can calculate monthly churn totals based on their category/reason.

