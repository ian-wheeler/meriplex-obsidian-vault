# Customer Portal Queries
---
Comprehensive guide for the queries utilized to generate datasets for the customer portal application. Its primary purpose is to detail the sources, structures, and strategies behind the data retrieval processes that underpin the application's visualization features. 

---
## Agreements
The  numbers between the 2 queries dont't add up.  Brian mentioned the 'Agreements by Location' is  should be using site.  I think Agreements by Product Segment needs some more groupings.
### Agreements by Product Segment

```SQL
SELECT 
    COUNT(*) AS RecordCount,
    source.custom_product_category_desc AS Category,
    source.custom_product_category_id AS SortOrder
FROM 
    (
        SELECT 
            category.parent_custom_product_category_id,
            category.custom_product_category_id,
            category.custom_product_category_desc,
            subcategory.custom_product_category_id AS SubCat_custom_product_category_id,
            subcategory.custom_product_category_desc AS SubCat_custom_product_category_desc,
            agreement.AGR_Name
        FROM 
            custom_product_category AS category
        LEFT JOIN
            (
                SELECT 
                    parent_custom_product_category_id,
                    custom_product_category_id,
                    custom_product_category_desc
                FROM 
                    custom_product_category
                WHERE 
                    parent_custom_product_category_id > 0
            ) AS subcategory ON subcategory.parent_custom_product_category_id = category.custom_product_category_id
        LEFT JOIN
            (
                SELECT 
                    AGR_Header.AGR_Header_RecID, 
                    AGR_Name, 
                    IV_Item.Item_ID, 
                    IV_Item.Description, 
                    custom_product_category_id
                FROM 
                    AGR_Header
                INNER JOIN AGR_Detail ON AGR_Header.AGR_Header_RecID = AGR_Detail.AGR_Header_RecID
                INNER JOIN custom_product_category_item ON agr_detail.iv_item_recid = custom_product_category_item.iv_item_recid
                INNER JOIN IV_Item ON agr_detail.iv_item_recid = iv_item.iv_item_recid
                WHERE 
                    Company_RecID = @companyId
            ) AS agreement ON agreement.custom_product_category_id = subcategory.custom_product_category_id
        WHERE 
            category.parent_custom_product_category_id = 0 
            AND category.custom_product_category_id <> 68 -- Excludes 'unassigned'
    ) AS source
GROUP BY 
    source.custom_product_category_id, 
    source.custom_product_category_desc
ORDER BY 
    source.custom_product_category_id;
```

### Agreements by Location
```SQL
SELECT 
    COUNT(*) AS RecordCount, 
    t.owner_level_name AS Category
FROM
    (
        SELECT
            a.Owner_Level_RecID,
            b.owner_level_name
        FROM 
            dbo.AGR_Header AS a -- (Owner_Level_RecID = SystemLocation) (Billing_Unit_RecID == department)
        JOIN 
            dbo.Owner_Level AS b ON b.Owner_Level_RecID = a.Owner_Level_RecID
        WHERE 
            a.Company_RecID = @companyId
    ) AS t
GROUP BY 
    t.Owner_Level_RecID, 
    t.owner_level_name;
```
### Projects - Total Hours to Date
Not sure what 'Total Hours to Date' means
### Open Projects
```SQL
SELECT 
    COUNT(*) AS RecordCount, 
    S.Closed_Flag
FROM 
    PM_Project AS P
LEFT JOIN 
    PM_Status AS S ON P.PM_Status_RecID = S.PM_Status_RecID
WHERE 
    P.Company_RecID = @CompanyId 
    AND S.Closed_Flag <> 1
GROUP BY 
    S.Closed_Flag;
```
### Invoices
No clue what any of the queries for the charts are