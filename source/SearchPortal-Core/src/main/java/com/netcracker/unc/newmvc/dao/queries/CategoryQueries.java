package com.netcracker.unc.newmvc.dao.queries;

public final class CategoryQueries {

	public static final String SP_ADD_CATEGORY = " ";
	public static final String SP_UPDATE_CATEGORY = " ";
	public static final String SP_DELETE_CATEGORY = " ";
	public static final String SP_GET_FULL_CATEGORIES_WITH_SUM = "SELECT \n" + " main_fo.FIN_OBJECT_ID as object_ID, \n"
			+ " main_fo.USER_ID,\n" + " main_fo.OBJECT_NAME,\n" + " (\n" + "  SELECT select_par.VALUE\n"
			+ "   FROM SP_FIN_OBJECTS select_fo \n" + "    INNER JOIN SP_ATTRIBUTES select_pja\n"
			+ "     ON select_fo.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID\n"
			+ "    INNER JOIN SP_PARAMS select_par\n" + "     ON select_pja.ATTRIBUTE_ID = select_par.ATTRIBUTE_ID\n"
			+ "   WHERE select_pja.ATTRIBUTE_NAME='Коэффициент приоритета'\n"
			+ "    AND main_fo.FIN_OBJECT_ID = select_fo.FIN_OBJECT_ID\n"
			+ "    AND main_fo.FIN_OBJECT_ID = select_par.FIN_OBJECT_ID\n" + " ) as coefficient,\n" + " (\n"
			+ "  SELECT select_par.VALUE\n" + "   FROM SP_FIN_OBJECTS select_fo \n"
			+ "    INNER JOIN SP_ATTRIBUTES select_pja\n"
			+ "     ON select_fo.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID\n"
			+ "    INNER JOIN SP_PARAMS select_par\n" + "     ON select_pja.ATTRIBUTE_ID = select_par.ATTRIBUTE_ID\n"
			+ "   WHERE select_pja.ATTRIBUTE_NAME='Минимальный % от расхода'\n"
			+ "    AND main_fo.FIN_OBJECT_ID = select_fo.FIN_OBJECT_ID\n"
			+ "    AND main_fo.FIN_OBJECT_ID = select_par.FIN_OBJECT_ID\n" + " ) as min_percent,\n" + " (\n"
			+ "  SELECT select_par.VALUE\n" + "  FROM SP_FIN_OBJECTS select_fo \n"
			+ "   INNER JOIN SP_ATTRIBUTES select_pja\n"
			+ "    ON select_fo.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID\n"
			+ "   INNER JOIN SP_PARAMS select_par\n" + "    ON select_pja.ATTRIBUTE_ID = select_par.ATTRIBUTE_ID\n"
			+ "  WHERE select_pja.ATTRIBUTE_NAME='Максимальный % от расхода'\n"
			+ "   AND main_fo.FIN_OBJECT_ID = select_fo.FIN_OBJECT_ID\n"
			+ "   AND main_fo.FIN_OBJECT_ID = select_par.FIN_OBJECT_ID\n" + " ) as max_percent,\n"
			+ " (SELECT SYSDATE FROM DUAL\n"
			+ " ) as final_date, --время до конца расчетн. периода может тоже будет влиять\n" + " (\n" + "  SELECT\n"
			+ "   SUM(obj_params.VALUE) as sum_root\n" + "  FROM (\n" + "   SELECT \n"
			+ "    f_ob.USER_ID as user_id,\n" + "    CONNECT_BY_ROOT f_ob.FIN_OBJECT_ID as root_object_id,\n"
			+ "    f_ob.FIN_OBJECT_ID as object_id,\n" + "    f_ob.FIN_OBJECT_TYPE_ID as object_type\n"
			+ "   FROM SP_FIN_OBJECTS f_ob\n" + "   START WITH f_ob.FIN_OBJECT_ID = ANY(\n"
			+ "    SELECT join_fo.FIN_OBJECT_ID\n" + "    FROM SP_FIN_OBJECTS join_fo \n"
			+ "     INNER JOIN SP_FIN_OBJECT_TYPES join_fot\n"
			+ "      ON join_fo.FIN_OBJECT_TYPE_ID = join_fot.FIN_OBJECT_TYPE_ID\n"
			+ "    WHERE join_fot.FIN_OBJECT_TYPE_NAME = 'Категория'\n" + "   )\n"
			+ "  CONNECT BY PRIOR f_ob.FIN_OBJECT_ID = f_ob.PARENT_ID\n" + " ) table_objects_and_its_roots \n"
			+ "  INNER JOIN SP_PARAMS obj_params\n"
			+ "   ON table_objects_and_its_roots.object_id = obj_params.FIN_OBJECT_ID\n"
			+ "  INNER JOIN SP_ATTRIBUTES obj_atr\n"
			+ "   ON obj_atr.FIN_OBJECT_TYPE_ID = table_objects_and_its_roots.object_type  \n"
			+ " WHERE obj_atr.ATTRIBUTE_NAME = 'Сумма расхода' AND\n"
			+ "  obj_params.ATTRIBUTE_ID = obj_atr.ATTRIBUTE_ID AND \n"
			+ "  table_objects_and_its_roots.root_object_id = main_fo.FIN_OBJECT_ID\n"
			+ " GROUP BY table_objects_and_its_roots.root_object_id\n" + ") as sum_category\n"
			+ "FROM SP_FIN_OBJECTS main_fo \n" + " LEFT JOIN SP_FIN_OBJECT_TYPES main_fot\n"
			+ "  ON main_fo.FIN_OBJECT_TYPE_ID = main_fot.FIN_OBJECT_TYPE_ID\n"
			+ "WHERE main_fot.FIN_OBJECT_TYPE_NAME = 'Категория'";

