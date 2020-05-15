package com.codeassignment.problem2;

import java.util.Map;

public class PromotionType1 implements ActivePromotion {

    private int noOfItems;
    private int price;
    private String skuId;

    public PromotionType1(int noOfItems,int price) {
        this.noOfItems = noOfItems;
        this.price = price;
    }

    public PromotionType1(String skuId, int noOfItems, int price) {
        this.skuId = skuId;
        this.price = price;
        this.noOfItems = noOfItems;

        promotionData.put(skuId,new PromotionType1(noOfItems,price));
    }


    @Override
    public int applyPromotionCalculation(String userSKUId, int userNoOfItems, Map<String,Integer> itemsList) {

        int totalPrice = 0;

        int d = userNoOfItems % noOfItems;
        int q = userNoOfItems / noOfItems;

        if(d == 0){
            totalPrice+= (q * price);
        } else {
            totalPrice+= (q * price);
            totalPrice+= (d * itemsList.get(userSKUId));
        }

        return totalPrice;
    }
}
