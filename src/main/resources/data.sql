CREATE TABLE Command_Template (id int, template_Name varchar(255),regex varchar(255),bean_name varchar(50));
INSERT INTO Command_Template  VALUES (1, 'Open customerName profile in client management','Open profile in client management','clientManagementTemplate');
INSERT INTO Command_Template  VALUES (2, 'what is the balance of customerName savings account','what is the balance of savings account','accountBalanceTemplate');
INSERT INTO Command_Template  VALUES (3, 'add a hold recommendation to customerName trade account as xxx','add a hold recommendation to trade account as',null);
INSERT INTO Command_Template  VALUES (4, 'Transfer amount from customerName savings account to Brokerage Account','Transfer from savings account to',null);
INSERT INTO Command_Template  VALUES (5, 'Add a note to customerName as update','Add a note to as',null);


CREATE TABLE ACCOUNT (accountnumber int,customername varchar(255),accountvalue int);
INSERT INTO ACCOUNT  VALUES (101,'rahul mehra',500);
INSERT INTO ACCOUNT  VALUES (102,'amar khanna',600);