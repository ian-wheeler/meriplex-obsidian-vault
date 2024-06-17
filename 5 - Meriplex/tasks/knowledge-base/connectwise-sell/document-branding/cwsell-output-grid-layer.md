# Output Grid Layout Editor Overview
---
The Output Grid Layout Editor lets you create custom layouts on the Order Porter™ page and quote PDF. You can select which layouts are active, copy layouts and delete layouts on this screen. Use the Preview button when editing a layout to quickly see how the layout looks on a quote. You must have administrator permissions to access the Output Grid Layout Editor. For field definitions, refer to [Hidden Fields](https://docs.connectwise.com/ConnectWise_Sell/050/030 "https://docs.connectwise.com/ConnectWise_Sell/050/030"). 

To select an active layout for your quote content tab on the Prepare Content screen, navigate to the [Tab Details](https://docs.connectwise.com/ConnectWise_Sell/300/030/010/200/030 "Tab Details") screen. 

**Important:** Output Grid Layouts only customize 2018 and newer quote forms downloaded from the Content Vault in ConnectWise CPQ (Sell). Older quote forms do not work with layouts. For information on downloading 2018 and newer quote forms and attaching them to your quotes, refer to [Search the Content Vault](https://docs.connectwise.com/ConnectWise_Sell/800/040#Search_the_Content_Vault "Output Grid Layout Editor") and [Publish and Deliver](https://docs.connectwise.com/ConnectWise_Sell/300/050/010 "Output Grid Layout Editor"). 

**Important:** The Output Grid Layout Editor does not customize your product grid layout that your sales team sees in Prepare Content; only the layout of the Order Porter page and quote PDF. You can customize your product grid layouts on the [Prepare Content screen](https://docs.connectwise.com/ConnectWise_Sell/300/030/010 "https://docs.connectwise.com/ConnectWise_Sell/300/030/010").

To locate this screen navigate to **Settings > Document Branding > Output Grid Layout Editor**.
## Business Case
---
John, the Sales Manager, wants to display the discount amount on the Order Porter when customers receive a promotional deal. He uses the Output Grid Layout to add a custom discount layout that his sales team can select whenever the quote contains a special deal. The custom layout enables sales representatives to easily display a discount column, providing additional information for customers approving their quote in the Order Porter.
## Field Descriptions
---
See the `Output Grid Layout Field Desc.` sheet in the document linked below to view output grid layout field descriptions.

![[cwsell-orderporter-matrix.xlsx]]
## How to Create a Layout
---
Follow the steps below to create a grid layout. Your layouts are stored in the Output Grid Layout Editor and are available in the Output Grid Layout drop-down menu on your quotes. Refer to [How to Select a Layout](https://docs.connectwise.com/ConnectWise_Sell/800/020/030#How_to_Select_a_Layout "Output Grid Layout Editor") for more information. 

1. Navigate to **Settings** > **Document Branding** > **Output Grid Layout Editor**. 
2. Click **Add**. 
3. Enter a label in the **Layout Name** field. 
4. Select the **Active** check box to make this layout display in the **Output Grid Layout** drop-down.   
5. If you want to add a column to your grid layout, enter the field name in the search filter. For example, you can enter Recurring to display all recurring columns.   
6. Select the check box next to the column you want to add. The column immediately appears at the end of the grid. 
7. If you want to remove a column, deselect the check box next to the field name. 
8. Adjust your columns width as desired by hovering your cursor between columns until the arrow cursor displays.
9. Click and drag to change the width.  
10. To change the order of how the columns display, hover your cursor over the double arrow icon until the hand icon displays. 
11. Click and drag to move the column.   
12. Click into a column name to quickly rename it. The original label will display in the parenthesis below. You can revert the label back to the original by re-typing the original label.   
13. Click **Save and Close**.
14. Navigate to **Settings** > **Order Porter Setup** > **Upload Metadata** and click **Submit**. You can [preview your layout](https://docs.connectwise.com/ConnectWise_Sell/800/020/030#How_to_Preview_a_Layout "Output Grid Layout Editor") to get an idea of what it looks like.
### How to Create an Output Grid Layout
[How to Create an Output Grid Layout - YouTube](https://www.youtube.com/watch?v=OGUkVVs6BfM)
## How to Preview a Layout
---
1. Create a layout or click the **Edit** icon to preview an existing layout. 
2. Click **Preview**.   
3. Select the quote form you want to preview your layout on.  
4. Determine how many decimal places are used to display fake quote prices by selecting values in the **Digits left of decimal point** and **Digits right of decimal point** drop-down. You also have the option to use a real quote to preview you layout. Skip to step 5 if you would like to choose this option. 
5. Type in an existing quote number. The preview will not affect the actual quote but use the existing quote to create a preview only. 
6. Click **Generate Preview PDF**. 
7. Click the PDF link. A new tab opens in your browser displaying the quote preview.
## How to Select a Layout
---
After you have created a layout in the Output Grid Layout Editor, follow the steps below. 

**Important:** The layout must be active in order to display on the Tab Details screen. 

1. In a quote, navigate to the **Prepare Content** tab. 
2. Click the **Actions** arrow icon and select **Edit Tab**.   
3. Select a layout in the **Output Grid Layout** drop-down.   
4. Click **Save**. 