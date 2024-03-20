# ConnectWise REST API - General Notes
---
This document contains personal notes and tips for working with the ConnectWise REST API. It includes:

- Authentication and authorization
- Endpoint descriptions and usage examples
- Best practices for API requests and error handling
- Specific use cases and code snippets
- Troubleshooting common issues
- Additional resources and documentation links

These notes serve as a quick reference guide to help developers efficiently interact with the ConnectWise REST API, providing practical insights and solutions based on personal experience.

## Authentication
---

## Endpoints
---
**Companies** 
```
{{baseURL}}/v4_6_release/apis/3.0/company/companies
```

**Companies by Company_RecID**
```
{{baseURL}}/v4_6_release/apis/3.0/company/companies/{{Company_RecID}}
```

**Company Sites**
```
{{baseURL}}/v4_6_release/apis/3.0/company/companies/{{Company_RecID}}/sites
```

**Company Sites by Company_Address_RecID**
```
{{baseURL}}/v4_6_release/apis/3.0/company/companies/{{Company_RecID}}/sites
```
