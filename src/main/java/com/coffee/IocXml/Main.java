package com.coffee.IocXml;

import com.coffee.IocXml.ioc.ClassPathXmlAC;
import com.coffee.IocXml.pojo.Brand;
import com.coffee.IocXml.service.BrandService;

public class Main {

    public static void main(String[] args) throws Exception {
        ClassPathXmlAC ac = new ClassPathXmlAC("bean.xml");
        Brand brand = (Brand) ac.getBean("Brand");
        System.out.println(brand);

        BrandService ser = (BrandService) ac.getBean("ser");
        ser.hh();

    }




    }









