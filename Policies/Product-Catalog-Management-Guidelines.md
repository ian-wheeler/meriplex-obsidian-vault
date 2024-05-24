# Standard Operating Procedure

## Meriplex Product Catalog Management

---

## Table of Contents

1. [[#Purpose]]
2. [[#Scope]]
3. [[#Definitions]]
4. [[#Roles and Responsibilities]]
5. [[#Procedures]]
6. [[#Business Rules]]
7. [[#Configurations/Settings]]
8. [[#Permissions Matrix]]
9. [[#Related Documents]]
10. [[#Change Management]]
11. [[#Revision History]]

---

## Purpose

To provide standardized procedures for managing the Meriplex Product Catalog, ensuring consistency and accuracy in product data.

## Scope

This SOP applies to all personnel involved in the management of the Meriplex Product Catalog, including the creation, updating, and deletion of products.

## Definitions

- **Apply Cost by Serial #**: Enables costing by serial number.
- **Customer Description**: The description that displays on the customer invoice.
- **Default Minimum Stock Level**: Default value to reorder inventory items when stock falls below this level.
- **Description**: A summary of the product, limited to 50 characters, displayed on sales documents.
- **Drop Ship**: Product is shipped directly from the vendor to the customer.
- **Entity Type**: Indicates the type of tax exemption, determining taxability.
- **Integration Cross Reference or Avalara Tax Code**: Integration code for the accounting package or Avalara tax code.
- **Phase Bundle**: Indicates the product should be a separate phase during opportunity conversion.
- **Price Attribute**: Defines how the service is priced (Fixed Fee, Not to Exceed, T&M, Override Rate).
- **Product Catalog**: The comprehensive list of products offered by Meriplex.
- **Product Category**: The category or group of the product, affecting GL mappings and revenue posting.
- **Product Class**: Controls product behavior in PSA (Professional Services Automation), with options such as Agreement, Bundle, Inventory, Non-Inventory, and Service.
- **Product ID (SKU)**: The name or item number of the product, limited to 30 characters.
- **Product Manager**: The individual responsible for overseeing the product lifecycle.
- **Product Subcategory**: The subcategory or group of the product, affecting GL mappings and revenue posting.
- **Product Type**: Classification of the product, affecting accounting and GL mapping.
- **Sales Tax**: Indicates if the product is taxable.
- **Serialized**: Indicates if the product is a serialized inventory item.
- **SLA**: Service Level Agreement that applies to the product.
- **Special Order**: Product is a special order for a customer.
- **UOM (Unit of Measure)**: The unit of measure for the product, defined in the UOM Setup Table.
- **Unit Cost**: The cost of the product, necessary for calculating gross profit.
- **Unit Price**: The price to charge for the product.

## Roles and Responsibilities

- **Product Manager**: Oversees product creation, updates, and deletions.
- **Data Entry Specialist**: Enters product data into the system.
- **Quality Assurance**: Verifies the accuracy and consistency of product information.
- **IT Support**: Maintains the systems used for managing the product catalog.

## Procedures

### **Create New Product**

1. Navigate to the Product Catalog Management System.
2. Select 'Create New Product'.
3. Enter product details, including name, description, and initial SKU.

### **Update Existing Product**

1. Search for the product in the Product Catalog.
2. Select 'Edit' for the relevant product.
3. Update necessary fields such as description, pricing, and SKU.

### **Delete Product**

1. Search for the product in the Product Catalog.
2. Select 'Delete' for the relevant product.
3. Confirm the deletion action.

## Business Rules

_List and describe the business rules that apply._

| Rule ID | Business Rule Description                                        | Justification                                       | Implementation Date | Review Date | Owner                 |
| ------- | ---------------------------------------------------------------- | --------------------------------------------------- | ------------------- | ----------- | --------------------- |
| BR-001  | All product entries must have a unique SKU.                      | Ensures product tracking accuracy.                  | 2024-05-01          | 2024-11-01  | Product Manager       |
| BR-002  | Product descriptions must follow the standardized format.        | Maintains consistency in product catalog.           | 2024-05-01          | 2024-11-01  | Quality Assurance     |
| BR-003  | Changes to product information must be documented and approved.  | Ensures accountability and traceability.            | 2024-05-01          | 2024-11-01  | Product Manager       |
| BR-004  | Only authorized personnel can create, edit, or delete products.  | Maintains data integrity and security.              | 2024-05-01          | 2024-11-01  | IT Support            |
| BR-005  | SKUs should follow the format: `Category-Subcategory-ProductID`. | Facilitates easy identification and categorization. | 2024-05-01          | 2024-11-01  | Data Entry Specialist |
|         |                                                                  |                                                     |                     |             |                       |

## Configurations/Settings

### System Settings

Ensure the Product Catalog Management System is configured to allow only authorized personnel to create, edit, or delete products.

### Security Settings

Implement role-based access control to restrict actions based on user roles.

### Naming Nomenclature

SKUs should follow the format: `Category-Subcategory-ProductID`. Product names should be concise and descriptive.

## Permissions Matrix

_Outline the permissions matrix, showing which roles have access to which resources or actions._

|Role|Resource/Action|Permission Level|
|---|---|---|
|Product Manager|Create/Edit/Delete Product|Read/Write|
|Data Entry Specialist|Create/Edit Product|Read/Write|
|Quality Assurance|View Product Information|Read|
|IT Support|System Maintenance|Execute|

## Related Documents

_List any related documents, such as other SOPs, guidelines, or reference materials._

- [Manage: Product Catalog (meriplex.com)](https://connect.meriplex.com/v4_6_release/ConnectWise.aspx?locale=en_US#XQAACABaAAAAAAAAAAA9iIoG07$U9XZqpLgsNh4oLBjXAw2UR$ZvUcrqictbnx0_BMcdsZ5Q6OJUFtMBn7ZMg_hpPtbY6QBMfpTesM7HmABVL$17jeTldcZjnDRx$8BFgA==??ProductList)
- [[Product-Catalog-Management-Guidelines]]
- [ConnectWise Product Documentation](https://docs.connectwise.com/ConnectWise_Documentation/040/015)

## Change Management

_Describe the process for managing changes to the document._

1. **Request for Change**: Submit a request for change detailing the proposed modifications.
2. **Review and Approval**: The change request is reviewed and approved by the relevant stakeholders.
3. **Implementation**: Approved changes are implemented and documented.
4. **Communication**: Communicate changes to all relevant personnel.
5. **Documentation Update**: Update the SOP to reflect the changes and revise the version history accordingly.

## Revision History

| Date       | Version | Description      | Author      |
| ---------- | ------- | ---------------- | ----------- |
| 2024-05-23 | 1.0     | Initial creation | Ian Wheeler |

---

_End of Document_