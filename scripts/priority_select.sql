
/*
 * ����: ������� ������� � ���������: 
 *    - object name(���������), 
 *    - SUM(��� ���� ������������� �� �������� ��������),
 *    - ��������� 
 */
 
--
/*����� ���� ���������� ��� ���� ��������*/
SELECT * 
FROM FIN_OBJECTS fo 
 INNER JOIN FIN_OBJECT_TYPES fot
  ON fo.FIN_OBJECT_TYPE_ID = fot.FIN_OBJECT_TYPE_ID
 INNER JOIN PJ_ATTRIBUTES pja
  ON fot.FIN_OBJECT_TYPE_ID = pja.FIN_OBJECT_TYPE_ID
 INNER JOIN PARAMS par
  ON pja.ATTRIBUTE_ID = par.ATTRIBUTE_ID
WHERE fot.FIN_OBJECT_TYPE_NAME = '���������';


--
/*�������� ���������*/
SELECT *
FROM FIN_OBJECTS
START WITH Object_name = '��������'
CONNECT BY PRIOR FIN_OBJECT_ID =  PARENT_ID;

--
/*������� �������� ���� ���������*/
SELECT *
FROM FIN_OBJECTS
START WITH FIN_OBJECT_ID = ANY 
 (
  SELECT FIN_OBJECT_ID 
  FROM FIN_OBJECTS fo 
   INNER JOIN FIN_OBJECT_TYPES fot
    ON fo.FIN_OBJECT_TYPE_ID = fot.FIN_OBJECT_TYPE_ID
  WHERE fot.FIN_OBJECT_TYPE_NAME = '���������'
 )
CONNECT BY PRIOR FIN_OBJECT_ID =  PARENT_ID;

--
/*
 * �� ������ ������ 3 ���������.
 * ���� ������ �������� 3 ������ � ���������� � ��������
 * ������������ ������������ ����������
 */
SELECT 
 main_fo.FIN_OBJECT_ID as object_ID, 
 main_fo.USER_ID,
 main_fo.OBJECT_NAME,
 (
  SELECT select_par.VALUE1
   FROM FIN_OBJECTS select_fo 
    INNER JOIN PJ_ATTRIBUTES select_pja
     ON select_fo.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID
    INNER JOIN PARAMS select_par
     ON select_pja.ATTRIBUTE_ID = select_par.ATTRIBUTE_ID
   WHERE select_pja.ATTRIBUTE_NAME='��������� ����������'-- ������ ���� ��
    AND main_fo.FIN_OBJECT_ID = select_fo.FIN_OBJECT_ID
    AND main_fo.FIN_OBJECT_ID = select_par.FIN_OBJECT_ID
 ) as coefficient,
 (
  SELECT select_par.VALUE1
   FROM FIN_OBJECTS select_fo 
    INNER JOIN PJ_ATTRIBUTES select_pja
     ON select_fo.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID
    INNER JOIN PARAMS select_par
     ON select_pja.ATTRIBUTE_ID = select_par.ATTRIBUTE_ID
   WHERE select_pja.ATTRIBUTE_NAME='����������� % �� �������'
    AND main_fo.FIN_OBJECT_ID = select_fo.FIN_OBJECT_ID
    AND main_fo.FIN_OBJECT_ID = select_par.FIN_OBJECT_ID
 ) as min_percent,
 (
  SELECT select_par.VALUE1
  FROM FIN_OBJECTS select_fo 
   INNER JOIN PJ_ATTRIBUTES select_pja
    ON select_fo.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID
   INNER JOIN PARAMS select_par
    ON select_pja.ATTRIBUTE_ID = select_par.ATTRIBUTE_ID
  WHERE select_pja.ATTRIBUTE_NAME='������������ % �� �������'
   AND main_fo.FIN_OBJECT_ID = select_fo.FIN_OBJECT_ID
   AND main_fo.FIN_OBJECT_ID = select_par.FIN_OBJECT_ID
 ) as max_percent,
 (SELECT SYSDATE FROM DUAL
 ) as final_date, --����� �� ����� �������. ������� ����� ���� ����� ������
 (
  SELECT SUM(select_fo.FIN_OBJECT_ID) 
  FROM FIN_OBJECTS select_fo 
   INNER JOIN FIN_OBJECT_TYPES select_fot
    ON select_fo.FIN_OBJECT_TYPE_ID = select_fot.FIN_OBJECT_TYPE_ID
   INNER JOIN PJ_ATTRIBUTES select_pja
    ON select_fot.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID
  START WITH select_fo.FIN_OBJECT_ID = main_fo.FIN_OBJECT_ID
  CONNECT BY PRIOR select_fo.FIN_OBJECT_ID = select_fo.PARENT_ID
 ) as sum_category--�� ��������
FROM FIN_OBJECTS main_fo 
 INNER JOIN FIN_OBJECT_TYPES main_fot
  ON main_fo.FIN_OBJECT_TYPE_ID = main_fot.FIN_OBJECT_TYPE_ID
WHERE main_fot.FIN_OBJECT_TYPE_NAME = '���������';


--���������� ������

SELECT (COUNT(fin_object_id))*410, 4063+6260+402 FROM FIN_OBJECTS;