	public static final String SP_GET_USER_CATEGORIES_WITH_SUM = "SELECT \n" + " main_fo.FIN_OBJECT_ID as object_ID, \n"
			+ " main_fo.OBJECT_NAME,\n" + " (\n" + "  SELECT select_par.VALUE\n" + "   FROM SP_FIN_OBJECTS select_fo \n"
			+ "    INNER JOIN SP_ATTRIBUTES select_pja\n"
			+ "     ON select_fo.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID\n"
			+ "    INNER JOIN SP_PARAMS select_par\n" + "     ON select_pja.ATTRIBUTE_ID = select_par.ATTRIBUTE_ID\n"
			+ "   WHERE select_pja.ATTRIBUTE_NAME='Коэффициент приоритета'\n"
			+ "    AND main_fo.FIN_OBJECT_ID = select_fo.FIN_OBJECT_ID\n"
			+ "    AND main_fo.FIN_OBJECT_ID = select_par.FIN_OBJECT_ID\n" + " ) as coefficient,\n" + " (\n"
			+ "  SELECT select_par.VALUE\n" + "   FROM SP_FIN_OBJECTS select_fo \n"
			+ "    INNER JOIN SP_ATTRIBUTES select_pja\n"
			+ "     ON select_fo.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID\n"
			+ "    INNER JOIN SP_PARAMS select_par\n" + "     ON select_pja.ATTRIBUTE_ID = select_par.ATTRIBUTE_ID\n"
			+ "   WHERE select_pja.ATTRIBUTE_NAME='Минимальный % от расхода'\n"
			+ "    AND main_fo.FIN_OBJECT_ID = select_fo.FIN_OBJECT_ID\n"
			+ "    AND main_fo.FIN_OBJECT_ID = select_par.FIN_OBJECT_ID\n" + " ) as min_percent,\n" + " (\n"
			+ "  SELECT select_par.VALUE\n" + "  FROM SP_FIN_OBJECTS select_fo \n"
			+ "   INNER JOIN SP_ATTRIBUTES select_pja\n"
			+ "    ON select_fo.FIN_OBJECT_TYPE_ID = select_pja.FIN_OBJECT_TYPE_ID\n"
			+ "   INNER JOIN SP_PARAMS select_par\n" + "    ON select_pja.ATTRIBUTE_ID = select_par.ATTRIBUTE_ID\n"
			+ "  WHERE select_pja.ATTRIBUTE_NAME='Максимальный % от расхода'\n"
			+ "   AND main_fo.FIN_OBJECT_ID = select_fo.FIN_OBJECT_ID\n"
			+ "   AND main_fo.FIN_OBJECT_ID = select_par.FIN_OBJECT_ID\n" + " ) as max_percent,\n"
			+ " (SELECT SYSDATE FROM DUAL\n"
			+ " ) as final_date, --время до конца расчетн. периода может тоже будет влиять\n" + " (\n" + "  SELECT\n"
			+ "   SUM(obj_params.VALUE) as sum_root\n" + "  FROM (\n" + "   SELECT \n"
			+ "    f_ob.USER_ID as user_id,\n" + "    CONNECT_BY_ROOT f_ob.FIN_OBJECT_ID as root_object_id,\n"
			+ "    f_ob.FIN_OBJECT_ID as object_id,\n" + "    f_ob.FIN_OBJECT_TYPE_ID as object_type\n"
			+ "   FROM SP_FIN_OBJECTS f_ob\n" + "   START WITH f_ob.FIN_OBJECT_ID = ANY(\n"
			+ "    SELECT join_fo.FIN_OBJECT_ID\n" + "    FROM SP_FIN_OBJECTS join_fo \n"
			+ "     INNER JOIN SP_FIN_OBJECT_TYPES join_fot\n"
			+ "      ON join_fo.FIN_OBJECT_TYPE_ID = join_fot.FIN_OBJECT_TYPE_ID\n"
			+ "    WHERE join_fot.FIN_OBJECT_TYPE_NAME = 'Категория'\n" + "   )\n"
			+ "  CONNECT BY PRIOR f_ob.FIN_OBJECT_ID = f_ob.PARENT_ID\n" + " ) table_objects_and_its_roots \n"
			+ "  INNER JOIN SP_PARAMS obj_params\n"
			+ "   ON table_objects_and_its_roots.object_id = obj_params.FIN_OBJECT_ID\n"
			+ "  INNER JOIN SP_ATTRIBUTES obj_atr\n"
			+ "   ON obj_atr.FIN_OBJECT_TYPE_ID = table_objects_and_its_roots.object_type  \n"
			+ " WHERE obj_atr.ATTRIBUTE_NAME = 'Сумма расхода' AND\n"
			+ "  obj_params.ATTRIBUTE_ID = obj_atr.ATTRIBUTE_ID AND \n"
			+ "  table_objects_and_its_roots.root_object_id = main_fo.FIN_OBJECT_ID\n"
			+ " GROUP BY table_objects_and_its_roots.root_object_id\n" + ") as sum_category\n"
			+ "FROM SP_FIN_OBJECTS main_fo \n" + " LEFT JOIN SP_FIN_OBJECT_TYPES main_fot\n"
			+ "  ON main_fo.FIN_OBJECT_TYPE_ID = main_fot.FIN_OBJECT_TYPE_ID\n"
			+ "WHERE main_fot.FIN_OBJECT_TYPE_NAME = 'Категория' AND main_fo.USER_ID = ?";

	public static final String SP_GET_USER_CATEGORIES = " SELECT " + " FIN_OBJECT_ID as OBJECT_ID," + " OBJECT_NAME,"
			+ " (" + " SELECT coef_par.VALUE" + " FROM SP_PARAMS coef_par" + " WHERE coef_par.ATTRIBUTE_ID = 1"
			+ "  AND coef_par.FIN_OBJECT_ID = main_fo.FIN_OBJECT_ID" + " ) as coefficient," + " ("
			+ " SELECT coef_par.VALUE" + " FROM SP_PARAMS coef_par" + " WHERE coef_par.ATTRIBUTE_ID = 2 "
			+ "  AND coef_par.FIN_OBJECT_ID = main_fo.FIN_OBJECT_ID" + " ) as min_percent," + " ("
			+ " SELECT coef_par.VALUE" + " FROM SP_PARAMS coef_par" + " WHERE coef_par.ATTRIBUTE_ID = 3 "
			+ "  AND coef_par.FIN_OBJECT_ID = main_fo.FIN_OBJECT_ID" + " ) as max_percent "
			+ "FROM SP_FIN_OBJECTS main_fo " + "WHERE FIN_OBJECT_TYPE_ID =1 " 
			+ "AND USER_ID = ? ";
}
