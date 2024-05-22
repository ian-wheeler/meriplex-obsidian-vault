# Task Report

| **Task Title**   | Enhance Power Automate Flow for Inventory Transfer and Shipping |
| ---------------- | --------------------------------------------------------------- |
| **Task ID**      | PA-20240521                                                     |
| **Requested By** | Chris Jouban                                                    |
| **Assigned To**  | Ian Wheeler                                                     |
| **Priority**     | Medium                                                          |
| **Status**       | In Progress                                                     |
| **Due Date**     | 2024-06-30                                                      |
|                  |                                                                 |

## Task Description

The current Power Automate flow needs modification and enhancement to improve its functionality. The existing flow is triggered by a Microsoft Forms submission, gathers the submission details, adds them to an Excel spreadsheet on SharePoint, creates a ticket in ConnectWise Manage, and sends an email notification to the form submitter. This task involves addressing limitations with Microsoft Forms and ensuring proper integration with ConnectWise Manage by enhancing the flow to capture necessary details.

## Objectives

- [ ]  Modify the existing Power Automate flow to address limitations with Microsoft Forms.
- [ ]  Ensure the flow properly captures and maps necessary details for ticket creation in ConnectWise Manage.
- [ ]  Enhance the flow to populate drop-down lists with selectable values in Microsoft Forms.
- [ ]  Update the Excel spreadsheet on SharePoint with form submission details.
- [ ]  Ensure email notifications are sent to form submitters after ticket creation.

## Requirements

- **Functional Requirements:**
    - [ ]  Modify the trigger to handle detailed form submissions.
    - [ ]  Update the flow to gather and map necessary details to ConnectWise Manage tickets.
    - [ ]  Enhance the form to include drop-down lists with selectable values.
    - [ ]  Ensure seamless integration with the SharePoint-hosted Excel spreadsheet.
    - [ ]  Implement email notifications for form submitters.

- **Non-functional Requirements:**
    - [ ]  Ensure the flow operates efficiently and without errors.
    - [ ]  Maintain data integrity and security throughout the process.
    - [ ]  Ensure the flow is scalable for future modifications.

## Deliverables

- [ ]  Enhanced Power Automate flow.
- [ ]  Updated Microsoft Form with necessary drop-down lists.
- [ ]  Integration with ConnectWise Manage for ticket creation.
- [ ]  Updated Excel spreadsheet on SharePoint.
- [ ]  Email notification system for form submitters.

## Milestones

- [ ]  **Milestone 1:** Complete form modifications by 2024-06-10
- [ ]  **Milestone 2:** Update Power Automate flow to handle new form details by 2024-06-20
- [ ]  **Milestone 3:** Final testing and deployment by 2024-06-30

## Dependencies

|**Dependency**|**Details**|
|---|---|
|**Prerequisites**|Existing Power Automate flow and Microsoft Form|
|**Postrequisites**|Updated flow integration with ConnectWise Manage|

## Risks and Mitigations

|**Risk**|**Mitigation**|
|---|---|
|Limited capabilities of Microsoft Forms|Explore alternative form solutions if necessary|
|Integration issues with ConnectWise Manage|Conduct thorough testing and have a fallback plan|
|Data mapping errors|Implement validation checks in the flow|

## Resources

- **Team Members:**
    - Chris Jouban
    - Ian Wheeler
    - Novasource

- **Tools & Technologies:**
    - Microsoft Power Automate
    - Microsoft Forms
    - SharePoint
    - ConnectWise Manage

- **Budget:** Not applicable

## Progress Updates

|**Date**|**Progress**|**Issues**|**Next Steps**|
|---|---|---|---|
|2024-05-22|Initial task assigned and requirements gathered|None|Begin form modifications|

## Notes

- Consider alternative solutions if Microsoft Forms cannot meet the requirements.
- Ensure all stakeholders are informed about the progress and any changes to the plan.

## References

- [ConnectWise Manage API Documentation](https://developer.connectwise.com/Products/ConnectWise_PSA/REST)
- [Power Automate Documentation](https://learn.microsoft.com/en-us/power-automate/)
- [SharePoint Integration Guide](https://learn.microsoft.com/en-us/sharepoint/dev/)