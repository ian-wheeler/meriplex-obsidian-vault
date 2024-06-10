Action Items:

---

Issue: `Campaign` field in CW-Manage is required
Solution: Make this field non-required and hidden

---

Issue: `Secondary Sales Rep` field in CW-Manage is required
Solution: Make this field non-required and hidden

---

Issue: `Territory` and `Location` have improperly entered
Solution: Retroactively repair `Territory` and `Location` using underlying logic to identify

---

Issue: `Department` field in CW-Manage is required and doesn't display appropriate fields
Solution: Make this field non-required and change fields displayed to include
- Non-Recurring
- Monthly Recurring
- Revenue Fields

---

Issue: `Shipping Contact` is a required field in CW-Manage
Solution: Add the `Shipping Contact` field to SF

---

Issue: `Board` routing on ticket creation from SF to CW is incorrect
Solution: 
	IF `Opportunity Type` in SF is `3. Non-Recurring Revenue` 
		Create the ticket on the NRR Quoting Board (`NRR - Quoting`) in CW
	ELSE 
		Create the ticket on the MRR Quoting Board (`Sales - Quoting Team`) in CW

| SR_Board_RecID | Board_Name           | Owner_Level_RecID | Billing_Unit_RecID |
|----------------|----------------------|-------------------|--------------------|
| 532            | NRR - Quoting        | 11                | 6                  |
| 21             | Sales - Quoting Team | 11                | 6                  |

---

Issue: Time wasted closing quoting tickets

Request A: Automate the creation of the quoting tickets on their appropriate service board.
Solution A: When an Opportunity webhook is received with the following,
1. `lastUpdated` = `CW-SELL` AND
2. `Type` = `3. Non-Recurring Revenue` <-- Future Name; Currently it is called `3. NRR - Renewal`, however, it will retain the same RecID

```JSON
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

Action: 
- Mark all `Resources` as `Done` 
- Change status to ">Quote Delivered"
- Notify the user that the quote is delivered via existing notification system

| SR_Status_RecID | Description      | SR_Board_RecID | Board_Name           |
| --------------- | ---------------- | -------------- | -------------------- |
| 587             | >Quote Delivered | 21             | Sales - Quoting Team |
| 10952           | >Quote Delivered | 532            | NRR - Quoting        |


Request B: When a signed email is received attach the signed PDF to the opp in SF and change stage to Signed

---

Issue: Linking `RecID` Fields in CW-SELL are exposed with write permissions
Solution: Make this field hidden