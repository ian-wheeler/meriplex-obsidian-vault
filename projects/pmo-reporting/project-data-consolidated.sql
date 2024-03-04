SELECT
p.pm_project_Recid as id
,p.Project_ID AS 'Project'
, ISNULL(UDF.[Action], '(none)') AS [Action]
  , ISNULL(UDF.Technology, '(none)') AS Technology
  , ISNULL(UDF.[REvenue Type], '(none)') AS [Revenue Type]
  , ISNULL(UDF.[Customer Type], '(none)') AS [Customer Type]
  , ISNULL(UDF.[Budget Rating], '(none)') AS [Budget Rating]
  , co.Company_Name AS 'Company'
  , ISNULL (ct.First_Name + ' ' + ct.Last_Name, '(none)') AS Contact
  , ISNULL (pt.Description, '(none)') AS Type
  , ISNULL (pms.Description, '(none)') AS Status
  , ISNULL (pm.First_Name + ' ' + pm.Last_Name, '(none)') AS 'Manager'
  , sb.Board_Name AS 'Project Board'
  , ISNULL (ol.Owner_Level_Name, '(none)') AS 'Location'
  , ISNULL (bu.Description, '(none)') AS 'Department'
  , CAST(p.Date_Start AS DATETIME) AS 'Estimated Start Date'
  , CAST(p.Date_Req AS DATETIME) AS 'Estimated End Date'
  , CAST (CASE
      WHEN CASE
          WHEN DATEDIFF (DAY, p.Date_Start, p.Date_Req) = 0 THEN 0 ELSE CAST (DATEDIFF (DAY, p.Date_Start, te_all.End_Date) AS NUMERIC (11, 2)) / CAST (DATEDIFF (DAY, p.Date_Start, p.Date_Req) AS NUMERIC (11, 2)) 
          END > 1 THEN 1 ELSE CASE
                    WHEN DATEDIFF (DAY, p.Date_Start, p.Date_Req) = 0 THEN 0 ELSE CAST (DATEDIFF (DAY, p.Date_Start, te_all.End_Date) AS NUMERIC (11, 2)) / CAST (DATEDIFF (DAY, p.Date_Start, p.Date_Req) AS NUMERIC (11, 2)) 
                    END
      END AS NUMERIC (9, 2)) AS 'Estimated Percent Complete'
  , CAST(sch.Scheduled_Start AS DATETIME) AS 'Scheduled Start Date'
  , CAST(sch.Scheduled_End AS DATETIME) AS 'Scheduled End Date'
  , CAST (ISNULL (sch.Scheduled_Hours, 0) AS NUMERIC (9, 2)) AS 'Scheduled Hours'
  , CAST (CASE
      WHEN CASE p.Budget_Flag
          WHEN 1 THEN p.Est_Hours
          WHEN 0 THEN sr.Hours_Budget_Sum
          END = 0 THEN 0 ELSE sch.Scheduled_Hours / NULLIF (CASE p.Budget_Flag
                                  WHEN 1 THEN p.Est_Hours
                                  WHEN 0 THEN sr.Hours_Budget_Sum
                                  END, 0) 
      END AS NUMERIC (9, 2)) AS 'Scheduled Percent Complete'
  , CAST(te_all.Start_Date AS DATETIME) AS 'Actual Start Date'
  , CAST(te_all.End_Date AS DATETIME) AS 'Actual End Date'

  -------------------------Merged Fields from another Gauge to this gauge-----------------------------------------------
  
 
  , CAST (ISNULL (te_all.Hours_Actual_SUM, 0) AS NUMERIC (9, 2)) AS 'Actual Hours'
  , CAST (CASE
      WHEN CASE p.Budget_Flag
          WHEN 1 THEN p.Est_Hours
          WHEN 0 THEN sr.Hours_Budget_Sum
          END = 0 THEN 0 ELSE te_all.Hours_Actual_SUM / NULLIF (CASE p.Budget_Flag
                                    WHEN 1 THEN p.Est_Hours
                                    WHEN 0 THEN sr.Hours_Budget_Sum
                                    END, 0) 
      END AS NUMERIC (9, 2)) AS 'Actual Percent Complete'
  ,CAST(p.date_entered_utc AS DATETIME) AS 'Date Project Entered'
  ,CAST(p.date_closed_utc AS DATETIME)  AS 'Date Project Closed'
  , pbm.Description AS 'Billing Method'
  , CAST (ISNULL (p.Billing_Amount, 0) AS NUMERIC (9, 2)) AS 'Billing Amount Rate'
  , CAST (ISNULL (p.Est_Revenue, 0) + ISNULL (p.Est_Product_Revenue, 0) + ISNULL (p.Est_Expense_Revenue, 0) + ISNULL (ph.Addon_Revenue, 0) AS NUMERIC (9, 2)) AS 'Revenue'
  , CAST (ISNULL (bl.Net_Invoice_Amount_SUM, 0) AS NUMERIC (9, 2)) AS 'Total Billed'
  , CAST (ISNULL (bl.Net_Time_Amount_SUM, 0) AS NUMERIC (9, 2)) AS 'Labor Billed'
  , CAST (ISNULL (bl.Misc_Amount_SUM, 0) AS NUMERIC (9, 2)) AS 'Product Billed'
  , CAST (ISNULL (bl.Expense_Amount_SUM, 0) AS NUMERIC (9, 2)) AS 'Expenses Billed'
  , CAST (ISNULL (te_8.Hours_BillXRate_SUM, 0) AS NUMERIC (9, 2)) AS 'Amount WIP'
  , CAST (ISNULL (te_lt_8.Hours_BillXRate_SUM, 0) AS NUMERIC (9, 2)) AS 'Amount Unapproved'
  , CASE p.PM_Billing_Method_ID
     WHEN 'F' THEN (p.Est_Revenue - ISNULL ((bl.Net_Invoice_Amount_SUM) , 0)) 
     WHEN 'A' THEN (p.Est_Revenue - ISNULL ((bl.Net_Invoice_Amount_SUM) , 0) - ISNULL ((te_8.Hours_BillXRate_SUM) , 0)) 
     END AS 'Amount Remaining'
  , CAST (ISNULL (CASE
          WHEN p.Budget_Flag = 1 THEN p.Est_Hours ELSE sr.Hours_Budget_Sum
          END, 0) AS NUMERIC (9, 2)) AS 'Hours Budget'
  , CAST (ISNULL (te_cw.Hours_Invoiced_SUM, 0) AS NUMERIC (9, 2)) AS 'Hours Billed'
  , CAST (ISNULL (te_8.Hours_Bill_SUM, 0) AS NUMERIC (9, 2)) AS 'Hours WIP'
  , CAST (ISNULL (te_lt_8.Hours_Bill_SUM, 0) AS NUMERIC (9, 2)) AS 'Hours Unapproved'
  , CASE
     WHEN ISNULL ((CASE
          WHEN p.Budget_Flag = 1 THEN p.Est_Hours
          WHEN p.Budget_Flag = 0 THEN sr.Hours_Budget_Sum
          END) , 0) < ISNULL (te_cw.Hours_Invoiced_SUM, 0) + ISNULL (te_8.Hours_Bill_SUM, 0) THEN 0 ELSE ISNULL ((CASE
                                                              WHEN p.Budget_Flag = 1 THEN p.Est_Hours
                                                              WHEN p.Budget_Flag = 0 THEN sr.Hours_Budget_Sum
                                                              END) , 0) - ISNULL (te_Cw.Hours_Invoiced_SUM, 0) - ISNULL (te_8.Hours_Bill_SUM, 0) 
     END AS 'Hours Remaining'
  , CAST (ISNULL (te_all.Hours_Invoiced_SUM, 0) AS NUMERIC (9, 2)) AS 'Total Hours'
  , CAST (ISNULL (te_all.Amount, 0) AS NUMERIC (9, 2)) AS 'Total Amount'
  , CAST (ISNULL (te_all.Hours_B, 0) AS NUMERIC (9, 2)) AS 'Total Billable Hours'
  , CAST (ISNULL (te_all.Amount_B, 0) AS NUMERIC (9, 2)) AS 'Total Billable Amount'
  , CAST (ISNULL (te_all.Hours_NB, 0) AS NUMERIC (9, 2)) AS 'Total Non-Billable Hours'
  , CAST (ISNULL (te_all.Amount_NB, 0) AS NUMERIC (9, 2)) AS 'Total Non-Billable Amount'
  , CAST (ISNULL (te_all.Hours_NC, 0) AS NUMERIC (9, 2)) AS 'Total No-Charge Hours'
  , CAST (ISNULL (te_all.Amount_NC, 0) AS NUMERIC (9, 2)) AS 'Total No-Charge Amount'
  , CAST (ISNULL (te_all.Labor_Cost, 0) AS NUMERIC (9, 2)) AS 'Total Labor Cost'
  , CAST (ISNULL (bl.Net_Time_Amount_SUM, 0) - ISNULL (te_all.Labor_Cost, 0) AS NUMERIC (9, 2)) AS 'Project Labor GM Amount'
  , CAST ((ISNULL (bl.Net_Time_Amount_SUM, 0) - ISNULL (te_all.Labor_Cost, 0)) / NULLIF (bl.Net_Time_Amount_SUM, 0) AS NUMERIC (9, 2)) AS 'Project Labor GM Percent'
  , CAST (ISNULL (p.Est_Hours, 0) AS NUMERIC (9, 2)) AS 'Estimated Hours Finance Tab'

  -------------------------Merged Fields from another Gauge to this gauge-----------------------------------------------
  , CAST (ISNULL (sr.Hours_Budget_Sum, 0) AS NUMERIC (9, 2)) AS 'Budget Estimate'
  , CAST (ISNULL (te_all.Hours_Actual_SUM, 0) AS NUMERIC (9, 2)) AS 'Actual Time Entered "Current"'
  , CAST (ISNULL (te_all.Hours_Actual_SUM, 0) AS NUMERIC (9, 2)) - CAST (ISNULL (sr.Hours_Budget_Sum, 0) AS NUMERIC (9, 2)) AS 'Over/Under budget estimate'
  , CASE WHEN CAST (ISNULL (sr.Hours_Budget_Sum, 0) AS NUMERIC (9, 2)) = 0
        THEN NULL  
    ELSE 
        CAST (ISNULL (te_all.Hours_Actual_SUM, 0) AS NUMERIC (9, 2)) / CAST (ISNULL (sr.Hours_Budget_Sum, 0) AS NUMERIC (9, 2)) 
    END AS 'Percent Over/Under Budget'
  
  , CAST (ISNULL (sr.Hours_Budget_Sum, 0) AS NUMERIC (9, 2)) AS 'Estimated Hours Work Plan'
  -----------------------------------------------------------------------------------------------------------------------

  , ISNULL (a.AGR_Name, '(none)') AS 'Agreement'
  , ISNULL (so.Opportunity_Name, '(none)') AS 'Opportunity'
