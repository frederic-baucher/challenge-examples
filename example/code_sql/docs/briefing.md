# SQL JOIN



For this challenge we will talk about join, how to use it and especially what it brings more than traditional requests. 

 ###  But why use the JOIN SQL command 🙄?

> Another useless thing to make my code seem more scholarly 🤨 ?

Not at all, joins allow you to associate several tables in the same query, to obtain results that combine their data efficiently, they allow you to optimize queries by improving their execution speed.
You can always do the work by hand by applying several requests in a transaction, for example, but you should only know that the performance of the joins is unparalleled. 

 ### Okay, but how does the JOIN SQL command work 🤔?


All you have to do is create a join based on a criterion that matches the values of a column in one table to a column in another table.
A join therefore makes it possible to combine the columns of several tables during queries, thus increasing the search fields. But they can all restrict the number of records by forcing equality between two columns to return only matching records.



There are several types of join:


* Inner join 
* Left join
* Right join
* Self join 
* Cross join
* Natural join
* Full join 

In this part you will learn how to use the inner join 🙂. 

---

# Inner join 


The inner join is the default access link mode, it returns ONLY records that have a link (records with matching keys) in each of the linked tables.

<p style="text-align:center;"> <img src="${DEADLOCK_RESOURCE}/docs/images/inner_join.png" width="200" /></p>



## Syntax

To handle this type of join it is necessary to use a SQL query with this syntax:

```sql
SELECT *
FROM table1
INNER JOIN table2 ON table1.id = table2.fk_id

```


Example

<p style="text-align:center;"> <img src="${DEADLOCK_RESOURCE}/docs/images/inner_join_example.png" width="450" /></p>

To have the table join12 you must make a join between table1 and table2 where column C11 is equal to column C21 as follows : 

```sql
SELECT *
FROM Table1
INNER JOIN Table2 ON table1.C11 = table2.C21
```

To have the table joined123 you must make a join between the table12 and the table3 where the column C22 is equal to the column C31 as follows : 

```sql
SELECT *
FROM Table12
INNER JOIN Table3 ON table1.C22 = table2.C31
```
---

Now it's up to you to play by doing the following challenge 😎.


## Your mission  `😈`

To solve this challenge, you must write a request allowing you to find and display all customers' personal information, their subscription date and the amount of each type of customer account.
 
Easy, right? 🙂
 
---

The following sections contain some useful information that will help you solving this challenge.

The bank has 5 tables in the database including PERSON, CUSTOMER, ACCOUNT:

### Person table

This table groups together customer and employee information
 
  
 | id | first_name | last_name|  gender | birth_date | email |phone_number| country | city|
 |---:|---:|---:|---:|---:|---:|---:|---:|---:|
 |... | ... | ... | ... | ... | ... | ... | ... | ...|
 |11 |Mickey |Mouse|male|1974-09-02|mickey.mouse@yahoo.com|507-450-4521 |OT |Paris|
 |14 |Donald |Duck|male|1985-08-23|donald.duck@outlook.com |435-197-1141 |US |Los Angeles|
 |18 |Minnie | Mouse |female|1971-07-19 |minnie.mouse@outlook.com|634-167-4861|CA|Montreal|
 | ... | ... | ... | ... | ... | ... | ... | ... | ...|
  
  #### Attributes
  
  - **id**: a person's id (primary key of the table);
  - **first_name**: the person first name;
  - **last_name**: the person last name;
  - **gender**: to make it simple we only have two genders here (male and female);
  - **birth_date**: the person birth date;
  - **email**: the person e-mail, <first_name>.<last_name>@domain;
  - **phone_number**: the person phone number;
  - **country**: the person "country" (United States, Canada, or Other regions);
  - **city**: the person city (US cities, Canadian cities, or other regions cities).
  

### Customer table

| id | person_id | subscribe_date | adviser_id |
|---:|---:|---:|---:|
| ... | ... | ... | ... | 
| 5 | 10 | 1946-04-20 | 5 |
| 6 | 12 | 1867-04-20 | 2 |
| 7 | 15 | 1971-06-28 | 5 |
| 8 | 17 | 1987-04-20 | 6 |
| ... | ... | ... | ... | 

#### Attributes

   - **id**: the customer id (primary key of the table);
   - **person_id**: foreign key that refers to a person in PERSON table;
   - **subscribe_date**: the date the customer subscribed to his/her bank;
   - **adviser_id**: foreign key that refers to the customer's advisor in the EMPLOYEE table.
 



### Account table

| id | customer_id |type| amount |
|---:|---:|---:|---:|
| ... | ... | ... | ... | 
| 3  | 1  |current  | 7497.00 |
| 4  | 1  | saving  | 84503.9 |
| 5  |  15| current | 40113.2 |
| 6  |  17|current  | 39667.41|
| ... | ... | ... | ... | 

  #### Attributes
  
   - **id**: the account id (primary key of the table);
   - **customer_id**: foreign key that refers to a customer of table CUSTOMER;
   - **type**: the account type, here we only have two types (adviser,amount);
   - **amount**: the balance of the account.
  

 ---
 
 ## Example of the expected result
  
 | first_name	|	last_name	|	gender	|	birth_date	|	email	|	phone_number	|	country	|	city	|	subscribe_date	|	type	|	amount	|
 |---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
 | ... | ... | ... | ... | ... | ... | ... | ... | ... | ... | ... | 	
 | Mickey	|	Mouse	|	male	|	1964-06-07	|	mickey.mouse@gmail.com	|	303-645-9178	|	CA	|	Ottawa	|	1993-04-23	|	current	|	34896.52	|	
 | Donald	|	Duck	|	male	|	1964-06-07	|	donald.duck@gmail.com	|	303-645-9178	|	CA	|	Ottawa	|	1993-04-23	|	saving	|	92077.21	|	
 | Minnie    |	Mouse	|	female	|	1951-09-17	|	minnie.mouse@aol.com	|	644-208-8201	|	CA	|	Montreal|	1991-03-10	|	saving	|	83808.10	|	
 | Daisy	    |	Duck	|	female	|	1945-08-30	|	daisy.duck@outlook.com	|	553-615-3529	|	US	|	Miami	|	1983-05-06	|	current	|	83422.80	|	
 | ... | ... | ... | ... | ... | ... | ... | ... | ... | ... | ... | 
 
---
<div align  ="center">Good luck 🙂</div>