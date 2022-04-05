package com.example.trial1.ui;

public class Food {
    private String name, order,price, discount, menuid;

    public Food(){

    }

    public Food(String Name, String Order, String Price, String Discount, String Menuid){
        name=Name;
        order=Order;
        price=Price;
        discount=Discount;
        menuid=Menuid;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}
