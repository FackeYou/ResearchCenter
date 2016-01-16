DROP SEQUENCE short_table_sequence;

Create SEQUENCE short_table_sequence
 START WITH 10000
 NOCACHE
 NOCYCLE;
 
--
DELETE FROM FIN_OBJECT_ATR_TYPES;
DELETE FROM FIN_OBJECTS;
DELETE FROM PARAMS;
DELETE FROM PJ_ATTRIBUTES;
DELETE FROM PJ_USERS;
DELETE FROM TRANSACTIONS;


--���������
INSERT INTO PJ_ATTRIBUTES
 VALUES(short_table_sequence.nextval, '���������');
INSERT INTO PJ_ATTRIBUTES
 VALUES(short_table_sequence.nextval, '���� ���������� ��������');
INSERT INTO PJ_ATTRIBUTES
 VALUES(short_table_sequence.nextval, '��������� ����������');
INSERT INTO PJ_ATTRIBUTES
 VALUES(short_table_sequence.nextval, '�������');
INSERT INTO PJ_ATTRIBUTES
 VALUES(short_table_sequence.nextval, '�������');
INSERT INTO PJ_ATTRIBUTES
 VALUES(short_table_sequence.nextval, '������');

--������������

/*
 *������������ � ������� ��������(���=����=0):
 */
INSERT INTO PJ_USERS
 VALUES(short_table_sequence.nextval, 'neadmin', 0, 'Jack D.', 'admin', 0);
INSERT INTO PJ_USERS
 VALUES(short_table_sequence.nextval,'nedoadmin', 0, '���� ������', 'user', 0);
INSERT INTO PJ_USERS
 VALUES(short_table_sequence.nextval,'person1', 0, '���', 'user', 0);
INSERT INTO PJ_USERS
 VALUES(short_table_sequence.nextval,'person2', 0, '���� ������', 'user', 0);