,CAST(p.est_expense_cost AS NUMERIC (9, 2)) AS est_expense_cost
,CAST(p.est_product_cost AS NUMERIC (9, 2)) AS est_product_cost
,CAST(p.est_time_cost AS NUMERIC (9, 2)) AS est_time_cost
,CAST(p.est_expense_revenue AS NUMERIC (9, 2)) AS est_expense_revenue
,CAST(p.est_product_revenue AS NUMERIC (9, 2)) AS est_product_revenue
,CAST(fp.est_time_revenue AS NUMERIC (9, 2))  AS est_time_revenue
,p.pm_project_Recid as project_id
--diverged--
,p.Percent_Complete
,al.agr_type_desc AS agreement_type
,bu.description AS Opportunity_Department --------------------------Added to Project data for Opportunity purposes

--********************************Added to Project data for Date Range purposes****************************************************
,(1-CAST(p.Percent_Complete AS Numeric (9,4))) * CAST (ISNULL (p.Est_Revenue, 0) AS NUMERIC (9, 2)) AS 'Remaining_rev'
,DATEDIFF(Day,p.date_entered_utc,CURRENT_TIMESTAMP) AS 'Age_Days'
,(CASE 
    --WHEN DATEDIFF(Day,p.date_entered_utc,CURRENT_TIMESTAMP) < 16 THEN '000 - 016 days' 
     --WHEN DATEDIFF(Day,p.date_entered_utc,CURRENT_TIMESTAMP) < 31 THEN '016 - 030 Days'
     WHEN DATEDIFF(Day,p.date_entered_utc,CURRENT_TIMESTAMP) < 31 THEN '000 - 030 Days'
     WHEN DATEDIFF(Day,p.date_entered_utc,CURRENT_TIMESTAMP) < 61 THEN '031 - 060 Days'
     WHEN DATEDIFF(Day,p.date_entered_utc,CURRENT_TIMESTAMP) < 91 THEN '061 - 090 Days'
     WHEN DATEDIFF(Day,p.date_entered_utc,CURRENT_TIMESTAMP) < 181 THEN '091 - 180 Days'
     WHEN DATEDIFF(Day,p.date_entered_utc,CURRENT_TIMESTAMP) < 366 THEN '181 - 365 Days'
     ELSE '>365 Days'
     END) AS "Project Age Cat"
