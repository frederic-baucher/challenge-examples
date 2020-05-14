# JOINTURES SQL


Pour ce challenge nous allons parler de jointure , comment l'utiliser et surtout ce qu'elle apporte de plus que les requêtes classiques. 

 ### Mais pourquoi utiliser les jointures 🙄 ?

> Encore un truc inutile pour que mon code paraisse plus savant 🤨 ?

Pas du tout, les jointures permettent d’associer plusieurs tables dans une même requête, pour obtenir des résultats qui combinent leurs données de manière efficace, elles permettent ainsi d’optimiser les requêtes en améliorant leur vitesse d'exécution.
On peut toujours faire le travail à la main en appliquant par exemple plusieurs requêtes de suite dans une transaction mais sachez seulement que les performances des jointures sont sans égales. 

 ### Ok, mais comment ça marche une jointure 🤔 ? 


Il suffit de créer une jointure basée sur un critère de concordance des valeurs d’une colonne d’une table à une colonne d’une autre table.
Une jointure permet donc de combiner les colonnes de plusieurs tables pendant les requêtes, augmentant ainsi les champs de recherche. Mais elles peuvent toutes aussi bien en restreindre le nombre en forçant l’égalité entre deux colonnes pour ne retourner que les enregistrements concordants.



Il existe plusieurs types de jointure :


* Inner join 
* Left join
* Right join
* Self join 
* Cross join
* Natural join
* Full join 

dans cette partie tu vas apprendre à utiliser l'inner join  🙂. 

---

# Inner join 


L'inner join est le mode de liaison d’accès par défaut, elle retourne SEULEMENT les enregistrements qui ont une liaison (des enregistrements dont les clés correspondent) dans chacune des tables liées.

<p style="text-align:center;"> <img src="${DEADLOCK_RESOURCE}/docs/images/inner_join.png" width="200" /></p>



## Syntaxe

Pour manipuler ce type de jointure il convient d’utiliser une requête SQL avec cette syntaxe :

```sql
SELECT *
FROM table1
INNER JOIN table2 ON table1.id = table2.fk_id

```
 

Exemple
 
<p style="text-align:center;"> <img src="${DEADLOCK_RESOURCE}/docs/images/inner_join_example.png" width="450" /></p>

Pour avoir la table join12 tu dois faire une jointure entre la table1 et la table2 où la colonne  C11 est égale a la colonne C21 comme suite : 

```sql
SELECT *
FROM Table1
INNER JOIN Table2 ON table1.C11 = table2.C21
```

Pour avoir la table join123 tu dois faire une jointure entre la table12 et la table3 où la colonne  C22 est égale a la colonne C31 comme suite : 

```sql
SELECT *
FROM Table12
INNER JOIN Table3 ON table1.C22 = table2.C31
```
---

Maintenant c'est à toi de jouer en relevant le challenge suivant 😎.


## Ta mission `😈`

Pour résoudre ce challenge, tu dois écrire une requête te permettant de trouver et afficher les informations personnelles de tous les clients, leur date de souscription ainsi que le montant de chaque type de compte qu'ils possèdent.
 
Facile, non ? 🙂
 
---  

La section suivante contient des renseignements utiles qui t'aideront à relever ce défi.

La base de données de la banque comporte 5 tables dont PERSON, CUSTOMER, ACCOUNT.
  
### Table person

Cette table regroupe les informations des clients et des employés

  
 | id | first_name | last_name|  gender | birth_date | email |phone_number| country | city|
 |---:|---:|---:|---:|---:|---:|---:|---:|---:|
 |... | ... | ... | ... | ... | ... | ... | ... | ...|
 11	|Mickey	|  Mouse	|male |1974-09-02	|mickey.mouse@yahoo.com	  |507-450-4521	|OT	|Paris
 14	|Donald	| Duck	|male	|1985-08-23 |donald.duck@outlook.com  |435-197-1141	|US |Los Angeles
 18 |Minnie	| Mouse  	|female	|1971-07-19 |minnie.mouse@outlook.com |634-167-4861	|CA	|Montreal
 | ... | ... | ... | ... | ... | ... | ... | ... | ...|
  
  #### Les attributs
  
  - **id**: l'id d'une personne (clé primaire de la table) ;
  - **first_name**: le prénom de l'employé ;
  - **last_name**: le nom de famille de l'employé ;
  - **gender**: pour simplifier le tout, ici on a que deux genres (male and female) ;
  - **birth_date**: la date de naissance de l'employé ;
  - **email**: l'adresse e-mail de l'employé, <first_name>.<last_name>@domain ;
  - **phone_number**: le numéro de téléphone de l'employé ;
  - **country**: le "pays" de l'employé (United States, Canada, ou Other regions) ;
  - **city**: la ville de l'employé (villes des USA, villes canadiennes, ou villes d'autres régions).
  
  
### Table customer

| id | person_id | subscribe_date | adviser_id |
|---:|---:|---:|---:|
| ... | ... | ... | ... | 
| 5 | 10 | 1946-04-20 | 5 |
| 6 | 12 | 1867-04-20 | 2 |
| 7 | 15 | 1971-06-28 | 5 |
| 8 | 17 | 1987-04-20 | 6 |
| ... | ... | ... | ... | 

 #### Les attributs

   - **id** : l'id du client (clé primaire de la table) ;
   - **person_id** : clé étrangère qui fait référence à une personne de la table PERSON ;
   - **subscribe_date** : la date à laquelle le client s'est inscrit à la banque ;
   - **adviser_id** : clé étrangère qui fait référence au conseiller du client de la table EMPLOYEE.
 


### Table account

| id | customer_id |type| amount |
|---:|---:|---:|---:|
| ... | ... | ... | ... | 
| 3  | 1  |current  | 7497.00 |
| 4  | 1  | saving  | 84503.9 |
| 5  |  15| current | 40113.2 |
| 6  |  17|current  | 39667.41|
| ... | ... | ... | ... | 

  #### Les attributs
  
   - **id** : l'id du compte (clé primaire de la table) ;
   - **customer_id** : clé étrangère qui fait référence a un client de la table CUSTOMER ;
   - **type** : le type du compte, ici on a que deux type (current,saving) ;
   - **amount** : le solde du compte.

  
---

## Exemple du résultat attendu 
 
| first_name	|	last_name	|	gender	|	birth_date	|	email	|	phone_number	|	country	|	city	|	subscribe_date	|	type	|	amount	|
|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
| ... | ... | ... | ... | ... | ... | ... | ... | ... | ... | ... | 	
| Mickey	|	Mouse	|	male	|	1964-06-07	|	mickey.mouse@gmail.com	|	303-645-9178	|	CA	|	Ottawa	|	1993-04-23	|	current	|	34896.52	|	
| Donald	|	Duck	|	male	|	1964-06-07	|	donald.duck@gmail.com	|	303-645-9178	|	CA	|	Ottawa	|	1993-04-23	|	saving	|	92077.21	|	
| Minnie    |	Mouse	|	female	|	1951-09-17	|	minnie.mouse@aol.com	|	644-208-8201	|	CA	|	Montreal|	1991-03-10	|	saving	|	83808.10	|	
| Daisy	    |	Duck	|	female	|	1945-08-30	|	daisy.duck@outlook.com	|	553-615-3529	|	US	|	Miami	|	1983-05-06	|	current	|	83422.80	|	
| ... | ... | ... | ... | ... | ... | ... | ... | ... | ... | ... | 

---
<div align='center'>  Bon courage 🙂 </div>