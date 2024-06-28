# Quote Process Review

## Process Overview

1. **Opportunity Identification**:
    - NRR Team member identifies an opportunity.
2. **Opportunity Creation**:
    - Create a `Quick Opportunity` in Salesforce.
3. **Ticket Triage**:
    - Based on the NRR/MRR Classification, the ticket is triaged to one of the following boards:
        1. Solutions Engineering (MRR Advanced)
        2. Sales - Quoting Team (MRR Standard)
        3. NRR - Solutions Consulting Engineers (NRR Advanced)
        4. NRR - Quoting (NRR Standard)
        5. Sales - Account Management (Catchall) - Currently, all opportunities sync here.
4. **Board Navigation**:
    - Navigate to `NRR - Quoting` or `NRR - Solutions Consulting Engineers` Board.
5. **Detail Entry**:
    - Enter remaining details for the `Opportunity`.
6. **Note Entry**:
    - Click `Enter a New Note` to start a timer, add notes during the quoting process, and notify team members.
7. **CPQ Process**:
    - Navigate into CPQ and choose the `Non-Recurring` template, followed by Customer Setup, Quote Setup, Content Preparation, Review, Approval, and finally, Publish and Deliver.
8. **Client Approval**:
    - The client signs and approves the order. If e-sign is not available, consult Jason Nelson (Meriplex Attorney) for the process.
9. **Contract Validation**:
    - Contract Distribution validates the signed quote and returns it to Quoting if necessary.

## Issues Identified

- **Ticket Triaging**:
    - Difficulty routing tickets to the appropriate board.
- **Automated Alerts**:
    - Unhelpful alerts, primarily from LightPoint and various sources, requiring investigation.
- **Opportunity and Ticket Fields**:
    - Necessity to bring over all required fields so the quoting team doesn't have to complete the opportunity details.
- **Ticket Naming**:
    - Appending "ticket" to each ticket created is not useful.
- **CPQ Terms & Conditions**:
    - Multiple `Terms & Conditions` and duplication issues, highlighted as a high priority.
- **CPQ Complexity**:
    - The CPQ system is considered "infinitely complicated," needing rework and a dedicated admin.
- **Team Member Classification**:
    - Clarification needed on which team members are responsible for the quote, with a suggestion for a dedicated dispatcher.
- **Quoting Specialists**:
    - Concerns over Quoting Specialists moving too slowly and needing higher volume.
- **Stylistic Alignment**:
    - Efforts to align the Order/Porter and Invoice PDF stylistically are significant.
- **Email Connector**:
    - Generating tickets on quoting boards with no linked opportunity, which should originate from Salesforce.

## Notes

- Approximately 20 requests in 3 hours.
- Four types of Sales/Quoting Team Members are identified, each with different responsibilities.

## SSI Workflow

- **Initial Request**:
    - Ticket arrives on `SSI-Quotes` Board with `New Request` status.
- **Quoting Process**:
    - Assigned status changed to `Quoting`. Rep must finish or reassign the quote before moving on.
- **Pending Response**:
    - If waiting for a response, select one of the `Waiting...` statuses.
- **Quote Completion**:
    - Once a quote is completed in CPQ and sent, change the ticket status to `Quote Sent`
- **CPQ Usage**:
    - Preference to copy items from another quote rather than using tab templates.

## Additional Notes

- Terms & Conditions for NRR to be sent to Brian Jones first, as advised by Jason Nelson.

# 2024/04/01
- 2023 Meriplex Standard is the only Order Porter Template
- Eliminate PDF being displayed
- Send the PDF after E-Signing (does so automatically after signing; per John S.)
- Approval > Acceptable Use 
	- Auto-fill: Full Name, and Email Address
	- Manual-fill: Title, Purchase Order Number, and Signature
	- Remove: Company Name, Your Initials
- Improve the overall design, colors, padding, font-style, etc.
- Try to eliminate the user's ability to modify the template font-sizes.
- Add the Shipping Address
- Display whether the quote is drop-ship or ship-to-meriplex-warehouse
- Remove Comments or Questions
## User Permission Matrix
## Teams Permission Matrix
## Review Locations
## Review Prefixes
## Order Porter Setup
## Order Porter Templates
## Output Grid Layer
## Payment Processors
## DocuSign


2024/04/19