,ad_b.Agreement_Rev
,CAST (ISNULL (p.Est_Revenue, 0) + ISNULL (p.Est_Expense_Revenue, 0) + ISNULL (ph.Addon_Revenue, 0) AS NUMERIC (9, 2)) AS 'NRR_rev'
,ad_T.T_MRR AS "Total_MRR"
--***********************************************************************************************************************************

FROM
  PM_Project AS p INNER JOIN
  Company AS co ON p.Company_RecID = co.Company_RecID
      INNER JOIN
  PM_Status AS pms ON p.PM_Status_RecID = pms.PM_Status_RecID
    
--************Added Field definition Tables to pull in 4 fields: Technology, Action, Customer Type*************************
 LEFT JOIN
(SELECT b.PM_Project_RecID,
    MAX(CASE a.User_Defined_Field_RecID
        WHEN 287 THEN b.User_Defined_Field_Value
    END) AS [Action],
    MAX(CASE a.User_Defined_Field_RecID
        WHEN 288 THEN b.User_Defined_Field_Value
    END) AS [Technology],
    MAX(CASE a.User_Defined_Field_RecID
        WHEN 289 THEN b.User_Defined_Field_Value
    END) AS [Revenue Type],
    MAX(CASE a.User_Defined_Field_RecID
        WHEN 290 THEN b.User_Defined_Field_Value
    END) AS [Customer Type],
    MAX(CASE a.User_Defined_Field_RecID
        WHEN 311 THEN b.User_Defined_Field_Value
    END) AS [Budget Rating]
FROM User_Defined_Field a
LEFT JOIN  [dbo].[PM_Project_User_Defined_Field_Value] b ON a.User_Defined_Field_RecID =b.User_Defined_Field_RecID
GROUP BY PM_Project_RecID) UDF
ON p.PM_Project_RecID = UDF.PM_Project_RecID
LEFT JOIN --changed from inner join to left join to get all managers including where they have no contact
  Contact AS ct ON p.contact_recid = ct.Contact_RecID
