package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    private int calculateAndPrintBasketContents(boolean printBasketContents) {
        int total = 0;
        int count = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getCost();
                if (printBasketContents) {
                    System.out.println(product.getName() + ": " + product.getCost());
                }
                count++;
            }
        }
        if (printBasketContents) {
            if (count == 0) {
                System.out.println("в корзине пусто");
            } else {
                System.out.println("Итого: " + total);
            }
        }
        return total;
    }

    public void printBasket() {
        calculateAndPrintBasketContents(true);
    }

    public int getTotalCost() {
        return calculateAndPrintBasketContents(false);
    }

    public boolean checkProductByName(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}
