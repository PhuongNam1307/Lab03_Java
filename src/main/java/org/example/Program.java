package org.example;
import java.util.Date;
import java.util.List;

import org.example.utils.HibernateUtils;
import org.example.domain.Phone;
import org.example.domain.Manufacture;

import org.example.dao.ManufactureDao;
import org.example.dao.PhoneDao;

import org.hibernate.Session;

public class Program {
    public static void main(String[] args) {
        ManufactureDao manufactureDAO = null;
        manufactureDAO.add(new Manufacture("123","123", "123", 123));
        manufactureDAO.add(new Manufacture("456","456","456", 456));
        Manufacture manufacture = new Manufacture("789","789", "789", 789);
        manufactureDAO.add(manufacture);
        System.out.println(manufactureDAO.readAll());
        System.out.println(manufactureDAO.get("123"));
        System.out.println(manufactureDAO.update( "789", new Manufacture("789","89","89", 89)));
        System.out.println(manufactureDAO.remove("456"));
		
        System.out.println(manufactureDAO.checkOver100Emp());
        System.out.println(manufactureDAO.sumAllEmployee());
        System.out.println(manufactureDAO.allManuInUS());

        PhoneDao phoneDAO =null;
        Phone phone = new Phone("p1","Iphone 10",8000000,"Black","America"
                ,600,manufacture);
        Phone phone1 = new Phone("p1","Iphone 12",80000000,"Pink","America"
                ,600,manufacture);
        phoneDAO.add(phone);
        phoneDAO.add(phone1);
        phoneDAO.add(phone3);
        System.out.println(phoneDAO.readAll());

        System.out.println(phoneDAO.highestPrice());
        System.out.println(phoneDAO.sorted());
        System.out.println(phoneDAO.greater50M());
        System.out.println(phoneDAO.pinkColorAndGt15M());

    }
}
