DELETE FROM sp_params;
DELETE FROM sp_attributes;
DELETE FROM sp_fin_objects;
DELETE FROM sp_users;
DELETE FROM sp_fin_object_types;
DELETE FROM sp_transactions;

DROP SEQUENCE SP_USER_ID_SEQ;
DROP SEQUENCE SP_FIN_OBJECT_TYPE_ID_SEQ;
DROP SEQUENCE SP_FIN_OBJECT_ID_SEQ;
DROP SEQUENCE SP_ATTRIBUTE_ID_SEQ;
DROP SEQUENCE SP_Transaction_ID_SEQ;

CREATE SEQUENCE SP_USER_ID_SEQ INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SP_FIN_OBJECT_TYPE_ID_SEQ INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SP_FIN_OBJECT_ID_SEQ INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SP_ATTRIBUTE_ID_SEQ INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SP_Transaction_ID_SEQ INCREMENT BY 1 START WITH 1;
  
--
--������������
--
INSERT INTO sp_users(USER_ID, LOGIN, hash_sum, salt, name, account_type)
  VALUES (sp_user_id_seq.nextval, 'testusr', 0, 0, 'ftft', 'admin');

--password: 123QWEasd
INSERT INTO SP_USERS
 VALUES(sp_user_id_seq.nextval, 'neadmin', -1005244443, 'Jack D.', 'admin', 1291088537);




INSERT INTO SP_FIN_OBJECT_TYPES --1
 (FIN_OBJECT_TYPE_ID, FIN_OBJECT_TYPE_NAME)
   VALUES(SP_FIN_OBJECT_TYPE_ID_seq.nextval, '���������');
INSERT INTO SP_FIN_OBJECT_TYPES --2
 (FIN_OBJECT_TYPE_ID, FIN_OBJECT_TYPE_NAME) 
   VALUES(SP_FIN_OBJECT_TYPE_ID_seq.nextval, '�����');
INSERT INTO SP_FIN_OBJECT_TYPES --3
 (FIN_OBJECT_TYPE_ID, FIN_OBJECT_TYPE_NAME) 
   VALUES(SP_FIN_OBJECT_TYPE_ID_seq.nextval, '������');
INSERT INTO SP_FIN_OBJECT_TYPES --4
 (FIN_OBJECT_TYPE_ID, FIN_OBJECT_TYPE_NAME) 
   VALUES(SP_FIN_OBJECT_TYPE_ID_seq.nextval, '������');
INSERT INTO SP_FIN_OBJECT_TYPES --5
 (FIN_OBJECT_TYPE_ID, FIN_OBJECT_TYPE_NAME)
   VALUES(SP_FIN_OBJECT_TYPE_ID_seq.nextval, '����');
   
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --1
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '����������� ����������', 1);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --2
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '����������� % �� �������', 1);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --3
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '������������ % �� �������', 1);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --4
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '���� ������', 2);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --5
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '����� ������', 2);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --6
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '����������� �����', 2);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --7
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '���� �������', 3);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --8
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '����� �������', 3);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --9
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '����������� ������', 3);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --10
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '���� ��������', 4);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --11
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '���� ����������', 4);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --12
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '���������', 4);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --13
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '���������', 4);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --14
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '������', 5);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --15
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '���������', 5);
INSERT INTO SP_ATTRIBUTES(ATTRIBUTE_ID, ATTRIBUTE_NAME, FIN_OBJECT_TYPE_ID) --16
 VALUES(SP_ATTRIBUTE_ID_SEQ.nextval, '���������� ������', 5);





--
--�������
--

INSERT INTO SP_FIN_OBJECTS
 (FIN_OBJECT_ID, PARENT_ID, OBJECT_NAME, FIN_OBJECT_TYPE_ID, USER_ID)
   VALUES(SP_FIN_OBJECT_ID_SEQ.nextval, NULL, '��������', 1, 1);
INSERT INTO SP_FIN_OBJECTS
 (FIN_OBJECT_ID, PARENT_ID, OBJECT_NAME, FIN_OBJECT_TYPE_ID, USER_ID)
   VALUES(SP_FIN_OBJECT_ID_SEQ.nextval, NULL, '���������', 1, 1);
INSERT INTO SP_FIN_OBJECTS
 (FIN_OBJECT_ID, PARENT_ID, OBJECT_NAME, FIN_OBJECT_TYPE_ID, USER_ID)
   VALUES(SP_FIN_OBJECT_ID_SEQ.nextval, NULL, '���', 1, 1);
INSERT INTO SP_FIN_OBJECTS
 (FIN_OBJECT_ID, PARENT_ID, OBJECT_NAME, FIN_OBJECT_TYPE_ID, USER_ID)
   VALUES(SP_FIN_OBJECT_ID_SEQ.nextval, 1, '�����', 3, 1);
INSERT INTO SP_FIN_OBJECTS
 (FIN_OBJECT_ID, PARENT_ID, OBJECT_NAME, FIN_OBJECT_TYPE_ID, USER_ID)
   VALUES(SP_FIN_OBJECT_ID_SEQ.nextval, 1, '�����', 3, 1);
INSERT INTO SP_FIN_OBJECTS
 (FIN_OBJECT_ID, PARENT_ID, OBJECT_NAME, FIN_OBJECT_TYPE_ID, USER_ID)
   VALUES(SP_FIN_OBJECT_ID_SEQ.nextval, 2, '����� �� 500', 3, 1);
INSERT INTO SP_FIN_OBJECTS
 (FIN_OBJECT_ID, PARENT_ID, OBJECT_NAME, FIN_OBJECT_TYPE_ID, USER_ID)
   VALUES(SP_FIN_OBJECT_ID_SEQ.nextval, null, '��������', 2, 1);
--
--��������� ���������
--
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(1, 1, '0.42', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(1, 2, '10', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(1, 3, '50', null);
 
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(2, 1, '0.8', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(2, 2, '20', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(2, 3, '30', null);

INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(3, 1, '0.1', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(3, 2, '15', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(3, 3, '40', null);
 
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(7, 4, null, SYSDATE-10);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(7, 5, '4000', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(7, 6, 'true', null);
 
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(4, 7, null, SYSDATE-2);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(4, 8, '35', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(4, 9, 'false', null); 
 
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(5, 7, null, SYSDATE-5);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(5, 8, '50', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(5, 9, 'false', null); 
 
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(6, 7, null, SYSDATE-1);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(6, 8, '500', null);
INSERT INTO SP_PARAMS(FIN_OBJECT_ID, ATTRIBUTE_ID, VALUE, VALUE_DATE)
 VALUES(6, 9, 'false', null); 
