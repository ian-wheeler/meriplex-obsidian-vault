# Task Report

| **Task Title**   | Inventory BI Report |
| ---------------- | ------------------- |
| **Task ID**      | BI-20240503         |
| **Requested By** | Kelvin Garrison     |
| **Assigned To**  | Monish Allu         |
| **Priority**     | Low                 |
| **Status**       | Not Started         |
| **Due Date**     | N/A                 |
## Task Description

Develop an inventory BI report for the accounting team, extracting data from CW (ConnectWise). The report should be capable of generating monthly, quarterly, and annual balances. The following specifications must be included:

- **Location**
- **Warehouse and Bin**
- **==Ownership==**
- **==Type==**
- **Product ID**
- **Description**
- **Vendor**
- **Category**
- **Picked Count**
- **Beginning of month on hand count**
- **Receipts, adjustments, transfers, and shipments**
- **End of month on hand count**
- **Extended Cost**

**Note:** Highlighted items are not captured in CW and are manually added by the inventory team.

## Objectives

- [ ] Extract relevant data from CW reports.
- [ ] Create a comprehensive BI report.
- [ ] Ensure the report can be run for monthly, quarterly, and annual balances.
- [ ] Include manually added items by the inventory team in the report.
## Requirements

- **Functional Requirements:**
    - [ ]  Integrate data from the following CW reports:
        - [ ]  Inventory Valuation Detail
        - [ ]  Purchase Order Line Item Detail
        - [ ]  Product Audit List (including receipts, picks, transfers, adjustments, and on-hand quantity after each transaction, excluding extended cost)
    - [ ]  Develop a user-friendly interface for running the report.
    - [ ]  Ensure data accuracy and consistency.

- **Non-functional Requirements:**
    - [ ]  Report generation should be efficient and timely.
    - [ ]  Ensure data security and privacy.

## Deliverables

- [ ]  A BI report template that includes all specified fields.
- [ ]  Documentation on how to generate and interpret the report.
- [ ]  Training session for the accounting team on using the report.

## Milestones

1. [ ]  **Data Extraction Plan:** 2024-06-01
2. [ ]  **Initial Report Template:** 2024-06-15
3. [ ]  **Report Testing and Validation:** 2024-06-30
4. [ ]  **Final Report Delivery:** 2024-07-10

## Dependencies

|**Dependency**|**Details**|
|---|---|
|**Dependent On**|Access to CW reports and relevant data|
|**Dependent By**|Accounting team for manual data entry|

## Risks and Mitigations

|**Risk**|**Mitigation**|
|---|---|
|Incomplete or inaccurate data extraction from CW|Perform thorough testing and validation|
|Manual data entry errors by the inventory team|Provide clear guidelines and training|

## Resources

- **Team Members:**
    - Monish Allu (SQL Developer)
    - Ian Wheeler (Analyst)
    - Kelvin Garrison (VP of Supply Chain)

- **Tools & Technologies:**
    - ConnectWise Manage
    - SQL Server
    - Power BI
    - Excel

- **Budget:** Not applicable

## Progress Updates

| **Date**   | **Progress**            | **Issues** | **Next Steps**                                                                                                                                                  |
| ---------- | ----------------------- | ---------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 2024-06-03 | Review with Monish Allu |            | - Ownership and Type Business Rules<br>- Receipts, adjustments, transfers, and shipments business rules<br>- Reference document review<br>- Demo current report |

## Notes

- Ensure communication with the inventory team for accurate manual data addition.
- Maintain regular updates with the accounting team for feedback and adjustments.

## References

- Inventory Valuation Detail Report
- Purchase Order Line Item Detail Report
- Product Audit List Report