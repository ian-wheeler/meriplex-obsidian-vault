---
id: 20240620141422
type: fleeting
tags:
  - fleeting
---

# How to get an inventory audit report

## Extract Necessary Fields

First you need to extract the necessary fields from the database which can be returned by the query below.

```SQL
SELECT DISTINCT
    audit.Inventory_By_Warehouse_Audit_RecID ,
    audit.Inventory_By_Warehouse_RecID,
    audit.IV_Item_RecID,
    audit.Warehouse_RecID,
	w.Warehouse_Name AS Warehouse_Name,
    audit.Warehouse_Bin_RecID,
	wb.Description AS Bin_Name,
    audit.Before_Qty_On_Hand,
    audit.After_Qty_On_Hand,
    audit.Last_Update,
    audit.Updated_By,
    item.Item_ID,
    item.Description AS Item_Description,
    item.Current_Cost,
    item.List_Price
FROM
    Inventory_By_Warehouse_Audit audit
LEFT JOIN IV_Item item ON audit.IV_Item_RecID = item.IV_Item_RecID
LEFT JOIN Warehouse_Bin wb ON audit.Warehouse_Bin_RecID = wb.Warehouse_Bin_RecID
LEFT JOIN Warehouse w ON audit.Warehouse_RecID = w.Warehouse_RecID
WHERE
    audit.Last_Update >= DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()) - 1, 0)
    AND audit.Last_Update < DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()) + 1, 0)
ORDER BY
    audit.Last_Update DESC
```

## Next Steps

I need to produce a report from the above dataset. We are trying to get the Inventory on hand quantities and inventory on hand cost of all item's in our catalog. We need to be able to filter by item, bin, or warehouse. We need to see the inventory quantity and inventory cost for the beginning of the month and the end of the month.