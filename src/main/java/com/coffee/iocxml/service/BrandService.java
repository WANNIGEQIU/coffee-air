package com.coffee.iocxml.service;

import com.coffee.iocxml.pojo.Brand;

public class BrandService {

    private Brand brand;

    public void hh() {
        System.out.println("品牌："+brand.getName() +"\t价格\t"+brand.getPrice());
    }

     public Brand getBrand() {
         return brand;
     }

     public void setBrand(Brand brand) {
         this.brand = brand;
     }
}
