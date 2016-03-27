
--invoice
insert into SP_FIN_OBJECT_TYPES (FIN_OBJECT_TYPE_ID,FIN_OBJECT_TYPE_NAME )
values (5,'invoice'); 

insert into SP_ATTRIBUTES(ATTRIBUTE_ID,FIN_OBJECT_TYPE_ID,ATTRIBUTE_NAME)
values (14,5,'balance');

insert into SP_ATTRIBUTES(ATTRIBUTE_ID,FIN_OBJECT_TYPE_ID,ATTRIBUTE_NAME)
values (15,5,'credit');

insert into SP_ATTRIBUTES(ATTRIBUTE_ID,FIN_OBJECT_TYPE_ID,ATTRIBUTE_NAME)
values (16,5,'percent');

--income
insert INTO SP_FIN_OBJECT_TYPES( FIN_OBJECT_TYPE_ID, FIN_OBJECT_TYPE_NAME)
 VALUES (2, 'income');
 
 INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) 
 VALUES (4, 'date', 2); 
 
 INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) 
 VALUES (5, 'sum', 2); 
 
 INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) 
 VALUES (6, 'everyMonth', 2); 


-- consumption
 insert INTO SP_FIN_OBJECT_TYPES( FIN_OBJECT_TYPE_ID, FIN_OBJECT_TYPE_NAME)
 VALUES (3, 'consumption');
 
 INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) 
 VALUES (7, 'date', 3); 
 
 INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) 
 VALUES (8, 'sum', 3); 
 
 INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) 
 VALUES (9, 'everyMonth', 3); 
