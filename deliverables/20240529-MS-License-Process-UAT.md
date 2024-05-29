# Task Report

| **Task Title**   | Testing Microsoft Licensing Process for Quantity Change Requests |
| ---------------- | ---------------------------------------------------------------- |
| **Task ID**      | UAT-20240529                                                     |
| **Requested By** | Brian Jones                                                      |
| **Assigned To**  | Ian Wheeler                                                      |
| **Priority**     | High                                                             |
| **Status**       | In Progress                                                      |
| **Due Date**     | 2024-05-29                                                       |

## Task Description

The team aims to go live with the new Microsoft Licensing process on Thursday. This task involves testing the new feature for changing Microsoft License product quantities in the `Spark` web app. The tests need to ensure that all aspects of the transaction function correctly, including ticket creation, log record insertion, document attachment, and product posting.

## Objectives

- [x] Test the quantity change request process for Microsoft License products in `Spark`.
- [x] Verify that submitting the quantity change produces a ticket.
- [x] Ensure that attaching a document with the quantity change submission posts the document as an attachment on the ticket.
- [x] Confirm that products and the quantity to add are attached to the ticket with matching details.
- [x] Check that submitting the quantity change produces a log record on `[cwwebapp_meriplex_log].[dbo].[AGR_Change_Qty_Log]` on the `[IAHVMPRODRP01]` server.
- [x] Verify that changing the ticket status to closed in ConnectWise reflects the quantity change on the default agreement for the company being tested.

## Requirements

- **Functional Requirements:**
    - [x] Only Microsoft License products allow the user to change quantities.
    - [x] Submitting the quantity change should produce a ticket.
    - [x] Attaching a document with the quantity change submission should post the document as an attachment on the ticket.
    - [x] Products and the quantity to add should be attached to the ticket with matching details selected in the tool.
    - [x] Submitting the quantity change should produce a log record on `[cwwebapp_meriplex_log].[dbo].[AGR_Change_Qty_Log]` on the `[IAHVMPRODRP01]` server.
    - [x] Changing the ticket status to closed in ConnectWise should reflect the quantity change on the default agreement for the company being tested.

- **Non-functional Requirements:**
    - [ ] High reliability and accuracy in processing requests.
    - [x] Secure handling of sensitive contract data.
    - [x] Compatibility with existing systems and processes.

## Deliverables

- [ ] Detailed report on the testing results and any issues encountered.
- [x] Confirmation of successful completion of all test cases.
- [ ] Recommendations for any further actions or improvements needed before going live.

## Milestones

1. [ ]  **Milestone 1:** Initial setup and preparation for testing [2024-05-29]
2. [ ]  **Milestone 2:** Conducting tests in production [2024-05-29]
3. [ ]  **Milestone 3:** Evaluation and reporting [2024-07-29]

## Dependencies

| **Dependency**     | **Details**            |
| ------------------ | ---------------------- |
| **Prerequisites**  | Access to `Spark` web app and necessary test contracts |
| **Postrequisites** | Evaluation of results and report preparation |

## Risks and Mitigations

|**Risk**|**Mitigation**|
|---|---|
|Potential data handling issues| Ensure all data handling complies with company policies and regulations.|
|Inaccurate processing of requests| Conduct thorough tests and validations before going live.|

## Resources

- **Team Members:**
    - Ian Wheeler
    - Brian Jones
    - Roy Surles
    - Cameron Ott

- **Tools & Technologies:**
    - `Spark` web app
    - ConnectWise

- **Budget:** No budget allocated; potential cost savings if successful.

## Progress Updates

| **Date**   | **Progress**                                        | **Issues**  | **Next Steps**                                                  |
| ---------- | --------------------------------------------------- | ----------- | --------------------------------------------------------------- |
| 2024-05-29 | Initial setup and preparation for testing completed | None so far | Proceed with conducting tests in production                     |
| 2024-05-29 | All test cases have been completed and passed       | None so far | Confirm test results with Brian Jones and relevant stakeholders |

## Notes

Additional context for testing includes ensuring that only Microsoft License products allow quantity changes and that all necessary aspects of the transaction (ticket posting, log insertion, document attachment, and product posting) are functioning correctly.

## References

- [Test Agreement](https://connect.meriplex.com/v4_6_release/services/system_io/router/openrecord.rails?recordType=AgreementFV&recid=19064&companyName=Meriplex)
- [Spark Viewer Web Application](https://slviewer.meriplex.com/)
