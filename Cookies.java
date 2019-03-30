package com.example.coffeeorder.Order;

public class Cookies {
    private int number = 0;//数量
    private int price = 6;//价格

    public int getNumber() {
        return number;
    }

    //增加ICookies数量
    public void addNumber() {
        if(number > 10){
            return ;
        }
        number ++;
    }

    //减少Cookies的数量
    public void lossNumber(){
        if(number<0){
            return ;
        }
        number--;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
