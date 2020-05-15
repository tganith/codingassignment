package com.codeassignment.problem2;

public class Item {

    private String skuID;
    private int unitPrice;
    private int noOfItems;

    public Item(String skuID, int unitPrice) {
        this.skuID = skuID;
        this.unitPrice = unitPrice;
    }

    public Item(int noOfItems,String skuID) {
        this.skuID = skuID;
        this.noOfItems = noOfItems;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public String getSkuID() {
        return skuID;
    }

    public void setSkuID(String skuID) {
        this.skuID = skuID;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
