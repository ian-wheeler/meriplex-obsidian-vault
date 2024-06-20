# DocuSign Overview
---
The eSignature integration lets your customers sign quotes using DocuSign®. A quote PDF is sent to your customer using your DocuSign account from within ConnectWise CPQ™ (Sell). After the approval is downloaded, you can pass your quote information to your CRM. You can use a default email message or create a custom delivery email message. Custom emails can be personalized using [Order Porter tags](https://docs.connectwise.com/ConnectWise_Sell/300/050/100/Common_Order_Porter_Tags "Commonly Used Order Porter Tags"). 

- [Integration Setup](https://docs.connectwise.com/ConnectWise_Sell/800/020/DocuSign#Integration_Setup "DocuSign")
- [Custom Quote Delivery Email Template](https://docs.connectwise.com/ConnectWise_Sell/800/020/DocuSign#Custom_Quote_Delivery_Email_Template "DocuSign")
- [DocuSign Quote Templates](https://docs.connectwise.com/ConnectWise_Sell/800/020/DocuSign#DocuSign_Quote_Templates "DocuSign") 
- [Send a Quote with DocuSign](https://docs.connectwise.com/ConnectWise_Sell/800/020/DocuSign#Send_a_Quote_with_DocuSign "DocuSign")
- [Republish a Quote](https://docs.connectwise.com/ConnectWise_Sell/800/020/DocuSign#Republish_a_Quote "DocuSign")
- [SuccessList with DocuSign](https://docs.connectwise.com/ConnectWise_Sell/800/020/DocuSign#SuccessList_with_DocuSign "DocuSign")
## Prerequisites

- DocuSign Account
- DocuSign compatible quote template
- ConnectWise Sell Standard or Premium

## Integration Setup

The DocuSign account is used to set up a global integration for your entire ConnectWise CPQ (Sell) instance. Users cannot set up individual integrations. You must be a ConnectWise CPQ (Sell) administrator to set up the integration. 

1. Open the DocuSign application and navigate to My Preferences.
2. Click **Settings**. 
3. In the left navigation, click **Apps and Keys**.   
4. Copy and paste the **User ID**, **API Account ID**, and **Account Base URI** under **My Account** **Information**  
5. In ConnectWise CPQ (Sell), navigate to **Settings > Document Branding > DocuSign Integration**. 
6. In the Authorize section, copy and paste the values from DocuSign for the following fields:  **User ID, API Account ID,** and **Account URI** fields.   
7. In ConnectWise CPQ (Sell), click **Authorize Sell with DocuSign**. If you are already logged into DocuSign, you will be signed in via single-sign-on. In the confirmation message that  appears, click **OK**.   
8. Select the **Enable DocuSign** **Integration** check box. 
9. Select **Automatically Download DocuSign Approvals** if you want ConnectWise CPQ (Sell) to receive approvals from DocuSign automatically. This step is optional. 
10. Click **Save**.
## Custom Quote Delivery Email Template

Emails are sent from DocuSign and do not use your ConnectWise CPQ (Sell) email integration.

You have the option to customize the message that appears in the email. This custom message appears for all quotes delivered through DocuSign from all users in your ConnectWise CPQ (Sell)  instance. The Review Document header cannot be altered. 

1. In ConnectWise CPQ (Sell), navigate to **Settings** > **Document Branding** > **DocuSign Integration**. 
2. Enter text and [Order Porter tags](https://docs.connectwise.com/ConnectWise_Sell/300/050/100/Common_Order_Porter_Tags "Commonly Used Order Porter Tags") in the **Email Template for Delivery Using DocuSign** editor.  
3. If you want to add a logo to your email, click the image icon and enter the URL of the image. The image cannot be uploaded in ConnectWise CPQ (Sell) and must have an image address. You can use a hosting service to host your image on the web.
   Select **More options** to adjust the image size, position, and more.   
4. Click **Save**.   
## DocuSign Quote Templates

All 2022 quote templates are compatible with DocuSign. You can also edit your custom templates to make them compatible. 
### Download Templates

1. Navigate to **Settings** > **Community Resources** > **Content Vault** > **Search Content Vault**
2. Select **Quosal Form Templates** in the **Content Type** drop-down.
3. Click **Search**.
4. Select a 2022 quote form. 
5. Click **Install Selected**. The quote form appears in the quote template on the **Publish Overview** screen (Publish and Deliver on quotes). We recommend adding this form to your [quote templates](https://docs.connectwise.com/ConnectWise_Sell/800/050/050/050 "Publish Overview - Edit Quote Templates") to streamline the quoting process for your sales reps. 
### Edit a Custom Template

You can edit your custom templates to make them compatible using the Form Designer. DocuSign looks for the text RECIPIENT SIGNATURE and attaches the signing functionality to it. You can add this text to your document in the same color as the document background so that it's invisible to the customer. 

The Form Designer is only available in Sell Premium. If you do not have access to the Form Designer, ConnectWise Professional Services can assist you with editing your templates. Contact [Help@ConnectWise.com](mailto:Help@ConnectWise.com "Help@ConnectWise.com") to set up a session with a form designer. 

1. If you need to install Form Designer, refer to the [Desktop Admin Installation](https://docs.connectwise.com/ConnectWise_Sell/800/050/020#Desktop_Admin_Installation "https://docs.connectwise.com/ConnectWise_Sell/800/050/020#Desktop_Admin_Installation") steps. 
2. Open Form Designer and right-click on the form you want to edit and select **Duplicate Form**. This copies the form so that you do not alter your original quote form. 
3. Right-click on the copied form and select **Rename Form**.
4. Enter the new name and click **OK**.
5. Open the new copied form. Add a label to the **Signature** area of your form.   
6. Type RECIPIENT SIGNATURE in the label. The text must be in all capital letters.  
7. Select the **Foreground Color** of the text to be the same color as the background color. This hides the text so your customer can't see it.   
8. Click **Save**. 
9. Right-click on the file and select **Save to File**. This saves an .XRPT file to your computer. 
10. In ConnectWise CPQ (Sell), navigate to **Settings > Quote Preparation > Manage Additional Content** 
11. Click **Add**. 
12. Click **Choose File** and select a template from your local workstation. Click **Upload**. The quote form appears in the quote template on the **Publish Overview** screen (Publish and Deliver on quotes). We recommend adding this form to your [quote templates](https://docs.connectwise.com/ConnectWise_Sell/800/050/050/050 "Publish Overview - Edit Quote Templates") to streamline the quoting process for your sales reps. 
## Send a Quote with DocuSign

The DocuSign integration uses a special PDF that enables your customer to add an e-signature to the PDF document. DocuSign does not use Order Porter. Optional quote items and term options cannot be used with DocuSign because the quote is sent as a PDF. If you need to provide a dynamic quote with options your customer can choose, please use [Order Porter](https://docs.connectwise.com/ConnectWise_Sell/300/050/100/005 "Order Porter Overview") instead.   

ConnectWise recommends that you attach the DocuSign PDF template to your quote templates to streamline the delivery process. 

1. Ensure that you do not have optional items or terms on your quote. Optional items and term options cannot be used with DocuSign. 
2. After you have created the quote, click **Publish and Deliver**. 
3. Select **Email DocuSign**.   
4. In **Documents Attached**, verify that a DocuSign compatible PDF is attached. All 2022 PDFs are DocuSign compatible. You may also [edit your custom templates to make them DocuSign compatible](https://docs.connectwise.com/ConnectWise_Sell/800/020/DocuSign#Edit_a_Custom_Template "DocuSign"). 
5. Click **Publish**. 
6. Click **Send Email**. The email is always sent from DocuSign and does not use your email integration. 
7. After the customer approves the quote, an email is sent to the DocuSign account's email address. If you do not select the **Automatically Download DocuSign Approvals** check box during integration setup, navigate to **Quote Setup** and click **Check DocuSign for Approval**.   
8. After you have downloaded the approved quote, click **Win!**.
9. To send the approved quote information to your CRM, click **Update Opportunity**. The signed quote PDF file is attached to your opportunity. 
10. To send over line items, verify that you have selected **Group By Line Item** as the opportunity grouping type. After reviewing the opportunity fields, click **Save**. 
## Resend an Approved Quote

If your customer has already approved a quote with DocuSign and you need to resend the quote, you need to create a new quote by copying the existing one. ConnectWise CPQ (Sell)  cannot invalidate an approved DocuSign quote. You need to invalidate the quote in DocuSign. You cannot delete DocuSign quotes in ConnectWise CPQ (Sell).

To republish a DocuSign quote in ConnectWise CPQ (Sell):

1. Navigate to **Quote Setup**. 
2. Click **Copy Quote**. You can now send this new copied quote to your customer.  
3. The previous quote is locked down and cannot be altered or deleted. You have the option to put your previous quote in a **No Decision** status on the **Win!** screen. However, the quote must be invalidated in DocuSign.   
## SuccessList with DocuSign

Unlike Order Porter, DocuSign quotes do not indicate when a user has viewed a quote. However, you can use SuccessList to keep track of the time it takes to deliver the quote and process the quote approval. The following [SuccessList](https://docs.connectwise.com/ConnectWise_Sell/400 "SuccessList") stages can be used for DocuSign quotes:

| Delivered | This stage tracks the time between quote creation and when the quote is emailed to the customer. This stage activates when the quote is created and is completed when the Send Email button is clicked in the Publish and Deliver tab to send the quote to the customer. |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Win!      | This stage tracks the amount of time between the customer's quote approval and the quote's movement to the status of Won using the Win! tab of a quote. This stage is activated when the customer approves the quote and is completed when the quote is in a Won status. |
