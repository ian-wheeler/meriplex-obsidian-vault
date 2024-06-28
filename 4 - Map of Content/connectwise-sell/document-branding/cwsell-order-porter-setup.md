# Order Porter Setup Overview
---
The Order Porter Setup pod under Settings enables you to configure various Order Porter™ settings such as branding, email, Win! tab settings, payment processing and other advanced settings. Refer to [Order Porter Templates](https://docs.connectwise.com/ConnectWise_Sell/800/020/020 "Order Porter Templates"), [Order Porter Overview](https://docs.connectwise.com/ConnectWise_Sell/300/050/100/005 "Order Porter Overview") and the [Interactive Order Porter web page](https://university.connectwise.com/university/content/Documents/Sell/sell-accordion-interactive.html "https://university.connectwise.com/university/content/Documents/Sell/sell-accordion-interactive.html") for more information.

**Note:** You must have Administrator permissions to access Order Porter Setup. 

**Tip:** To locate this screen navigate to **Settings > Document Branding > Order Porter Setup**.
## Resources
---
[Order Porter Setup - ConnectWise](https://docs.connectwise.com/ConnectWise_Sell/800/020/010)
[Document Branding - ConnectWise](https://docs.connectwise.com/ConnectWise_Sell/800/020)
[Order Porter Templates - ConnectWise](https://docs.connectwise.com/ConnectWise_Sell/800/020/020)
[Changing the Time Zone for Order Porter Time Stamps - ConnectWise](https://docs.connectwise.com/ConnectWise_Sell/800/020/020/Changing_the_Time_Zone_for_Order_Porter_Time_Stamps)
[Custom Email Subjects for Order Porter Visited and Approved Email Messages - ConnectWise](https://docs.connectwise.com/ConnectWise_Sell/800/020/020/Custom_Email_Subjects_for_Order_Porter_Visited_and_Approved_Email_Messages)
[Output Grid Layout Editor - ConnectWise](https://docs.connectwise.com/ConnectWise_Sell/800/020/030)
[Common Order Porter Template Modifications - ConnectWise](https://docs.connectwise.com/ConnectWise_Sell/800/020/Common_Order_Porter_Template_Modifications)
[DocuSign - ConnectWise](https://docs.connectwise.com/ConnectWise_Sell/800/020/DocuSign)
[Order Porter Templates Overview - ConnectWise](https://docs.connectwise.com/ConnectWise_Sell/800/020/Order_Porter_Templates_Overview)
## Basic Branding
---
Order Porter Basic Branding defines the HTML colors on the Sell Accordion, Sell Fundamentals, Sell Reorder, and Sell request Order Porter templates (2013 or later) when using the Default Order Porter style. You can quickly modify template colors without having to edit the template code when using this combination of template and Order Porter style.

**Tip:** If you want to modify your company logo or the Order Porter visual style, learn more at [Order Porter ConnectWise Sell Accordion Template](https://docs.connectwise.com/ConnectWise_Sell/300/050/100/020 "Order Porter ConnectWise Sell Accordion Template"). 

**Note:** HTML colors can also be applied to a legacy Order Porter template titled Quosal Branded or Sell Branded. However, these legacy templates are no longer available in the Content Vault.
## Field Descriptions
---
![[cwsell-orderporter-matrix.xlsx]]
## Change Order Porter Colors
---
Follow the steps below to change the Order Porter HTML colors for the Default theme. Other Order Porter themes are not affected by colors set in Basic Branding. 

1. Navigate to **Settings** > **Document Branding** > **Order Porter Setup** > **Basic Branding**.
2. Make any changes by entering a hexadecimal code for each color. Click **Save**.
3. Navigate to **Settings** > **Document Branding** > **Order Porter Setup** > **Upload Metadata**. Select all the checkboxes. You must upload all metadata for color changes to apply. 
4. Click **Submit**. Uploading metadata may take several minutes. 
5. In a CPQ quote, navigate to **Quote Setup**. 
6. Click the **MORE** drop-down and select **Edit Publish Settings**. 
7. In the **Order Porter Style** drop-down, select **Default**. This tells CPQ to use the colors in the Order Porter Basic Branding screen. 
8. In the **Order Porter Template** drop-down, select the **Sell Accordion**, **Sell Fundamentals**, **Sell Reorder**, or **Sell Request** template. 
9. Click **Save**. 
10. Navigate to **Publish and Deliver** to preview your template. Click **Save Changes** to generate a preview. 
11. Click the quote preview link to view the Order Porter page. You may also want to test the Link HTML Color by creating a test quote that you can approve and receive Order Porter approved emails.
12. If you like the look of the Order Porter page, set your quote template with the desired publish settings for future quotes. In a [Sell quote template](https://docs.connectwise.com/ConnectWise_Sell/800/050/050 "Edit Quote Templates"), navigate to **Publish Settings**. 
13. In the **Order Porter Style** drop-down, select **Default**. 
14. In the **Order Porter Template** drop-down, select the **Sell Accordion**, **Sell Fundamentals**, **Sell Reorder**, or **Sell Request** template. 
15. Click **Save**.
## Setup Email
---
Follow the instructions on the `Setup Email` sheet in the document linked below to set up your Order Porter email settings. These settings determine the various settings visible to your clients when they receive PDFs through Order Porter.

**Note:** Custom SMTP Server setup is not available in Sell Basic.

![[cwsell-orderporter-matrix.xlsx]]
## Change the Subject of the Send Email
---
1. Navigate to **Settings** > **Document Branding** > **Order Porter Setup** > **Setup Email**.
2. Enter your new email subject in the Email Subject field. This field can accept dynamic tags in the following format: `#Attribute.Detail`. For example, you can enter the following tag Quote `##Quote.PrintedquoteReadableID#Quote.Quote Name` and it will pull this information from the quote and enter it in this field. 
3. Click **Save**.
## Set Up Custom SMTP Server for Order Porter Emails
---
**Note:** Custom SMTP Server setup is not available in Sell Basic. 

CPQ's Order Porter Service sends two different types of email communications.

- Order Porter visits - sent only to you.
- Order Porter approvals - sent to the customer and to you.

By default, the orders come from SellOrders@ConnectWise.com, an email server provided by CPQ as a part of the Order Porter service. No other email addresses are allowed on the Order Porter email server.  If you want to have these emails sent by your own email server, you can configure your own SMTP server by following the steps below. For details on how you can set up your email server to send email on the Publish and Deliver tab, refer to [Use Your SMTP Relay When Sending Email](https://docs.connectwise.com/ConnectWise_Sell/800/070/005#Use_Your_SMTP_Relay_When_Sending_Email "https://docs.connectwise.com/ConnectWise_Sell/800/070/005#Use_Your_SMTP_Relay_When_Sending_Email").

**Important:** If you are using Office 365, do not use any of the following characters in your password:

- Question Mark (?)
- Forward Slash (/)

**Warning:** CPQ does not provide support or assistance for this reconfiguration. We recommend that you only attempt this reconfiguration if you have expertise with email configuration and full and proper access to all of your email and network infrastructure. Properly configuring and testing email relay can involve reconfiguring firewall rules, reconfiguring your email services to provide for the relay, and can involve security risks if not configured properly. CPQ does not provide these services or have the requisite levels of expertise with the various email systems, firewall controls, and other infrastructures necessary to properly assist you.    

You must grant permissions to the following IP addresses on your SMTP server and firewall to relay Order Porter emails. If this is not set, then the Order Porter emails will not be sent out.

- [www.orderporter.com](https://nam02.safelinks.protection.outlook.com/?url=http%3A%2F%2Fwww.orderporter.com%2F&data=04%7C01%7Cuserdocs%40ConnectWise.com%7C1edb4f1558bc41cec55b08d89df99f83%7Cf2ddb62f83354cc99886175b834e4bf3%7C0%7C0%7C637433042736333187%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=h5OAoGsL%2B%2FjA5NntZTG2G2L3aYhemjatuVZi9Notewg%3D&reserved=0): 40.71.90.166 and 40.114.52.148
- Australia distributed: 13.70.91.208 and 13.75.178.225
- Europe distributed: 52.178.181.175 and 40.69.194.171
- NA1(US East) distributed: 40.71.89.108 and 40.114.54.41
- NA2(US West) distributed: 168.62.213.148 and 23.99.61.241

1. Navigate to **Settings** > **Document Branding** > **Order Porter Setup** > **Setup Email**.
2. Select the **Use Custom SMTP Server** check box.
3. Enter the **SMTP Host**, **SMTP Port**, **SMTP Username**, **SMTP Password** and **SMTP From Email Address**. Refer to the [Setup Email](https://docs.connectwise.com/ConnectWise_Sell/800/020/010#Setup_Email "Order Porter Setup") table for additional field descriptions. 

**Note:** If you are using Exchange for delivering email, the **SMTP Username** must have proper send and receive permissions in Exchange, and you must use the following format for the server: `https://your-exchange-server-host/ews/exchange.asmx`

**Note:** If you are using Office 365, use the following format for the server: `https://outlook.office365.com/ews/exchange.asmx`

4. If you are using SSL (Secure Sockets Layer) SSL then select the **Use SSL** check box. SSL may require a security certificate on your SMTP server.
5. Click **Test Email** to test the settings. 
6. Enter the **From** and **To** addresses for the test email and click **OK**. If the test fails, then verify the settings in the **Order Porter Email Settings** pod. 
7. Click **Save**.
## Win! Tab Settings
---
The Win! Tab Settings require that a purchase order number is entered before winning a quote.

1. Navigate to **Settings** > **Document Branding** > **Order Porter Setup** > **Win! Tab Settings**.
2. Select the **Require Purchase Order Number** check box to require a purchase order number to be entered on the Order Porter form before a quote can be won.
3. Click **Save**.
## Payment Processing
---
Order Porter payment processing settings can be stored for [ConnectBooster®](https://docs.connectwise.com/ConnectWise_Sell/800/020/010/Payment_Processors/ConnectBooster_BNG_Payments "ConnectBooster BNG Payments"), [Authorize.net™](https://docs.connectwise.com/ConnectWise_Sell/800/020/010/Payment_Processors/Other_Payments%3A_PayPal_Payflow_and_Authorize.net#Authorize.net_Field_Descriptions "ConnectWise_Sell/800/020/010/Payment_Processors/Other_Payments%3A_PayPal_Payflow_and_Authorize.net"), [WisePay](https://docs.connectwise.com/ConnectWise_Sell/800/020/010/Payment_Processors/WisePay_Payments "WisePay Payments"), and [PayPal Payflow™](https://docs.connectwise.com/ConnectWise_Sell/800/020/010/Payment_Processors/Other_Payments%3A_PayPal_Payflow_and_Authorize.net#PayPal_Payflow_Field_Descriptions "Other Payments: PayPal Payflow and Authorize.net"). Navigate to **Settings** > **Document Branding** > **Order** **Porter Setup** to set up your preferred payment processing so your customers can pay with a credit card directly from the Order Porter page. Refer to [Payment Processors](https://docs.connectwise.com/ConnectWise_Sell/800/020/010/Payment_Processors "Payment Processors") for more information and steps to integrate your account with CPQ. 

**Note:** Payment Processing is not available in Sell Basic and Sell Standard. 

**Note:** You must have a PayPal Payflow Pro account to integrate Paypal Payflow with CPQ. 

**Important:** A green checkmark icon will display next to the payment method in the Win! tab of a quote except when there is an error with the transaction. 

**Note:** When your customer purchases optional items and pays using payment processing on Order Porter, they must select Update Options in order for the payment to process. You can re-publish the quote if your customer needs to resubmit their payment.
## Advanced Settings
---
### Order Porter Advanced Settings
Follow the instructions on the `Order Porter Advanced Settings` sheet in the document linked below to set up Order Porter Advanced Settings. You can set up PDF approval, tax, and opportunity status for approved Order Porters.

![[cwsell-orderporter-matrix.xlsx]]
### Display All Active Quotes on Order Porter
When your customer has received multiple quotes from you but has not approved them, all their active, unapproved quotes display on the Order Porter page so they can easily view and approve all outstanding quotes. Quote status displays in the Quote Status field on the [Quote Setup](https://docs.connectwise.com/ConnectWise_Sell/300/020/010 "Quote Setup Screen") screen. To enable active quotes to display on the Order Porter page, select the Show Active Quotes check box in the [Order Porter Advanced Settings pod](https://docs.connectwise.com/ConnectWise_Sell/800/020/010#Advanced_Settings "Order Porter Setup"), then [upload metadata](https://docs.connectwise.com/ConnectWise_Sell/800/020/010#How_to_Upload_Metadata "Order Porter Setup"). 

The following quotes do not display on the Order Porter page:

- Expired quotes. 
- Quotes that were not published and sent in an Active status. If the quote does not display, republish and send the quote while it's in an Active status. 
- Approved quotes.
## Upload Metadata
---
See the `Upload Metadata Field Desc.` sheet in the document linked below to set up Order Porter Advanced Settings. You can set up PDF approval, tax, and opportunity status for approved Order Porters.

![[cwsell-orderporter-matrix.xlsx]]
### How to Upload Metadata
1. Navigate to **Settings** > **Document Branding** > **Order Porter Setup** > **Metadata**.
2. Select the check box next to areas of CPQ that were updated. You can also select all check boxes if you are not sure when you uploaded metadata last or are not sure which area was updated. 
3.  Click **Submit**.