--****************************************************************************************************************************

 INNER JOIN
  Billing_Unit AS bu ON p.Billing_Unit_RecID = bu.Billing_Unit_RecID
      INNER JOIN
  Owner_Level AS ol ON p.Owner_Level_RecID = ol.Owner_Level_RecID
      INNER JOIN
  SR_Board AS sb ON p.SR_Board_RecID = sb.SR_Board_RecID
      LEFT JOIN
  SO_Opportunity AS so ON p.Opportunity_RecID = so.Opportunity_RecID
      LEFT JOIN
  AGR_Header AS a ON p.AGR_Header_RecID = a.AGR_Header_RecID
      LEFT JOIN
  PM_Type AS pt ON p.PM_Type_RecID = pt.PM_Type_RecID
      LEFT JOIN
  PM_Billing_Method AS pbm ON p.PM_Billing_Method_ID = pbm.PM_Billing_Method_ID
              AND p.Override_Flag = pbm.Override_Flag
      LEFT JOIN
  Member AS pm ON p.Member_ID = pm.Member_ID
      LEFT JOIN
  (SELECT PM_Phase.PM_Project_RecID
      , SUM (coalesce(PM_Phase.est_revenue,0) + coalesce(PM_Phase.Est_Product_Revenue,0)  +coalesce(PM_Phase.Est_Expense_Revenue,0) ) AS Addon_Revenue
    FROM PM_Phase
    WHERE PM_Phase.Add_On_Flag = 1
    GROUP BY PM_Phase.PM_Project_RecID) AS ph ON ph.PM_Project_RecID = p.PM_Project_RecID
      LEFT JOIN
  (SELECT PM_Phase.PM_Project_RecID
      , SUM (SR_Service.Hours_Budget) AS Hours_Budget_Sum
    FROM
      SR_Service INNER JOIN
      PM_Phase ON SR_Service.PM_Phase_RecID = PM_Phase.PM_Phase_RecID
    WHERE PM_Phase.PM_Project_RecID IS NOT NULL
    GROUP BY PM_Phase.PM_Project_RecID) AS sr ON p.PM_Project_RecID = sr.PM_Project_RecID
      LEFT JOIN
  (SELECT PM_Project_RecID
      , SUM (Invoice_Amount - Sales_Tax_Amount) AS Net_Invoice_Amount_SUM
      , SUM (Time_Amount - DownPayment) AS Net_Time_Amount_SUM
      , SUM (Expense_Amount) AS Expense_Amount_SUM
      , SUM (Misc_Amount) AS Misc_Amount_SUM
    FROM Billing_Log
    WHERE (PM_Project_RecID IS NOT NULL) 
    AND (Date_Invoice <= CURRENT_TIMESTAMP) 
    GROUP BY PM_Project_RecID) AS bl ON p.PM_Project_RecID = bl.PM_Project_RecID
      LEFT JOIN
  (SELECT t.PM_Project_RecID
      , MIN (t.Date_Start) AS 'Start_Date'
      , MAX (t.date_start) AS 'End_Date'
      , SUM (t.Hours_Actual) AS 'Hours_Actual_SUM'
      , SUM (t.Hours_Invoiced) AS 'Hours_Invoiced_SUM'
      , SUM (t.Hours_B) AS 'Hours_B'
      , SUM (t.Hours_NC) AS 'Hours_NC'
      , SUM (t.Hours_NB) AS 'Hours_NB'
      , SUM (t.Amount) AS 'Amount'
      , SUM (t.Amount_B) AS 'Amount_B'
      , SUM (t.Amount_NC) AS 'Amount_NC'
      , SUM (t.Amount_NB) AS 'Amount_NB'
      , SUM (t.Labor_Cost) AS 'Labor_Cost'
    FROM (SELECT pm_project_recid
         , Date_Start
         , Hours_Actual
         , Hours_Invoiced
         , CASE
          WHEN Billable_Flag = 1
          AND Invoice_Flag = 1 THEN Hours_Invoiced
          END AS 'Hours_B'
         , CASE
          WHEN Billable_Flag = 0
          AND Invoice_Flag = 1 THEN Hours_Invoiced
          END AS 'Hours_NC'
         , CASE
          WHEN Billable_Flag = 0
          AND Invoice_Flag = 0 THEN Hours_Invoiced
          END AS 'Hours_NB'
         , Hours_Invoiced * Hourly_Rate AS Amount
         , CASE
          WHEN Billable_Flag = 1
          AND Invoice_Flag = 1 THEN Hours_Invoiced * Hourly_Rate
          END AS 'Amount_B'
         , CASE
          WHEN Billable_Flag = 0
          AND Invoice_Flag = 1 THEN Hours_Invoiced * Hourly_Rate
          END AS 'Amount_NC'
         , CASE
          WHEN Billable_Flag = 0
          AND Invoice_Flag = 0 THEN Hours_Invoiced * Hourly_Rate
          END AS 'Amount_NB'
          --, Hours_Actual * dbo.udf_EncrDecr (Hourly_Cost, 'd') AS Labor_Cost   --commented this out to make things work if they don't want labor cost
        , 0 as Labor_Cost   --remove this comment after doing above
      FROM Time_Entry
      WHERE PM_Project_RecID IS NOT NULL) AS t
    GROUP BY t.PM_Project_RecID) AS te_all ON te_all.PM_Project_RecID = p.PM_Project_RecID
      LEFT JOIN
  (SELECT PM_Project_RecID
      , SUM (Hours_Invoiced) AS Hours_Invoiced_SUM
    FROM Time_Entry
    WHERE Billable_Flag = 1
    AND Billing_Log_RecID IS NOT NULL
    AND PM_Project_Recid IS NOT NULL
    GROUP BY PM_Project_RecID) AS te_cw ON te_cw.PM_Project_RecID = p.PM_Project_RecID
      LEFT JOIN
  (SELECT PM_Project_RecID
      , SUM (Hours_Bill) AS Hours_Bill_SUM
      , SUM (Hours_Bill * Hourly_Rate) AS Hours_BillXRate_SUM
    FROM Time_Entry
    WHERE Billable_Flag = 1
    AND Billing_Log_RecID IS NULL
    AND TE_Status_ID < 6
    AND PM_Project_Recid IS NOT NULL
    GROUP BY PM_Project_RecID) AS te_lt_8 ON te_lt_8.PM_Project_RecID = p.PM_Project_RecID
      LEFT JOIN
  (SELECT PM_Project_RecID
      , SUM (Hours_Bill) AS Hours_Bill_SUM
      , SUM (Hours_Bill * Hourly_Rate) AS Hours_BillXRate_SUM
    FROM Time_Entry
    WHERE Billable_Flag = 1
    AND Billing_Log_RecID IS NULL
    AND TE_Status_ID >= 6
    AND PM_Project_Recid IS NOT NULL
    GROUP BY PM_Project_RecID) AS te_8 ON te_8.PM_Project_RecID = p.PM_Project_RecID
      LEFT JOIN
  (SELECT p.PM_Project_RecID
      , MIN (v.Date_Time_Start) AS Scheduled_Start
      , MAX (v.Date_Time_End) AS Scheduled_End
      , ISNULL (SUM (v.Hours_Sched) , 0) AS Scheduled_Hours
    FROM
      PM_Project AS p LEFT JOIN
      PM_Phase AS ph ON ph.PM_Project_RecID = p.PM_Project_RecID
        LEFT JOIN
      SR_Service AS s ON s.PM_Phase_RecID = ph.PM_Phase_RecID
        LEFT JOIN
      v_Schedule_w_Type AS v ON v.Table_Reference = 'sr_service'
                 AND v.RecID = s.SR_Service_RecID
    GROUP BY p.PM_Project_RecID) AS sch ON sch.PM_Project_RecID = p.PM_Project_RecID
