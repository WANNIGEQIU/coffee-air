package com.coffee.IocXml.pojo;

import com.coffee.IocXml.utils.DateUtils;

import java.util.Date;

public class Brand {

    private String name;

    private int id;

    private Date day;

    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public Brand(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", day=" + DateUtils.date2String(day) +
                ", price=" + price +
                '}';
    }
}
