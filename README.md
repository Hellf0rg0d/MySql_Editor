# ~~Bored~~ of Writing _DML_?? OR ~~Bored~~ of Writing _INSERT_ , _UPDATE_ , _DELETE_? 
##  SAY NO MORE! 
***
# INTRODUCING MYSQL TABLE EDITOR A GUI 
![orgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/23967bda-6c40-434e-ae93-b4ec155bfd9f)
***
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/c2c63d87-27de-40bb-9f37-9e98eb014420)

***
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/a518fdac-4405-4ee6-a9bc-9123530a713f)

>[!IMPORTANT]
>THE USER **MUST HAVE** MYSQL SERVER 8.0 OR LATER WITH AUTHENTICATION PROTOCOL ENABLED AND INSTALLED ON THE DEVICE ON WHICH THIS APPLICATION IS TO BE USED
***
# THE WHOLE APPLICATION CONSIST OF **3** `SUB-APPLICATIONS` 
# 1.[_TABLE EDITOR_](#1-the-table-editor)                        
# 2.[_AUTHENTICATOR_](#the-authenticator)                  
# 3.[_COMMAND INTERPRETER_](#4-command-interpreter)
***
## **Lets Talk About The _TABLE EDITOR?_ SHALL WE?**
***
## THE WHOLE _TABLE EDITOR_ CONSISTS OF `4` ELEMENTS MAINLY 
### 1.THE TABLE EDITOR
![firstorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/747f908f-dda1-4ed1-bea3-bcf2d518dd0f)
***
### 2.[REFRESH BUTTON](#2-refresh-button)
![secondorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/efd824be-bfaf-450a-9477-14e695e6368b)

***
### 3.[DELETE BUTTON](#3-delete-button)
![thirdorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/e3101223-203f-4b10-ad11-e89469981d0b)
***
### 4.CUI
![fourthorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/885d58be-131e-4c8d-a2c5-d165a8daf16c)
***
***
# 1 _THE TABLE EDITOR_ 
## THE [TABLE EDITOR](#1the-table-editor) Displays the tables returned by executing the commands in the [cui](#4cui).
>[!NOTE]
>It Displays All kind of tables.
## On the `TABLE EDITOR` we can edit the table cell by  ` double clicking a particular cell ` which will execute ` updates/inserts ` statements on the data of the table in the connected database.
## The Edited Data Of The Cell Can Be Saved by Pressing ` enter ` Key Or ` tab ` Key.
![man](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/137d43f1-438b-4ebf-839c-783eb3fcd327)
>[!IMPORTANT]
>THE TABLES LIKE `INFORMATION SCHEMAS` , `METADATA` ** WILL NOT BE UPDATED/INSERTED ** BUT CAN BE EDITED FOR THE USER-END
***
# 2 _REFRESH BUTTON_
## When you click this [button](#2refresh-button) the command executed in the [cui](#4cui) _if the command executed returns any table_ then the particular table will be displayed in the **[TABLE EDITOR](#1the-table-editor)**
***
# 3 _DELETE BUTTON_
## When you click this [button](#3delete-button) the Application will delete the selected *row* and refreshes itself.
>[!WARNING]
>IF THE SELECTED ROW HAS A RECURRING VALUE/S THE IT'S BETTER TO DELETE THE ROW BY USING THE COMMAND TO DELETE THE REQUIRED ROW

***
***
# 4 _COMMAND INTERPRETER_ 
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/a518fdac-4405-4ee6-a9bc-9123530a713f)
## The [COMMAND INTERPRETER or CUI](#4cui) is an `Command line user interface` for executing **_all kinds_** of commands inside a particular **DATABASE** 
>[!IMPORTANT]
>BY DEFAULT THE CUI WILL EXECUTE `select*from<table>;` and if there's any error executing a particular command then when the [refresh](#2refresh-button) is pressed the previous command returning a table will be executed this **previous command** can also be `select*from<table>;`
### ABOUT
 The errors returned by mysql will be displayed in the CUI itself.    
 In Order to View the table returned by the executed command the user must click the [refresh](#2refresh-button).   
 ### non sql commands 
 The program current has only one _non-sql-command_ which is `help`.       
 the help command returns few details regarding version of the application, maker, connected table 
 >[!NOTE]
>THE APPLICATION IS NOT RESTRICTED TO ONLY ONE TABLE BUT CAN ALSO BE USED TO INTERACT WITH DIFFERENT TABLES AS FAR AS THEY BELONG TO THE SAME DATABASE
***
*** 
# _THE AUTHENTICATOR_ 
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/c2c63d87-27de-40bb-9f37-9e98eb014420)
## The Authenticator Consists of 4 TextFields        
+ "DB name" has to be filled with the required **DATABASE**
+ "Table Name" has to be filled with the required **TABLE**
+ "User" has to be filled with the required **USER NAME**
+ "PassWord" has to be filled with the required **PASSWORD** For the Username
  ***
# SEND ME THE FEEDBACKS/BUGS/REPORTS ABOUT THIS APPLICATION HERE - nhmkar@gmail.com.
# STAY TUNED FOR FUTURE UPDATES/FIXES.
