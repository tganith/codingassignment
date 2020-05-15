package com.codeassignment.problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<String,Integer> itemsList;
    private List<Item> userItemsList;
    private Map<String,Integer> mergedSkuType;
    private int grandTotal;


    public Cart(){
        itemsList = new HashMap<>();
        userItemsList = new ArrayList<>();
        mergedSkuType = new HashMap<>();
    }

    public void addItem(String skuId, int unitPrice) {
        itemsList.put(skuId,unitPrice);
    }

    public void addUserItems(Item item) {
        userItemsList.add(item);
    }

    public int getGrandTotal() {
        return grandTotal;
    }

    public int getCalculateTotal(String skuId, int noOfItems) {

        Map<String,ActivePromotion> promotionData = ActivePromotion.promotionData;
        ActivePromotion promotion = promotionData.get(skuId);
        int price = 0;

        if(promotion == null){
            mergedSkuType.put(skuId,noOfItems);
        } else{
            price = promotion.applyPromotionCalculation(skuId,noOfItems,itemsList);
        }

        return price;
    }

    public void display() {

        System.out.println("\n\n==============================================");

        for(Item item :userItemsList){
            int calculateTotal = getCalculateTotal(item.getSkuID(),item.getNoOfItems());
            if(calculateTotal >0) {
                String itemRow = String.format("%d * %s = %d",item.getNoOfItems(),item.getSkuID(),calculateTotal);
                System.out.println(itemRow);
                grandTotal+=calculateTotal;
            }
        }

        if(mergedSkuType.size()>0){

            if(mergedSkuType.size() == 1){
                for(Map.Entry<String,Integer> map :mergedSkuType.entrySet()){
                    int value = itemsList.get(map.getKey());
                    int total = map.getValue() * value;
                    String itemRow = String.format("%d * %s = %d",map.getValue(),map.getKey(),total);
                    System.out.println(itemRow);
                    grandTotal+=total;
                }
            } else{
                String key = "";
                Map<String,ActivePromotion> promotionData = ActivePromotion.promotionData;
                for(Map.Entry<String,Integer> map :mergedSkuType.entrySet()){
                    key+=map.getKey();
                    ActivePromotion promotion = promotionData.get(key);
                    if(promotion!=null){
                        int total =  promotion.applyPromotionCalculation(key,map.getValue(),itemsList);
                        String itemRow = String.format("%d * %s = %d",map.getValue(),map.getKey(),total);
                        System.out.println(itemRow);
                        grandTotal+=total;
                    } else{
                        String itemRow = String.format("%d * %s = %s",map.getValue(),map.getKey(),"-");
                        System.out.println(itemRow);
                    }

                }
            }

        }

        System.out.println("==============================================");
        System.out.println(String.format("Total: %d",getGrandTotal()));

    }


}