LEFT JOIN v_api_collection_project_project AS fp ON fp.PM_Project_RecID = p.PM_Project_RecID
LEFT JOIN v_rpt_agreementlist as al ON al.AGR_Header_RecID = p.AGR_Header_RecID

--************************Added to original project data for date range purposes**************************************
LEFT JOIN 
    (Select ad.Opportunity_RecID
    , SUM(ad.Extended_Price_Amount) As "Agreement_Rev"
    From AGR_Detail as ad
    Left Join 
        (Select AGR_Detail_RecID
        , AGR_Detail_User_Defined_Field_Value_RecID
        , User_Defined_Field_RecID
        , User_Defined_Field_Value
        From AGR_Detail_User_Defined_Field_Value
        Where User_Defined_Field_RecID = 97) as udfv on udfv.AGR_Detail_RecID = ad.AGR_Detail_RecID
    Left Join 
        (Select AGR_Detail_RecID
        , AGR_Detail_User_Defined_Field_Value_RecID
        , User_Defined_Field_RecID
        , User_Defined_Field_Value
        From AGR_Detail_User_Defined_Field_Value
        Where User_Defined_Field_RecID = 130) as udfv1 on udfv1.AGR_Detail_RecID = ad.AGR_Detail_RecID
    Where (udfv.User_Defined_Field_Value <> 'true' OR udfv.User_Defined_Field_Value IS NULL)
    AND(udfv1.User_Defined_Field_Value IS NULL OR udfv1.User_Defined_Field_Value <> 'true')
    Group By ad.Opportunity_RecID) as ad_b ON ad_b.Opportunity_RecID = p.Opportunity_RecID
LEFT JOIN 
    (Select ad2.Opportunity_RecID
    , SUM(ad2.Extended_Price_Amount) As "T_MRR"
    From AGR_Detail as ad2
    Group By ad2.Opportunity_RecID) as ad_T ON ad_T.Opportunity_RecID = p.Opportunity_RecID
WHERE 
DATEADD (Month, -36 , CURRENT_TIMESTAMP) <= p.Date_Start-------------------------Where condition specific to original project data qry
GO