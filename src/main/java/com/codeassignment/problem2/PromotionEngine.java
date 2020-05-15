package com.codeassignment.problem2;

import java.util.*;

public class PromotionEngine {


    public static void main(String args[]) throws Exception {

        Cart cart = new Cart();
        preRequisiteData(cart);

        try{
            getInputDataFromUser(cart);
            cart.display();
        } catch (Exception e) {
            throw new Exception("Please enter valid data");
        }
    }

    public static void preRequisiteData(Cart cart) {
        cart.addItem("A",50);
        cart.addItem("B",30);
        cart.addItem("C",20);
        cart.addItem("D",15);

        new PromotionType1("A",3,130);
        new PromotionType1("B",2,45);
        new PromotionType2("C","D",30);
        new PromotionType2("D","C",30);
    }

    public static void  getInputDataFromUser(Cart cart) {

        System.out.println("Please Enter Required Information:\n");
        Scanner scanner = new Scanner(System.in);
        String message ;

        try{
            do {
                System.out.print("Enter SKU ID: ");
                String skuName = scanner.next();

                System.out.print("Enter No Of Items: ");
                int noOfItems = scanner.nextInt();

                cart.addUserItems(new Item(noOfItems,skuName));

                System.out.print("Do you want to add items (y/n): ");

                message = scanner.next();

            } while(!message.equalsIgnoreCase("n"));

        } catch(InputMismatchException exception){
            System.out.println("please enter valid data");
        } finally {
            scanner.close();
        }
    }


}
