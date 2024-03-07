# ~~Bored~~ of Writing _DML_?? OR ~~Bored~~ of Writing _INSERT_ , _UPDATE_ , _DELETE_? 
##  SAY NO MORE! 
***
# INTRODUCING MYSQL TABLE EDITOR A GUI 
![orgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/cc1358cc-8551-45f2-9684-e80e8c4a7dab)

***
![tempimg](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/de1529e4-931d-4102-9b8f-6411992a9e9e)

***
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/9d6691db-99fb-4891-9b48-7636055f5b70)

***
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/dcdb3405-fc1f-45a7-8910-480d86fc6cda)

***
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/2437be8f-7e6b-4057-9042-c072d19b4dc2)

>[!IMPORTANT]
>THE USER **MUST HAVE** MYSQL SERVER 8.0 OR LATER WITH AUTHENTICATION PROTOCOL ENABLED AND INSTALLED ON THE DEVICE ON WHICH THIS APPLICATION IS TO BE USED
***
# THE WHOLE APPLICATION CONSIST OF **5** `SUB-APPLICATIONS` 
# 1.[_TABLE EDITOR_](#1-the-table-editor)                        
# 2.[_AUTHENTICATOR_](#the-authenticator)                  
# 3.[_COMMAND INTERPRETER_](#4-command-interpreter)
# 4.[_Logger_](#5-logger)
# 5.[_Themes_](#6-themes)
***
## **Lets Talk About The _TABLE EDITOR?_ SHALL WE?**
***
## THE WHOLE _TABLE EDITOR_ CONSISTS OF `6` ELEMENTS MAINLY 
### 1.THE TABLE EDITOR
![firstorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/879157bf-cffe-4926-9b2c-1d4a6a583985)

***
### 2.[REFRESH BUTTON](#2-refresh-button)
![secondorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/70745732-ee32-418b-b66c-2c7d747c6e28)

***
### 3.[DELETE BUTTON](#3-delete-button)
![thirdorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/fccb036d-7ed3-4ae4-8589-c906e4940017)

***
### 4.CUI
![fourthorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/a82ee698-e30c-46c3-8380-78ee59e9d629)

***
### 5.Logger
![sixthorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/551f2905-b837-438d-b63d-408ffc70c782)
***
### 6.Themes
![seventhorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/30646adb-c88f-40b8-9d10-0eb99ff5f19b)
***
# 1 _THE TABLE EDITOR_ 
## THE [TABLE EDITOR](#1the-table-editor) Displays the tables returned by executing the commands in the [cui](#4cui).
>[!IMPORTANT]
>Inorder to actually edit the table both user-end and on the database the user must be connected to the Table _[read more about it here](#2-to-change-database--table-mid-way-or-a--if-change-of-mind)_

## On the `TABLE EDITOR` we can edit the table cell by  `double clicking a particular cell` which will execute `updates/inserts` statements on the data of the table in the connected database.

## The Edited Data Of The Cell Can Be Saved by Pressing ` enter ` Key Or ` tab ` Key.
![man](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/3ec83b26-329a-46fc-b1c9-45ba1e6c63fd)

>[!IMPORTANT]
>THE TABLES LIKE `INFORMATION SCHEMAS` , `METADATA` **WILL NOT BE UPDATED/INSERTED** BUT CAN BE EDITED FOR THE USER-END
***
# 2 _REFRESH BUTTON_
## When you click this [button](#2refresh-button) the command executed in the [cui](#4cui) _if the command executed returns any table_ then the particular table will be displayed in the **[TABLE EDITOR](#1the-table-editor)**
>[!NOTE]
>BY DEFAULT THERE'LL BE NO COMMAND EXECUTED THE USER HAS TO SPEICFY WHICH TABLE HE WANT'S TO VIEW 
***
# 3 _DELETE BUTTON_
## When you click this [button](#3delete-button) the Application will delete the selected *row* and refreshes itself.
***
***
# 4 _COMMAND INTERPRETER_ 
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/9d6691db-99fb-4891-9b48-7636055f5b70)
## The [COMMAND INTERPRETER or CUI](#4cui) is an `Command line user interface` for executing **_all kinds_** of commands inside a particular **DATABASE** 
>[!IMPORTANT]
>if there's any error executing a particular command then when the [refresh](#2refresh-button) is pressed the previous command returning a table will be executed this **previous command** can also be `select*from<table>;`
### ABOUT
 The errors returned by mysql will be displayed in the CUI itself.    
 In Order to View the table returned by the executed command the user must click the [refresh](#2refresh-button).   
 ### non sql commands 
 The program current has only two _non-sql-command_ which is `help`, `clear`.       
 the `help` command returns few details regarding version of the application, maker, connected table     
 the `clear` command clears the screen of the cui
***
# 5 _Logger_
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/56073582-93a7-4340-b5a6-102699828f92)
## The Logger logs the commands executed by the user on the [TABLE EDITOR](#1the-table-editor) and the [COMMAND INTERPRETER or CUI](#4cui)
*** 
# 6 _Themes_

![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/043249d5-589c-4a89-9e45-f4b098f815ec)
## Theme can be changed by clicking on any component and selecting a particular theme 
## you can keep theme for each comoponent a different one 
![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/cd9605f1-0219-4f24-a611-7f706b892632)
## Currently there're only 20 themes but i'll add few more soon!! 
> [!NOTE]
> # ALL the themes are from [flatlaf](https://www.formdev.com/flatlaf/)
***
*** 
# _THE AUTHENTICATOR_ 

## THE AUTHENTICATOR CAN BE USED & ACCESSED IN TWO WAYS 
***
# 1. ON STARTUP - 
**When the Application is Launched the Authenticator Boots up by itself and _if_ the user wants to connect to a database the user can do the following -**       

![image](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/c2c63d87-27de-40bb-9f37-9e98eb014420)
## The Authenticator Consists of 4 TextFields        
+ "DB name" has to be filled with the required **DATABASE**
+ "Table Name" has to be filled with the required **TABLE** _(optional)_
+ "User" has to be filled with the required **USER NAME**
+ "PassWord" has to be filled with the required **PASSWORD** For the Username
  ***
# 2. TO CHANGE `DATABASE / TABLE` MID-WAY OR A CHANGE OF MIND 
## THE USER MUST CLICK HERE  - 
![fifthorgy](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/8c037faa-2029-4419-b226-abc3cba9befb)!

+ ## IF THE USER WANTS TO CHANGE JUST THE TABLE 
+ THE USER **MUST** CHANGE THE TABLE IN-ORDER TO MANIPULATE THE DATA ON THE DATABASE!!
+ THE USER IS ONLY ALLOWED TO CHANGE THE TABLE AND USER BUT CAN'T ACCESS OTHER CREDENTIALS

## IF THE USERS WANTS TO CHANGE THE DATABASE THEN HE CAN CLICK HERE - 

![mini](https://github.com/Hellf0rg0d/MySql_Editor/assets/93775719/c4d43296-5933-4da8-87a1-d29a616a11b7)

***
***
# DOWNLOAD IT FROM [HERE](https://github.com/Hellf0rg0d/MySql_Editor/blob/main/How%20to%20Download.md)
# SEND ME THE FEEDBACKS/BUGS/REPORTS ABOUT THIS APPLICATION HERE -hellf0rg0d _AT_ proton.me
# STAY TUNED FOR FUTURE UPDATES/FIXES.
