package utils;

import java.util.Date;


public class Generator {
    
    public String generatorId(){
        String id;
        Date fecha= new Date();
        id=""+fecha.getTime()+fecha.getTimezoneOffset();
        return id;
    }
    /*
     public static void main(String[] args) {
         Generator gn= new Generator();
         System.out.println("id:"+gn.generatorId());
     }
    1636379028831300
    1636379038542300
    1636379078416300*/
}
