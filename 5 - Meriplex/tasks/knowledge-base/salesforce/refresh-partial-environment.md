# Records copied when you refresh Partial Data sandbox

Publish Date: Mar 2, 2021

Description

What records will be copied to my Partial Data Sandbox upon refresh?  
 

Resolution

Partial data copy works by collecting sample 10K records per object. Unless the objects are related by a Master Detailed relationship or Required Lookup, the sampling application does not pick up related records.   
 

### **For example if there are objects A, B, C, D** 

  
If A and B have master detailed. A and C have required lookup relationship and D has just lookup with rest of objects, sampler would pick 10,000 of related A,B and C records. However the 10,000 records from D might not have the A,B,C values populated as they are randomized. This is the feature design of Partial Data Copies which relies on random sampling and enforces relationships only on Master Detail or Required Lookups. If you were to either have only 10,000 records across all objects or required lookups between all objects, the partial data copy would work as per expectation.  
 

### **Here's another way to explain above example:**

  
Example Object relationships (Parent <- Child).  Assume we have Objects A, B, C, D with the following relationships:  
 

1. A <- (MD) B  
  
2. A <- (Required Lookup) C  
  
3. A <- (Lookup) D  
  
4. B <- (Lookup) D  
  
5. C <- (Lookup) D

  
D could get up to 10,000 records since it has no MD nor required lookup to other objects. Therefore, D is acting like a top “parent” object.  However, if D had MD / required lookup to another object, it now becomes a “child” object and record sampled are dependent on parent object.  Since the sampling starts at parent object, it could be possible that child or grandchild objects may come back with little to zero records.  
  
When copying contacts, accounts, and opportunities, partial copy results work differently. Contact and Opportunity don’t have a required master-detail relationship with the Account object. However in default layouts in the UI, you can’t create contacts or opportunities without assigning an account to them.   
  
The Partial Copy Sandbox sampling application treats the relationships imposed by the UI as required, and skips all contact and opportunity records without an associated account. If you created contact and opportunity records using Apex or an API, and didn’t associate them with an account, those records are skipped during sampling and won’t be copied to your sandbox.  
  
Please note there is a storage limitation of 5 GB. So if there are larger number of objects (having more than 10,000 records), then in order to maintain the 5 GB limit - the number of records copied per object could be less than 10,000.  
 

### **See also:  
[Create or Edit Sandbox Templates](https://help.salesforce.com/s/articleView?id=sf.data_sandbox_templates.htm&type=5&language=en_US)  
[Sandbox Licenses and Storage by Type](https://help.salesforce.com/s/articleView?id=sf.data_sandbox_environments.htm&type=5&language=en_US)  
[Considerations for Partial Sandbox creation and refreshes](https://help.salesforce.com/s/articleView?id=000313358&language=en_US&type=1&mode=1)   
  
  
Support video:**  
[**How to Create a Sandbox Template**](https://www.youtube.com/watch?v=5KA6CCkau3c)  
  
 

Knowledge Article Number

000386381