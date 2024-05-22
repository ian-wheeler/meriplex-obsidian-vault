# Change Request: 2024-02-01

## Salesforce Changes Requested

1. **Add a Question Field (`complianceQuestionResponse`) to the Account Record level and lead generation process**
    - **Question**: Is the entity, whether a current client or a prospect, required to adhere to DFARS, CMMC, or CJIS compliance standards, or do they conduct work for the federal government?
    - **Response**: Yes/No
    - **Note**: This is a REQUIRED field & READ-ONLY field after initial selection.

2. **Modify the Territory (`Territory__c`) field on the Account object so that it’s a Picklist data type with the following picklist values:**
    - `SSI`
    - `Meriplex Government Services`
    - `Meriplex Solutions`
    - **Note**: The picklist values listed above are the only values that should be exposed to the end user, however, it should still allow for different values passed through integration(s) via API.
    - **Note**: This is a REQUIRED field & READ-ONLY field.

3. **Insert background logic at the Account level to determine Territory (`Territory__c`); Logic is as follows:**

```apex
// The question above “complianceQuestionResponse” is a field that stores the response (yes/no)
complianceQuestionResponse = getFieldValue("complianceQuestionResponse")

// Initialize variables for account source and sub-source
accountSource = getFieldValue("accountSource")
subSource = getFieldValue("subSource")

// Determine the territory based on compliance question response and account source
if complianceQuestionResponse == "yes" then
    territory = "Meriplex Government Solutions"
else
    // Additional logic based on account source and sub-source
    if accountSource == "Acquisition" then
        territory = subSource
    else
        territory = "Meriplex Solutions"
end if

// Output or set the territory value accordingly
setFieldValue("territory", territory)
```

4. **Insert background logic to determine the Location (`Location__c`) field value of the Opportunity record based off the territory (`Territory__c`) field value of the corresponding Account record.**

```apex
// Step 1: Retrieve the opportunity record
opportunity = getOpportunityRecord()

// Step 2: Retrieve the associated account record
account = getAssociatedAccount(opportunity.accountID)

// Step 3: Copy the territory value from the account to the opportunity's location
opportunity.location = account.territory

// Step 4: Update the opportunity record with the new location
updateOpportunityRecord(opportunity)

// Supporting Functions:
// - getOpportunityRecord(): Retrieves the current opportunity record.
// - getAssociatedAccount(accountID): Retrieves the account record using the account ID associated with the opportunity.
// - updateOpportunityRecord(opportunity): Updates the opportunity record in the database with the new location.
```

- **Note**: This is a REQUIRED field & READ-ONLY field.

## SF-CW Integration Changes Requested

1. Sync the Territory field (at the Account/Company level) bi-directionally.
2. Sync the Location field (at the Opportunity level) bi-directionally.

---
# Issues and Comments - 20240202

1. When generating a lead in SF, if the user answers the questions for source and sub-source with the values "Referral" and "GCC High Referral" then the answer to the question of whether they need to be GOV compliant should automatically be yes.
2. In addition to the point above, I was permitted to select the "GCC High Referral" sub-source and select "No" as a response to the question of compliance which should not be permitted as it is a logical conflict. If the account is a "GCC High Referral" then it automatically has to be compliant, effectively placing them in the "Meriplex Government Services" territory.
3. Converting the lead works as anticipated outside of point (2) listed above. 
4. After a lead is converted / for already existing accounts and opportunities, saving an account record does not update the opportunity location(s) with the account territory field value. This can stay by design but needs to be agreed on in the next meeting. If it does stay this way we will have to clean up some records. (Note: either way we will have to clean records but implementing the logic in all scenarios would have a sort of "self-healing" component to it)
5. Creating a new opportunity from the account opportunity list screen does not auto-populate the location with the account territory field value. (This could just be my account but it would probably be best to implement this at the new opportunity record screen for all users)

# Issues and Comments - 20240205

1. After setting an account source, sub-source, and the question response. Future changes to these fields do no update the territory or opportunity locations accordingly.

