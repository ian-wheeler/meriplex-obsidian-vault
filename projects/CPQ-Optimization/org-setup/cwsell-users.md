# Users Overview
---
The Users screen displays all active and inactive members. Administrators can manage user permissions and access to different areas of ConnectWise CPQ™ (Sell), including Electronic Orders. It also provides the option to edit existing member profiles. Consult the [Permissions Matrix](https://university.connectwise.com/university/pageview.aspx?short_name=sell-permission-matrix "https://university.connectwise.com/university/pageview.aspx?short_name=sell-permission-matrix") for help configuring user settings.

**Important:** The Users screen is Administrator-only. Non-administrators can access the [My User](https://docs.connectwise.com/ConnectWise_Sell/800/010/010 "My User") screen to update their user settings.

**Warning:** Do not delete the member QuosalAdmin from the Active Users list. This is the member that enables Support to troubleshoot and perform mandatory updates.

**Tip:** To locate this screen navigate to **Settings > Organization Setup > Users.**
## ConnectWise Sell - User Permissions Matrix
---
![[cwsell-users-matrix.xlsx]]
## Resources
---
[Users - ConnectWise](https://docs.connectwise.com/@go/path/setupusers)
[Users List - ConnectWise CPQ](https://meriplex.quosalsell.com/QuosalWeb/adminuserslist.quosalweb?accesskey=meriplex_azure&datatheme=a&skin=quosal)
[Onboarding a New User](https://university.connectwise.com/university/pageview.aspx?short_name=onboarding-a-new-user-blueprints-connectwise-sell&_gl=1*1ijnj88*_ga*MTQ3NTU1ODI1Mi4xNjk3NTc4NzIw*_ga_J034RPY1DQ*MTcxMTQ4MjU3OC40MC4xLjE3MTE0ODY2MDcuMC4wLjA.#)
[Configuring New Users for Sell (CPQ)](https://university.connectwise.com/university/training/videolibrary.aspx?CourseID=3362)
[How to Add a User Video](https://university.connectwise.com/University/training/videolibrary.aspx?CourseID=1343)
[ConnectWise SSO Setup Documentation](https://docs.connectwise.com/ConnectWise_Sell/800/010/040/SSO_Setup_for_ConnectWise_CPQ#Set_Up_SSO_For_Your_User_Account)
[How to Add PSA Credentials to a CPQ User](https://university.connectwise.com/University/training/videolibrary.aspx?CourseID=1832)
[CRM Integration Documentation](https://docs.connectwise.com/ConnectWise_Sell/800/030)
[How To Add Manage Credentials to a Sell User](https://docs.connectwise.com/ConnectWise_Sell/800/070/005)
[Teams Documentation](https://docs.connectwise.com/ConnectWise_Sell/800/010/030)
[Multi-Level Approvals Partner Kit](https://university.connectwise.com/university/pageview.aspx?short_name=multi-level-approvals-partner-kit)
[ConnectWise Home User and Application Settings Documentation](https://docs.connectwise.com/ConnectWise_Unified_Product/ConnectWise_Home/040)
[PSA | University Admin Overview](https://university.connectwise.com/University/training/videolibrary.aspx?CourseID=963)
[Assigning University Coursework Documentation](https://docs.connectwise.com/ConnectWise_Documentation/001/100/ConnectWise_University/Using_the_ConnectWise_University/030)
## Onboarding a New User
---
### 1. Configure User Access
When adding a new user to ConnectWise CPQ, the first step is to configure their user page. Details like login credentials and contact information enable access to the application and determine how user details are presented to the customer when creating quotes. This screen is also where you configure security settings that control what actions the user can take within ConnectWise CPQ.

To grant seamless access to not only ConnectWise CPQ but also other products and services through ConnectWise Home, we recommend also completing the ConnectWise SSO user setup.
#### CPQ User Setup
1. Navigate to Settings > Organization Setup > Users.
2. Click Add.
3. Enter details for the user, including user name, first name, last name, presented name, job title, email address, picture, and time zone.
4. On the left of the screen, review and select checkboxes to assign the appropriate security access. Refer to the [CPQ Permission Matrix](https://university.connectwise.com/university/pageview.aspx?short_name=sell-permission-matrix) for additional details.
5. Click Save.
6. Enter a New Password, Confirm New Password, and then click Change Password.  
    **Note:** Use the Impersonate User button at the top right of the screen to test security settings applied to a user. To end the impersonation session, click the user avatar at the top right corner of the screen and select End Impersonation from the drop-down menu.
#### Optional: ConnectWise SSO User Setup
1. From CPQ, navigate to the Company screen under Settings > Organization Setup.
2. Click the SUBMIT USERS button.
3. Click the Register a setup token from the ConnectWise Home URL link.
4. From the ConnectWise Home Products tab, click Generate Token.
5. Click Copy and then return to the CPQ Company screen.
6. Paste the token in the Register flyout and click SUBMIT, then OK.
7. In the ConnectWise Home Imported Users tab, click the checkbox beside the new user’s name and then click the Approve check mark icon at the top.
8. Select your desired login method from the drop-down and then click Approve.  
    **Note:** This action sends an email to the user allowing them to create their own password for ConnectWise Home. This password is used to access ConnectWise Home features and the ConnectWise University.
9. From the Users & Application Settings screen in ConnectWise Home, check the box for the new user and then grant them access to the CPQ (Sell) application through USER SETTINGS > Permissions > Application Access.

### 2. Connect CPQ and CRM Accounts
Now that the user has access to CPQ, it’s time to connect that user account to your CRM tool. Configuring the CRM integration for a user in CPQ allows them to access the customers, opportunities, and products stored in your CRM database. This configuration is critical, as it enables the user to quickly build quotes from CRM records and allows CPQ to update CRM records throughout the sales cycle.
### Steps
1. Navigate to Settings > Organization Setup > Users.
2. Click the Edit icon next to the User Name.
3. Click Impersonate User.
4. Navigate to Settings > CRM Integration > Manage Credentials (if using ConnectWise PSA).  
    **Note:** The name of the credential screen depends on the provider selected in the Settings > CRM Integration > CRM Provider screen. These exact steps may differ depending on your CRM. Refer to the [CRM Integration](https://docs.connectwise.com/ConnectWise_Sell/800/030) documentation for specific instructions.
5. Enter the users PSA credentials and then click Check Login.
6. Click Save.
7. Click the user avatar in the top right corner of the screen and select End Impersonation from the drop-down menu.

### 3. Enable Sending Quotes
Configuring the Email Server screen per user allows ConnectWise CPQ to send emails on the users’ behalf. This is primarily used to ensure successful delivery of quotes to customers.

To ensure that only high-quality quotes are delivered to your customers, we recommend assigning the sales rep to a sales team, which controls the quote templates available to the user, and establishing an approval rule to funnel their quotes to the appropriate resource for review before sending.
### Steps
#### Email Integration Setup
1. Navigate to Settings > Organization Setup > Users.
2. Click the Edit icon next to the User Name.
3. Click Impersonate User.
4. Navigate to Settings > Workflow Integrations > Email Server.
5. Enter the user specific details into the configuration pod for your email provider.  
    **Note:** These exact steps may differ depending on your email provider. Refer to the [Email Server](https://docs.connectwise.com/ConnectWise_Sell/800/070/005) documentation for specific instructions.
6. Select the Use [email provider name] checkbox.
7. Click Save.
8. Click Test Email.
9. Click the user avatar at the top right corner of the screen and select End Impersonation from the drop-down menu.
#### Optional: Sales Team Assignment
1. Navigate to Settings > Organization Setup > Users.
2. Click the Edit icon next to the User Name.
3. Select the team name from the Team Profile drop-down.
4. Click Save.  
    **Note:** Team settings, like available quote templates, can be edited from the Settings > Organization Setup > Teams screen.
#### Optional: Quote Approval Setup
1. Navigate to Settings > Approvals > Rules.
2. Scroll to the Rules Shortcuts pod.
3. Select the individual’s User Name in the When created by drop-down.
4. Click CREATE to generate the rule. This adds a new rule to the list called “Review [User Name].”
5. Select the Edit icon beside the new rule.
6. Edit settings to select the individual or team responsible for reviewing and approving the quotes created by this user.
7. Click SAVE.  
    **Note:** To use this feature, you must have the Multi-Level Quote Approval Mode selected in Settings > Approvals > Setup.

### 4. Confirm University Access
Now that your new team member is ready to use CPQ, it’s critical to help them get the most out of it! The ConnectWise University contains documentation, short how-to videos, process blueprints (like this one) and more to help support their learning. We highly recommend exposing new CPQ users to the [Paths to Product Proficiency: Sales and Marketing](https://university.connectwise.com/university/pageview.aspx?short_name=paths-to-product-proficiency-sales-and-marketing#sales_rep) Sales Representative track, which covers product features and processes that are critical to their success.

Additionally, the University contains product-specific degrees made up of lessons to help them master product features. We recommend assigning a degree to new users, which allows you to track their progress through the coursework and supplement any on-the-job training your organization provides.
### Steps
#### University Access
1. Navigate to home.connectwise.com.
2. Log in and then navigate to the Users & Application Settings screen.
3. Select the user you wish to grant access to the university.
4. From the user profile flyout, review the Connected App Access section and ensure the University is listed.
5. Click Save.
#### Optional: Assign Coursework
1. Navigate to ConnectWise.com/University and log in.
2. Expand the Education drop-down and select Train Your Team.
3. Search for and select the user.
4. Select CPQ (Sell) from the drop-down under Assign By ConnectWise Product.
5. Select the checkbox beside the appropriate degree based on the user role.
6. Enter a date in the Due Date field.
7. Click Email.
8. Review the email content and click Send.