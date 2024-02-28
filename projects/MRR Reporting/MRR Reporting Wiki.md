# Overview

This document outlines the business rules and definitions for handling activations, tracking remaining activations, and forecasting the Original Monthly Recurring Revenue (MRR). It also provides guidance on processing downgrades and churns.

## Business Rules

- **Requests Handled:**
  - Activations
  - Activations Remaining
  - Original MRR Forecast

- **Expected Install Date:** An `expected_install_date` set in the future indicates the number of activations remaining.

- **Effective Date for MRR Reporting:** The "Effective Date" noted on additions in the Graphical User Interface (GUI) should be used as the reference date for MRR reporting.

- **Reference Data:** For Background (BG) data reference, use the additions rather than the configurations.

## Data Handling Instructions

### Additions Table

- **Product Category:** Join the additions table with products to categorize each addition.
- **Prorate Agreement:** Join the additions table with agreements to determine the prorate agreement. Consult with Ebony for the prorate formula.
- **Disco Consultation:** For matters related to Disco, consult Yusenia.

### Definitions

#### Downgrade

- A downgrade occurs when a customer's new contract results in a lower MRR compared to their previous contract. For example, moving from a $1000/month contract to a $500/month contract.
- An example of a downgrade is when a customer cancels a product, reducing the number of products they are paying for (e.g., from 3 products to 2).

#### Churn

- Churn refers to the complete termination of all products by a customer. Consult Yesenia for procedures related to churn processing.

## Conclusion

This document serves as a guide for the OPS-ACTIVATIONS-ROLLUP team, detailing the process for activations, managing data in the additions table, and handling downgrades and churns.
