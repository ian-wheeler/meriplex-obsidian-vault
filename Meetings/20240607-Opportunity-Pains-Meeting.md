**Action Items/Tasks Report**

**Summary Table**

| Issue Description                                                                          | Status      | Link                             |
| ------------------------------------------------------------------------------------------ | ----------- | -------------------------------- |
| `Campaign` field in CW-Manage is required                                                  | Complete    | [[#`Campaign` Field]]            |
| `Secondary Sales Rep` field in CW-Manage is required                                       | Complete    | [[#`Secondary Sales Rep` Field]] |
| `Territory` and `Location` have improperly entered                                         | In Progress | [[#`Territory` and `Location`]]  |
| `Department` field in CW-Manage is required and doesn't display appropriate fields         | Complete    | [[#`Department` Field]]          |
| `Shipping Contact` is a required field in CW-Manage                                        | In Progress | [[#`Shipping Contact`]]          |
| `Board` routing on ticket creation from SF to CW is incorrect                              | In Progress | [[#`Board` Routing]]             |
| Time wasted on quoting tickets - Automatically close quote tickets                         | In Progress | [[#Close Quote Tickets]]         |
| Time wasted on quoting tickets - Attach signed PDF to opp in SF and change stage to Signed | On Hold     | [[#Attach Signed PDF]]           |
| Linking `RecID` Fields in CW-SELL are exposed with write permissions                       | Complete    | [[#`RecID` Fields]]              |

---

**Details**

### `Campaign` Field
**Issue:** `Campaign` field in CW-Manage is required  
**Solution:** Make this field non-required and hidden  
**Status:** Complete

---

### `Secondary Sales Rep` Field
**Issue:** `Secondary Sales Rep` field in CW-Manage is required  
**Solution:** Make this field non-required and hidden  
**Status:** Complete

---

### `Territory` and `Location`
**Issue:** `Territory` and `Location` have improperly entered  
**Solution:** Retroactively repair `Territory` and `Location` using underlying logic to identify  
**Status:** In Progress

---

### `Department` Field
**Issue:** `Department` field in CW-Manage is required and doesn't display appropriate fields  
**Solution:** Make this field non-required and change fields displayed to include:
- Non-Recurring
- Monthly Recurring
- Revenue Fields  
**Status:** Complete

---

### `Shipping Contact`
**Issue:** `Shipping Contact` is a required field in CW-Manage  
**Solution:** Add the `Shipping Contact` field to SF  
**Status:** In Progress

---

### `Board` Routing
**Issue:** `Board` routing on ticket creation from SF to CW is incorrect  
**Solution:** 
- IF `Opportunity Type` in SF is `3. Non-Recurring Revenue`, create the ticket on the NRR Quoting Board (`NRR - Quoting`) in CW.
- ELSE, create the ticket on the MRR Quoting Board (`Sales - Quoting Team`) in CW.

| SR_Board_RecID | Board_Name           | Owner_Level_RecID | Billing_Unit_RecID |
|----------------|----------------------|-------------------|--------------------|
| 532            | NRR - Quoting        | 11                | 6                  |
| 21             | Sales - Quoting Team | 11                | 6                  |

**Status:** In Progress

---

### Close Quote Tickets
**Issue:** Time wasted on quoting tickets  
**Request A:** Automatically close quote tickets given the conditions below.  
**Solution A:** When an Opportunity webhook is received with the following,
1. `lastUpdated` = `CW-SELL` AND
2. `Type` = `3. Non-Recurring Revenue` (Future Name; Currently it is called `3. NRR - Renewal`, however, it will retain the same RecID)

```json
{
    "id": 44271,
    "name": "Test Opp",
    "expectedCloseDate": "2024-06-26T00:00:00Z",
    "type": {
        "id": 34,
        "name": "3. NRR - Renewal",
        "_info": {
            "type_href": "https://connect.meriplex.com/v4_6_release/apis/3.0/sales/opportunities/types/34"
        }
    },
    "_info": {
        "lastUpdated": "2024-06-07T21:48:36Z",
        "updatedBy": "CW-Sell",
        "notes_href": "https://connect.meriplex.com/v4_6_release/apis/3.0/sales/opportunities/44271/notes"
    }
}
```

**Actions:** 
- Mark all `Resources` as `Done`.
- Change status to ">Quote Delivered".
- Notify the user that the quote is delivered via existing notification system.

```sql
-- View the Resources given SR_Service_RecID
SELECT
	*
FROM Schedule
WHERE RecID = <SR_Service_RecID>;
```

```sql
-- Update all resources to done given SR_Service_RecID
UPDATE Schedule
SET close_flag = 1
WHERE Ticket_ID = <SR_Service_RecID>;
```

| SR_Status_RecID | Description      | SR_Board_RecID | Board_Name           |
| --------------- | ---------------- | -------------- | -------------------- |
| 587             | >Quote Delivered | 21             | Sales - Quoting Team |
| 10952           | >Quote Delivered | 532            | NRR - Quoting        |

**Status:** In Progress

---

### Attach Signed PDF
**Issue:** Time wasted on quoting tickets  
**Request B:** When a signed email is received, attach the signed PDF to the opp in SF and change stage to Signed.  
**Status:** On Hold

---

### `RecID` Fields
**Issue:** Linking `RecID` Fields in CW-SELL are exposed with write permissions  
**Solution:** Make this field hidden  
**Status:** Complete

---

![[Pasted image 20240611111014.png]]

Post-Mortem
---

Add Rob Ford and Eric O'Shea to an approver list for change management.
Change-management windows need to be agreed upon.

Contract Distribution - Amy Chestnutt - SOP
Procurement - Chris Jouban - SOP
NRR - John Powell - SOP
MRR - Rob Ford - SOP 
Finance - 
Sales - Eric Carlson & Mike Barron - SOP
Activations - Chris Matthison
Internal IT - Brian Jones
Operations - Dusty Corning
