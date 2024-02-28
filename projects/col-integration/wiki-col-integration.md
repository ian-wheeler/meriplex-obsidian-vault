# Meriplex Systems Integration - Phase 2
## Table of Contents 
1. [Overview](#overview) 
2. [Integration Review, Documentation, and Future Planning Across All Systems](#integration-review-documentation-and-future-planning-across-all-systems) 
3. [Specific Integration Initiatives](#specific-integration-initiatives) 
	- [Product Catalog Integration](#product-catalog-integration) 
	- [Merge Interface Development](#merge-interface-development) 
4. [Requests](#requests) 

---
# Overview

This phase aims to enhance the integration between Salesforce and ConnectWise by implementing new features, improving data flow, and addressing current issues to streamline operations.

---

# Stakeholders
| Name            | Title                     | Role                          | Responsibility                                                         |
|-----------------|---------------------------|-------------------------------|------------------------------------------------------------------------|
| Brian Jones     | CIO               | Executive Decision Making     | ConnectWise Manage Ownership; allocation of  development resources                          |
| Dusty Corning   | CSO                | Executive Decision Making     | Salesforce Ownership; allocation of sales resources                                 |
| John Powell     | VP, NRR | Project Champion / Primary Stakeholder      | NRR Sales/Quoting Process Ownership; UAT                                |
| Chris Jouban    | Sr. Manager, Procurement       | Stakeholder, SME                        | Procurement Process Ownership; Consulting                                      |
| Kelvin Garrison | VP, Procurement       | Stakeholder, SME                        | Procurement Process Ownership; Consulting                                      |
| Carrie Hatley   | Sales Operations           | Consultant, SME              | Sales Consulting, UAT                                                          |
| John Sobernheim | Solutions Consultant, NRR           | Consultant, SME, UAT              | NRR Consulting, UAT                                                          |
| Amy Chestnut    | Sr. Manager, Contract Management      | Stakeholder, SME                        | Distribution Process & Contract Management Process Ownership; Consulting                         |
| Ian Wheeler     | Business Analyst, DevOps   | Project Management             | PM, Documentation, and Integrations Consulting                              |
| Cameron Ott     | Full-Stack Developer, DevOps | Development, SME | Development & Integrations Consulting                                               |
| Joseph Rosales  | Automation Architect, DevOps         | Development, SME | Development & Integrations Consulting                                               |


---
## Integration Review, Documentation, and Future Planning Across All Systems

- **Comprehensive Integration Assessment**: Undertake a detailed evaluation of the existing integrations across all systems, not limited to ConnectWise (CW) and Salesforce (SF). This evaluation aims to uncover opportunities for refactoring and optimization across the integration landscape to enhance operational efficiency and system interoperability.

- **Documentation Requirements**: Essential documentation to facilitate the integration assessment, refactoring efforts, and future planning includes:
  - **Baseline Data Flow Diagrams (DFD's)**: Construct visual diagrams to map out the current data flows within and between all integrated systems. These diagrams serve as foundational tools for understanding existing architectures and pinpointing inefficiencies.
  - **Current State (As-Is) Wiki Documentation**: Compile comprehensive documentation that covers:
    - **Object and Field-by-Field Mappings**: Detail the mappings between objects and fields across all systems to ensure consistent and accurate data exchanges.
    - **Custom Routing Logic**: Document the specifics of any custom logic used to route data across systems, including decision criteria and conditional flows.
    - **Integration Point Directionality**: Define the data flow direction (uni-directional or bi-directional) for each integration point to clarify system interactions.
    - **Restrictive Logic and Compliance Rules**: Describe any logic, rules, or constraints that govern the data syncing process, including data validation and transformation requirements.
  
  - **Future State (To-Be) Documentation**: Envision and document the desired future state of system integrations post-refactoring. This includes:
    - **Proposed Data Flow Diagrams (DFD's)**: Visual representations of the optimized data flows, highlighting changes and improvements from the current state.
    - **System Integration Roadmap**: A strategic plan outlining steps, milestones, and key objectives to transition from the current to the future state, including technological, procedural, and governance changes.
    - **Updated Object and Field Mappings**: Adjustments to mappings reflecting the new integration architecture, ensuring continued data integrity.
    - **Revised Routing and Logic Specifications**: Updated documentation on routing logic and data handling processes to accommodate the new system layout and improved integration strategies.
    - **Enhanced Directionality and Restrictive Logic Details**: Clarifications on any changes to the directionality of data flows and modifications to restrictive logic to support the refined integration framework.

- **Refactoring and Future Planning**: Based on the thorough assessment and detailed documentation, decide on the necessity and scope of refactoring the integration architecture. This decision-making process should consider the benefits of improved data management, reduced manual intervention, and alignment with best practices in system design, aiming for a streamlined, efficient, and scalable integration ecosystem.

## Specific Integration Initiatives
### Product Catalog Integration

The integration of product catalogs into Salesforce involves two primary components to ensure comprehensive coverage of both Non-Recurring Revenue (NRR) and Monthly Recurring Revenue (MRR) products:

1. **Integration of the ChannelOnline Product Catalog with Salesforce for NRR Products**
   - **Objective**: Seamlessly integrate the ChannelOnline product catalog into Salesforce to enable accurate tracking and management of NRR products. This integration ensures that sales teams have up-to-date access to the entire range of NRR products available for quoting and sales processes.
   - **Steps**:
     - Assess the current state of the ChannelOnline product catalog and Salesforce integration capabilities.
     - Define mapping rules for product categories, pricing, and availability to ensure data consistency between ChannelOnline and Salesforce.
     - Implement data synchronization mechanisms to update Salesforce with the latest product information from ChannelOnline in real-time or via scheduled updates.
     - Test the integration thoroughly to ensure data accuracy and system reliability.

2. **Integration of the Meriplex Product Catalog (Located in ConnectWise CPQ) with Salesforce for MRR Products**
   - **Objective**: Integrate the Meriplex product catalog, housed within ConnectWise CPQ, into Salesforce. This integration is crucial for managing MRR products, facilitating accurate and efficient quoting, and sales forecasting within Salesforce.
   - **Steps**:
     - Evaluate the existing Meriplex product catalog structure within ConnectWise CPQ and determine integration requirements with Salesforce.
     - Establish field mappings and data transformation rules to align MRR product details, pricing models, and subscription terms between ConnectWise CPQ and Salesforce.
     - Develop and implement an integration solution that ensures continuous synchronization of MRR product data from ConnectWise CPQ to Salesforce.
     - Conduct comprehensive testing to validate the integration, focusing on data integrity, user experience, and reporting accuracy.

Both integration efforts aim to enhance product management capabilities within Salesforce, providing a unified view of all products and simplifying the sales process. These initiatives require close collaboration between IT, sales, and product management teams to ensure successful implementation and adoption.

### Merge Interface Development
Develop a merge tool that syncs records across various systems, similar to the ConnectWise `company merge` tool, ensuring data consistency and reducing duplication.

---
## Salesforce Integration Guide
[Salesforce Integration User Guide](Salesforce%20Integration%20User%20Guide.pdf Online/Salesforce Integration User Guide.pdf>)

---
## ConnectWise Integration Guide
[ConnectWise Integration User Guide](ConnectwiseUserGuide.pdf Online/ConnectwiseUserGuide.pdf>)
