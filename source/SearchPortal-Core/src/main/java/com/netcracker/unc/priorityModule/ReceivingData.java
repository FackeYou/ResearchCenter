package com.netcracker.unc.priorityModule;

import java.util.ArrayList;

/**
 *
 * @author Dmitry
 */
public class ReceivingData {
    
    private ArrayList FinData = new ArrayList();

    private int UserId = 0;
    
    public ArrayList getFinData(){
        return FinData;
    }
    
    private void UserCosts(){
        /*
        как-то так будет выглядеть:
        */
        ResultCategoryRow categoryRow = new ResultCategoryRow();
        FinData.add(categoryRow);
    }
    
    private void UserIncome(){
        //FinData.add(rtfttgtgtgtg);
    }
    
    public void detailsRow(){
        /*
        будет выводить детей строки если потребуется и если они есть.
        */
    }
    
    public ReceivingData() {
    }
    
    ReceivingData(int userId){
        this.UserId = userId;
    }
    
    @Override
    public String toString(){
        String statusString = "Класс получает строки доходов и расходов юзера "
                + "и возвразает их на анализ."
                + "<br/> userID = " + UserId;
        return statusString;
    }
    
    
    public class ResultCategoryRow{
        /*
        как вариант, создать несколько вложенных классов и отдавать лист без 
        generic типа. Вложенные классы будут отличаться полями.
        
        */
        private String Type = "Категория";
        
        //for categories info
        private String objectId;
        private String objectName;
        private String minPercent;
        private String maxPercent;
        private String finalDate;
        private String sumCategory;

        public ResultCategoryRow() {
        }

        
        
        
        
        
        @Override
        public String toString(){
            String statusString = "Экземпляры этого класса - строки запроса "
                    + "финансовых объектов пользователя, "
                    + "возможно за некоторый период, по которым расставляются"
                    + " приоритеты расходов. Объектный тип указывается при "
                    + "добавлении тем или иным методом.";
            return statusString;
        }
    }
    
    public class ResultIncomeRow{
        private String Type;
        
        //for categories info
        private String objectId;
        private String objectName;
        private String minPercent;
        private String maxPercent;
        private String finalDate;
        private String sumCategory;
        
        
        
        
        @Override
        public String toString(){
            String statusString = "Экземпляры этого класса - строки запроса "
                    + "финансовых объектов пользователя, "
                    + "возможно за некоторый период, по которым расставляются"
                    + " приоритеты расходов. Объектный тип указывается при "
                    + "добавлении тем или иным методом.";
            return statusString;
        }
    }
    public class ResultCostRow{
        private String Type;
        
        //for categories info
        private String objectId;
        private String objectName;
        private String minPercent;
        private String maxPercent;
        private String finalDate;
        private String sumCategory;
        
        
        
        
        @Override
        public String toString(){
            String statusString = "В перспективе объекты этого класса будут "
                    + "разворачиваться и выводить более подрубную статистику";
            return statusString;
        }
    }
}