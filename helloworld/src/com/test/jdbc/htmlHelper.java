package com.test.jdbc;


public class htmlHelper {

	
	protected static String countUser(Object data){
		int dataint =(Integer) data;
		if(dataint>0 && dataint<300)
			return dataint+" ";
		else
			return 42+" ";
	}
	
	public static String printErr(String err){
		//�����, �� ����� ���� ���.
		return err;
	}
	
	
	public static String printRow(boolean isHeader, Object... data){
		StringBuffer stringBuffer = new StringBuffer("<table><tr>");//����� ������ table
		if(data != null){
			for(Object object: data){
				stringBuffer.append("<th>");
				stringBuffer.append(object.toString());
				stringBuffer.append("</th>");
			}
		}
		stringBuffer.append("</tr></table>");
		return stringBuffer.toString();
	}
}
