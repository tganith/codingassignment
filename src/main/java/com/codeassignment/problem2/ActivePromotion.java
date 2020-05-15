package com.codeassignment.problem2;

import java.util.HashMap;
import java.util.Map;

public interface ActivePromotion {

    Map<String,ActivePromotion> promotionData = new HashMap<>();
    public int applyPromotionCalculation(String skuId, int noOfItems,Map<String,Integer> itemsList);
}
