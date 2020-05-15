package com.codeassignment.problem2;

import java.util.Map;

public class PromotionType2 implements ActivePromotion {

    private int price;

    public PromotionType2(int price) {
        this.price = price;
    }

    public PromotionType2(String sku1, String sku2, int price) {
        promotionData.put(sku1.concat(sku2),new PromotionType2(price));
    }

    @Override
    public int applyPromotionCalculation(String skuId, int noOfItems, Map<String,Integer> itemsList) {
        return price;
    }

}
