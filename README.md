# ~~Bored~~ of Writing _DML_?? OR ~~Bored~~ of Writing _INSERT_ , _UPDATE_ , _DELETE_? 
##  SAY NO MORE! 
***
# INTRODUCING MYSQL TABLE EDITOR A GUI 
![orgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/23967bda-6c40-434e-ae93-b4ec155bfd9f)
***
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/c2c63d87-27de-40bb-9f37-9e98eb014420)

***
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/a518fdac-4405-4ee6-a9bc-9123530a713f)


***
# THE WHOLE APPLICATION CONSIST OF **3** `SUB-APPLICATIONS` 
# 1._TABLE EDITOR_                         
# 2._AUTHENTICATOR_                    
# 3.[_COMMAND INTERPRETER_](#3command-interpreter)
***
## **Lets Talk About The _TABLE EDITOR?_ SHALL WE?**
***
## THE WHOLE _TABLE EDITOR_ CONSISTS OF `4` ELEMENTS MANLY 
### 1.THE TABLE EDITOR 
![firstorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/747f908f-dda1-4ed1-bea3-bcf2d518dd0f)
***
### 2.REFRESH BUTTON
![secondorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/efd824be-bfaf-450a-9477-14e695e6368b)

***
### 3.DELETE BUTTON
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
## On the `TABLE EDITOR` we can edit the table cell by  ` double clicking a particular cell ` which will intern `updates/inserts` data of the table in the connected database.
![man](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/137d43f1-438b-4ebf-839c-783eb3fcd327)
>[!IMPORTANT]
>THE TABLES LIKE `INFORMATION SCHEMAS` , `METADATA` ** WILL NOT BE UPDATED/INSERTED ** BUT CAN BE EDITED FOR THE USER-END
***
# 2 _REFRESH BUTTON_
## When you click this [button](#2refresh-button) the command executed in the [cui](#4cui) _if the command executed returns any table_ then the particular table will be displayed in the **[TABLE EDITOR](#1the-table-editor)**
***
***
# 3 _COMMAND INTERPRETER_ 
## The [COMMAND INTERPRETER or CUI](#4cui) is an `Command line user interface` for executing all kinds of commands inside a particular **DATABASE** 
>[!IMPORTANT]
>BY DEFAULT THE CUI WILL EXECUTE `select*from<table>;` and if there's any error executing a particular command then when the [refresh](2refresh-button) is pressed the previous command returning a table will be executed this **previous command** can also be `select*from<table>;`
### ABOUT
 The errors returned by mysql will be displayed in the CUI itself.    
 In Order to View the table returned by the executed command the user must click the [refresh](#2refresh-button).   
 ### non sql commands 
 The program current has only one _non-sql-command_ which is `help`.       
 the help command returns few details regarding version of the application, maker, connected table 
 >[!NOTE]
>THE APPLICATION IS NOT RESTRICTED TO ONLY ONE TABLE BUT CAN ALSO BE USED TO INTERACT WITH DIFFERENT TABLES AS FAR AS THEY BELONG TO THE SAME DATABASE
***
*** # 
